package com.acorn2.FinalProject.lectureReview.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadRes;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;


@Repository
public class LectureReviewDaoImpl implements LectureReviewDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<LectureReviewReadRes> getList(LectureReviewReadReq reviewReq) {
		return session.selectList("lectureReview.getList", reviewReq);
	}
	
	@Override
	public void delete(int num) {
	      session.update("lectureReview.delete", num);
		
	}

	@Override
	public void insert(LectureReviewRes res) {
		session.insert("lectureReview.insert", res);
		
	}

	@Override
	public int getSequence() {
		return session.selectOne("lectureReview.getSequence");
	}

	@Override
	public void update(LectureReviewReadReq req) {
		session.update("lectureReview.update", req);
		
	}

	@Override
	public LectureReviewDto getData(int num) {
		return session.selectOne("lectureReview.getData", num);
	}

	@Override
	public int getCount(int num) {
		return session.selectOne("lectureReview.getCount", num);
	}

	

}
