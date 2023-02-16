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
	
	public LectureReviewDto LectureReviewOne(int lec_re_num);
	
	Integer insertLectureReview(LectureReviewDto dto);
	
	Integer deleteLectureReview(int lec_re_num);
	
	Integer updateLectureReview(LectureReviewDto dto);
}
