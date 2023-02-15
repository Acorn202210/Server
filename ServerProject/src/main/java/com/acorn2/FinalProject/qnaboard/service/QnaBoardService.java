package com.acorn2.FinalProject.qnaboard.service;

import java.util.List;
import java.util.Map;

import com.acorn2.FinalProject.qnaboard.dto.QnaBoardDto;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardReq;
import com.acorn2.FinalProject.qnaboard.dto.QnaBoardRes;

public interface QnaBoardService {
	public List<QnaBoardDto> getList(int pageNum, String keyword, String condition); //목록불러오기
	public Map<String, Object> getDetail(int num, String keyword, String condition);
	public Map<String, String> saveContent(QnaBoardRes dto); //글 저장
	public Map<String, String> updateContent(QnaBoardReq dto);
	public Map<String, String> deleteContent(int num);
	public Map<String, Object> getData(int num);
	
	/*
	public void saveComment(HttpServletRequest request); //댓글 저장	
	public void updateComment(QnaBoardAnswerDto dto); //댓글 수정
	public void moreCommentList(HttpServletRequest request); //댓글 더보기 기능
	 */
}
