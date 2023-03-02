package com.acorn2.plec.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.acorn2.plec.users.dao.UsersDao;
import com.acorn2.plec.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.users.exception.UsersNotLoginException;

@Component
public class ManagerInterceptor implements HandlerInterceptor{
	@Autowired private UsersDao usersDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		UsersReadDetailResDto usersReadDetailResDto = usersDao.selectUser(id);
		
		if(usersReadDetailResDto.getManagerYn().toString().equals("N")) {
			throw new UsersNotLoginException("관리자가 아닙니다.");
		}
		return true;
	}
}
