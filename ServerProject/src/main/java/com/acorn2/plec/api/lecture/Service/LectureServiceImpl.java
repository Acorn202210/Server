package com.acorn2.plec.api.lecture.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.lecture.dao.LectureDao;
import com.acorn2.plec.api.lecture.dto.LectureDto;
import com.acorn2.plec.api.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureReadReqDto;
import com.acorn2.plec.api.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadListResDto;
import com.acorn2.plec.api.lecture.dto.res.LectureReadResDto;
import com.acorn2.plec.api.lecture.image.dao.ImageDao;
import com.acorn2.plec.api.lecture.image.dto.ImageDto;



@Service
public class LectureServiceImpl implements LectureService{
	@Autowired private LectureDao lectureDao;
	@Autowired private ImageDao imageDao;

	@Override
	public LectureReadListResDto LectureList(LectureReadReqDto lectureReadReqDto) {	
		Integer totalCount = lectureDao.selectLectureCount(lectureReadReqDto);
		List<LectureReadResDto> lectureReadResDtoList = lectureDao.lectureList(lectureReadReqDto);
		LectureReadListResDto lectureReadListRedDto = new LectureReadListResDto(totalCount,lectureReadReqDto);
		lectureReadListRedDto.setData(lectureReadResDtoList);
		return lectureReadListRedDto;
	}

	@Override
	public LectureDto LectureOne(Integer lecNum) {
		
		return lectureDao.lectureOne(lecNum);
	}

	@Transactional
	@Override
	public void LectureInsert(LectureCreateReqDto lectureCreateReqDto, String id) {
		LectureDto dto = new LectureDto();
	    ImageDto imageDto = new ImageDto();
	    imageDto.setImageNum(lectureCreateReqDto.getImageNum()); 
	    
	    dto.setImageNum(imageDto.getImageNum());
		dto.setTeacher(lectureCreateReqDto.getTeacher());
		dto.setLecWriter(id);
		dto.setTitle(lectureCreateReqDto.getTitle());
		dto.setDescribe(lectureCreateReqDto.getDescribe());
		dto.setVideoPath(lectureCreateReqDto.getVideoPath());
		dto.setLargeCategory(lectureCreateReqDto.getLargeCategory());
		dto.setSmallCategory(lectureCreateReqDto.getSmallCategory());
		
		lectureDao.lectureInsert(dto);
		
		
	}
	
	@Transactional
	@Override
	public void LectureDelete(Integer lecNum) {
		lectureDao.lectureDelete(lecNum);
		
	}

	@Transactional
	@Override
	public void LectureUpdate(LectureUpdateReqDto lectureUpdateReqDto, String id) {
		LectureDto dto = new LectureDto();
		ImageDto imageDto = new ImageDto();
		imageDto.setImageNum(lectureUpdateReqDto.getImageNum()); 
		
		dto.setImageNum(imageDto.getImageNum());
		dto.setLecNum(lectureUpdateReqDto.getLecNum());
		dto.setTitle(lectureUpdateReqDto.getTitle());
		dto.setTeacher(lectureUpdateReqDto.getTeacher());
		dto.setUpdateId(id);
		dto.setDescribe(lectureUpdateReqDto.getDescribe());
		dto.setVideoPath(lectureUpdateReqDto.getVideoPath());
		dto.setLargeCategory(lectureUpdateReqDto.getLargeCategory());
		dto.setSmallCategory(lectureUpdateReqDto.getSmallCategory());
		lectureDao.lectureUpdate(dto);

	}
	
	@Transactional
	@Override
	public void batchLectureDelete() {
		lectureDao.batchLectureDelete();
		
	}
	

	
	
}
