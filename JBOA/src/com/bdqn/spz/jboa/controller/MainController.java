package com.bdqn.spz.jboa.controller;


import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bdqn.spz.jboa.pojo.Employee;
import com.bdqn.spz.jboa.service.IEmployeeService;
import com.bdqn.spz.jboa.tools.Page;

/**
 * 职工控制器
 * @author 施鹏振
 *
 */
@RequestMapping
public class MainController {

	//职工
	private IEmployeeService employeeService;
	
	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//跳转登录页面
	@RequestMapping("/login")
	public String login(){
		return Page.LOGIN;
	}
	
	//登录
	@RequestMapping("/dologin")
	public String doLogin(String sn,String passWord,HttpSession session,Model model){
		String page=null;
		try {
			Employee employee=employeeService.findEmployee(sn, passWord);
			if (employee!=null) {
				session.setAttribute("employee",employee);
				page="redirect:/sys/claim/index";
			}else {
				page=Page.LOGIN;
				model.addAttribute("error","用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}
	
	//退出
	@RequestMapping("/dropout")
	public String dropOut(HttpSession session){
		session.setAttribute("employee",null);
		return Page.LOGIN;
	}
}
