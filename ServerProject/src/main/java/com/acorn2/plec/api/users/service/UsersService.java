package com.acorn2.plec.api.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.dto.req.UsersCreateReqDto;
import com.acorn2.plec.api.users.dto.req.UsersLoginReqDto;
import com.acorn2.plec.api.users.dto.req.UsersReadReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadListResDto;



public interface UsersService {
	Map<String, Object> isValidId(String lecUserId);
	UsersReadListResDto selectUsersList(UsersReadReqDto usersReadReqDto);
	UsersReadDetailResDto selectUser(HttpServletRequest request);
	void insertUser(UsersCreateReqDto usersCreateReqDto);
	Map<String, String> login(UsersLoginReqDto usersLoginReqDto, HttpServletRequest request);
	void updateUser(UsersUpdateReqDto usersUpdateReqDto, MultipartFile file, HttpServletRequest request);
	void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, HttpServletRequest request);
	void deleteUpdateUser(String lecUserId,HttpServletRequest request);
	void batchUser();
}
