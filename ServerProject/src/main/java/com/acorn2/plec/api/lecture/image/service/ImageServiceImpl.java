package com.acorn2.plec.api.lecture.image.service;

import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.acorn2.plec.api.lecture.image.dao.ImageDao;
import com.acorn2.plec.api.lecture.image.dto.ImageDto;



@Service
public class ImageServiceImpl implements ImageService{
	@Autowired private ImageDao imageDao;

	@Override
	public Map<String, Object> selectImage(int lecNum) {
		ImageDto imageDto = imageDao.selectImage(lecNum);
		      
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", imageDto.getMimetype());
		headers.add("Content-Length", String.valueOf(imageDto.getData().length));
      
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageDto", imageDto);
		map.put("headers", headers);
      
		return map;
	}

}
