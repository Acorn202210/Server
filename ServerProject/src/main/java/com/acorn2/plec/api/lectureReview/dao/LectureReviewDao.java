package com.acorn2.plec.api.lectureReview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.lectureReview.dto.LectureReviewDto;
import com.acorn2.plec.api.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.plec.api.lectureReview.dto.res.LectureReviewReadResDto;


@Mapper
public interface LectureReviewDao {
	public List<LectureReviewReadResDto> LectureReviewList(LectureReviewReadReqDto reviewReq);
	
	public Integer selectLectureReivewCount(LectureReviewReadReqDto reviewReq);
	
	public LectureReviewDto LectureReviewOne(int lecReNum);
	
	Integer insertLectureReview(LectureReviewDto dto);
	
	Integer deleteLectureReview(int lecReNum);
	
	Integer updateLectureReview(LectureReviewDto dto);
	
	Integer batchDeleteLectureReview();
}
