package com.acorn2.plec.api.qnaboard.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.api.qnaboard.dto.QnaBoardAnswerDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardAnswerUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.plec.api.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.plec.api.qnaboard.dto.res.QnaBoardAnswerReadListResDto;
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
	QnaBoardAnswerReadListResDto qnaAnswerList(QnaBoardAnswerReadReqDto qnaAnswerReadReq);
	
	QnaBoardAnswerDto selectComment(int boardCommentRefGroup);
	
	void saveComment(QnaBoardAnswerCreateReqDto dto, String id);
	
	void updateComment(QnaBoardAnswerUpdateReqDto dto, String id);
	
	void updateDeleteComment(int boardCommentRefGroup);
	
	void deleteComment();
	

}
