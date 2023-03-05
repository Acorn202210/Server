package com.acorn2.plec.common.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.acorn2.plec.common.interceptor.LoginInterceptor;
import com.acorn2.plec.common.interceptor.ManagerInterceptor;

@Configuration
public class ApiConfig implements WebMvcConfigurer{
	
	@Autowired LoginInterceptor loginInterceptor;
	@Autowired ManagerInterceptor managerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> apiPatternDto = getApiPatternDto();
		registry.addInterceptor(loginInterceptor)
			.addPathPatterns(apiPatternDto.toArray(new String[apiPatternDto.size()]))
			.excludePathPatterns("/api/users/login", "/api/users", "/api/users/checkid", "/api/users/isYN", "/api/faq/Faqlist", "/api/faq/*/faqOne");
			
		registry.addInterceptor(managerInterceptor)
			.addPathPatterns("/api/notice/*/*", "/api/notice", "/api/users/list","/api/faq/*/*","/api/lecture/*/*","/api/lectureReview/*/*","/api/lectureStudent/*/*",
							"/api/lecture/lecutureInsert", "/api/lecture/{lecNum}","/api/lecture/{lecNum}/lectureDelete", "/api/faq/*")
			.excludePathPatterns("/api/users/login", "/api/users", "/api/users/checkid",
					"/api/lecture/lectureList","/api/lecture/{lecNum}/lectureOne",
					"/api/lectureReview/lectureReviewList" ,"/api/faq/Faqlist", "/api/faq/*/faqOne");
	}
	
	@Bean
	@ConfigurationProperties("add-patterns")
	public List<String> getApiPatternDto() {
    	return new ArrayList<>();
    }

}