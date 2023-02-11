package com.acorn2.FinalProject.lectureReview.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;

	@Override
	public void saveReview(HttpServletRequest request) {
		
		
	}

	@Override
	public void deleteReview(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		LectureReviewDto dto=reviewDao.getData(num);
	    String id=(String)request.getSession().getAttribute("id");      
	    reviewDao.delete(num);
		
	}

	@Override
	public void updateReview(LectureReviewDto dto) {
	
		
	}

	@Override
	public Map<String, Object> getList(int pageNum,int ref_group) {
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

		
		int totalRow=reviewDao.getCount(ref_group);
		
		
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; 
		}
		
		List<LectureReviewDto> list = reviewDao.getList(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		map.put("totalPageCount", totalPageCount);
		map.put("totalRow", totalRow);
		map.put("list", list);
		return map;
	}

}
