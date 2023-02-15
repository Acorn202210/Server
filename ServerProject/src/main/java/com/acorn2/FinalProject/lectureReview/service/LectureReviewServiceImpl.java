package com.acorn2.FinalProject.lectureReview.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadResDto;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;
	
	@Override
	public LectureReviewReadListResDto LectureReviewList(int ref_group,LectureReviewReadReqDto reviewReq) {
		Integer totalCount = reviewDao.selectLectureReivewCount(reviewReq); 
		List<LectureReviewReadResDto> ReviewReadList = reviewDao.getList(reviewReq);
		LectureReviewReadListResDto ReviewListRes = new LectureReviewReadListResDto(totalCount,reviewReq);
		ReviewListRes.setData(ReviewReadList);
		return ReviewListRes;
	}
	
	

	

}
