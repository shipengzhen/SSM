package com.bdqn.app.controller.developer;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bdqn.app.pojo.DevUser;
import com.bdqn.app.service.developer.IDevUserService;
import com.bdqn.app.tools.Properties;

/**
 * 开发者控制器
 * 
 * @author 施鹏振
 *
 */
@RequestMapping("/dev")
public class DeveloperController {

	// Service层对象
	private IDevUserService developerService;

	public IDevUserService getDeveloperService() {
		return developerService;
	}

	public void setDeveloperService(IDevUserService developerService) {
		this.developerService = developerService;
	}

	//跳转主页面
	@RequestMapping("/flatform/main")
	public String main(){
		return Properties.getString("page", "developermain");
	}
	
	// 跳转登录页面
	@RequestMapping("/login")
	public String login() {
		return Properties.getString("page", "devlogin");
	}

	// 登录
	@RequestMapping("/dologin")
	public String doLogin(String devCode, String devPassword, HttpSession session) {
		String string = null;
		try {
			DevUser devUser = developerService.doLogin(devCode, devPassword);
			if (devUser != null) {
				session.setAttribute("devUser", devUser);
				string = Properties.getString("page", "developermain");
			} else {
				string = Properties.getString("page", "devlogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	// 退出
	@RequestMapping("/logout")
	public String logOut(HttpSession session,String isok) {
		String string=null;
		try {
			session.setAttribute("devUser", null);
			if (isok.equals("ok")) {
				string=Properties.getString("page", "index");
			}else {
				string=Properties.getString("page", "devlogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	
}
