package com.acorn2.FinalProject.lectureReview.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewUpdateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;



public interface LectureReviewService {

	LectureReviewReadListResDto LectureReviewList(LectureReviewReadReqDto reviewReq);
	
	LectureReviewDto LectureReviewOne(int lecReNum);
	
	void LectureReviewInsert(LectureReviewCreateReqDto ReviewCreateReqDto, HttpServletRequest request);
	
	void LectureReviewDelete(int lecReNum);
	
	void LectureReviewUpdate(LectureReviewUpdateReqDto reviewUpdateReqDto);
	
	void batchDeleteLectureReview();
}
