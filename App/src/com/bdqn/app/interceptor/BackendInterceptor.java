package com.bdqn.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bdqn.app.pojo.BackendUser;
import com.bdqn.app.pojo.DevUser;

/**
 * 管理员拦截器
 * @author 施鹏振
 *
 */
public class BackendInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		
		HttpSession session = request.getSession();
		
		BackendUser backendUser =(BackendUser)session.getAttribute("backendUser");
		
		if(null == backendUser){
			response.sendRedirect(request.getContextPath()+"/403.jsp");
			return false;
		}
		return true;
	}
}
