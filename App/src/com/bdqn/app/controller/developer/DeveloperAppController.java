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

	// ��תAppά��ҳ��
	@RequestMapping("/list")
	public String appinfolist(Model model, HttpSession session) {
		try {
			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// ������id
			AppInfo appInfo = new AppInfo();
			appInfo.setDevId(devId);
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
		return Properties.getString("page", "appinfolist");
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

			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// ������id
			appInfo.setDevId(devId);
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
		return Properties.getString("page", "appinfolist");
	}

	/*
	 * // ģ����ѯapp��Ϣ(��ҳ)
	 * 
	 * @RequestMapping(value = "/paging") public String paging(Model model,
	 * AppInfo appInfo, Integer currentPageNo) { try {
	 * 
	 * Integer pageSize = Integer.parseInt(Properties.getString("paging",
	 * "appInfos"));// ҳ��С int totalCount =
	 * appInfoService.getAppInfosCount(appInfo, currentPageNo, pageSize);// �ܼ�¼��
	 * int totalPageCount =
	 * com.bdqn.app.tools.PageSupport.getTotalPageCount(totalCount, pageSize);//
	 * ҳ���� List<AppInfo> appInfos = appInfoService.getAppInfos(appInfo,
	 * currentPageNo, pageSize);// app��Ϣ
	 * 
	 * model.addAttribute("appInfos", appInfos);// app��Ϣ
	 * model.addAttribute("currentPageNo", currentPageNo);// ��ǰҳ
	 * model.addAttribute("totalPageCount", totalPageCount);// ҳ����
	 * model.addAttribute("totalCount", totalCount);// �ܼ�¼��
	 * 
	 * model.addAttribute("appTypes", appInfoService.getAppType());
	 * model.addAttribute("appPlatforms", appInfoService.getAppPlatform());
	 * model.addAttribute("categoryLevel1s",
	 * appInfoService.getCategoryLevel1()); model.addAttribute("appInfo",
	 * appInfo); } catch (Exception e) { e.printStackTrace(); throw new
	 * RuntimeException(e); } return Properties.getString("page",
	 * "appinfolist"); }
	 */

	// ����ƽ̨
	@RequestMapping("/datadictionarylist.json")
	@ResponseBody
	public String datadictionarylist() {
		return JSON.toJSONString(appInfoService.getAppPlatform());
	}

	// ��ת����add������Ϣҳ��
	@RequestMapping("/appinfoadd")
	public String appinfoadd() {
		return Properties.getString("page", "appinfoadd");
	}

	// �ж�APKName�Ƿ����
	@RequestMapping("apkexist.json")
	@ResponseBody
	public String apkexist(@RequestParam(value = "APKName", required = false) String APKName) {
		Map<String, String> map = new HashMap<String, String>();
		if (APKName == null || APKName.equals("")) {
			map.put("APKName", "APKNameΪ����Ϊ�գ�");
		} else if (appInfoService.getApkexist(APKName)) {
			map.put("APKName", "��APKName�Ѵ��ڣ�����ʹ�ã�");
		} else {
			map.put("APKName", "��APKName����ʹ�ã�");
		}
		return JSON.toJSONString(map);
	}

	// ����app��Ϣ
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
			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
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
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// ��ȡͼƬ���·��
							String logoLocPath = targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// ������id
							appInfo.setCreatedBy(devId);// ������(devUserId)
							appInfo.setDevId(devId);// ������id
							appInfo.setCreationDate(new Date());// ����ʱ��
							appInfo.setLogoPicPath(logoPicPath);// ���·��
							appInfo.setLogoLocPath(logoLocPath);// ����·��
							if (appInfoService.addAppInfo(appInfo)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								request.setAttribute("uploadFileError", "�ϴ�ʧ��");
								string = Properties.getString("page", "appinfoadd");
							}
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute("uploadFileError", "�ϴ�ʧ��");
							string = Properties.getString("page", "appinfoadd");
						}
					}
				} else {
					request.setAttribute("uploadFileError", "�ϴ�ͼƬ��ʽ����ȷ");
					string = Properties.getString("page", "appinfoadd");
				}
			} else {
				request.setAttribute("uploadFileError", "�ϴ�ͼƬ����Ϊ��");
				string = Properties.getString("page", "appinfoadd");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return string;
	}

	// �鿴App��Ϣ
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

	// ɾ���ļ�
	@RequestMapping("/delfile")
	@ResponseBody
	public String delFile(String flag, Integer id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		String fileLocPath = null;
		if (flag == null || flag.equals("") || id == null || id.equals("")) {
			resultMap.put("result", "failed");
		} else if (flag.equals("logo")) {// ɾ��logoͼƬ������app_info��
			try {
				fileLocPath = (appInfoService.getAppInfo(id)).getLogoLocPath();// ����·��
				File file = new File(fileLocPath);
				if (file.exists()) {
					if (file.delete()) {// ɾ���������洢�������ļ�
						if (appInfoService.deleteAppLogo(id)) {// ���±�
							resultMap.put("result", "success");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (flag.equals("apk")) {
			try {
				fileLocPath = appVersionService.getApkLocPath(id);// ����·��
				File file = new File(fileLocPath);
				if (file.exists()) {
					if (file.delete()) {// ɾ���������洢�������ļ�
						if (appVersionService.deleteApkLocPath(id)) {// ���±�
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

	// ��ת�޸�App��Ϣҳ��
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

	// �޸�App��Ϣ
	@RequestMapping(value = "/appinfomodifysave", method = RequestMethod.POST)
	public String appinfomodifysave(AppInfo appInfo, HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {
		String uploadFileError = null;
		String string = null;
		try {
			HttpSession session = request.getSession();
			DevUser devUser = (DevUser) session.getAttribute("devUser");
			Integer devId = devUser.getId();// ������id
			appInfo.setModifyBy(devId);// ������(devUserId)
			appInfo.setUpdateDate(new Date());// ��������
			appInfo.setModifyDate(new Date());// ����ʱ��

			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
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
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + targetFile.getName();// ��ȡͼƬ���·��
							String logoLocPath = targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							appInfo.setLogoPicPath(logoPicPath);// ���·��
							appInfo.setLogoLocPath(logoLocPath);// ����·��
							if (appInfoService.modifyAppInfo(appInfo)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
								string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
										+ "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
							string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
									+ "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("�ϴ�ͼƬ��ʽ����ȷ", "utf-8");
					string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId()
							+ "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("�ϴ�ͼƬ����Ϊ�� ", "utf-8");
				string = "redirect:/dev/flatform/app/appinfomodify?appInfoId=" + appInfo.getId() + "&uploadFileError="
						+ uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	// ��ת����App�汾��Ϣ
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

	// ����App�汾��Ϣ
	@RequestMapping(value = "/addversionsave", method = RequestMethod.POST)
	public String addversionsave(AppVersion appVersion, HttpServletRequest request,
			@RequestParam(value = "a_downloadLink", required = false) MultipartFile attach) {
		String uploadFileError = null;
		String string = null;
		try {
			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
				String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
				String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
				if (attach.getSize() > 524288000) {// �ϴ���С���ó��� 500MB
					request.setAttribute("uploadFileError", "�ϴ���С���ó��� 500MB");
					string = Properties.getString("page", "adduser");
				} else if (prefix.equalsIgnoreCase("apk")) {// �ж�ͼƬ�ϴ���ʽ
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Spz.apk";// �����ļ���
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + fileName;// ��ȡͼƬ���·��
							String logoLocPath = targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// ������id
							appVersion.setCreatedBy(devId);// ������(devUserId)
							appVersion.setCreationDate(new Date());// ����ʱ��
							appVersion.setDownloadLink(logoPicPath);// ���·��(��������)
							appVersion.setApkLocPath(logoLocPath);// ����·��
							appVersion.setApkFileName(fileName);
							if (appVersionService.addAppVersion(appVersion)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
								string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
										+ "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
							string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
									+ "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("�ϴ�Apk��ʽ����ȷ", "utf-8");
					string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
							+ "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("Apk����Ϊ��", "utf-8");
				string = "redirect:/dev/flatform/app/appversionadd?appInfoId=" + appVersion.getAppId()
						+ "&uploadFileError=" + uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

	// ��ת�޸�app�汾ҳ��
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

	//�޸�app�汾
	@RequestMapping(value = "/appversionmodifysave", method = RequestMethod.POST)
	public String appversionmodifysave(AppVersion appVersion, HttpServletRequest request, MultipartFile attach) {
		String string = null;
		String uploadFileError = null;
		try {
			if (!attach.isEmpty()) {// �ж��ļ��Ƿ�Ϊ��
				String path = request.getSession().getServletContext()// ������·��
						.getRealPath("statics" + File.separator + "uploadfiles");// ͼƬҪ�ŵ���������λ�õ�λ��
				String oldFileName = attach.getOriginalFilename();// ԭ�ļ���
				String prefix = FilenameUtils.getExtension(oldFileName);// ԭ�ļ���׺
				if (attach.getSize() > 524288000) {// �ϴ���С���ó��� 500MB
					request.setAttribute("uploadFileError", "�ϴ���С���ó��� 500MB");
					string = Properties.getString("page", "adduser");
				} else if (prefix.equalsIgnoreCase("apk")) {// �ж�ͼƬ�ϴ���ʽ
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Spz.apk";// �����ļ���
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();// ָ�����ļ�λ�ò����ڷ���true���Զ�����,���ڷ���flaseʹ�ô����ļ�λ��
						try {
							String logoPicPath = request.getSession().getServletContext().getContextPath()
									+ "/statics/uploadfiles/" + fileName;// ��ȡͼƬ���·��
							String logoLocPath = targetFile.getCanonicalPath();// ��ȡͼƬ����·��(����)
							// idPicPath=path+File.separator+fileName;//��ȡͼƬ����·��(����)
							HttpSession session = request.getSession();
							DevUser devUser = (DevUser) session.getAttribute("devUser");
							Integer devId = devUser.getId();// ������id
							appVersion.setModifyBy(devId);// �޸���(devUserId)
							appVersion.setModifyDate(new Date());// ����ʱ��
							appVersion.setDownloadLink(logoPicPath);// ���·��(��������)
							appVersion.setApkLocPath(logoLocPath);// ����·��
							appVersion.setApkFileName(fileName);
							if (appVersionService.modifyAppVersion(appVersion)) {
								string = "redirect:/dev/flatform/app/list";
								attach.transferTo(targetFile);// �ϴ���������ָ��λ��
							} else {
								uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
								string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId()
										+ "&appId=" + appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
							}
						} catch (Exception e) {
							e.printStackTrace();
							uploadFileError = URLEncoder.encode("�ϴ�ʧ��", "utf-8");
							string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId()
									+ "&appId=" + appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
						}
					}
				} else {
					uploadFileError = URLEncoder.encode("�ϴ�APK��ʽ����ȷ", "utf-8");
					string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId() + "&appId="
							+ appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
				}
			} else {
				uploadFileError = URLEncoder.encode("ApK����Ϊ��", "utf-8");
				string = "redirect:/dev/flatform/app/appversionmodify?verId=" + appVersion.getId() + "&appId="
						+ appVersion.getAppId() + "&uploadFileError=" + uploadFileError;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}
	
	//ɾ��app��Ϣ
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
	
	//�ϼ�,�¼�
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
