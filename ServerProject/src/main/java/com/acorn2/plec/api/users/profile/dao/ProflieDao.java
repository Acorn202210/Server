package com.acorn2.plec.api.users.profile.dao;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.users.profile.dto.ProfileDto;
import com.acorn2.plec.api.users.profile.dto.ProfileNumDto;


@Mapper
public interface ProflieDao {
	void insertProfile(ProfileDto profileDto);
	ProfileDto selectProfile(Integer profileNum);
	void updateProfile(ProfileDto profileDto);
	void deleteUpdateProfile(Integer profileNum);
	Integer deleteUpdateProfileN(Integer profileNum);
	void deleteProfile();
}
