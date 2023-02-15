package com.acorn2.FinalProject.lectureStudent.service;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.acorn2.FinalProject.lectureStudent.dao.LectureStudentDao;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentDto;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentReq;
import com.acorn2.FinalProject.lectureStudent.dto.LectureStudentRes;




@Service
public class LectureStudentServiceImpl implements LectureStudentService{

	@Autowired LectureStudentDao studentDao;

	@Override
	public ResponseEntity<Object> lectureSignup(LectureStudentRes res) {
		
		studentDao.lectureSignup(res);
		
		return ResponseEntity.ok("Success");
	}
	
	@Override
	public ResponseEntity<Object> lectureComplete(LectureStudentReq req) {
		studentDao.lectureComplete(req);
		
				
		return ResponseEntity.ok("Success");
		
	}

	@Override
	public ResponseEntity<List<LectureStudentDto>> studentList(int pageNum, String large_category, String small_category) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;

		int num=1;
		String strPageNum = Integer.toString(pageNum);
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureStudentDto dto = new LectureStudentDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setLarge_category(large_category);
		dto.setSmall_category(small_category);
	   
		List<LectureStudentDto> list = studentDao.studentList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = studentDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		return ResponseEntity.ok(list);
	}


	
	


}