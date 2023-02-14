package com.acorn2.FinalProject.lectureStudent.service;



import java.util.List;
import java.util.Map;



import org.springframework.http.ResponseEntity;


import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentReq;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentRes;






public interface LectureStudentService {
	//강의 신청
	public ResponseEntity<Object> lectureSignup(LectureStudentRes res);
	
	//강의 신청 리스트
	public ResponseEntity<List<LectureStudentDto>> studentList(int pageNum, String large_category, String small_category);

	public ResponseEntity<Object> lectureComplete(LectureStudentReq req);
}
