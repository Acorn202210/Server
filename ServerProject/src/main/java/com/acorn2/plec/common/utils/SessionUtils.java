package com.acorn2.plec.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {
	public static String getAttribute() {
		return RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION).toString();
	}
	
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static String getUserId() {
		return getRequest().getSession().getAttribute("id").toString();
		//return getRequest().getAttribute("id").toString();
	}
	
	public static Object getAttribute(String id) {
		return getRequest().getAttribute(id);
	}
	
	public static Boolean isManager() {
		Boolean isManager = (Boolean) getRequest().getAttribute("manager");
		return isManager;
	}
	
	public static void setMyData(String key, Object value) {
		getRequest().setAttribute(key, value);
	}
	
	public static Object getMyData(String key) {
		return getRequest().getAttribute(key);
	}
}
