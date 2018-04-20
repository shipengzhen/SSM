package com.bdqn.smbms.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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

//�û�������
@RequestMapping("/user")
public class UserController {

	private IUserService userService;// service���û��ӿ�

	public IUserService getUserService() {
		return userService;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	private IRoleService roleService;// service���ɫ�ӿ�

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	// �û���½
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
				// redirect�ض���,forwardת��,Ĭ����ת��
				string = Properties.getString("page", "frame");
			} else {
				// ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
				request.setAttribute("error", "�û��������벻��ȷ");
				string = Properties.getString("page", "login");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// �û��˳�
	@RequestMapping(value = "/doout", method = RequestMethod.GET)
	public String doOut(HttpSession session) {
		String string = null;
		try {
			session.setAttribute("user", null);
			string = Properties.getString("page", "login");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// �û�����
	@RequestMapping("/userAdmin.html")
	public String userAdmin(HttpSession session) {
		String string = null;
		try {
			if (session.getAttribute("user") != null) {
				session.setAttribute("roles", roleService.findRoles());
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// ģ����ѯ�û���Ϣ
	@RequestMapping("/findUsers")
	public String findUsers(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String userName = request.getParameter("userName");
				int userRole = Integer.parseInt(request.getParameter("userRole"));
				int totalCount = userService.findUCount(userName, userRole);// �ܼ�¼��
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// ҳ��С
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
				int currentPageNo = 1;// ��ǰҳ
				request.setAttribute("totalCount", totalCount);// ��¼����
				request.setAttribute("totalPageCount", totalPageCount);// ҳ����
				request.setAttribute("currentPageNo", currentPageNo);// ��ǰҳ
				request.setAttribute("users", userService.findUsers(userName, userRole, currentPageNo, pageSize));// �û�����
				request.setAttribute("userName", userName);// �û���
				request.setAttribute("userRole", userRole);// ��ɫ��
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// �û���ҳ
	@RequestMapping("/userPaging")
	public String userPaging(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String userName = request.getParameter("userName");
				int userRole = Integer.parseInt(request.getParameter("userRole"));
				int totalCount = userService.findUCount(userName, userRole);// �ܼ�¼��
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "UserPageSize"));// ҳ��С
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
				PageSupport.setCurrentPageNo(Integer.parseInt(request.getParameter("currentPageNo")));// ��ǰҳ
				int currentPageNo = PageSupport.getCurrentPageNo();// ��ǰҳ
				request.setAttribute("totalCount", totalCount);// ��¼����
				request.setAttribute("totalPageCount", totalPageCount);// ҳ����
				request.setAttribute("currentPageNo", currentPageNo);// ��ǰҳ
				List<User> users = userService.findUsers(userName, userRole, currentPageNo, pageSize);// �û�����
				request.setAttribute("users", users);
				request.setAttribute("userName", userName);// �û���
				request.setAttribute("userRole", userRole);// ��ɫ��
				string = Properties.getString("page", "userlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// ��ת���ҳ��
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
			throw new RuntimeException(e);
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

	// ����û�(���ļ��ϴ�)
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(User user, HttpServletRequest request, MultipartFile attach) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			if (u != null) {
				if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
					String path = request.getSession().getServletContext()// ������·��
							.getRealPath("statics" + File.separator + "userphoto");// ͼƬҪ�ŵ���������λ�õ�λ��
					String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
					String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
					if (attach.getSize() > 500000) {// �ϴ���С���ó��� 500k
						request.setAttribute("uploadFileError", "�ϴ���С���ó��� 500k");
						string = Properties.getString("page", "adduser");
					} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
							|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// �ж�ͼƬ�ϴ���ʽ
						String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Userphoto.jpg";// ����ͼƬ��
						File targetFile = new File(path, fileName);
						if (!targetFile.exists()) {
							targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
							try {
								// idPicPath=targetFile.getCanonicalPath();idPicPath=path+File.separator+fileName;��ȡͼƬ����·��
								String idPicPath = targetFile.getName();// ��ȡͼƬ��
								user.setCreatedBy(u.getId());// ������(userId)
								user.setCreationDate(new Date());// ����ʱ��
								user.setIdPicPath(idPicPath);// ֤����
								if (userService.userCodeIsExit(user.getUserCode())) {// �ж��û�����Ƿ����
									if (userService.addUser(user)) {
										string = Properties.getString("page", "userlist");
										attach.transferTo(targetFile);// �ϴ���������ָ��λ��
									} else {
										string = Properties.getString("page", "adduser");
									}
								} else {
									string = Properties.getString("page", "adduser");
									System.out.println("�˺��Ѵ���");
								}
							} catch (Exception e) {
								e.printStackTrace();
								request.setAttribute("uploadFileError", "�ϴ�ʧ�ܣ�");
								string = Properties.getString("page", "adduser");
							}
						}
					} else {
						request.setAttribute("uploadFileError", "�ϴ�ͼƬ��ʽ����ȷ");
						string = Properties.getString("page", "adduser");
					}
				}
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
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
	// user.setCreatedBy(u.getId());// �����ߣ�userId��
	// user.setCreationDate(new Date());// ����ʱ��
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

	// ��ת�û���Ϣ����ҳ��
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
			throw new RuntimeException(e);
		}
		return string;
	}

	// ��ˢ��ѯ�û�������Ϣ
	@RequestMapping(value = "/userview", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String userview(@RequestParam String userId) {
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

	// ��ת�޸��û���Ϣҳ��
	@RequestMapping(value = "/modifyuser.html", method = RequestMethod.GET)
	public String skipModifyuserHtml(HttpServletRequest request) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				request.setAttribute("user", userService.findUser(userId));
				string = Properties.getString("page", "modifyuser");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return string;
	}

	// �޸��û���Ϣ
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
			throw new RuntimeException(e);
		}
		return string;
	}

	/**
	 * ��ˢ��֤�û����
	 * 
	 * @param userCode
	 * @return
	 */
	@RequestMapping(value = "/ucexist.html")
	@ResponseBody
	public Object userCodeIsExit(@RequestParam String userCode) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(userCode)) {
			resultMap.put("userCode", "exist");
		} else {
			if (userService.userCodeIsExit(userCode))
				resultMap.put("userCode", "noexist");// ������
			else
				resultMap.put("userCode", "exist");// ����
		}
		return JSONArray.toJSONString(resultMap);
	}

	// �ֲ��쳣����
//	@ExceptionHandler(value = { RuntimeException.class })
//	public String handlerException(RuntimeException e, HttpServletRequest request) {
//		request.setAttribute("exception", e);
//		return "500";
//	}
}
