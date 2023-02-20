package com.acorn2.FinalProject.lecture.Service;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureReadReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadListResDto;

public interface LectureService {
	
	LectureReadListResDto LectureList(LectureReadReqDto lectureReadReqDto);
	
	LectureDto LectureOne(int lecNum);
	
	void LectureInsert(MultipartFile image, int lecNum,LectureCreateReqDto lectureCreateReqDto);
	
	void LectureDelete(int lecNum);
	
	void LectureUpdate(LectureUpdateReqDto lectureUpdateReqDto);
}
