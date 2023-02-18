package com.acorn2.FinalProject.lectureStudent.service;


import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentOneReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;

public interface LectureStudentService {

	LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto);

	LectureStudentOneReadReqDto LectureStudentOne(int lecStuNum);
	
	void LectureSignup (LectureStudentCreateReqDto studentCreateReqDto);
	
	void LectureCompleteYn (LectureStudentUpdateReqDto studentUpdateReqDto);

}