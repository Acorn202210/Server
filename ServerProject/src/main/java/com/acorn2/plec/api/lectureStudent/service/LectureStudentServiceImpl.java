package com.acorn2.plec.api.lectureStudent.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.lectureStudent.dao.LectureStudentDao;
import com.acorn2.plec.api.lectureStudent.dto.LectureStudentDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.api.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.plec.api.lectureStudent.dto.res.LectureStudentReadResDto;


@EnableCaching
@Service
public class LectureStudentServiceImpl implements LectureStudentService{
	@Autowired LectureStudentDao studentDao;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Cacheable(value = "lecturesStudent", key = "#studentReadReqDto.hashCode()")
	@Override
	public LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto) {
		
		if(studentReadReqDto.getKeyword() != null){
			String condition = studentReadReqDto.getCondition();
			String keword = studentReadReqDto.getKeyword();
			if("lecUserId".equals(condition)){
				studentReadReqDto.setLecUserId(keword);
			}else if("userBirth".equals(condition)){ 
				studentReadReqDto.setUserBirth(keword);
			}else if("userPhone".equals(condition)){ 
				studentReadReqDto.setUserPhone(keword);
			}else if("userEmail".equals(condition)){ 
				studentReadReqDto.setUserEmail(keword);
			}else if("userRegdate".equals(condition)){ 
				studentReadReqDto.setUserRegdate(keword);
			}
		}
		
		Integer totalCount = studentDao.SelectLectureStudentCount(studentReadReqDto);
		List<LectureStudentReadResDto> StudentReadResDto = studentDao.LectureStudentList(studentReadReqDto);
		LectureStudentReadListResDto studentReadListResDto = new LectureStudentReadListResDto(totalCount, studentReadReqDto);
		studentReadListResDto.setData(StudentReadResDto);
		logger.debug("lectureStudent Cach", studentReadReqDto.hashCode(), StudentReadResDto.toString());
		return studentReadListResDto;
	}

	@Override
	public LectureStudentOneReadResDto LectureStudentOne(String lecStuUserId, int lecStuRefGroup) {
		return studentDao.studentDataOne(lecStuUserId, lecStuRefGroup);
	}
	
	@Override
	public boolean hasStudentDataOne(String lecStuUserId, int lecStuRefGroup) {
	    LectureStudentOneReadResDto result = studentDao.studentDataOne(lecStuUserId, lecStuRefGroup);
	    return result != null ? true : false;
	}

	@Transactional
	@Override
	public void LectureSignup(LectureStudentCreateReqDto lecstudentCreateDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuUserId(id);
		dto.setLecStuRefGroup(lecstudentCreateDto.getLecStuRefGroup());
		
		studentDao.LectureSignup(dto);
	}

	@Transactional
	@Override
	public void LectureCompleteYn(LectureStudentUpdateReqDto studentUpdateReqDto, HttpServletRequest request) {
		LectureStudentDto dto = new LectureStudentDto();
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		dto.setLecStuUserId(id);
		dto.setLecStuRefGroup(studentUpdateReqDto.getLecStuRefGroup());
		
		studentDao.LectureCompleteYn(dto);
	}

	@Transactional
	@Override
	public void LectureDelete() {
		studentDao.LectureStudentDelete();
		
	}



}