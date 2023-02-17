package com.acorn2.FinalProject.lectureStudent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentOneReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadResDto;

@Mapper
public interface LectureStudentDao {
	public List<LectureStudentReadResDto> LectureStudentList(LectureStudentReadReqDto studentReadReqDto);
	
	public Integer SelectLectureStudentCount(LectureStudentReadReqDto studentReadReqDto);

	public LectureStudentOneReadReqDto studentDataOne (int lec_Stu_Num);
	
	Integer LectureSignup(LectureStudentDto dto);
	
	Integer LectureCompleteYn(LectureStudentDto dto);

}
