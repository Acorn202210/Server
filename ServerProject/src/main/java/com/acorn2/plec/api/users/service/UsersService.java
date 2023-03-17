package com.acorn2.plec.api.users.service;

import java.util.Map;

import com.acorn2.plec.api.users.dto.req.UsersCreateReqDto;
import com.acorn2.plec.api.users.dto.req.UsersLoginReqDto;
import com.acorn2.plec.api.users.dto.req.UsersReadReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadListResDto;



public interface UsersService {
	Map<String, Object> isValid(String lecUserId);
	UsersReadListResDto selectUsersList(UsersReadReqDto usersReadReqDto);
	UsersReadListResDto myLectureList(UsersReadReqDto usersReadReqDto, String id);
	UsersReadListResDto myLectureListY(UsersReadReqDto usersReadReqDto, String id);
	UsersReadDetailResDto selectUser(String id);
	void insertUser(UsersCreateReqDto usersCreateReqDto);
	Map<String, String> login(UsersLoginReqDto usersLoginReqDto);
	void updateUser(UsersUpdateReqDto usersUpdateReqDto, String id);
	void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, String id);
	void deleteUpdateUser(String lecUserId);
	void batchUser();
}
