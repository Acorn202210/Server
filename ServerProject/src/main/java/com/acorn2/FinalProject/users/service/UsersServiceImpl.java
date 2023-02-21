package com.acorn2.FinalProject.users.service;

import java.util.List;

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
	public UsersReadListResDto selectUsersList(UsersReadReqDto usersReadReqDto) {
		Integer totalCount = usersDao.selectUsersCount(usersReadReqDto);
		List<UsersReadResDto> usersReadResDtoList = usersDao.selectUsersList(usersReadReqDto);
		UsersReadListResDto usersReadListResDto = new UsersReadListResDto(totalCount, usersReadReqDto);
		usersReadListResDto.setData(usersReadResDtoList);
		return usersReadListResDto;
	}

	@Override
	public UsersReadDetailResDto selectUser(HttpSession session) {
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
	public void login(UsersLoginReqDto usersLoginReqDto, HttpSession session) {
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
	public void updateUser(UsersUpdateReqDto usersUpdateReqDto, HttpSession session) {
		
		usersUpdateReqDto.setLecUserId(session.getAttribute("id").toString());
		usersDao.updateUser(usersUpdateReqDto);
		
	}

	@Override
	public void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, HttpSession session) {
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

}
