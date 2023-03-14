package com.acorn2.plec.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {
//	public static String getUserID(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object idTemp = session.getAttribute("id");
//		String id = "";
//		if(idTemp != null) {
//			id = idTemp.toString();
//		}
//		return id;
//	}
	
	
	public static String getAttribute() {
		return RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION).toString();
	}
	
	public static void removeAttribute() {
		getRequest().getSession().removeAttribute("id");
	}
	
	public static void setAttribute(String id) {
		getRequest().getSession().setAttribute("id", id);
	}
	
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	public static String getUserId() {
		return  getRequest().getSession().getAttribute("id").toString();
	}
}