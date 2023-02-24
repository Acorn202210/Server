package com.acorn2.FinalProject.lectureStudent.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.FinalProject.lectureStudent.dao.LectureStudentDao;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadResDto;

@EnableCaching
@Service
public class LectureStudentServiceImpl implements LectureStudentService{
	@Autowired LectureStudentDao studentDao;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Cacheable(value = "lecturesStudent", key = "#studentReadReqDto.hashCode()")
	@Override
	public LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto) {
		Integer totalCount = studentDao.SelectLectureStudentCount(studentReadReqDto);
		List<LectureStudentReadResDto> StudentReadResDto = studentDao.LectureStudentList(studentReadReqDto);
		LectureStudentReadListResDto studentReadListResDto = new LectureStudentReadListResDto(totalCount, studentReadReqDto);
		studentReadListResDto.setData(StudentReadResDto);
		logger.debug("Cached value for key {} is {}", studentReadReqDto.hashCode(), StudentReadResDto.toString());
		return studentReadListResDto;
	}

	@Override
	public LectureStudentOneReadResDto LectureStudentOne(int lecStuNum) {
		return studentDao.studentDataOne(lecStuNum);
	}

	@Transactional
	@Override
	public void LectureSignup(LectureStudentCreateReqDto studentCreateReqDto) {
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuNum(studentCreateReqDto.getLecStuNum());
		dto.setLecStuUserId(studentCreateReqDto.getLecStuUserId());
		dto.setLecStuRefGroup(studentCreateReqDto.getLecStuRefGroup());
		
		studentDao.LectureSignup(dto);
	}

	@Transactional
	@Override
	public void LectureCompleteYn(LectureStudentUpdateReqDto studentUpdateReqDto) {
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuNum(studentUpdateReqDto.getLecStuNum());
		dto.setCompleteYn(studentUpdateReqDto.getCompleteYn());
		
		studentDao.LectureCompleteYn(dto);
	}


}