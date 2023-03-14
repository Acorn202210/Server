package com.acorn2.plec.api.lecture.image.dao;

import org.apache.ibatis.annotations.Mapper;

import com.acorn2.plec.api.lecture.image.dto.ImageDto;


@Mapper
public interface ImageDao {
	Integer insertImage(ImageDto imageDto);
	ImageDto selectImage(Integer imageNum);
	void updateImage(ImageDto imageDto);
	void deleteUpdateImage(Integer imageNum);
	void deleteImage();
}
