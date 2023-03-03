package com.acorn2.plec.lectureStudent.service;


import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentReadListResDto;

public interface LectureStudentService {

	LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto);

	LectureStudentOneReadResDto LectureStudentOne(int lecStuNum);
	
	void LectureSignup (Integer lecStuRefGroup, HttpServletRequest request);
	
	void LectureCompleteYn (LectureStudentUpdateReqDto studentUpdateReqDto, HttpServletRequest request);
	
	void LectureDelete();

}