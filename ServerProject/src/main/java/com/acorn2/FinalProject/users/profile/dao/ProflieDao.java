package com.acorn2.FinalProject.users.profile.dao;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.users.profile.dto.ProfileDto;

@Mapper
public interface ProflieDao {
	Integer insertProfile(ProfileDto profileDto);
	ProfileDto selectProfile(String lecUserId);
	void updateProfile(ProfileDto profileDto);
	void deleteUpdateProfile(String lecUserId);
	void deleteProfile();
}
