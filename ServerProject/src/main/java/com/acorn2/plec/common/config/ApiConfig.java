package com.acorn2.plec.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.acorn2.plec.common.config.dto.ApiPatternsDto;
import com.acorn2.plec.common.interceptor.LoginInterceptor;
import com.acorn2.plec.common.interceptor.ManagerInterceptor;

@Configuration
public class ApiConfig implements WebMvcConfigurer{
	@Autowired LoginInterceptor loginInterceptor;
	@Autowired ManagerInterceptor managerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> loginAddPatternDto = getLoginAddPatternDto();
		List<String> loginExcludePatternDto = getLoginExcludePatternDto();
		List<String> managerAddPatternDto = getManagerAddPatternDto();
		List<String> managerExcludePatternDto = getManagerExcludePatternDto();
		
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns(loginAddPatternDto.toArray(new String[loginAddPatternDto.size()]))
		.excludePathPatterns(loginExcludePatternDto.toArray(new String[loginExcludePatternDto.size()]));
		
		registry.addInterceptor(managerInterceptor)
		.addPathPatterns(managerAddPatternDto.toArray(new String[managerAddPatternDto.size()]))
		.excludePathPatterns(managerExcludePatternDto.toArray(new String[managerExcludePatternDto.size()]));
	}
	
	@Bean
	@ConfigurationProperties("login-add-patterns")
	public List<String> getLoginAddPatternDto() {
		return new ArrayList<>();
	}
	
	@Bean
	@ConfigurationProperties("login-exclude-patterns")
	public List<String> getLoginExcludePatternDto() {
		return new ArrayList<>();
	}
	
	@Bean
	@ConfigurationProperties("manager-add-patterns")
	public List<String> getManagerAddPatternDto() {
		return new ArrayList<>();
	}
	
	@Bean
	@ConfigurationProperties("manager-exclude-patterns")
	public List<String> getManagerExcludePatternDto() {
		return new ArrayList<>();
	}

}