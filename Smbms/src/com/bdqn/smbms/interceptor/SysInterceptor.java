package com.bdqn.smbms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bdqn.smbms.entity.User;

public class SysInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(null == user){
			response.sendRedirect(request.getContextPath()+"/error/404.jsp");
			return false;
		}
		return true;
	}
}
