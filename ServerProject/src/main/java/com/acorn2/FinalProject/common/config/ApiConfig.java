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
		.addPathPatterns("/api/users/**", "/api/notice/*/*", "/api/notice", "/api/faq/*", "/api/faq/**", "/api/qnaboard/*", "/api/qnaboard/*/*")
		.excludePathPatterns("/api/users/*/login", "/api/users", "/api/users/checkid", "/api/faq/Faqlist", "/api/faq/*/faqOne");
		
		registry.addInterceptor(managerInterceptor)
		.addPathPatterns("/api/users/**", "/api/notice/*/*", "/api/notice", "/api/users/list","/api/faq/*/*","/api/lecture/*/*","/api/lectureReview/*/*","/api/lectureStudent/*/*",
						"/api/lecture/lecutureInsert", "/api/lecture/{lecNum}","/api/lecture/{lecNum}/lectureDelete")
		.excludePathPatterns("/api/users/*/login", "/api/users", "/api/users/checkid",
				"/api/lecture/lectureList","/api/lecture/{lecNum}/lectureOne",
				"/api/lectureReview/lectureReviewList");
	}

}
