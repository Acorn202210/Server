package com.acorn2.plec.lectureReview.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.lectureReview.dto.LectureReviewDto;
import com.acorn2.plec.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.plec.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.plec.lectureReview.dto.req.LectureReviewUpdateReqDto;
import com.acorn2.plec.lectureReview.dto.res.LectureReviewReadListResDto;



public interface LectureReviewService {

	LectureReviewReadListResDto LectureReviewList(LectureReviewReadReqDto reviewReq);
	
	LectureReviewDto LectureReviewOne(int lecReNum);
	
	void LectureReviewInsert(LectureReviewCreateReqDto ReviewCreateReqDto, HttpServletRequest request);
	
	void LectureReviewDelete(int lecReNum);
	
	void LectureReviewUpdate(LectureReviewUpdateReqDto reviewUpdateReqDto);
	
	void batchDeleteLectureReview();
}
