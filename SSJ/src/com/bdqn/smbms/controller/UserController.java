package com.bdqn.smbms.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.service.IRoleService;
import com.bdqn.smbms.service.IUserService;
import com.bdqn.smbms.util.PageSupport;
import com.bdqn.smbms.util.Properties;
import com.mysql.jdbc.StringUtils;

//用户控制器
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;// 用户
	@Resource
	private IRoleService roleService;// 角色

	// 用户登陆
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			User user = userService.doLogin(userName, userPassword);
			if (user != null) {
				session.setAttribute("user", user);
				string =Properties.getString("page", "frame");//转发,默认是重定向
			} else {
				// 页面跳转（login.jsp）带出提示信息--转发
				request.setAttribute("error", "用户名或密码不正确");
				string = Properties.getString("page", "login");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 用户退出
	@RequestMapping(value = "/doout", method = RequestMethod.GET)
	public String doOut(HttpSession session) {
		String string = null;
		try {
			session.setAttribute("user", null);
			string = Properties.getString("page", "login");
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 用户管理
	@RequestMapping("/userAdmin.html")
	public String userAdmin(HttpSession session,Model model) {
		String string = null;
		try {
			if (session.getAttribute("user") != null) {
				session.setAttribute("roles", roleService.findRoles());
				int totalCount = userService.getAllUCount();// 总记录数
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// 页大小
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
				int currentPageNo = 1;// 当前页
				model.addAttribute("totalCount", totalCount);// 记录总数
				model.addAttribute("totalPageCount", totalPageCount);// 页总数
				model.addAttribute("currentPageNo", currentPageNo);// 当前页
				model.addAttribute("users", userService.findUsers(currentPageNo, pageSize));// 用户集合
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 模糊查询用户信息
	@RequestMapping("/findUsers")
	public String findUsers(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String userName = request.getParameter("userName");
				int userRole = Integer.parseInt(request.getParameter("userRole"));
				int totalCount = userService.findUCount(userName, userRole);// 总记录数
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// 页大小
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
				int currentPageNo = 1;// 当前页
				request.setAttribute("totalCount", totalCount);// 记录总数
				request.setAttribute("totalPageCount", totalPageCount);// 页总数
				request.setAttribute("currentPageNo", currentPageNo);// 当前页
				request.setAttribute("users", userService.findUsers(userName, userRole, currentPageNo, pageSize));// 用户集合
				request.setAttribute("userName", userName);// 用户名
				request.setAttribute("userRole", userRole);// 角色名
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 用户分页
	@RequestMapping("/userPaging")
	public String userPaging(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				if (request.getParameter("userRole").equals("")) {
					int totalCount = userService.getAllUCount();// 总记录数
					int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// 页大小
					int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
					PageSupport.setCurrentPageNo(Integer.parseInt(request.getParameter("currentPageNo")));// 当前页
					int currentPageNo = PageSupport.getCurrentPageNo();// 当前页
					request.setAttribute("totalCount", totalCount);// 记录总数
					request.setAttribute("totalPageCount", totalPageCount);// 页总数
					request.setAttribute("currentPageNo", currentPageNo);// 当前页
					List<User> users = userService.findUsers(currentPageNo, pageSize);// 用户集合
					request.setAttribute("users", users);
				}else {
					String userName = request.getParameter("userName");
					int userRole = Integer.parseInt(request.getParameter("userRole"));
					int totalCount = userService.findUCount(userName, userRole);// 总记录数
					int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// 页大小
					int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
					PageSupport.setCurrentPageNo(Integer.parseInt(request.getParameter("currentPageNo")));// 当前页
					int currentPageNo = PageSupport.getCurrentPageNo();// 当前页
					request.setAttribute("totalCount", totalCount);// 记录总数
					request.setAttribute("totalPageCount", totalPageCount);// 页总数
					request.setAttribute("currentPageNo", currentPageNo);// 当前页
					List<User> users = userService.findUsers(userName, userRole, currentPageNo, pageSize);// 用户集合
					request.setAttribute("users", users);
					request.setAttribute("userName", userName);// 用户名
					request.setAttribute("userRole", userRole);// 角色名
				}
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 跳转添加页面
	@RequestMapping(value = "/adduser.html", method = RequestMethod.GET)
	public String skipAddUserHtml(@ModelAttribute("user") User user, HttpSession session) {
		String string = null;
		try {
			if (session.getAttribute("user") != null) {
				string = Properties.getString("page", "adduser");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}
	// @RequestMapping("/adduser.html")
	// public String skipAddUserHtml(HttpSession session){
	// String string=null;
	// try {
	// if (session.getAttribute("user")!=null) {
	// string=Properties.getString("page","adduser");
	// }else {
	// string=Properties.getString("page","syserror");
	// }
	// }catch (Exception e) {
	// string=Properties.getString("page","error");
	// }
	// return string;
	// }

	// 添加用户(单文件上传)
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(User user, HttpServletRequest request, MultipartFile attach) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			if (u != null) {
				if (!attach.isEmpty()) {// 判断文件是否为空
					String path = request.getSession().getServletContext()// 服务器路径
							.getRealPath("statics" + File.separator + "userphoto");// 图片要放到服务器的位置的位置
					String oldFileName = attach.getOriginalFilename();// 原文件名
					String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
					if (attach.getSize() > 500000) {// 上传大小不得超过 500k
						request.setAttribute("uploadFileError", "上传大小不得超过 500k");
						string = Properties.getString("page", "adduser");
					} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
							|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// 判断图片上传格式
						String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Userphoto.jpg";// 更改图片名
						File targetFile = new File(path, fileName);
						if (!targetFile.exists()) {
							targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
							try {
								// idPicPath=targetFile.getCanonicalPath();idPicPath=path+File.separator+fileName;获取图片完整路径
								String idPicPath = targetFile.getName();// 获取图片名
								user.setCreatedBy(u.getId());// 创建者(userId)
								user.setCreationDate(new Date());// 创建时间
								user.setIdPicPath(idPicPath);// 证件照
								if (userService.userCodeIsExit(user.getUserCode())) {// 判断用户编号是否存在
									if (userService.addUser(user)) {//成功
										string ="redirect:/user/userAdmin.html";// 重定向
										attach.transferTo(targetFile);// 上传到服务器指定位置
									} else {
										string = Properties.getString("page", "adduser");
									}
								} else {
									string = Properties.getString("page", "adduser");
									System.out.println("账号已存在");
								}
							} catch (Exception e) {
								e.printStackTrace();
								request.setAttribute("uploadFileError", "上传失败！");
								string = Properties.getString("page", "adduser");
							}
						}
					} else {
						request.setAttribute("uploadFileError", "上传图片格式不正确");
						string = Properties.getString("page", "adduser");
					}
				}
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}
	// public String addUser(User user, BindingResult bindingResult, HttpSession
	// session) {
	// String string = null;
	// try {
	// User u = (User) session.getAttribute("user");
	// if (u != null) {
	// if (bindingResult.hasErrors()) {
	// return Properties.getString("page", "adduser");
	// }
	// user.setCreatedBy(u.getId());// 创建者（userId）
	// user.setCreationDate(new Date());// 创建时间
	// if (userService.addUser(user)) {
	// string = Properties.getString("page", "userlist");
	// } else {
	// string = Properties.getString("page", "adduser");
	// }
	// } else {
	// string = Properties.getString("page", "404");
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// string = Properties.getString("page", "500");
	// }
	// return string;
	// }

	// 跳转用户信息详情页面
	@RequestMapping(value = "/userview.html", method = RequestMethod.GET)
	public String skipUserviewHtml(HttpServletRequest request) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				request.setAttribute("user", userService.findUser(userId));
				string = Properties.getString("page", "userview");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 无刷查询用户详情信息
	@RequestMapping(value = "/userview", method = RequestMethod.GET,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String userview(String userId) {
		String user = "";
		if (null == userId || "".equals(userId)) {
			user = "nodata";
		} else {
			try {
				user = JSON.toJSONString(userService.findUser(Integer.parseInt(userId)));
			} catch (Exception e) {
				e.printStackTrace();
				user = "failed";
			}
		}
		return user;
	}

	// 跳转修改用户信息页面
	@RequestMapping(value = "/modifyuser.html/{userId}", method = RequestMethod.GET)
	public String skipModifyuserHtml(@PathVariable int userId,HttpServletRequest request) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				request.setAttribute("user", userService.findUser(userId));
				string = Properties.getString("page", "modifyuser");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 修改用户信息
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	public String updateUser(User user, HttpServletRequest request) {
		String string = null;
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("user") != null) {
				if (userService.modifyUser(user)) {
					string = Properties.getString("page", "userlist");
				}
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	/**
	 * 无刷验证用户编号
	 * 
	 * @param userCode
	 * @return
	 */
	@RequestMapping(value = "/ucexist.html")
	@ResponseBody
	public String userCodeIsExit(@RequestParam String userCode) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(userCode)) {
			resultMap.put("userCode", "exist");
		} else {
			if (userService.userCodeIsExit(userCode))
				resultMap.put("userCode", "noexist");// 不存在
			else
				resultMap.put("userCode", "exist");// 存在
		}
		return JSONArray.toJSONString(resultMap);
	}
	 //局部异常处理
	 @ExceptionHandler(value={RuntimeException.class})
	 public String handlerException(RuntimeException e,HttpServletRequest request){
		 request.setAttribute("e", e);
		 return "error";
	 }
}
