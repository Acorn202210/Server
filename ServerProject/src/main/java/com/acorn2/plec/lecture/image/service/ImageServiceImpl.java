package com.acorn2.plec.lecture.image.service;

import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.acorn2.plec.lecture.image.dao.ImageDao;
import com.acorn2.plec.lecture.image.dto.ImageDto;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired private ImageDao imageDao;

	@Override
	public Map<String, Object> selectImage(int lecNum) {
		ImageDto imageDto = imageDao.selectImage(lecNum);
		      
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", imageDto.getMimetype());
		headers.add("Content-Length", String.valueOf(imageDto.getData().length));
		//폴더하나에 파일1000개씩 파일받을때 시퀀스번호로 저장시키고 보낼때는 헤더에 원래저장한이름으로 보내는게 좋음
		//2023/03/02/01/10/a.jpg 이런식으로 저장시킬수있다.
      
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageDto", imageDto);
		map.put("headers", headers);
      
		return map;
	}

}
