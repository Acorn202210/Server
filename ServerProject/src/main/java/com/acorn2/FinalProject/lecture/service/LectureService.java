package com.acorn2.FinalProject.lecture.service;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.LectureReq;
import com.acorn2.FinalProject.lecture.dto.LectureRes;





public interface LectureService {
	//강의 리스트 가져오기
	public ResponseEntity<List<LectureDto>> LectureList(int pageNum, String large_category, String small_category);
	
	//연습 이미지 업로드
	public Map<String, Object> uploadImage(LectureDto dto, HttpServletRequest request);
	
	//이미지 업로드
	public void saveImage(LectureDto dto, HttpServletRequest request);
	
	//강의 저장하기
	public Map<String,String> insert(LectureRes lectureRes);
	//강의 상세보기
	public ResponseEntity<LectureDto> getDetail(int num);
	//강의 하나의 정보 가져오기
	public ResponseEntity<LectureDto> getData(int num);
	//강의 수정
	public Map<String, String> updateContent(LectureReq lectureReq);
	//강의 삭제
	public ResponseEntity<Object> deleteContent(int num);
	
	
}
