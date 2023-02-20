package com.acorn2.FinalProject.users.service;

import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;

public interface UsersService {
	void insertUser(UsersCreateReqDto usersCreateReqDto);
}
