package com.acorn2.plec.api.qnafree.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.qnafree.dao.QnaFreeDao;
import com.acorn2.plec.api.qnafree.dto.QnaFreeDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeCreateReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.api.qnafree.dto.req.QnaFreeUpdateReqDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadListResDto;
import com.acorn2.plec.api.qnafree.dto.res.QnaFreeReadResDto;
import com.acorn2.plec.api.qnafree.exception.QnaFreeNotFoundException;

@EnableCaching
@Service
public class QnaFreeServiceImpl implements QnaFreeService {

	@Autowired
	private QnaFreeDao qnaFreeDao;

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	@Cacheable(value = "qnaFree")
	public QnaFreeReadListResDto selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReqDto) {
		if (qnaFreeReadReqDto.getKeyword() != null) {
			if (qnaFreeReadReqDto.getCondition().equals("title_content")) {
				qnaFreeReadReqDto.setTitle(qnaFreeReadReqDto.getKeyword());
				qnaFreeReadReqDto.setContent(qnaFreeReadReqDto.getKeyword());
			} else if (qnaFreeReadReqDto.getCondition().equals("title")) {
				qnaFreeReadReqDto.setTitle(qnaFreeReadReqDto.getKeyword());
			} else if (qnaFreeReadReqDto.getCondition().equals("writer")) {
				qnaFreeReadReqDto.setFreeQuestionWriter(qnaFreeReadReqDto.getKeyword());
			}
		}

		logger.debug("QnaFree List Start");
		Integer totalCount = qnaFreeDao.selectQnaFreeCount(qnaFreeReadReqDto);
		List<QnaFreeReadResDto> qnaFreeReadResDtoList = qnaFreeDao.selectQnaFreeList(qnaFreeReadReqDto);
		QnaFreeReadListResDto qnaFreeReadListResDto = new QnaFreeReadListResDto(totalCount, qnaFreeReadReqDto);
		qnaFreeReadListResDto.setData(qnaFreeReadResDtoList);
		logger.debug("Cached value for key {} is {}", qnaFreeReadReqDto.hashCode(), qnaFreeReadListResDto.toString());
		return qnaFreeReadListResDto;
	}

	@Override
	public QnaFreeReadDetailResDto selectQnaFreeOne(QnaFreeReadReqDto qnaFreeReadReqDto) {
		if (qnaFreeDao.selectQnaFree(qnaFreeReadReqDto) == null) {
			throw new QnaFreeNotFoundException("자유게시판이 없습니다.");
		}
		qnaFreeDao.addViewCount(qnaFreeReadReqDto.getFreeQuestionNum());
		return qnaFreeDao.selectQnaFree(qnaFreeReadReqDto);
	}

	@Transactional
	@Override
	public void insertQnaFree(QnaFreeCreateReqDto qnaFreeCreateReqDto, String id) {

		QnaFreeDto dto = new QnaFreeDto();
		dto.setTitle(qnaFreeCreateReqDto.getTitle());
		dto.setContent(qnaFreeCreateReqDto.getContent());
		dto.setFreeQuestionWriter(id);

		qnaFreeDao.insertQnaFree(dto);
	}

	@Transactional
	@Override
	public void updateQnaFree(QnaFreeUpdateReqDto qnaFreeUpdateReqDto) {

		QnaFreeDto dto = new QnaFreeDto();
		dto.setFreeQuestionNum(qnaFreeUpdateReqDto.getFreeQuestionNum());
		dto.setTitle(qnaFreeUpdateReqDto.getTitle());
		dto.setContent(qnaFreeUpdateReqDto.getContent());
		qnaFreeDao.updateQnaFree(dto);
	}

	@Transactional
	@Override
	public void deleteUpdateQnaFree(Integer freeQuestionNum) {
		qnaFreeDao.deleteUpdateQnaFree(freeQuestionNum);
	}

	// 글 삭제(batch)
	@Transactional
	@Override
	public void deleteQnaFree() {
		qnaFreeDao.deleteQnaFree();
	}

}
