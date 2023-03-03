package com.acorn2.plec.qnafree.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.qnafree.dto.QnaFreeAnswerDto;
import com.acorn2.plec.qnafree.dto.req.QnaFreeCreateReqDto;
import com.acorn2.plec.qnafree.dto.req.QnaFreeReadReqDto;
import com.acorn2.plec.qnafree.dto.req.QnaFreeUpdateReqDto;
import com.acorn2.plec.qnafree.dto.res.QnaFreeReadDetailResDto;
import com.acorn2.plec.qnafree.dto.res.QnaFreeReadListResDto;

public interface QnaFreeService {
	
	QnaFreeReadListResDto selectQnaFreeList(QnaFreeReadReqDto qnaFreeReadReq);
	
	QnaFreeReadDetailResDto selectOne(QnaFreeReadReqDto QnaFreeReadReqDto);
	
	void QnaFreeInsert(QnaFreeCreateReqDto qnaFreeCreateReqDto, HttpServletRequest request);
	
	void QnaFreeUpdate(QnaFreeUpdateReqDto qnaFreeUpdateReqDto, HttpServletRequest request);
	
	void QnaFreeUpdateDelete(int freeQuestionNum);
	
	void QnaFreeDelete();
		
	//댓글 관련 메소드
	void selectComment(int refGroup);
	
	void saveComment(QnaFreeAnswerDto dto, HttpServletRequest request);
	
	void updateComment(QnaFreeAnswerDto dto, HttpServletRequest request);
	
	void updateDeleteComment(int freeCommentNum);
	
	void deleteComment();
	
}
