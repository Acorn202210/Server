package com.acorn2.FinalProject.lectureReview.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadResDto;


@Service
public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;
	
	@Override
	public LectureReviewReadListResDto LectureReviewList(int lec_re_stu_ref_group,LectureReviewReadReqDto reviewReq) {
		Integer totalCount = reviewDao.selectLectureReivewCount(reviewReq); 
		List<LectureReviewReadResDto> ReviewReadList = reviewDao.LectureReviewList(reviewReq);
		LectureReviewReadListResDto ReviewListRes = new LectureReviewReadListResDto(totalCount,reviewReq);
		ReviewListRes.setData(ReviewReadList);
		return ReviewListRes;
	}

	@Override
	public void LectureReviewInsert(LectureReviewCreateReqDto ReviewCreateReqDto) {
		LectureReviewDto dto = new LectureReviewDto();
		dto.setLec_re_num(ReviewCreateReqDto.getLec_re_num());
		dto.setLec_re_writer(ReviewCreateReqDto.getLec_re_writer());
		dto.setLec_re_stu_ref_group(ReviewCreateReqDto.getLec_re_stu_ref_group());
		dto.setStar(ReviewCreateReqDto.getStar());
		dto.setContent(ReviewCreateReqDto.getContent());
		
		reviewDao.insertRectureReview(dto);
	}
	
	

	

}
