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
 * 标准信息控制器
 * 
 * @author 施鹏振
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

	// 跳转查询标准信息页面
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

	// 查询分页
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

	// 删除一条或多条标准信息
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

	// 跳转新增页面
	@RequestMapping("/standard_add")
	public String standard_add() {
		return Page.STANDARD_ADD;
	}

	// 新增
	@RequestMapping(value = "/standard_add", method = RequestMethod.POST)
	public String standard_add(Standard standard, HttpServletRequest request, MultipartFile attach) {
		String page = null;
		try {
			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
				String oldFileName = attach.getOriginalFilename();// 原文件名
				String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
				if (attach.getSize() > 500000) {// 上传大小不得超过 500k
					request.setAttribute("uploadFileError", "上传大小不得超过 500k");
					page = Page.STANDARD_ADD;
				} else if (prefix.equalsIgnoreCase("docx")) {// 判断图片上传格式
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_spz.docx";// 更改图片名
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// 获取图片相对路径
							// String logoLocPath =
							// targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							standard.setPackagePath(logoPicPath);
							if (standardService.addStandard(standard)) {
								page = "redirect:/standard/standard_list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								request.setAttribute("uploadFileError", "上传失败");
								page = Page.STANDARD_ADD;
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "上传失败");
							page = Page.STANDARD_ADD;
						}
					}
				} else {
					request.setAttribute("uploadFileError", "上传图片格式不正确");
					page = Page.STANDARD_ADD;
				}
			} else {
				request.setAttribute("uploadFileError", "上传图片不能为空");
				page = Page.STANDARD_ADD;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return page;
	}

	// ajax 判断重名
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

	// 跳转修改页面
	@RequestMapping("/standard_modify")
	public String standard_modify(Model model, Integer standardId, String uploadFileError) {
		model.addAttribute("standard", standardService.findStandard(standardId));
		return Page.STANDARD_MODIFY;
	}

	// 修改
	@RequestMapping(value = "/standard_modify", method = RequestMethod.POST)
	public String standard_modify(Standard standard, HttpServletRequest request, MultipartFile attach) {
		String page = null;
		try {
			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
				String oldFileName = attach.getOriginalFilename();// 原文件名
				String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
				if (attach.getSize() > 500000) {// 上传大小不得超过 500k
					request.setAttribute("uploadFileError", "上传大小不得超过 500k");
					page = Page.STANDARD_MODIFY;
				} else if (prefix.equalsIgnoreCase("docx")) {// 判断图片上传格式
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_spz.docx";// 更改图片名
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// 获取图片相对路径
							// String logoLocPath =
							// targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							standard.setPackagePath(logoPicPath);
							if (standardService.modifyStandard(standard)) {
								page = "redirect:/standard/standard_list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								request.setAttribute("uploadFileError", "上传失败");
								page = Page.STANDARD_MODIFY;
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "上传失败");
							page = Page.STANDARD_MODIFY;
						}
					}
				} else {
					request.setAttribute("uploadFileError", "上传图片格式不正确");
					page = Page.STANDARD_MODIFY;
				}
			} else {
				request.setAttribute("uploadFileError", "上传图片不能为空");
				page = Page.STANDARD_MODIFY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return page;
	}
}
