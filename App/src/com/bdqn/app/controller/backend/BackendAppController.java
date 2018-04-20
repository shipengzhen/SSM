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
 * ����ԱApp������
 * 
 * @author ʩ����
 *
 */
@RequestMapping("/manager/backend/app")
public class BackendAppController {

	// Service��app����
	private IAppInfoService appInfoService;

	public IAppInfoService getAppInfoService() {
		return appInfoService;
	}

	public void setAppInfoService(IAppInfoService appInfoService) {
		this.appInfoService = appInfoService;
	}

	// Service��app�汾����
	private IAppVersionService appVersionService;

	public IAppVersionService getAppVersionService() {
		return appVersionService;
	}

	public void setAppVersionService(IAppVersionService appVersionService) {
		this.appVersionService = appVersionService;
	}

	// ��תapp���ҳ��
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		try {
			AppInfo appInfo = new AppInfo();
			Integer pageIndex = 1;// ��ǰҳ
			Integer pageSize = Integer.parseInt(Properties.getString("paging", "appInfos"));// ҳ��С
			int totalCount = appInfoService.getAppInfosCount(appInfo);// �ܼ�¼��
			int totalPageCount = com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
			List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo, pageIndex, pageSize);// app��Ϣ

			model.addAttribute("appInfos", appInfos);// app��Ϣ
			model.addAttribute("currentPageNo", pageIndex);// ��ǰҳ
			model.addAttribute("totalPageCount", totalPageCount);// ҳ����
			model.addAttribute("totalCount", totalCount);// �ܼ�¼��

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

	// ��������������
	@RequestMapping("/categorylevellist.json")
	@ResponseBody
	public String appinfolist(Integer parentId) {
		return JSON.toJSONString(appInfoService.getCategoryLevel(parentId));
	}

	// ģ����ѯapp��Ϣ(��ҳ)
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String appInfos(Model model, AppInfo appInfo, HttpSession session, Integer pageIndex) {
		try {
			if (pageIndex == null) {
				pageIndex = 1;// ��ǰҳ
			}
			Integer pageSize = Integer.parseInt(Properties.getString("paging", "appInfos"));// ҳ��С
			int totalCount = appInfoService.getAppInfosCount(appInfo);// �ܼ�¼��
			int totalPageCount = com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);// ҳ����
			List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo, pageIndex, pageSize);// app��Ϣ

			model.addAttribute("appInfos", appInfos);// app��Ϣ
			model.addAttribute("currentPageNo", pageIndex);// ��ǰҳ
			model.addAttribute("totalPageCount", totalPageCount);// ҳ����
			model.addAttribute("totalCount", totalCount);// �ܼ�¼��

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

	// ��ת��App���ҳ��
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
	
	//���app
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
