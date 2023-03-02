package com.acorn2.FinalProject.lecture.image.dao;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.FinalProject.lecture.image.dto.ImageDto;

@Mapper
public interface ImageDao {
	Integer insertImage(ImageDto imageDto);
	ImageDto selectImage(int lecNum);
	void updateImage(ImageDto imageDto);
	void deleteUpdateImage(int lecNum);
	void deleteImage();
}
