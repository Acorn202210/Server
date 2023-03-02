package com.acorn2.FinalProject.lectureStudent.service;


import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;

public interface LectureStudentService {

	LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto);

	LectureStudentOneReadResDto LectureStudentOne(int lecStuNum);
	
	void LectureSignup (LectureStudentCreateReqDto studentCreateReqDto, HttpServletRequest request);
	
	void LectureCompleteYn (LectureStudentUpdateReqDto studentUpdateReqDto, HttpServletRequest request);
	
	void LectureDelete();

}