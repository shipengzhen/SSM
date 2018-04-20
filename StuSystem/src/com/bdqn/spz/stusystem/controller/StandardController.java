package com.bdqn.spz.stusystem.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.service.IStandardService;
import com.bdqn.spz.stusystem.tools.Page;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * ��׼��Ϣ������
 * 
 * @author ʩ����
 *
 */
@RequestMapping("/standard")
public class StandardController {

	private IStandardService standardService;

	public IStandardService getStandardService() {
		return standardService;
	}

	public void setStandardService(IStandardService standardService) {
		this.standardService = standardService;
	}

	// ��ת��ѯ��׼��Ϣҳ��
	@RequestMapping("/standard_list")
	public String standard_List(Model model) {
		try {
			Paging<Standard> paging = new Paging<Standard>();
			paging.setT(new Standard());
			paging.setPageSize(5);
			paging.setCurrentPageNo(1);
			model.addAttribute("paging", standardService.findStandards(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.STANDARD_LIST;
	}

	// ��ѯ��ҳ
	@RequestMapping(value = "/standard_list", method = RequestMethod.POST)
	public String standard_List(Model model, Paging<Standard> paging, Standard standard) {
		try {
			paging.setT(standard);
			model.addAttribute("paging", standardService.findStandards(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.STANDARD_LIST;
	}

	// ɾ��һ���������׼��Ϣ
	@RequestMapping("/standard_del")
	public String standard_del(Integer[] standardIds) {
		String page = null;
		try {
			if (standardService.amputateStandards(standardIds)) {
				page = "redirect:/standard/standard_list";
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}

	// ��ת����ҳ��
	@RequestMapping("/standard_add")
	public String standard_add() {
		return Page.STANDARD_ADD;
	}

	// ����
	@RequestMapping(value = "/standard_add", method = RequestMethod.POST)
	public String standard_add(Standard standard, HttpServletRequest request, MultipartFile attach) {
		String page = null;
		try {
			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
				String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
				String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
				if (attach.getSize() > 500000) {// �ϴ���С���ó��� 500k
					request.setAttribute("uploadFileError", "�ϴ���С���ó��� 500k");
					page = Page.STANDARD_ADD;
				} else if (prefix.equalsIgnoreCase("docx")) {// �ж�ͼƬ�ϴ���ʽ
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_spz.docx";// ����ͼƬ��
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// ��ȡͼƬ���·��
							// String logoLocPath =
							// targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							standard.setPackagePath(logoPicPath);
							if (standardService.addStandard(standard)) {
								page = "redirect:/standard/standard_list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								request.setAttribute("uploadFileError", "�ϴ�ʧ��");
								page = Page.STANDARD_ADD;
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "�ϴ�ʧ��");
							page = Page.STANDARD_ADD;
						}
					}
				} else {
					request.setAttribute("uploadFileError", "�ϴ�ͼƬ��ʽ����ȷ");
					page = Page.STANDARD_ADD;
				}
			} else {
				request.setAttribute("uploadFileError", "�ϴ�ͼƬ����Ϊ��");
				page = Page.STANDARD_ADD;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return page;
	}

	// ajax �ж�����
	@RequestMapping("dostdnum")
	@ResponseBody
	public Object dopdstdNum(String stdNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (standardService.findStandard(stdNum)) {
			map.put("result", "ok");
		} else {
			map.put("result", "no");
		}
		return JSON.toJSONString(map);
	}

	// ��ת�޸�ҳ��
	@RequestMapping("/standard_modify")
	public String standard_modify(Model model, Integer standardId, String uploadFileError) {
		model.addAttribute("standard", standardService.findStandard(standardId));
		return Page.STANDARD_MODIFY;
	}

	// �޸�
	@RequestMapping(value = "/standard_modify", method = RequestMethod.POST)
	public String standard_modify(Standard standard, HttpServletRequest request, MultipartFile attach) {
		String page = null;
		try {
			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
				String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
				String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
				if (attach.getSize() > 500000) {// �ϴ���С���ó��� 500k
					request.setAttribute("uploadFileError", "�ϴ���С���ó��� 500k");
					page = Page.STANDARD_MODIFY;
				} else if (prefix.equalsIgnoreCase("docx")) {// �ж�ͼƬ�ϴ���ʽ
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_spz.docx";// ����ͼƬ��
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// ��ȡͼƬ���·��
							// String logoLocPath =
							// targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							standard.setPackagePath(logoPicPath);
							if (standardService.modifyStandard(standard)) {
								page = "redirect:/standard/standard_list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								request.setAttribute("uploadFileError", "�ϴ�ʧ��");
								page = Page.STANDARD_MODIFY;
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "�ϴ�ʧ��");
							page = Page.STANDARD_MODIFY;
						}
					}
				} else {
					request.setAttribute("uploadFileError", "�ϴ�ͼƬ��ʽ����ȷ");
					page = Page.STANDARD_MODIFY;
				}
			} else {
				request.setAttribute("uploadFileError", "�ϴ�ͼƬ����Ϊ��");
				page = Page.STANDARD_MODIFY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return page;
	}
}
