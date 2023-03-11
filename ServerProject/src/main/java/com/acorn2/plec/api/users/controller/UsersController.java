package com.acorn2.plec.api.users.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.dto.req.UsersCreateReqDto;
import com.acorn2.plec.api.users.dto.req.UsersLoginReqDto;
import com.acorn2.plec.api.users.dto.req.UsersReadReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadListResDto;
import com.acorn2.plec.api.users.profile.dto.ProfileDto;
import com.acorn2.plec.api.users.profile.dto.ProfileNumDto;
import com.acorn2.plec.api.users.profile.service.ProfileService;
import com.acorn2.plec.api.users.service.UsersService;
import com.acorn2.plec.common.ComResponseEntity;
import com.acorn2.plec.common.dto.ComResponseDto;
import com.acorn2.plec.common.utils.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@Api("Users")
@RequestMapping("/api/users")
public class UsersController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private UsersService userService;
	@Autowired private ProfileService profileService;	
	
	@ApiOperation(value="아이디 중복 확인", notes = "아이디 중복을 확인한다.")
	@GetMapping(value = "/checkid")
	public ComResponseEntity<Map<String, Object>> checkid(String lecUserId) {
		
		return new ComResponseEntity<>(new ComResponseDto<>(userService.isValidId(lecUserId)));
	}
	
	@ApiOperation(value="회원 목록", notes = "모든 회원의 목록을 가져온다.")
	@GetMapping(value = "/list")
	public ComResponseEntity<UsersReadListResDto> getUsersList(@Parameter(hidden = true) UsersReadReqDto usersReadReqDto) {
		UsersReadListResDto usersReadListResDto = userService.selectUsersList(usersReadReqDto);
		logger.debug("usersReadReqDto parameter:{}", usersReadReqDto.getLecUserId());
		return new ComResponseEntity<>(new ComResponseDto<>(usersReadListResDto));
	}
	
	@ApiOperation(value="마이페이지", notes = "마이페이지의 회원 정보를 가져온다.")
	@GetMapping(value = "/{lecUserId}")
	public ComResponseEntity<UsersReadDetailResDto> getNotice() {
		UsersReadDetailResDto usersReadResDto = userService.selectUser(SessionUtils.getUserId());
		return new ComResponseEntity<>(new ComResponseDto<>(usersReadResDto));
	}
	
	@ApiOperation(value="회원가입", notes = "회원가입")
	@Transactional
	@PostMapping
	public ComResponseEntity<Void> insertNotice(@RequestBody UsersCreateReqDto usersCreateReqDto){
		userService.insertUser(usersCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	
	@ApiOperation(value="로그인", notes = "로그인")
	@Transactional
	@PostMapping(value="/login")
	public ComResponseEntity<Map<String, String>> login(@RequestBody UsersLoginReqDto usersLoginReqDto){
		System.out.println(usersLoginReqDto.getLecUserId());
		return new ComResponseEntity<>(new ComResponseDto<>(userService.login(usersLoginReqDto)));
	}
	
	@ApiOperation(value="로그아웃", notes = "로그아웃")
	@Transactional
	@PostMapping(value="/{lecUserId}/logout")
	public ComResponseEntity<Void> logout(){
		SessionUtils.removeAttribute();
		return new ComResponseEntity<Void>();
	}
	
	
	@ApiOperation(value="프로필 업로드", notes = "프로필 업로드")
	@Transactional
	@PostMapping(value="/{lecUserId}/profile-img-upload")
	public ComResponseEntity<ProfileNumDto> updateProfile(@Parameter(
            description = "multipart/form-data 형식의 이미지 리스트를 input으로 받습니다. 이때 key 값은 multipartFile 입니다.",
            content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
			@RequestPart(value = "multipartFile", required = false) MultipartFile file){
		
		return new ComResponseEntity<>(new ComResponseDto<>(profileService.insertProfile(file, SessionUtils.getUserId())));
	}
	
	@ApiOperation(value="개인정보 수정", notes = "개인정보 수정하기")
	@Transactional
	@PutMapping(value="/{lecUserId}/profile-upload")
	public ComResponseEntity<Void> update(@RequestBody UsersUpdateReqDto usersUpdateReqDto){
		userService.updateUser(usersUpdateReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="비밀번호 수정", notes = "비밀번호 수정하기")
	@Transactional
	@PutMapping(value="/{lecUserId}/pwdUpdate")
	public ComResponseEntity<Void> updatePwd(@RequestBody UsersUpdatePwdReqDto usersUpdatePwdReqDto){
		userService.updateUserPwd(usersUpdatePwdReqDto, SessionUtils.getUserId());
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="회원 탈퇴", notes = "회원 탈퇴 ")
	@Transactional
	@PutMapping(value="/{lecUserId}/delete")
	public ComResponseEntity<Void> deleteUser(@PathVariable(required = false) String lecUserId){		
		userService.deleteUpdateUser(lecUserId);
		return new ComResponseEntity<Void>();
	}
	
	@ApiOperation(value="프로필 가져오기", notes = "프로필 가져오기 ")
	@GetMapping("/profile/{profileNum}")
	public ResponseEntity<byte[]> getProfile(@PathVariable Integer profileNum){
		Map<String, Object> map = profileService.selectProfile(profileNum);
		ProfileDto profileDto = (ProfileDto) map.get("profileDto");
		HttpHeaders headers = (HttpHeaders) map.get("headers");
		
		return new ResponseEntity<byte[]>(profileDto.getData(), headers, HttpStatus.OK);
	}
}