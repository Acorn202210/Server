package com.acorn2.plec.api.lecture.Service;

import com.acorn2.plec.api.lecture.dto.LectureDto;
import com.acorn2.plec.api.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureReadReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadListResDto;


public interface LectureService {
	
	LectureReadListResDto LectureList(LectureReadReqDto lectureReadReqDto);
	
	LectureDto LectureOne(Integer lecNum);
	
	void LectureInsert(LectureCreateReqDto lectureCreateReqDto, String id);
	
	void LectureDelete(Integer lecNum);

	void LectureUpdate(LectureUpdateReqDto lectureUpdateReqDto, String id);

	void batchLectureDelete();
	
}
