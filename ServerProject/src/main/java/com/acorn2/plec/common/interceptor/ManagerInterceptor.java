package com.acorn2.plec.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.acorn2.plec.api.users.dao.UsersDao;
import com.acorn2.plec.api.users.dto.res.UsersReadDetailResDto;
import com.acorn2.plec.api.users.exception.ManagerException;


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
			throw new ManagerException("권한이 없습니다.");
		}
		return true;
	}
}
