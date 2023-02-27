package com.acorn2.FinalProject.lecture.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.lecture.dao.LectureDao;
import com.acorn2.FinalProject.lecture.dto.LectureDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureCreateReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureReadReqDto;
import com.acorn2.FinalProject.lecture.dto.req.LectureUpdateReqDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadListResDto;
import com.acorn2.FinalProject.lecture.dto.res.LectureReadResDto;
import com.acorn2.FinalProject.lecture.image.dao.ImageDao;
import com.acorn2.FinalProject.lecture.image.dto.ImageDto;

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
	public LectureDto LectureOne(int lecNum) {
		
		return lectureDao.lectureOne(lecNum);
	}

	@Transactional
	@Override
	public void LectureInsert(LectureCreateReqDto lectureCreateReqDto,MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		LectureDto dto = new LectureDto();		
		dto.setTeacher(lectureCreateReqDto.getTeacher());
		dto.setLecWriter(id);
		dto.setTitle(lectureCreateReqDto.getTitle());
		dto.setDescribe(lectureCreateReqDto.getDescribe());
		dto.setVideoPath(lectureCreateReqDto.getVideoPath());
		dto.setLargeCategory(lectureCreateReqDto.getLargeCategory());
		dto.setSmallCategory(lectureCreateReqDto.getSmallCategory());
		
		lectureDao.lectureInsert(dto);
		
		Integer lecNum = lectureDao.currentLecNum();
		
		ImageDto imageSelectDto= imageDao.selectImage(lecNum);
		
		ImageDto imageDto = new ImageDto();
		if(file != null) {
			try {
				imageDto.setLecNum(lecNum);
				imageDto.setMimetype(file.getContentType());
				imageDto.setOriginalName(file.getOriginalFilename());
				imageDto.setData(file.getBytes());
				if(imageSelectDto == null) {
					imageDao.insertImage(imageDto);
				}else {
					imageDao.updateImage(imageDto);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Transactional
	@Override
	public void LectureDelete(int lecNum) {
		lectureDao.lectureDelete(lecNum);
		
	}

	@Transactional
	@Override
	public void LectureUpdate(LectureUpdateReqDto lectureUpdateReqDto, MultipartFile file,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		LectureDto dto = new LectureDto();
		dto.setLecNum(lectureUpdateReqDto.getLecNum());
		dto.setTitle(lectureUpdateReqDto.getTitle());
		dto.setTeacher(lectureUpdateReqDto.getTeacher());
		dto.setUpdateId(id);
		dto.setDescribe(lectureUpdateReqDto.getDescribe());
		dto.setVideoPath(lectureUpdateReqDto.getVideoPath());
		dto.setLargeCategory(lectureUpdateReqDto.getLargeCategory());
		dto.setSmallCategory(lectureUpdateReqDto.getSmallCategory());
		lectureDao.lectureUpdate(dto);
		
		Integer lecNum = lectureDao.currentLecNum();
		ImageDto imageDto= new ImageDto();
		ImageDto imageSelectDto= imageDao.selectImage(lecNum);
		if(file != null) {
			try {
				imageDto.setLecNum(lecNum);
				imageDto.setMimetype(file.getContentType());
				imageDto.setOriginalName(file.getOriginalFilename());
				imageDto.setData(file.getBytes());
				if(imageSelectDto == null) {
					imageDao.insertImage(imageDto);
				}else {
					imageDao.updateImage(imageDto);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Transactional
	@Override
	public void batchLectureDelete() {
		lectureDao.batchLectureDelete();
		
	}


	
	
	
}
