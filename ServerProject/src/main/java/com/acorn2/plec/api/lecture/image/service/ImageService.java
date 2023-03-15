package com.acorn2.plec.api.lecture.image.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.lecture.image.dto.ImageNumDto;

public interface ImageService {
	Map<String, Object> selectImage(Integer lecNum);
	void updateImage(MultipartFile file, Integer imageNum);
	ImageNumDto insertImage(MultipartFile file);
}
