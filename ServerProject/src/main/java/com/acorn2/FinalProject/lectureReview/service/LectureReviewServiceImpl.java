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
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewReq;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewRes;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;

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
	public ResponseEntity<Object> updateReview(LectureReviewReq req) {
		reviewDao.update(req);
		return ResponseEntity.ok("Success");
	
		
	}

	@Override
	public ResponseEntity<List<LectureReviewDto>> LectureReviewList(int pageNum,int ref_group) {
		final int PAGE_ROW_COUNT=5;
		final int PAGE_DISPLAY_COUNT=5;
		
		int num=1;
		String strPageNum=Integer.toString(pageNum);
		if(strPageNum != null){
			num=Integer.parseInt(strPageNum);
		}
		
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		int endRowNum=pageNum*PAGE_ROW_COUNT;

			
		LectureReviewDto dto = new LectureReviewDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setRef_group(ref_group);
		
		int totalRow=reviewDao.getCount(ref_group);
		
		
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; 
		}
		
		List<LectureReviewDto> list = reviewDao.getList(dto);
		return ResponseEntity.ok(list);
	}

	@Override
	public ResponseEntity<LectureReviewDto> getData(int num) {
		LectureReviewDto data =reviewDao.getData(num);
		return ResponseEntity.ok(data);
		}

}
