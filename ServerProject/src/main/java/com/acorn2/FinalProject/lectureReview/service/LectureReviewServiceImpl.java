package com.acorn2.FinalProject.lectureReview.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadListRes;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReadRes;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;
	
	@Override
	public LectureReviewReadListRes LectureReviewList(LectureReviewReadReq reviewReq) {
		Integer totalCount = reviewDao.getCount(0);

		
		return null;
	}
	
	

	@Override
	public ResponseEntity<Object> saveReview(LectureReviewRes res) {
		reviewDao.insert(res);
		return ResponseEntity.ok("Success");
		
	}

	@Override
	public ResponseEntity<Object> deleteReview(int num) {    
	    reviewDao.delete(num);
	    return ResponseEntity.ok("Success");
		
	}

	@Override
	public ResponseEntity<Object> updateReview(LectureReviewReadReq req) {
		reviewDao.update(req);
		return ResponseEntity.ok("Success");
	
		
	}

	@Override
	public ResponseEntity<LectureReviewDto> getData(int num) {
		LectureReviewDto data =reviewDao.getData(num);
		return ResponseEntity.ok(data);
		}

	

}
