package com.acorn2.plec.api.qnaboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.qnaboard.dao.QnaBoardAnswerDao;
import com.acorn2.plec.api.qnaboard.dao.QnaBoardDao;
import com.acorn2.plec.api.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.api.qnaboard.dto.QnaBoardDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardAnswerReadListResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardAnswerReadResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadDetailResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadListResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadResDto;



@EnableCaching
@Service
public class QnaBoardServiceImpl implements QnaBoardService {
	
	@Autowired private QnaBoardDao qnaDao;
	@Autowired private QnaBoardAnswerDao qnaAnswerDao;

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Override
	@Cacheable(value = "qnaBoard")
	public QnaBoardReadListResDto selectQnaBoardList(QnaBoardReadReqDto qnaBoardReadReqDto) {
		if(qnaBoardReadReqDto.getKeyword() !=null) {
			if(qnaBoardReadReqDto.getCondition().equals("title_content")) {
				qnaBoardReadReqDto.setTitle(qnaBoardReadReqDto.getKeyword());
				qnaBoardReadReqDto.setContent(qnaBoardReadReqDto.getKeyword());
			}else if(qnaBoardReadReqDto.getCondition().equals("title")) {
				qnaBoardReadReqDto.setTitle(qnaBoardReadReqDto.getKeyword());
			}else if(qnaBoardReadReqDto.getCondition().equals("writer")) {
				qnaBoardReadReqDto.setContent(qnaBoardReadReqDto.getKeyword());
			}
		}
		
		logger.debug("QnaBoard List Start");
		Integer totalCount = qnaDao.selectQnaBoardCount(qnaBoardReadReqDto);
		List<QnaBoardReadResDto> qnaBoardReadResDtoList = qnaDao.selectQnaBoardList(qnaBoardReadReqDto);
		QnaBoardReadListResDto qnaBoardReadListResDto = new QnaBoardReadListResDto(totalCount, qnaBoardReadReqDto);
		qnaBoardReadListResDto.setData(qnaBoardReadResDtoList);
		logger.debug("Cached value for key {} is {}", qnaBoardReadReqDto.hashCode(), qnaBoardReadListResDto.toString());
		return qnaBoardReadListResDto;
	}
	
	//상세보기
	@Override
	public QnaBoardReadDetailResDto selectOne(QnaBoardReadReqDto qnaBoardReadReqDto) {
		
		return qnaDao.selectQnaBoard(qnaBoardReadReqDto);
	}
	

	//글 추가하는 메소드
	@Transactional
	@Override
	public void QnaBoardInsert(QnaBoardCreateReqDto qnaBoardCreateReqDto, HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		QnaBoardDto dto = new QnaBoardDto();		
		dto.setTitle(qnaBoardCreateReqDto.getTitle());
		dto.setContent(qnaBoardCreateReqDto.getContent());
		dto.setBoardQuestionWriter(session.getAttribute("id").toString());
		
		qnaDao.insertQnaBoard(dto);
	}

	//글 수정
	@Transactional
	@Override
	public void QnaBoardUpdate(QnaBoardUpdateReqDto qnaBoardUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		QnaBoardDto dto=new QnaBoardDto();
		dto.setBoardQuestionNum(qnaBoardUpdateReqDto.getBoardQuestionNum());
		dto.setTitle(qnaBoardUpdateReqDto.getTitle());
		dto.setContent(qnaBoardUpdateReqDto.getContent());		
		
		qnaDao.updateQnaBoard(dto);
	}

	//글 삭제(삭제 칼럼 Y 변경)
	@Transactional
	@Override
	public void QnaBoardUpdateDelete(int boardQuestionNum) {
		qnaDao.deleteUpdateQnaBoard(boardQuestionNum);		
	}
	
	//글 삭제(batch)
	@Transactional
	@Override
	public void QnaBoardDelete() {
		qnaDao.deleteQnaBoard();
	}

	
	//댓글 목록 보기	
	@Override
	public QnaBoardAnswerReadListResDto qnaAnswerList(QnaBoardAnswerReadReqDto qnaAnswerReadReq) {
		Integer totalCount=qnaAnswerDao.selectQnaAnswerCount(qnaAnswerReadReq);	
		List<QnaBoardAnswerReadResDto> answerReadList=qnaAnswerDao.qnaAnswerList(qnaAnswerReadReq);
		QnaBoardAnswerReadListResDto answerListRes=new QnaBoardAnswerReadListResDto(totalCount, qnaAnswerReadReq);
		answerListRes.setData(answerReadList);
		return answerListRes;
	}
	
	//댓글 한개 보기 (selectOne)
	@Override
	public QnaBoardAnswerDto selectComment(int boardCommentRefGroup) {
		return qnaAnswerDao.selectQnaAnswer(boardCommentRefGroup);
	}
	
	//댓글 저장
	@Transactional
	@Override
	public void saveComment(QnaBoardAnswerCreateReqDto answerCreateReqDto, String id) {
		     
		QnaBoardAnswerDto dto=new QnaBoardAnswerDto();
		dto.setBoardCommentWriter(id);
	    dto.setBoardCommentRefGroup(answerCreateReqDto.getBoardCommentRefGroup());
	    dto.setContent(answerCreateReqDto.getContent());
		qnaAnswerDao.insertQnaAnswer(dto);
		
		QnaBoardDto dto2=new QnaBoardDto();
	    dto2.setBoardQuestionNum(answerCreateReqDto.getBoardCommentRefGroup());
	    dto2.setAnsweredYn("Y");
	    //answered(답변여부) 정보 DB 저장
	    qnaDao.answered(dto2);	    
	}

	//댓글 수정
	@Transactional
	@Override
	public void updateComment(QnaBoardAnswerUpdateReqDto answerUpdateReqDto, String id) {
		
		QnaBoardAnswerDto dto=new QnaBoardAnswerDto();
		dto.setBoardCommentRefGroup(answerUpdateReqDto.getBoardCommentRefGroup());
		dto.setContent(answerUpdateReqDto.getContent());		
		dto.setUpdateId(id);
		qnaAnswerDao.updateQnaAnswer(dto);		
	}

	//댓글 삭제(삭제 칼럼 Y 변경)
	@Transactional
	@Override
	public void updateDeleteComment(int boardCommentRefGroup) {
		qnaAnswerDao.deleteUpdateQnaAnswer(boardCommentRefGroup);		
	}

	//댓글 삭제(batch)
	@Transactional
	@Override
	public void deleteComment() {
		qnaAnswerDao.deleteQnaBoard();		
	}	

}
