package com.acorn2.plec.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.acorn2.plec.users.exception.UsersNotLoginException;


@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			throw new UsersNotLoginException("로그인이 되어있지 않습니다.");
		}
		return true;
	}
}
