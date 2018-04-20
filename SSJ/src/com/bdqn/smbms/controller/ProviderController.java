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

//��Ӧ��
@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Resource
	private IProviderService providerService;// ��Ӧ��

	// ��ת��Ӧ�̹���ҳ��
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

	// ģ����ѯ��Ӧ��
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
				int totalCount = providerService.findPCount(proCode, proName);// �ܼ�¼��
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "providerPageSize"));// ҳ��С
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
				int currentPageNo = 1;// ��ǰҳ
				request.setAttribute("totalCount", totalCount);// ��¼����
				request.setAttribute("totalPageCount", totalPageCount);// ҳ����
				request.setAttribute("currentPageNo", currentPageNo);// ��ǰҳ
				request.setAttribute("providers",
						providerService.findProviders(proCode, proName, currentPageNo, pageSize));// �û�����
				request.setAttribute("proCode", proCode);// �û���
				request.setAttribute("proName", proName);// ��ɫ��
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

	// ��Ӧ�̷�ҳ
	@RequestMapping("/providerPaging")
	public String provider(HttpServletRequest request) {
		String string = null;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("user") != null) {
				String proCode = request.getParameter("proCode");
				String proName = request.getParameter("proName");
				int totalCount = providerService.findPCount(proCode, proName);// �ܼ�¼��
				int pageSize = Integer.parseInt(Properties.getProperties("paging.properties", "providerPageSize"));// ҳ��С
				int totalPageCount = PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
				PageSupport.setCurrentPageNo(Integer.parseInt(request.getParameter("currentPageNo")));// ��ǰҳ
				int currentPageNo = PageSupport.getCurrentPageNo();// ��ǰҳ
				request.setAttribute("totalCount", totalCount);// ��¼����
				request.setAttribute("totalPageCount", totalPageCount);// ҳ����
				request.setAttribute("currentPageNo", currentPageNo);// ��ǰҳ
				request.setAttribute("providers",
						providerService.findProviders(proCode, proName, currentPageNo, pageSize));// �û�����
				request.setAttribute("proCode", proCode);// �û���
				request.setAttribute("proName", proName);// ��ɫ��
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

	// ��ת��ӹ�Ӧ��
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

	// ��ӹ�Ӧ��(���ļ��ϴ�)
	@RequestMapping(value = "/addProvider.html", method = RequestMethod.POST)
	public String addProvider(Provider provider, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		String errorInfo = null;// ������Ϣ
		boolean flag = true;
		String companyLicPicPath = null;// ��ҵӪҵִ��
		String orgCodePicPath = null;// ��֯��������֤
		MultipartFile companyLicPicPathAttach = null;// ��ҵӪҵִ��
		MultipartFile orgCodePicPathAttach = null;// ��֯��������֤
		File companyLicPicPathFile = null;// ��ҵӪҵִ��
		File orgCodePicPathFile = null;// ��֯��������֤
		String string = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			if (user != null) {
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "providerphoto");// ͼƬҪ�ŵ���������λ�õ�λ��
				for (int i = 0; i < attachs.length; i++) {
					MultipartFile attach = attachs[i];
					if (!attach.isEmpty()) {
						if (i == 0) {
							errorInfo = "uploadFileError";
						} else if (i == 1) {
							errorInfo = "uploadOcError";
						}
						String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
						String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
						if (attach.getSize() > 500000) {// �ϴ���С���ó��� 500k
							request.setAttribute(errorInfo, "�ϴ���С���ó��� 500k");
							string = Properties.getString("page", "addprovider");
							flag = false;
						} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
								|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// �ж�ͼƬ�ϴ���ʽ
							String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000)
									+ "_Providerphoto.jpg";// ����ͼƬ��
							File targetFile = new File(path, fileName);
							if (!targetFile.exists()) {
								targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
							}
							// ����
							try {
								if (i == 0) {
									companyLicPicPath = targetFile.getName();// ��ȡͼƬ��
									companyLicPicPathAttach = attach;// ��ȡMultipartFile����
									companyLicPicPathFile = targetFile;// ��ȡFile����
								} else if (i == 1) {
									orgCodePicPath = targetFile.getName();
									orgCodePicPathAttach = attach;
									orgCodePicPathFile = targetFile;
								}
							} catch (Exception e) {
								e.printStackTrace();
								request.setAttribute(errorInfo, "�ϴ�ʧ�ܣ�");
							}
						} else {
							request.setAttribute(errorInfo, "�ϴ�ͼƬ��ʽ����ȷ");
							string = Properties.getString("page", "addprovider");
							flag = false;
						}
					}
				}
				if (flag) {
					provider.setCreatedBy(user.getId());// ������(uId)
					provider.setCreationDate(new Date());// ����ʱ��
					provider.setCompanyLicPicPath(companyLicPicPath);// ��ҵӪҵִ��
					provider.setOrgCodePicPath(orgCodePicPath);// ��֯��������֤
					if (providerService.addUser(provider)) {
						companyLicPicPathAttach.transferTo(companyLicPicPathFile);// �ϴ���������ָ��λ��
						orgCodePicPathAttach.transferTo(orgCodePicPathFile);// �ϴ���������ָ��λ��
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
	// provider.setCreatedBy(user.getId());// ������(uId)
	// provider.setCreationDate(new Date());// ����ʱ��
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

	// ��ת��Ӧ����Ϣҳ��
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

	// ��ת�޸��û���Ϣҳ��
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

	// ͨ����Ӧ��Id�޸Ĺ�Ӧ����Ϣ
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
