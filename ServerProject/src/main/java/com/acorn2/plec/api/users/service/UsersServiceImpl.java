package com.acorn2.plec.api.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acorn2.plec.api.users.dao.UsersDao;
import com.acorn2.plec.api.users.dto.req.UsersCreateReqDto;
import com.acorn2.plec.api.users.dto.req.UsersLoginReqDto;
import com.acorn2.plec.api.users.dto.req.UsersReadReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdatePwdReqDto;
import com.acorn2.plec.api.users.dto.req.UsersUpdateReqDto;
import com.acorn2.plec.api.users.dto.res.MyLectureReadResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadListResDto;
import com.acorn2.plec.api.users.dto.res.UsersReadResDto;
import com.acorn2.plec.api.users.exception.UsersNotLoginException;
import com.acorn2.plec.api.users.profile.dao.ProflieDao;
import com.acorn2.plec.common.utils.SessionUtils;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired private UsersDao usersDao;
	@Autowired private ProflieDao profileDao;

	@Override
	public Map<String, Object> isValid(String lecUserId) {
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
	public UsersReadDetailResDto selectUser(String id) {
		return usersDao.selectUser(id);
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
	public Map<String, String> login(UsersLoginReqDto usersLoginReqDto) {
		String id = usersLoginReqDto.getLecUserId();
		
		boolean isValid = false;
		UsersReadDetailResDto resultDto = usersDao.selectUser(id);

		if(resultDto != null) {
			isValid = BCrypt.checkpw(usersLoginReqDto.getUserPwd(), resultDto.getUserPwd());
		}
	
		if(isValid) {
			SessionUtils.setAttribute(id);
			usersDao.updateUserLastDate(id);
		}else {
			throw new UsersNotLoginException("비밀번호가 잘못되었습니다!");
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("isManager", resultDto.getManagerYn());
		
		return map;
		
	}

	@Override
	public void updateUser(UsersUpdateReqDto usersUpdateReqDto, String id) {
		
		// 이전 프로필 사진 삭제
		Integer profileNum = usersDao.selectUser(id).getProfileNum();
		if(usersUpdateReqDto.getProfileNum()!= null && profileNum != null) {
			profileDao.deleteUpdateProfile(profileNum);	
		}
		
		// 프로필 수정
		usersUpdateReqDto.setLecUserId(id);
		usersDao.updateUser(usersUpdateReqDto);
		
		// 프로필  delete_YN_code 'N'으로 변경
		profileDao.deleteUpdateProfileN(usersUpdateReqDto.getProfileNum());
		
	}

	@Override
	public void updateUserPwd(UsersUpdatePwdReqDto usersUpdatePwdReqDto, String id) {
		
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
			SessionUtils.removeAttribute();
		}
	}

	@Override
	public void deleteUpdateUser(String lecUserId) {
		String id = SessionUtils.getUserId();

		usersDao.deleteUpdateUser(lecUserId);
		Integer profileNum = usersDao.selectUser(lecUserId).getProfileNum();
		if(profileNum != null) {
			profileDao.deleteUpdateProfile(profileNum);
		}
		
		if(id.equals(lecUserId)) {
			SessionUtils.removeAttribute();
		}
	}

	@Override
	public void batchUser() {
		usersDao.deleteUser();
		profileDao.deleteProfile();
		
		usersDao.updateRestUser();
	}


	@Override
	public UsersReadListResDto myLectureList(UsersReadReqDto usersReadReqDto, String id) {
		usersReadReqDto.setLecUserId(id);
		Integer totalCount = usersDao.selectMyLecCount(usersReadReqDto);
		List<MyLectureReadResDto> myLectureReadResDtoList = usersDao.myLectureList(usersReadReqDto);
		UsersReadListResDto usersReadListResDto = new UsersReadListResDto(totalCount, usersReadReqDto);
		usersReadListResDto.setLectureData(myLectureReadResDtoList);
		return usersReadListResDto;
	}
	
	@Override
	public UsersReadListResDto myLectureListY(UsersReadReqDto usersReadReqDto, String id) {
		usersReadReqDto.setLecUserId(id);
		Integer totalCount = usersDao.selectMyLecCountY(usersReadReqDto);
		List<MyLectureReadResDto> myLectureReadResDtoList = usersDao.myLectureListY(usersReadReqDto);
		UsersReadListResDto usersReadListResDto = new UsersReadListResDto(totalCount, usersReadReqDto);
		usersReadListResDto.setLectureData(myLectureReadResDtoList);
		return usersReadListResDto;
	}

	
}
