package com.acorn2.FinalProject.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.notice.dto.req.NoticeReadReqDto;
import com.acorn2.FinalProject.notice.dto.res.NoticeReadDetailResDto;
import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersLoginReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersReadReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdateReqDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadDetailResDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadListResDto;
import com.acorn2.FinalProject.users.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api("Users")
@RequestMapping("/api/users")
public class UsersController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private UsersService service;
	
	@ApiOperation(value="회원 목록", notes = "모든 회원의 목록을 가져온다.")
	@GetMapping
	public ComResponseEntity<UsersReadListResDto> getUsersList(@Parameter(hidden = true) UsersReadReqDto usersReadReqDto) {
		UsersReadListResDto usersReadListResDto = service.selectUsersList(usersReadReqDto);
		logger.debug("usersReadReqDto parameter:{}", usersReadReqDto.getLecUserId());
		return new ComResponseEntity<>(new ComResponseDto<>(usersReadListResDto));
	}
	
	@ApiOperation(value="마이페이지", notes = "마이페이지의 회원 정보를 가져온다.")
	@GetMapping(value = "/{lecUserId}")
	public ComResponseEntity<UsersReadDetailResDto> getNotice(HttpServletRequest request) {
		UsersReadDetailResDto usersReadResDto = service.selectUser(request);
		return new ComResponseEntity<>(new ComResponseDto<>(usersReadResDto));
	}
	
	@ApiOperation(value="회원가입", notes = "회원가입")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertNotice(@RequestBody UsersCreateReqDto usersCreateReqDto){
		service.insertUser(usersCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	
	@ApiOperation(value="로그인", notes = "로그인")
	@PostMapping(value="/{lecUserId}/login")
	public ComResponseEntity<Void> login(@RequestBody UsersLoginReqDto usersLoginReqDto, HttpServletRequest request){
		service.login(usersLoginReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="로그아웃", notes = "로그아웃")
	@PostMapping(value="/{lecUserId}/logout")
	public ComResponseEntity<Void> logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		return new ComResponseEntity<Void>();
	}
	
	
	@ApiOperation(value="개인정보 수정", notes = "개인정보 수정하기")
	@PutMapping(value="/{lecUserId}")
	public ComResponseEntity<Void> update(@RequestBody UsersUpdateReqDto usersUpdateReqDto, HttpServletRequest request){
		service.updateUser(usersUpdateReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="비밀번호 수정", notes = "비밀번호 수정하기")
	@PutMapping(value="/{lecUserId}/pwdUpdate")
	public ComResponseEntity<Void> updatePwd(@RequestBody UsersUpdatePwdReqDto usersUpdatePwdReqDto, HttpServletRequest request){
		service.updateUserPwd(usersUpdatePwdReqDto, request);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="회원 탈퇴", notes = "회원 탈퇴 ")
	@PutMapping(value="/{lecUserId}/delete")
	public ComResponseEntity<Void> deleteUser(HttpServletRequest request){
		service.deleteUpdateUser(request);
		return new ComResponseEntity<Void>();
	}
}
