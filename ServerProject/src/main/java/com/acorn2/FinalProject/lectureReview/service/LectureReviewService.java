package com.acorn2.FinalProject.lectureReview.service;

import java.util.List;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;



public interface LectureReviewService {

	LectureReviewReadListResDto LectureReviewList(int lec_re_stu_ref_group,LectureReviewReadReqDto reviewReq);
	
	void LectureReviewInsert(LectureReviewCreateReqDto ReviewCreateReqDto);
}
