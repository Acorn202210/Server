package com.acorn2.FinalProject.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.notice.dto.req.NoticeCreateReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;
import com.acorn2.FinalProject.users.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("Users")
@RequestMapping("/api/users")
public class UsersController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private UsersService service;
	
	@ApiOperation(value="회원가입", notes = "회원가입")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertNotice(@RequestBody UsersCreateReqDto usersCreateReqDto){
		service.insertUser(usersCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
}
