package com.acorn2.FinalProject.lecture.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.lecture.dao.LectureDao;
import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.LectureReq;
import com.acorn2.FinalProject.lecture.dto.LectureRes;
import com.acorn2.FinalProject.lectureReview.dao.LectureReviewDao;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureStudent.dao.LectureStudentDao;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;




@Service
public class LectureServiceImpl implements LectureService{

	@Autowired LectureDao lectureDao;
	@Autowired LectureReviewDao reviewDao;
	@Autowired LectureStudentDao studentDao;

	
	@Value("${file.location}")
	private String fileLocation;


	@Override
	public ResponseEntity<List<LectureDto>> LectureList(int pageNum, String large_category, String small_category) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, Object> uploadImage(LectureDto dto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveImage(LectureDto dto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Map<String, String> insert(LectureRes lectureRes) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<LectureDto> getDetail(int num) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<LectureDto> getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Map<String, String> updateContent(LectureReq lectureReq) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<Object> deleteContent(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
