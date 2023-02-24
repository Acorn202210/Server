package com.acorn2.FinalProject.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.acorn2.FinalProject.common.interceptor.LoginInterceptor;
import com.acorn2.FinalProject.common.interceptor.ManagerInterceptor;

@Configuration
public class ApiConfig implements WebMvcConfigurer{
	@Autowired LoginInterceptor loginInterceptor;
	@Autowired ManagerInterceptor managerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/api/users/**", "/api/notice/*/*", "/api/notice")
		.excludePathPatterns("/api/users/*/login", "/api/users", "/api/users/checkid");
		
		registry.addInterceptor(managerInterceptor)
		.addPathPatterns("/api/notice/*/*", "/api/notice", "/api/users/list");
	}

}
