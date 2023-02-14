package com.acorn2.FinalProject.lectureReview.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;


public interface LectureReviewService {
	public ResponseEntity<List<LectureReviewDto>> LectureReviewList(int pageNum,int ref_group);
	//후기 저장
	public ResponseEntity<Object> saveReview(LectureReviewRes res); 
	//후기 삭제
	public ResponseEntity<Object> deleteReview(int num);
	//후기 수정
	public ResponseEntity<Object> updateReview(LectureReviewReq req); 
	//후기 하나의 정보
	public ResponseEntity<LectureReviewDto> getData(int num);
	
}
