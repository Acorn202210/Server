package com.acorn2.FinalProject.users.profile.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public interface ProfileService {
	Map<String, Object> selectProfile(HttpServletRequest request);
}
