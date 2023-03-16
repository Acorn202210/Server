package com.acorn2.plec.api.lecture.image.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.lecture.dao.LectureDao;
import com.acorn2.plec.api.lecture.image.dao.ImageDao;
import com.acorn2.plec.api.lecture.image.dto.ImageDto;
import com.acorn2.plec.api.lecture.image.dto.ImageNumDto;



@Service
public class ImageServiceImpl implements ImageService{
	@Autowired private ImageDao imageDao;


	@Override
	public Map<String, Object> selectImage(Integer imageNum) {
		ImageDto imageDto = imageDao.selectImage(imageNum);
	      
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", imageDto.getMimetype());
		headers.add("Content-Length", String.valueOf(imageDto.getData().length));
      
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageDto", imageDto);
		map.put("headers", headers);
      
		return map;
	}

	@Override
	public void updateImage(MultipartFile file, Integer imageNum) throws IOException {
		ImageDto imageDto = new ImageDto();
		
			imageDto.setImageNum(imageNum);
			imageDto.setMimetype(file.getContentType());
			imageDto.setOriginalName(file.getOriginalFilename());
			imageDto.setData(file.getBytes());
			imageDao.updateImage(imageDto);
		
	}

	@Override
	public ImageNumDto insertImage(MultipartFile file) throws IOException {

		ImageDto imageDto = new ImageDto();
		imageDto.setMimetype(file.getContentType());
		imageDto.setOriginalName(file.getOriginalFilename());
		imageDto.setData(file.getBytes());
				

		imageDao.insertImage(imageDto);
	
		ImageNumDto dto = new ImageNumDto(imageDto.getImageNum());
		

		return 	dto;
	}


}
