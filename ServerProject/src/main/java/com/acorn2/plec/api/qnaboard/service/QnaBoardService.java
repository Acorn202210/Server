package com.acorn2.plec.api.qnaboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.api.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadDetailResDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardReadListResDto;


public interface QnaBoardService {
	
	QnaBoardReadListResDto selectQnaBoardList(QnaBoardReadReqDto qnaBoardReadReq);
	
	QnaBoardReadDetailResDto selectOne(QnaBoardReadReqDto QnaBoardReadReqDto);
	
	void QnaBoardInsert(QnaBoardCreateReqDto qnaBoardCreateReqDto, HttpServletRequest request);
	
	void QnaBoardUpdate(QnaBoardUpdateReqDto qnaBoardUpdateReqDto, HttpServletRequest request);
	
	void QnaBoardUpdateDelete(int boardQuestionNum);
	
	void QnaBoardDelete();
		
	//댓글 관련 메소드
	void selectComment(int refGroup);
	
	void saveComment(QnaBoardAnswerDto dto, HttpServletRequest request);
	
	void updateComment(QnaBoardAnswerDto dto, HttpServletRequest request);
	
	void updateDeleteComment(int boardCommentNum);
	
	void deleteComment();
	

}
