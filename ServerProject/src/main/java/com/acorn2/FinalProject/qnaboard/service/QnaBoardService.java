package com.acorn2.FinalProject.qnaboard.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardCreateReqDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardReadReqDto;
import com.acorn2.FinalProject.qnaboard.dto.req.QnaBoardUpdateReqDto;
import com.acorn2.FinalProject.qnaboard.dto.res.QnaBoardReadDetailResDto;
import com.acorn2.FinalProject.qnaboard.dto.res.QnaBoardReadListResDto;
import com.acorn2.FinalProject.qnaboard.dto.res.QnaBoardReadResDto;

public interface QnaBoardService {
	
	QnaBoardReadListResDto selectQnaBoardList(QnaBoardReadReqDto qnaBoardReadReq);
	
	QnaBoardReadDetailResDto selectOne(QnaBoardReadReqDto QnaBoardReadReqDto);
	
	void QnaBoardInsert(QnaBoardCreateReqDto qnaBoardCreateReqDto, HttpServletRequest request);
	
	void QnaBoardUpdate(QnaBoardUpdateReqDto qnaBoardUpdateReqDto, HttpServletRequest request);
	
	void QnaBoardUpdateDelete(int boardQuestionNum);
	
	void QnaBoardDelete();
		
//	public List<QnaBoardDto> getList(int pageNum, String keyword, String condition); //목록불러오기
//	public Map<String, Object> getDetail(int num, String keyword, String condition);
//	public Map<String, String> saveContent(QnaBoardReadResDto dto); //글 저장
//	public Map<String, String> updateContent(QnaBoardReadReqDto dto);
//	public Map<String, String> deleteContent(int num);
//	public Map<String, Object> getData(int num);
	
	/*
	public void saveComment(HttpServletRequest request); //댓글 저장	
	public void updateComment(QnaBoardAnswerDto dto); //댓글 수정
	public void moreCommentList(HttpServletRequest request); //댓글 더보기 기능
	 */
}
