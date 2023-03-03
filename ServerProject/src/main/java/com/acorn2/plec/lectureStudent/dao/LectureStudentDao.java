package com.acorn2.plec.lectureStudent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.lectureStudent.dto.LectureStudentDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentReadResDto;

@Mapper
public interface LectureStudentDao {
	public List<LectureStudentReadResDto> LectureStudentList(LectureStudentReadReqDto studentReadReqDto);
	
	public Integer SelectLectureStudentCount(LectureStudentReadReqDto studentReadReqDto);

	public LectureStudentOneReadResDto studentDataOne (int lecStuNum);
	
	Integer LectureSignup(LectureStudentDto dto);
	
	Integer LectureCompleteYn(LectureStudentDto dto);
	
	Integer LectureStudentDelete();

}
