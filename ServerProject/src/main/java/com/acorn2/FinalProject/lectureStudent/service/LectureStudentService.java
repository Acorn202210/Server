package com.acorn2.FinalProject.lectureStudent.service;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentReq;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentRes;






public interface LectureStudentService {
	//강의 신청
	public Map<String, String> lectureSignup(LectureStudentRes res);
	
	//강의 신청 리스트
	public Map<String, Object> studentList(int pageNum, String large_category, String small_category);
	
	
	public Map<String, String> lectureComplete(LectureStudentReq req);
}
