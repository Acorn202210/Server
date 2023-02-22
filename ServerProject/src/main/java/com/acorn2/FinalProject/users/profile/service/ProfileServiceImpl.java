package com.acorn2.FinalProject.users.profile.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.users.profile.dao.ProflieDao;
import com.acorn2.FinalProject.users.profile.dto.ProfileDto;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired private ProflieDao profileDao;
	
	@Override
	public void insertProfile(MultipartFile file) {
		ProfileDto profileDto = new ProfileDto();
		try {
			profileDto.setMimetype(file.getContentType());
			profileDto.setOriginalName(file.getOriginalFilename());
			profileDto.setData(file.getBytes());
			profileDao.insertProfile(profileDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
