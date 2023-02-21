package com.acorn2.FinalProject.users.service;

import javax.servlet.http.HttpSession;

import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersLoginReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersReadReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdateReqDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadDetailResDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadListResDto;

public interface UsersService {
	UsersReadListResDto selectUsersList(UsersReadReqDto usersReadReqDto);
	UsersReadDetailResDto selectUser(HttpSession session);
	void insertUser(UsersCreateReqDto usersCreateReqDto);
	void login(UsersLoginReqDto usersLoginReqDto, HttpSession session);
	void updateUser(UsersUpdateReqDto usersUpdateReqDto, HttpSession session);
	void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, HttpSession session);

}
