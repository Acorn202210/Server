package com.acorn2.FinalProject.lectureReview.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadListRes;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;


public interface LectureReviewService {

	public ResponseEntity<Object> saveReview(LectureReviewRes res); 
	//후기 삭제
	public ResponseEntity<Object> deleteReview(int num);
	//후기 수정
	public ResponseEntity<Object> updateReview(LectureReviewReadReq req); 
	//후기 하나의 정보
	public ResponseEntity<LectureReviewDto> getData(int num);
	public LectureReviewReadListRes LectureReviewList(LectureReviewReadReq reviewReq);
	
}
