package com.bdqn.app.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.app.pojo.BackendUser;
import com.bdqn.app.service.developer.IBackendUserService;
import com.bdqn.app.tools.Properties;

/**
 * 系统管理员控制器
 * 
 * @author 施鹏振
 *
 */
@RequestMapping("/manager")
public class BackendController {

	private IBackendUserService backendService;

	public IBackendUserService getBackendService() {
		return backendService;
	}

	public void setBackendService(IBackendUserService backendService) {
		this.backendService = backendService;
	}

	// 跳转主页面
	@RequestMapping("/backend/main")
	public String main() {
		return Properties.getString("page", "developermain");
	}

	// 跳转登录页面
	@RequestMapping("/login")
	public String login() {
		return Properties.getString("page", "backendlogin");
	}

	// 登录
	@RequestMapping("/dologin")
	public String doLogin(String userCode, String userPassword, HttpSession session) {
		String string = null;
		BackendUser backendUser = backendService.doLogin(userCode, userPassword);
		if (backendUser != null) {
			session.setAttribute("backendUser", backendUser);
			string = Properties.getString("page", "backendmain");
		} else {
			string = Properties.getString("page", "backendlogin");
		}
		return string;
	}

	// 退出
	@RequestMapping("/logout")
	public String logOut(HttpSession session, String isok) {
		String string = null;
		try {
			session.setAttribute("devUser", null);
			if (isok.equals("ok")) {
				string = Properties.getString("page", "index");
			} else {
				string = Properties.getString("page", "backendlogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

}
