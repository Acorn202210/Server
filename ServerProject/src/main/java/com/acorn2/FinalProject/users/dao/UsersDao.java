package com.acorn2.FinalProject.users.dao;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;

@Mapper
public interface UsersDao {
	
	Integer insertUser(UsersCreateReqDto usersCreateReqDto);
}
