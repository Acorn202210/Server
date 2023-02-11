package com.acorn2.FinalProject.lectureReview.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;


public interface LectureReviewService {
	public Map<String, Object> getList(int pageNum,int ref_group);
	//후기 저장
	public void saveReview(HttpServletRequest request); 
	//후기 삭제
	public void deleteReview(HttpServletRequest request);
	//후기 수정
	public void updateReview(LectureReviewDto dto); 
	
}
