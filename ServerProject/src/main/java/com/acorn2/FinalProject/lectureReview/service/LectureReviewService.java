package com.acorn2.FinalProject.lectureReview.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;



public interface LectureReviewService {

	LectureReviewReadListResDto LectureReviewList(int ref_group,LectureReviewReadReqDto reviewReq);
	
}
