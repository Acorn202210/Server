package com.acorn2.plec.api.lecture.image.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ImageService {
	Map<String, Object> selectImage(int lecNum);
}
