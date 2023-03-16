package com.acorn2.plec.api.lecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.lecture.dto.LectureDto;
import com.acorn2.plec.api.lecture.dto.req.LectureReadReqDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadResDto;


@Mapper
public interface LectureDao {
	public List<LectureReadResDto> lectureList(LectureReadReqDto lectureReadReqDto);

	public Integer selectLectureCount(LectureReadReqDto lectureReadReqDto);
	
	public LectureDto lectureOne(Integer lecNum);
	
	Integer lectureInsert(LectureDto dto);
	
	Integer lectureDelete(Integer lecNum);
	
	Integer lectureUpdate(LectureDto dto);
	
	Integer currentLecNum();
	
	Integer batchLectureDelete();
}
