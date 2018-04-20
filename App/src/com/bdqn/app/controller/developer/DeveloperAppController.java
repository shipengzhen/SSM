package com.bdqn.app.controller.developer;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.AppVersion;
import com.bdqn.app.pojo.DevUser;
import com.bdqn.app.service.developer.IAppInfoService;
import com.bdqn.app.service.developer.IAppVersionService;
import com.bdqn.app.tools.Properties;
import com.mysql.jdbc.StringUtils;

@RequestMapping("/dev/flatform/app")
public class DeveloperAppController {

	// Service层app对象
	private IAppInfoService appInfoService;

	public IAppInfoService getAppInfoService() {
		return appInfoService;
	}

	public void setAppInfoService(IAppInfoService appInfoService) {
		this.appInfoService = appInfoService;
	}

	// Service层app版本对象
	private IAppVersionService appVersionService;

	public IAppVersionService getAppVersionService() {
		return appVersionService;
	}

	public void setAppVersionService(IAppVersionService appVersionService) {
		this.appVersionService = appVersionService;
	}

	// 跳转App维护页面
	@RequestMapping("/list")
	public String appinfolist(Model model, HttpSession session) {
		try {
			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// 开发者id
			AppInfo appInfo = new AppInfo();
			appInfo.setDevId(devId);
			Integer pageIndex = 1;// 当前页
			Integer pageSize = Integer.parseInt(Properties.getString("paging", "appInfos"));// 页大小
			int totalCount = appInfoService.getAppInfosCount(appInfo);// 总记录数
			int totalPageCount = com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
			List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo, pageIndex, pageSize);// app信息

			model.addAttribute("appInfos", appInfos);// app信息
			model.addAttribute("currentPageNo", pageIndex);// 当前页
			model.addAttribute("totalPageCount", totalPageCount);// 页总数
			model.addAttribute("totalCount", totalCount);// 总记录数

			model.addAttribute("appTypes", appInfoService.getAppType());
			model.addAttribute("appPlatforms", appInfoService.getAppPlatform());
			model.addAttribute("categoryLevel1s", appInfoService.getCategoryLevel1());
			model.addAttribute("appInfo", appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return Properties.getString("page", "appinfolist");
	}

	// 二级，三级分类
	@RequestMapping("/categorylevellist.json")
	@ResponseBody
	public String appinfolist(Integer parentId) {
		return JSON.toJSONString(appInfoService.getCategoryLevel(parentId));
	}

	// 模糊查询app信息(分页)
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String appInfos(Model model, AppInfo appInfo, HttpSession session, Integer pageIndex) {
		try {

			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// 开发者id
			appInfo.setDevId(devId);
			if (pageIndex == null) {
				pageIndex = 1;// 当前页
			}
			Integer pageSize = Integer.parseInt(Properties.getString("paging", "appInfos"));// 页大小
			int totalCount = appInfoService.getAppInfosCount(appInfo);// 总记录数
			int totalPageCount = com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);// 页总数
			List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo, pageIndex, pageSize);// app信息

			model.addAttribute("appInfos", appInfos);// app信息
			model.addAttribute("currentPageNo", pageIndex);// 当前页
			model.addAttribute("totalPageCount", totalPageCount);// 页总数
			model.addAttribute("totalCount", totalCount);// 总记录数

			model.addAttribute("appTypes", appInfoService.getAppType());
			model.addAttribute("appPlatforms", appInfoService.getAppPlatform());
			model.addAttribute("categoryLevel1s", appInfoService.getCategoryLevel1());
			model.addAttribute("categoryLevel2s", appInfoService.getCategoryLevel(appInfo.getCategoryLevel1()));
			model.addAttribute("categoryLevel3s", appInfoService.getCategoryLevel(appInfo.getCategoryLevel2()));
			model.addAttribute("appInfo", appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return Properties.getString("page", "appinfolist");
	}

	/*
	 * // 模糊查询app信息(分页)
	 * 
	 * @RequestMapping(value = "/paging") public String paging(Model model,
	 * AppInfo appInfo, Integer currentPageNo) { try {
	 * 
	 * Integer pageSize = Integer.parseInt(Properties.getString("paging",
	 * "appInfos"));// 页大小 int totalCount =
	 * appInfoService.getAppInfosCount(appInfo, currentPageNo, pageSize);// 总记录数
	 * int totalPageCount =
	 * com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);//
	 * 页总数 List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo,
	 * currentPageNo, pageSize);// app信息
	 * 
	 * model.addAttribute("appInfos", appInfos);// app信息
	 * model.addAttribute("currentPageNo", currentPageNo);// 当前页
	 * model.addAttribute("totalPageCount", totalPageCount);// 页总数
	 * model.addAttribute("totalCount", totalCount);// 总记录数
	 * 
	 * model.addAttribute("appTypes", appInfoService.getAppType());
	 * model.addAttribute("appPlatforms", appInfoService.getAppPlatform());
	 * model.addAttribute("categoryLevel1s",
	 * appInfoService.getCategoryLevel1()); model.addAttribute("appInfo",
	 * appInfo); } catch (Exception e) { e.printStackTrace(); throw new
	 * RuntimeException(e); } return Properties.getString("page",
	 * "appinfolist"); }
	 */

	// 所属平台
	@RequestMapping("/datadictionarylist.json")
	@ResponseBody
	public String datadictionarylist() {
		return JSON.toJSONString(appInfoService.getAppPlatform());
	}

	// 跳转新增add基础信息页面
	@RequestMapping("/appinfoadd")
	public String appinfoadd() {
		return Properties.getString("page", "appinfoadd");
	}

	// 判断APKName是否存在
	@RequestMapping("apkexist.json")
	@ResponseBody
	public String apkexist(@RequestParam(value = "APKName", required = false) String APKName) {
		Map<String, String> map = new HashMap<String, String>();
		if (APKName == null || APKName.equals("")) {
			map.put("APKName", "APKName为不能为空！");
		} else if (appInfoService.getApkexist(APKName)) {
			map.put("APKName", "该APKName已存在，不能使用！");
		} else {
			map.put("APKName", "该APKName可以使用！");
		}
		return JSON.toJSONString(map);
	}

	// 新增app信息
	@RequestMapping(value = "/appinfoaddsave", method = RequestMethod.POST)
	public String appinfoaddsave(AppInfo appInfo, HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach) {

		/*
		 * System.out.println(appInfo.getSoftwareName());
		 * System.out.println(appInfo.getAPKName());
		 * System.out.println(appInfo.getSupportROM());
		 * System.out.println(appInfo.getInterfaceLanguage());
		 * System.out.println(appInfo.getSoftwareSize());
		 * System.out.println(appInfo.getDownloads());
		 * System.out.println(appInfo.getFlatformId());
		 * System.out.println(appInfo.getCategoryLevel1());
		 * System.out.println(appInfo.getCategoryLevel2());
		 * System.out.println(appInfo.getCategoryLevel3());
		 * System.out.println(appInfo.getStatus());
		 * System.out.println(appInfo.getAppInfo());
		 * System.out.println(appInfo.getLogoPicPath());
		 */
		String string = null;
		try {
			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
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
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// 获取图片相对路径
							String logoLocPath = targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// 开发者id
							appInfo.setCreatedBy(devId);// 创建者(devUserId)
							appInfo.setDevId(devId);// 开发者id
							appInfo.setCreationDate(new Date());// 创建时间
							appInfo.setLogoPicPath(logoPicPath);// 相对路径
							appInfo.setLogoLocPath(logoLocPath);// 绝对路径
							if (appInfoService.addAppInfo(appInfo)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								request.setAttribute("uploadFileError", "上传失败");
								string = Properties.getString("page", "appinfoadd");
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "上传失败");
							string = Properties.getString("page", "appinfoadd");
						}
					}
				} else {
					request.setAttribute("uploadFileError", "上传图片格式不正确");
					string = Properties.getString("page", "appinfoadd");
				}
			} else {
				request.setAttribute("uploadFileError", "上传图片不能为空");
				string = Properties.getString("page", "appinfoadd");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return string;
	}

	// 查看App信息
	@RequestMapping("/appview/{appInfoId}")
	public String appview(@PathVariable Integer appInfoId, Model model) {
		try {
			AppInfo appInfo = appInfoService.getAppInfo(appInfoId);
			model.addAttribute("appInfo", appInfo);
			List<AppVersion> appVersions = appVersionService.getAppVersions(appInfoId);
			model.addAttribute("appVersions", appVersions);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Properties.getString("page", "appinfoview");
	}

	// 删除文件
	@RequestMapping("/delfile")
	@ResponseBody
	public String delFile(String flag, Integer id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		String fileLocPath = null;
		if (flag == null || flag.equals("") || id == null || id.equals("")) {
			resultMap.put("result", "failed");
		} else if (flag.equals("logo")) {// 删除logo图片（操作app_info）
			try {
				fileLocPath = (appInfoService.getAppInfo(id)).getLogoLocPath();// 绝对路径
				File file = new File(fileLocPath);
				if (file.exists()) {
					if (file.delete()) {// 删除服务器存储的物理文件
						if (appInfoService.deleteAppLogo(id)) {// 更新表
							resultMap.put("result", "success");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (flag.equals("apk")) {
			try {
				fileLocPath = appVersionService.getApkLocPath(id);// 绝对路径
				File file = new File(fileLocPath);
				if (file.exists()) {
					if (file.delete()) {// 删除服务器存储的物理文件
						if (appVersionService.deleteApkLocPath(id)) {// 更新表
							resultMap.put("result", "success");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	// 跳转修改App信息页面
	@RequestMapping("/appinfomodify")
	public String appinfomodify(Integer appInfoId, Model model, String uploadFileError) {
		try {
			AppInfo appInfo = appInfoService.getAppInfo(appInfoId);
			model.addAttribute("appInfo", appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Properties.getString("page", "appinfomodify");
	}

	// 修改App信息
	@RequestMapping(value = "/appinfomodifysave", method = RequestMethod.POST)
	public String appinfomodifysave(AppInfo appInfo, HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {
		String uploadFileError = null;
		String string = null;
		try {
			HttpSession session = request.getSession();
			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// 开发者id
			appInfo.setModifyBy(devId);// 更新者(devUserId)
			appInfo.setUpdateDate(new Date());// 更新日期
			appInfo.setModifyDate(new Date());// 更新时间

			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
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
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// 获取图片相对路径
							String logoLocPath = targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							appInfo.setLogoPicPath(logoPicPath);// 相对路径
							appInfo.setLogoLocPath(logoLocPath);// 绝对路径
							if (appInfoService.modifyAppInfo(appInfo)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								uploadFileError = URLEncoder.encode("上传失败", "utf-8");
								string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
										+ "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("上传失败", "utf-8");
							string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
									+ "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("上传图片格式不正确", "utf-8");
					string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
							+ "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("上传图片不能为空 ", "utf-8");
				string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId() + "&uploadFileError="
						+ uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	// 跳转新增App版本信息
	@RequestMapping("/appversionadd")
	public String appversionadd(Integer appInfoId, Model model, String uploadFileError) {
		try {
			List<AppVersion> appVersions = appVersionService.getAppVersions(appInfoId);
			model.addAttribute("appVersions", appVersions);
			model.addAttribute("appInfoId", appInfoId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Properties.getString("page", "appversionadd");
	}

	// 新增App版本信息
	@RequestMapping(value = "/addversionsave", method = RequestMethod.POST)
	public String addversionsave(AppVersion appVersion, HttpServletRequest request,
			@RequestParam(value = "a_downloadLink", required = false) MultipartFile attach) {
		String uploadFileError = null;
		String string = null;
		try {
			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
				String oldFileName = attach.getOriginalFilename();// 原文件名
				String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
				if (attach.getSize() > 524288000) {// 上传大小不得超过 500MB
					request.setAttribute("uploadFileError", "上传大小不得超过 500MB");
					string = Properties.getString("page", "adduser");
				} else if (prefix.equalsIgnoreCase("apk")) {// 判断图片上传格式
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Spz.apk";// 更改文件名
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + fileName;// 获取图片相对路径
							String logoLocPath = targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// 开发者id
							appVersion.setCreatedBy(devId);// 创建者(devUserId)
							appVersion.setCreationDate(new Date());// 创建时间
							appVersion.setDownloadLink(logoPicPath);// 相对路径(下载链接)
							appVersion.setApkLocPath(logoLocPath);// 绝对路径
							appVersion.setApkFileName(fileName);
							if (appVersionService.addAppVersion(appVersion)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								uploadFileError = URLEncoder.encode("上传失败", "utf-8");
								string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
										+ "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("上传失败", "utf-8");
							string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
									+ "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("上传Apk格式不正确", "utf-8");
					string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
							+ "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("Apk不能为空", "utf-8");
				string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
						+ "&uploadFileError=" + uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	// 跳转修改app版本页面
	@RequestMapping("/appversionmodify")
	public String appversionmodify(Model model, Integer verId, Integer appId, String uploadFileError) {
		try {
			List<AppVersion> appVersions = appVersionService.getAppVersions(appId);
			model.addAttribute("appVersions", appVersions);
			model.addAttribute("verId", verId);
			model.addAttribute("appId", appId);
			model.addAttribute("appVersion", appVersionService.getNewAppVersion(appId));
			model.addAttribute("uploadFileError", uploadFileError);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Properties.getString("page", "appversionmodify");
	}

	//修改app版本
	@RequestMapping(value = "/appversionmodifysave", method = RequestMethod.POST)
	public String appversionmodifysave(AppVersion appVersion, HttpServletRequest request, MultipartFile attach) {
		String string = null;
		String uploadFileError = null;
		try {
			if (!attach.isEmpty()) {// 判断文件是否为空
				String path = request.getSession().getServletContext()// 服务器路径
						.getRealPath("statics" + File.separator + "uploadfiles");// 图片要放到服务器的位置的位置
				String oldFileName = attach.getOriginalFilename();// 原文件名
				String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
				if (attach.getSize() > 524288000) {// 上传大小不得超过 500MB
					request.setAttribute("uploadFileError", "上传大小不得超过 500MB");
					string = Properties.getString("page", "adduser");
				} else if (prefix.equalsIgnoreCase("apk")) {// 判断图片上传格式
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Spz.apk";// 更改文件名
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// 指定的文件位置不存在返回true并自动创建,存在返回flase使用存在文件位置
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + fileName;// 获取图片相对路径
							String logoLocPath = targetFile.getCanonicalPath();// 获取图片完整路径(绝对)
							// idPicPath=path+File.separator+fileName;//获取图片完整路径(绝对)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// 开发者id
							appVersion.setModifyBy(devId);// 修改者(devUserId)
							appVersion.setModifyDate(new Date());// 创建时间
							appVersion.setDownloadLink(logoPicPath);// 相对路径(下载链接)
							appVersion.setApkLocPath(logoLocPath);// 绝对路径
							appVersion.setApkFileName(fileName);
							if (appVersionService.modifyAppVersion(appVersion)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// 上传到服务器指定位置
							} else {
								uploadFileError = URLEncoder.encode("上传失败", "utf-8");
								string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId()
										+ "&appId=" + appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("上传失败", "utf-8");
							string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId()
									+ "&appId=" + appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("上传APK格式不正确", "utf-8");
					string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId() + "&appId="
							+ appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("ApK不能为空", "utf-8");
				string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId() + "&appId="
						+ appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}
	
	//删除app信息
	@RequestMapping("/delapp")
	@ResponseBody
	public Object delapp(Integer appId){
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			if(StringUtils.isNullOrEmpty(appId.toString())){
				resultMap.put("delResult", "notexist");
			}else{
				if(appInfoService.deleteAppByAppId(appId)){
					resultMap.put("delResult", "true");
				}else{
					resultMap.put("delResult", "false");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	//上架,下架
	@RequestMapping(value="/{appId}/sale",method=RequestMethod.PUT)
	@ResponseBody
	public Object sale(@PathVariable Integer appId,HttpSession session){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errorCode", "0");
		if(appId>0){
			try {
				DevUser devUser = (DevUser)session.getAttribute("devUser");
				if(appInfoService.modifyAppStatusByAppId(appId,devUser.getId())){
					resultMap.put("resultMsg", "success");
				}else{
					resultMap.put("resultMsg", "failed");
				}		
			} catch (Exception e) {
				resultMap.put("errorCode", "exception000001");
			}
		}else{
			resultMap.put("errorCode", "param000001");
		}
		return resultMap;
	}
}
