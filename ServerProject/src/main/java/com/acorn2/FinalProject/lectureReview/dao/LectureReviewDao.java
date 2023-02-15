package com.acorn2.FinalProject.lectureReview.dao;

import java.util.List;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;





public interface LectureReviewDao {
	//리뷰 목록 얻어오기
	public List<LectureReviewDto> getList(LectureReviewDto dto);
	//리뷰 삭제 
	public void delete(int num);
	//리뷰 저장
	public void insert(LectureReviewRes res);
	//추가할 리뷰의 글번호를 리턴하는 메소드
	public int getSequence();
	//리뷰 수정
	public void update(LectureReviewReadReq req);
	//리뷰 하나의 정보를 리턴하는 메소드
	public LectureReviewDto getData(int num);
	//리뷰의 갯수를 리턴하는 메소드
	public int getCount(int ref_group);
}
