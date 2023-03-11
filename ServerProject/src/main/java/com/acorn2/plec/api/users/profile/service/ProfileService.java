package com.acorn2.plec.api.users.profile.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.profile.dto.ProfileDto;
import com.acorn2.plec.api.users.profile.dto.ProfileNumDto;


public interface ProfileService {
	Map<String, Object> selectProfile(Integer profileNum);
	void updateProfile(MultipartFile file, Integer profileNum) throws IOException;
	ProfileNumDto insertProfile(MultipartFile file, String id) throws IOException;

}
