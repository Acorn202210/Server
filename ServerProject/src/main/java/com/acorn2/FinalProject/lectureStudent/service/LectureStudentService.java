package com.acorn2.FinalProject.lectureStudent.service;

import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;

public interface LectureStudentService {
	LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto);
}