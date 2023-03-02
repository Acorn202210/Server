package com.acorn2.plec.lectureStudent.service;

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

import com.acorn2.plec.lectureStudent.dao.LectureStudentDao;
import com.acorn2.plec.lectureStudent.dto.LectureStudentDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentCreateReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentReadReqDto;
import com.acorn2.plec.lectureStudent.dto.req.LectureStudentUpdateReqDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentOneReadResDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentReadListResDto;
import com.acorn2.plec.lectureStudent.dto.res.LectureStudentReadResDto;

@EnableCaching
@Service
public class LectureStudentServiceImpl implements LectureStudentService{
	@Autowired LectureStudentDao studentDao;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Cacheable(value = "lecturesStudent", key = "#studentReadReqDto.hashCode()")
	@Override
	public LectureStudentReadListResDto LectureStudentList(LectureStudentReadReqDto studentReadReqDto) {
		
		if(studentReadReqDto.getKeyword() != null){
			if(studentReadReqDto.getCondition().equals("lecUserId")){
				studentReadReqDto.setLecUserId(studentReadReqDto.getKeyword());
			}else if(studentReadReqDto.getCondition().equals("userBirth")){ 
				studentReadReqDto.setUserBirth(studentReadReqDto.getKeyword());
			}else if(studentReadReqDto.getCondition().equals("userPhone")){ 
				studentReadReqDto.setUserPhone(studentReadReqDto.getKeyword());
			}else if(studentReadReqDto.getCondition().equals("userEmail")){ 
				studentReadReqDto.setUserEmail(studentReadReqDto.getKeyword());
			}else if(studentReadReqDto.getCondition().equals("userRegdate")){ 
				studentReadReqDto.setUserRegdate(studentReadReqDto.getKeyword());
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
	public LectureStudentOneReadResDto LectureStudentOne(int lecStuNum) {
		return studentDao.studentDataOne(lecStuNum);
	}

	@Transactional
	@Override
	public void LectureSignup(Integer lecStuRefGroup, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		LectureStudentDto dto = new LectureStudentDto();
		dto.setLecStuUserId(id);
		dto.setLecStuRefGroup(lecStuRefGroup);
		
		studentDao.LectureSignup(dto);
	}

	@Transactional
	@Override
	public void LectureCompleteYn(LectureStudentUpdateReqDto studentUpdateReqDto, HttpServletRequest request) {
		LectureStudentDto dto = new LectureStudentDto();
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		dto.setLecStuUserId(id);
		dto.setLecStuNum(studentUpdateReqDto.getLecStuNum());
		
		studentDao.LectureCompleteYn(dto);
	}

	@Transactional
	@Override
	public void LectureDelete() {
		studentDao.LectureStudentDelete();
		
	}


}