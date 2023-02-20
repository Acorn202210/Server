package com.acorn2.FinalProject.lecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureReadReqDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadResDto;

@Mapper
public interface LectureDao {
	public List<LectureReadResDto> lectureList(LectureReadReqDto lectureReadReqDto);

	public Integer selectLectureCount(LectureReadReqDto lectureReadReqDto);
	
	public LectureDto lectureOne(int lecNum);
	
	Integer lectureInsert(LectureDto dto);
	
	Integer lectureDelete(int lecNum);
	
	Integer lectureUpdate(LectureDto dto);
}
