package com.bdqn.app.controller.backend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.AppVersion;
import com.bdqn.app.service.developer.IAppInfoService;
import com.bdqn.app.service.developer.IAppVersionService;
import com.bdqn.app.tools.Properties;

/**
 * 管理员App控制器
 * 
 * @author 施鹏振
 *
 */
@RequestMapping("/manager/backend/app")
public class BackendAppController {

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

	// 跳转app审核页面
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		try {
			AppInfo appInfo = new AppInfo();
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
		return Properties.getString("page", "applist");
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
		return Properties.getString("page", "applist");
	}

	// 跳转到App审核页面
	@RequestMapping("/check")
	public String check(Integer appId,Model model) {
		try {
			AppInfo appInfo =appInfoService.getAppInfo(appId);
			AppVersion appVersion = appVersionService.getNewAppVersion(appId);
			model.addAttribute(appVersion);
			model.addAttribute(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return Properties.getString("page", "appcheck");
	}
	
	//审核app
	@RequestMapping(value="/checksave",method=RequestMethod.POST)
	public String checkSave(AppInfo appInfo){
		try {
			if(appInfoService.modifyAppInfo(appInfo)){
				return "redirect:/manager/backend/app/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return Properties.getString("page", "appcheck");
	}
}
