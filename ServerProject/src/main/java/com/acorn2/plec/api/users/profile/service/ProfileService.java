package com.acorn2.plec.api.users.profile.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;


public interface ProfileService {
	Map<String, Object> selectProfile(HttpServletRequest request);
	void updateProfile(MultipartFile file, HttpServletRequest request);
}
