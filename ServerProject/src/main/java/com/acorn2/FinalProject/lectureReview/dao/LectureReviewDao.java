package com.acorn2.FinalProject.lectureReview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadResDto;





@Mapper
public interface LectureReviewDao {
	public List<LectureReviewReadResDto> LectureReviewList(LectureReviewReadReqDto reviewReq);
	
	public Integer selectLectureReivewCount(LectureReviewReadReqDto reviewReq);
	
	Integer insertRectureReview(LectureReviewDto dto);
}
