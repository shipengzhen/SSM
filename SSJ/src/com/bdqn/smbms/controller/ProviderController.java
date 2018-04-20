package com.bdqn.smbms.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.bdqn.smbms.entity.Provider;
import com.bdqn.smbms.entity.User;
import com.bdqn.smbms.service.IProviderService;
import com.bdqn.smbms.util.PageSupport;
import com.bdqn.smbms.util.Properties;

//供应商
@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Resource
	private IProviderService providerService;// 供应商

	// 跳转供应商管理页面
	@RequestMapping(value = "/providerAdmin.html", method = RequestMethod.GET)
	public String providerAdmin(HttpSession session) {
		String string = null;
		try {
			if (session.getAttribute("user") != null) {
				string = Properties.getString("page", "providerlist");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 模糊查询供应商
	// @RequestMapping(value = "/findProviders", method = RequestMethod.POST)
	@RequestMapping("/findProviders")
	public String findProviders(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String proCode = request.getParameter("proCode");
				String proName = request.getParameter("proName");
				int totalCount = providerService.findPCount(proCode, proName);// 总记录数
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "providerPageSize"));// 页大小
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
				int currentPageNo = 1;// 当前页
				request.setAttribute("totalCount", totalCount);// 记录总数
				request.setAttribute("totalPageCount", totalPageCount);// 页总数
				request.setAttribute("currentPageNo", currentPageNo);// 当前页
				request.setAttribute("providers",
						providerService.findProviders(proCode, proName, currentPageNo, pageSize));// 用户集合
				request.setAttribute("proCode", proCode);// 用户名
				request.setAttribute("proName", proName);// 角色名
				string = Properties.getString("page", "providerlist");
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

	// 供应商分页
	@RequestMapping("/providerPaging")
	public String provider(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String proCode = request.getParameter("proCode");
				String proName = request.getParameter("proName");
				int totalCount = providerService.findPCount(proCode, proName);// 总记录数
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "providerPageSize"));// 页大小
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
				PageSupport.setCurrentPageNo(Integer.parseInt(request.getParameter("currentPageNo")));// 当前页
				int currentPageNo = PageSupport.getCurrentPageNo();// 当前页
				request.setAttribute("totalCount", totalCount);// 记录总数
				request.setAttribute("totalPageCount", totalPageCount);// 页总数
				request.setAttribute("currentPageNo", currentPageNo);// 当前页
				request.setAttribute("providers",
						providerService.findProviders(proCode, proName, currentPageNo, pageSize));// 用户集合
				request.setAttribute("proCode", proCode);// 用户名
				request.setAttribute("proName", proName);// 角色名
				string = Properties.getString("page", "providerlist");
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

	// 跳转添加供应商
	@RequestMapping(value = "/addProvider.html", method = RequestMethod.GET)
	public String skipAddProviderHtml(@ModelAttribute("provider") Provider provider, HttpSession session) {
		String string = null;
		try {
			if (session.getAttribute("user") != null) {
				string = Properties.getString("page", "addprovider");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 添加供应商(多文件上传)
	@RequestMapping(value = "/addProvider.html", method = RequestMethod.POST)
	public String addProvider(Provider provider, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		String errorInfo = null;// 错误信息
		boolean flag = true;
		String companyLicPicPath = null;// 企业营业执照
		String orgCodePicPath = null;// 组织机构代码证
		MultipartFile companyLicPicPathAttach = null;// 企业营业执照
		MultipartFile orgCodePicPathAttach = null;// 组织机构代码证
		File companyLicPicPathFile = null;// 企业营业执照
		File orgCodePicPathFile = null;// 组织机构代码证
		String string = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			if (user != null) {
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "providerphoto");// 图片要放到服务器的位置的位置
				for (int i = 0; i < attachs.length; i++) {
					MultipartFile attach = attachs[i];
					if (!attach.isEmpty()) {
						if (i == 0) {
							errorInfo = "uploadFileError";
						} else if (i == 1) {
							errorInfo = "uploadOcError";
						}
						String oldFileName = attach.getOriginalFilename();// 原文件名
						String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
						if (attach.getSize() > 500000) {// 上传大小不得超过 500k
							request.setAttribute(errorInfo, "上传大小不得超过 500k");
							string = Properties.getString("page", "addprovider");
							flag = false;
						} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
								|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// 判断图片上传格式
							String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000)
									+ "_Providerphoto.jpg";// 更改图片名
							File targetFile = new File(path, fileName);
							if (!targetFile.exists()) {
								targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
							}
							// 保存
							try {
								if (i == 0) {
									companyLicPicPath = targetFile.getName();// 获取图片名
									companyLicPicPathAttach = attach;// 获取MultipartFile对象
									companyLicPicPathFile = targetFile;// 获取File对象
								} else if (i == 1) {
									orgCodePicPath = targetFile.getName();
									orgCodePicPathAttach = attach;
									orgCodePicPathFile = targetFile;
								}
							} catch (Exception e) {
								e.printStackTrace();
								request.setAttribute(errorInfo, "上传失败！");
							}
						} else {
							request.setAttribute(errorInfo, "上传图片格式不正确");
							string = Properties.getString("page", "addprovider");
							flag = false;
						}
					}
				}
				if (flag) {
					provider.setCreatedBy(user.getId());// 创建者(uId)
					provider.setCreationDate(new Date());// 创建时间
					provider.setCompanyLicPicPath(companyLicPicPath);// 企业营业执照
					provider.setOrgCodePicPath(orgCodePicPath);// 组织机构代码证
					if (providerService.addUser(provider)) {
						companyLicPicPathAttach.transferTo(companyLicPicPathFile);// 上传到服务器指定位置
						orgCodePicPathAttach.transferTo(orgCodePicPathFile);// 上传到服务器指定位置
						string = Properties.getString("page", "providerlist");
					} else {
						string = Properties.getString("page", "addprovider");
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
	// public String addProvider(@Valid Provider provider, BindingResult
	// bindingResult, HttpSession session) {
	// String string = null;
	// User user = (User) session.getAttribute("user");
	// try {
	// if (user != null) {
	// if (bindingResult.hasErrors()) {
	// return Properties.getString("page", "addprovider");
	// }
	// provider.setCreatedBy(user.getId());// 创建者(uId)
	// provider.setCreationDate(new Date());// 创建时间
	// if (providerService.addUser(provider)) {
	// string = Properties.getString("page", "providerlist");
	// } else {
	// string = Properties.getString("page", "addprovider");
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

	// 跳转供应商信息页面
	@RequestMapping("/providerview.html")
	public String skipProviderviewHtml(HttpServletRequest request) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				int providerId = Integer.parseInt(request.getParameter("providerId"));
				request.setAttribute("provider", providerService.findProvider(providerId));
				string = Properties.getString("page", "providerview");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 跳转修改用户信息页面
	@RequestMapping(value = "/modifyprovider.html", method = RequestMethod.GET)
	public String skipModifyproviderHtml(HttpServletRequest request) {
		String string = null;
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				int providerId = Integer.parseInt(request.getParameter("providerId"));
				request.setAttribute("provider", providerService.findProvider(providerId));
				string = Properties.getString("page", "modifyprovider");
			} else {
				string = Properties.getString("page", "404");
			}
		} catch (Exception e) {
			e.printStackTrace();
			string = Properties.getString("page", "500");
		}
		return string;
	}

	// 通过供应商Id修改供应商信息
	@RequestMapping(value = "/modifyprovider", method = RequestMethod.POST)
	public String modifyProvider(Provider provider, HttpServletRequest request) {
		String string = null;
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("user") != null) {
				if (providerService.modifyProvider(provider)) {
					string = Properties.getString("page", "providerlist");
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

}
