package com.acorn2.FinalProject.lectureReview.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewUpdateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadResDto;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;
	
	@Override
	public LectureReviewReadListResDto LectureReviewList(LectureReviewReadReqDto reviewReq) {
		Integer totalCount = reviewDao.selectLectureReivewCount(reviewReq); 
		List<LectureReviewReadResDto> ReviewReadList = reviewDao.LectureReviewList(reviewReq);
		LectureReviewReadListResDto ReviewListRes = new LectureReviewReadListResDto(totalCount, reviewReq);
		ReviewListRes.setData(ReviewReadList);
		return ReviewListRes;
	}
	
	@Override
	public LectureReviewDto LectureReviewOne(int lecReNum) {
		return reviewDao.LectureReviewOne(lecReNum);
	}

	@Override
	public void LectureReviewInsert(LectureReviewCreateReqDto ReviewCreateReqDto) {
		LectureReviewDto dto = new LectureReviewDto();
		dto.setLecReNum(ReviewCreateReqDto.getLecReNum());
		dto.setLecReWriter(ReviewCreateReqDto.getLecReWriter());
		dto.setLecReStuRefGroup(ReviewCreateReqDto.getLecReStuRefGroup());
		dto.setStar(ReviewCreateReqDto.getStar());
		dto.setContent(ReviewCreateReqDto.getContent());
		
		reviewDao.insertLectureReview(dto);
	}
	
	@Override
	public void LectureReviewUpdate(LectureReviewUpdateReqDto reviewUpdateReqDto) {
		LectureReviewDto dto = new LectureReviewDto();
		dto.setLecReNum(reviewUpdateReqDto.getLecReNum());
		dto.setContent(reviewUpdateReqDto.getContent());
		dto.setStar(reviewUpdateReqDto.getStar());
		reviewDao.updateLectureReview(dto);	
	}

	@Override
	public void LectureReviewDelete(int lecReNum) {
		reviewDao.deleteLectureReview(lecReNum);
		
	}



	
	

	

}
