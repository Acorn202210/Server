package com.acorn2.FinalProject.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.FinalProject.users.dao.UsersDao;
import com.acorn2.FinalProject.users.dto.req.UsersCreateReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersLoginReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersReadReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.FinalProject.users.dto.req.UsersUpdateReqDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadDetailResDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadListResDto;
import com.acorn2.FinalProject.users.dto.res.UsersReadResDto;
import com.acorn2.FinalProject.users.exception.UsersNotLoginException;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired private UsersDao usersDao;
	
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
	public void login(UsersLoginReqDto usersLoginReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();

		boolean isValid = false;
		UsersReadDetailResDto resultDto = usersDao.selectUser(usersLoginReqDto.getLecUserId());
		if(resultDto != null) {
			isValid = BCrypt.checkpw(usersLoginReqDto.getUserPwd(), resultDto.getUserPwd());
		}
	
		if(isValid) {
			session.setAttribute("id", resultDto.getLecUserId());
		}else {
			throw new UsersNotLoginException("비밀번호가 잘못되었습니다!");
		}
	}

	@Override
	public void updateUser(UsersUpdateReqDto usersUpdateReqDto, HttpServletRequest request) {
		HttpSession session = request.getSession();

		usersUpdateReqDto.setLecUserId(session.getAttribute("id").toString());
		usersDao.updateUser(usersUpdateReqDto);
		
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

		usersDao.deleteUpdateUser(session.getAttribute("id").toString());
		session.removeAttribute("id");
	}

	@Override
	public void deleteUser() {
		usersDao.deleteUser();
	}
}
