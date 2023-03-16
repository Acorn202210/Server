package com.acorn2.plec.api.lectureStudent.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentReadListResDto;


public interface LectureStudentService {

	LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto);

	LectureStudentOneReadResDto LectureStudentOne(String lecStuUserId, int lecStuRefGroup);
	
	Map<String, Object> isStudent(String lecStuUserId, int lecStuRefGroup);
	
	void LectureSignup (LectureStudentCreateReqDto lecstudentCreateDto, String id);
	
	void LectureCompleteYn (LectureStudentUpdateReqDto studentUpdateReqDto, String id);
	
	void LectureDelete();

}