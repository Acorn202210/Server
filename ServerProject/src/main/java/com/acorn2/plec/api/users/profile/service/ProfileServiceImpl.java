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



@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired private ProflieDao profileDao;
	

	@Override
	public Map<String, Object> selectProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ProfileDto profileDto = profileDao.selectProfile(session.getAttribute("id").toString());
		      
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", profileDto.getMimetype());
		headers.add("Content-Length", String.valueOf(profileDto.getData().length));
      
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("profileDto", profileDto);
		map.put("headers", headers);
      
		return map;
	}


	@Override
	public void updateProfile(MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		ProfileDto dto= profileDao.selectProfile(id);
		
		ProfileDto profileDto = new ProfileDto();
		if(file != null) {
			try {
				profileDto.setLecUserId(id);
				profileDto.setMimetype(file.getContentType());
				profileDto.setOriginalName(file.getOriginalFilename());
				profileDto.setData(file.getBytes());
				if(dto == null) {
					profileDao.insertProfile(profileDto);
				}else {
					profileDao.updateProfile(profileDto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
