package com.acorn2.plec.api.qnafree.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.notice.exception.NoticeNotFoundException;
import com.acorn2.plec.api.qnafree.dao.QnaFreeAnswerDao;
import com.acorn2.plec.api.qnafree.dao.QnaFreeDao;
import com.acorn2.plec.api.qnafree.dto.QnaFreeAnswerDto;
import com.acorn2.plec.api.qnafree.dto.QnaFreeDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeCreateReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeUpdateReqDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadListResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadResDto;



@EnableCaching
@Service
public class QnaFreeServiceImpl implements QnaFreeService {
	
	@Autowired private QnaFreeDao qnaDao;
	@Autowired private QnaFreeAnswerDao qnaAnswerDao;

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Override
	@Cacheable(value = "qnaFree")
	public QnaFreeReadListResDto selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReqDto) {
		if(qnaFreeReadReqDto.getKeyword() !=null) {
			if(qnaFreeReadReqDto.getCondition().equals("title_content")) {
				qnaFreeReadReqDto.setTitle(qnaFreeReadReqDto.getKeyword());
				qnaFreeReadReqDto.setContent(qnaFreeReadReqDto.getKeyword());
			}else if(qnaFreeReadReqDto.getCondition().equals("title")) {
				qnaFreeReadReqDto.setTitle(qnaFreeReadReqDto.getKeyword());
			}else if(qnaFreeReadReqDto.getCondition().equals("writer")) {
				qnaFreeReadReqDto.setFreeQuestionWriter(qnaFreeReadReqDto.getKeyword());
			}
		}
		
		logger.debug("QnaFree List Start");
		Integer totalCount = qnaDao.selectQnaFreeCount(qnaFreeReadReqDto);
		List<QnaFreeReadResDto> qnaFreeReadResDtoList = qnaDao.selectQnaFreeList(qnaFreeReadReqDto);
		QnaFreeReadListResDto qnaFreeReadListResDto = new QnaFreeReadListResDto(totalCount, qnaFreeReadReqDto);
		qnaFreeReadListResDto.setData(qnaFreeReadResDtoList);
		logger.debug("Cached value for key {} is {}", qnaFreeReadReqDto.hashCode(), qnaFreeReadListResDto.toString());
		return qnaFreeReadListResDto;
	}
	
	//????????????
	@Override
	public QnaFreeReadDetailResDto selectOne(QnaFreeReadReqDto qnaFreeReadReqDto) {
		if(qnaDao.selectQnaFree(qnaFreeReadReqDto)== null) {
			throw new NoticeNotFoundException("??????????????? ????????????.");
		}
		qnaDao.addViewCount(qnaFreeReadReqDto.getFreeQuestionNum());
		return qnaDao.selectQnaFree(qnaFreeReadReqDto);
	}
	

	//??? ???????????? ?????????
	@Transactional
	@Override
	public void QnaFreeInsert(QnaFreeCreateReqDto qnaFreeCreateReqDto, HttpServletRequest request) {
		HttpSession session=request.getSession();
		
		QnaFreeDto dto = new QnaFreeDto();		
		dto.setTitle(qnaFreeCreateReqDto.getTitle());
		dto.setContent(qnaFreeCreateReqDto.getContent());
		dto.setFreeQuestionWriter(session.getAttribute("id").toString());
		
		qnaDao.insertQnaFree(dto);
	}

	//??? ??????
	@Transactional
	@Override
	public void QnaFreeUpdate(QnaFreeUpdateReqDto qnaFreeUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		QnaFreeDto dto=new QnaFreeDto();
		dto.setFreeQuestionNum(qnaFreeUpdateReqDto.getFreeQuestionNum());
		dto.setTitle(qnaFreeUpdateReqDto.getTitle());
		dto.setContent(qnaFreeUpdateReqDto.getContent());		
		
		qnaDao.updateQnaFree(dto);
	}

	//??? ??????(?????? ?????? Y ??????)
	@Transactional
	@Override
	public void QnaFreeUpdateDelete(Integer freeQuestionNum) {
		qnaDao.deleteUpdateQnaFree(freeQuestionNum);		
	}
	
	//??? ??????(batch)
	@Transactional
	@Override
	public void QnaFreeDelete() {
		qnaDao.deleteQnaFree();
	}

	//?????? ?????? ?????? (selectOne)
	@Override
	public void selectComment(int refGroup) {
		qnaAnswerDao.selectQnaAnswer(refGroup);
	}
	
	//?????? ??????
	@Override
	public void saveComment(QnaFreeAnswerDto dto, HttpServletRequest request) {
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		int seq=qnaAnswerDao.getSequence();
		String content=request.getParameter("content");
		dto.setFreeCommentNum(seq);
	    dto.setFreeCommentWriter((String)request.getAttribute("id")); 
	    dto.setContent(content);
	    dto.setFreeCommentRefGroup(ref_group);
		qnaAnswerDao.insertQnaAnswer(dto, request);		
	}

	//?????? ??????
	@Override
	public void updateComment(QnaFreeAnswerDto dto, HttpServletRequest request) {
		qnaAnswerDao.updateQnaAnswer(dto, request);		
	}

	//?????? ??????(?????? ?????? Y ??????)
	@Override
	public void updateDeleteComment(int freeCommentNum) {
		qnaAnswerDao.deleteUpdateQnaAnswer(freeCommentNum);		
	}

	//?????? ??????(batch)
	@Override
	public void deleteComment() {
		qnaAnswerDao.deleteQnaFree();		
	}
		
	

}
