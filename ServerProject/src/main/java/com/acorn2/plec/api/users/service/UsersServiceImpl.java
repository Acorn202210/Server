package com.acorn2.plec.api.users.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.users.dao.UsersDao;
import com.acorn2.plec.api.users.dto.req.UsersCreateReqDto;
import com.acorn2.plec.api.users.dto.req.UsersLoginReqDto;
import com.acorn2.plec.api.users.dto.req.UsersReadReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadListResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadResDto;
import com.acorn2.plec.api.users.exception.UsersNotLoginException;
import com.acorn2.plec.api.users.profile.dao.ProflieDao;
import com.acorn2.plec.api.users.profile.dto.ProfileDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired private UsersDao usersDao;
	@Autowired private ProflieDao profileDao;

	@Override
	public Map<String, Object> isValidId(String lecUserId) {
		Map<String, Object> isValid = new HashMap<>();
		
		UsersReadDetailResDto dto = usersDao.selectUser(lecUserId);
		
		if(dto == null) {
			isValid.put("isValid", true);
		}else {
			isValid.put("isValid", false);
		}
		return isValid;
	}
	

	@Override
	public UsersReadListResDto selectUsersList(UsersReadReqDto usersReadReqDto) {
		Integer totalCount = usersDao.selectUsersCount(usersReadReqDto);
		List<UsersReadResDto> usersReadResDtoList = usersDao.selectUsersList(usersReadReqDto);
		UsersReadListResDto usersReadListResDto = new UsersReadListResDto(totalCount, usersReadReqDto);
		usersReadListResDto.setData(usersReadResDtoList);
		return usersReadListResDto;
	}

	@Override
	public UsersReadDetailResDto selectUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return usersDao.selectUser(session.getAttribute("id").toString());
	}

	@Transactional
	@Override
	public void insertUser(UsersCreateReqDto usersCreateReqDto) {
		String pwd = usersCreateReqDto.getUserPwd();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(pwd);
		
		usersCreateReqDto.setUserPwd(encodedPwd);
		usersDao.insertUser(usersCreateReqDto);		
	}

	@Override
	public Map<String, String> login(UsersLoginReqDto usersLoginReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = usersLoginReqDto.getLecUserId();
		
		boolean isValid = false;
		UsersReadDetailResDto resultDto = usersDao.selectUser(id);

		if(resultDto != null) {
			isValid = BCrypt.checkpw(usersLoginReqDto.getUserPwd(), resultDto.getUserPwd());
		}
	
		if(isValid) {
			session.setAttribute("id", id);
			usersDao.updateUserLastDate(id);
		}else {
			throw new UsersNotLoginException("비밀번호가 잘못되었습니다!");
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("isManager", resultDto.getManagerYn());
		
		return map;
		
	}

	@Override
	public void updateUser(UsersUpdateReqDto usersUpdateReqDto, MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		ProfileDto dto= profileDao.selectProfile(id);
		
		ProfileDto profileDto = new ProfileDto();
		if(file != null) {
			try {
				profileDto.setLecUserId(id);
				profileDto.setMimetype(file.getContentType());
				profileDto.setOriginalName(file.getOriginalFilename());
				profileDto.setData(file.getBytes());
				if(dto == null) {
					profileDao.insertProfile(profileDto);
				}else {
					profileDao.updateProfile(profileDto);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(usersUpdateReqDto.getUserEmail() != null || usersUpdateReqDto.getUserPhone() != null || usersUpdateReqDto.getUserPhone() != null) {
			usersUpdateReqDto.setLecUserId(id);
			usersDao.updateUser(usersUpdateReqDto);
		}
		
	}

	@Override
	public void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();

		String id = session.getAttribute("id").toString();
		
		UsersReadDetailResDto resultDto = usersDao.selectUser(id);
		String encodedPwd = resultDto.getUserPwd();
		String inputPwd = usersUpdatePwdReqDto.getUserPwd();
		boolean isValid = BCrypt.checkpw(inputPwd, encodedPwd);
		
		if(isValid) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedNewPwd = encoder.encode(usersUpdatePwdReqDto.getNewPwd());
			usersUpdatePwdReqDto.setNewPwd(encodedNewPwd);
			usersUpdatePwdReqDto.setLecUserId(id);
			usersDao.updateUserPwd(usersUpdatePwdReqDto);	
			session.removeAttribute("id");
		}
	}

	@Override
	public void deleteUpdateUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		
		usersDao.deleteUpdateUser(id);
		profileDao.deleteUpdateProfile(id);
		
		session.removeAttribute("id");
	}

	@Override
	public void batchUser() {
		usersDao.deleteUser();
		profileDao.deleteProfile();
		
		usersDao.updateRestUser();
	}	
}
