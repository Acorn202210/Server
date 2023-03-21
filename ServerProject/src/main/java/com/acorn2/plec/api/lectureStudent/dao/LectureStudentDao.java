package com.acorn2.plec.api.lectureStudent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.lectureStudent.dto.LectureStudentDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentReadResDto;


@Mapper
public interface LectureStudentDao {
	public List<LectureStudentReadResDto> LectureStudentList(LectureStudentReadReqDto studentReadReqDto);
	
	public Integer SelectLectureStudentCount(LectureStudentReadReqDto studentReadReqDto);

	public LectureStudentOneReadResDto studentDataOne (String lecStuUserId, Integer lecStuRefGroup);
	
	Integer LectureSignup(LectureStudentDto dto);
	
	Integer LectureCompleteYn(LectureStudentDto dto);
	
	Integer LectureStudentDelete();

}
