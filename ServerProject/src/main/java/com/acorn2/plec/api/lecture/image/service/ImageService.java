package com.acorn2.plec.api.lecture.image.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.acorn2.plec.api.lecture.image.dto.ImageNumDto;

public interface ImageService {
	Map<String, Object> selectImage(Integer imageNum);
	void updateImage(MultipartFile file, Integer imageNum) throws IOException;
	ImageNumDto insertImage(MultipartFile file) throws IOException;
}
