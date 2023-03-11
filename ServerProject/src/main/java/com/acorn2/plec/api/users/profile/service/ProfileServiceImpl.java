package com.acorn2.plec.api.users.profile.service;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.profile.dao.ProflieDao;
import com.acorn2.plec.api.users.profile.dto.ProfileDto;
import com.acorn2.plec.api.users.profile.dto.ProfileNumDto;



@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired private ProflieDao profileDao;
	

	@Override
	public Map<String, Object> selectProfile(Integer profileNum) {
		ProfileDto profileDto = profileDao.selectProfile(profileNum);
		      
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", profileDto.getMimetype());
		headers.add("Content-Length", String.valueOf(profileDto.getData().length));
      
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("profileDto", profileDto);
		map.put("headers", headers);
      
		return map;
	}

	@Override
	public void updateProfile(MultipartFile file, Integer profileNum) throws IOException {
		ProfileDto profileDto = new ProfileDto();
	
		profileDto.setMimetype(file.getContentType());
		profileDto.setOriginalName(file.getOriginalFilename());
		profileDto.setData(file.getBytes());
		profileDao.updateProfile(profileDto);
		
		
	}


	@Override
	public ProfileNumDto insertProfile(MultipartFile file, String id) {
		
		ProfileDto profileDto = new ProfileDto();
		try {
			profileDto.setLecUserId(id);
			profileDto.setMimetype(file.getContentType());
			profileDto.setOriginalName(file.getOriginalFilename());
			profileDto.setData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profileDao.insertProfile(profileDto);
	
		ProfileNumDto dto = new ProfileNumDto(profileDto.getProfileNum());
		

		return 	dto;
		
	}
	
	
}
