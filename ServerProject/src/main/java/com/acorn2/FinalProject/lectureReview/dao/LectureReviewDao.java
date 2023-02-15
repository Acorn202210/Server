package com.acorn2.FinalProject.lectureReview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadResDto;





@Mapper
public interface LectureReviewDao {
	//리뷰 목록 얻어오기
	public List<LectureReviewReadResDto> getList(LectureReviewReadReqDto reviewReq);
	
	public Integer selectLectureReivewCount(LectureReviewReadReqDto reviewReq);
	
	
}
