package com.acorn2.plec.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {
	/*
	 * public static String getuserId(HttpServletRequest request) { HttpSession
	 * session = request.getSession(); Object idTemp = session.getAttribute("id");
	 * String id = ""; if(idTemp != null) { id = idTemp.toString(); } return id;
	 * 
	 * }
	 */
	
	public static Boolean isManager(HttpServletRequest request) {
		
		return null;
	}
	
	//이렇게 하면 HttpServletRequest request를 사용안하고 사용 가능
	public static String getAttribute() {
		return RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_REQUEST).toString();
	}
	
	
	//HttpServletRequest으로 메소드로 사용하기, 보통 dto로 넣는 것이 더 편리하다.
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	//지금 프로젝트는 이걸로 사용!
	public static String getuserId() {
		return getRequest().getSession().getAttribute("id").toString();
	}
	
	public static Object getAtAttibute(String id) {
		return getRequest().getSession().getAttribute(id);
	}
	
	//매니저 예시
	public static Boolean isManager() {
		Boolean isManager = (Boolean) getRequest().getAttribute("manager");
		return isManager;
	}
	
	//예시
	public static Object getMyData(String key) {
		return getRequest().getAttribute(key);
	}
}
