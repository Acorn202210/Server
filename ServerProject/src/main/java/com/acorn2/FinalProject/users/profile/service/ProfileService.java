package com.acorn2.FinalProject.users.profile.service;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.FinalProject.users.profile.dto.ProfileDto;

public interface ProfileService {
	void insertProfile(MultipartFile file);

}
