package com.acorn2.FinalProject.lectureStudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.lectureStudent.dao.LectureStudentDao;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentOneReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.FinalProject.lectureStudent.dto.res.LectureStudentReadResDto;

@Service
public class LectureStudentServiceImpl implements LectureStudentService{
	@Autowired LectureStudentDao studentDao;
	
	@Override
	public LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto) {
		Integer totalCount = studentDao.SelectLectureStudentCount(studentReadReqDto);
		List<LectureStudentReadResDto> StudentReadResDto = studentDao.LectureStudentList(studentReadReqDto);
		LectureStudentReadListResDto studentReadListResDto = new LectureStudentReadListResDto(totalCount, studentReadReqDto);
		studentReadListResDto.setData(StudentReadResDto);
		return studentReadListResDto;
	}

	@Override
	public LectureStudentOneReadReqDto LectureStudentOne(int lecStuNum) {
		return studentDao.studentDataOne(lecStuNum);
	}

	@Override
	public void LectureSignup(LectureStudentCreateReqDto studentCreateReqDto) {
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuNum(studentCreateReqDto.getLecStuNum());
		dto.setLecStuUserId(studentCreateReqDto.getLecStuUserId());
		dto.setLecStuRefGroup(studentCreateReqDto.getLecStuRefGroup());
		
		studentDao.LectureSignup(dto);
	}

	@Override
	public void LectureCompleteYn(LectureStudentUpdateReqDto studentUpdateReqDto) {
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuNum(studentUpdateReqDto.getLecStuNum());
		dto.setCompleteYn(studentUpdateReqDto.getCompleteYn());
		
		studentDao.LectureCompleteYn(dto);
	}


}