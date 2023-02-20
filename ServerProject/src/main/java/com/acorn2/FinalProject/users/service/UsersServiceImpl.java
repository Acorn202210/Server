package com.acorn2.FinalProject.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.acorn2.FinalProject.users.dao.UsersDao;
import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired private UsersDao dao;
	
	@Override
	public void insertUser(UsersCreateReqDto usersCreateReqDto) {
		String pwd = usersCreateReqDto.getUserPwd();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(pwd);
		
		usersCreateReqDto.setUserPwd(encodedPwd);
		dao.insertUser(usersCreateReqDto);		
	}

}
