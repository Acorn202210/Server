package com.acorn2.FinalProject.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersReadReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdateReqDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadDetailResDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadResDto;

@Mapper
public interface UsersDao {
	public Integer selectUsersCount(UsersReadReqDto usersReadReqDto);
	public List<UsersReadResDto> selectUsersList(UsersReadReqDto usersReadReqDto);
	public UsersReadDetailResDto selectUser(String lecUserId);
	Integer insertUser(UsersCreateReqDto usersCreateReqDto);
	Integer updateUser(UsersUpdateReqDto usersUpdateReqDto);
	Integer updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto);
	Integer deleteUpdateUser(String lecUserId);
	Integer deleteUser();
}
