package com.bdqn.app.service.developer.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.bdqn.app.dao.appinfo.IAppInfoDao;
import com.bdqn.app.dao.appversion.IAppVersionDao;
import com.bdqn.app.pojo.AppCategory;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.AppVersion;
import com.bdqn.app.pojo.DataDictionary;
import com.bdqn.app.service.developer.IAppInfoService;

/**
 * AppService层实现类
 * 
 * @author 施鹏振
 *
 */
public class AppInfoServiceImpl implements IAppInfoService {

	// dao层app信息对象
	private IAppInfoDao appInfoDao;

	public IAppInfoDao getAppInfoDao() {
		return appInfoDao;
	}

	public void setAppInfoDao(IAppInfoDao appInfoDao) {
		this.appInfoDao = appInfoDao;
	}

	// dao层app版本信息对象
	private IAppVersionDao appVersionDao;

	public IAppVersionDao getAppVersionDao() {
		return appVersionDao;
	}

	public void setAppVersionDao(IAppVersionDao appVersionDao) {
		this.appVersionDao = appVersionDao;
	}

	// APP状态
	@Override
	public List<DataDictionary> getAppType() {
		List<DataDictionary> dataDictionaries = null;
		try {
			dataDictionaries = appInfoDao.findValueName("APP状态");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDictionaries;
	}

	// 所属平台
	@Override
	public List<DataDictionary> getAppPlatform() {
		List<DataDictionary> dataDictionaries = null;
		try {
			dataDictionaries = appInfoDao.findValueName("所属平台");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDictionaries;
	}

	// 一级分类
	@Override
	public List<AppCategory> getCategoryLevel1() {
		List<AppCategory> appCategorys = null;
		try {
			appCategorys = appInfoDao.findCategoryLevel(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appCategorys;
	}

	// 二,三级分类
	@Override
	public List<AppCategory> getCategoryLevel(Integer parentId) {
		List<AppCategory> appCategorys = null;
		try {
			appCategorys = appInfoDao.findCategoryLevel(parentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appCategorys;
	}

	// 模糊查询app信息(分页)
	@Override
	public List<AppInfo> getAppInfos(AppInfo appInfo, Integer currentPageNo, Integer pageSize) {
		List<AppInfo> appInfos = null;
		try {
			appInfos = appInfoDao.findAppInfos(appInfo, (currentPageNo - 1) * pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appInfos;
	}

	// 模糊查询app信息总数量(分页)
	@Override
	public Integer getAppInfosCount(AppInfo appInfo) {
		Integer count = null;
		try {
			count = appInfoDao.findAppInfosCount(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 新增App信息
	@Override
	public boolean addAppInfo(AppInfo appInfo) {
		boolean b = false;
		try {
			if (appInfoDao.insertAppInfo(appInfo) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询App信息
	@Override
	public AppInfo getAppInfo(Integer appInfoId) {
		AppInfo appInfo = null;
		try {
			appInfo = appInfoDao.findAppInfo(appInfoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appInfo;
	}

	// 判断APKName是否存在
	@Override
	public boolean getApkexist(String APKName) {
		boolean b = false;
		try {
			if (appInfoDao.findAppInfoCount(APKName) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 删除AppLogo
	@Override
	public boolean deleteAppLogo(Integer appInfoId) {
		boolean b = false;
		try {
			if (appInfoDao.updateAppLogo(appInfoId) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 修改App信息
	@Override
	public boolean modifyAppInfo(AppInfo appInfo) {
		boolean b = false;
		try {
			if (appInfoDao.updateAppInfo(appInfo) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 根据appId删除app信息及版本信息
	@Override
	public boolean deleteAppByAppId(Integer appId) {
		boolean b = false;
		try {
			// 1 先删版本信息
			// <1> 删除上传的apk文件
			List<AppVersion> appVersions = appVersionDao.findAppVersions(appId);
			for (AppVersion appVersion : appVersions) {
				if (appVersion.getApkLocPath() != null && !appVersion.getApkLocPath().equals("")) {
					File file = new File(appVersion.getApkLocPath());
					if (file.exists()) {
						if (!file.delete()) {
							throw new Exception();
						}
					}
				}
			}
			// <2> 删除app_version表数据
			appVersionDao.deleteVersionByAppId(appId);
			// 2 再删app基础信息
			// <1> 删除上传的logo图片
			AppInfo appInfo = appInfoDao.findAppInfo(appId);
			if (appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")) {
				File file = new File(appInfo.getLogoLocPath());
				if (file.exists()) {
					if (!file.delete()) {
						throw new Exception();
					}
				}
			}
			// <2> 删除app_info表数据
			if (appInfoDao.deleteAppInfoByAppId(appId) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	// 修改App状态
	@Override
	public boolean modifyAppStatusByAppId(Integer appId,Integer devId) {
		boolean b=true;
		try {
			AppInfo appInfo=appInfoDao.findAppInfo(appId);
			appInfo.setDevId(devId);
			Integer status =appInfo.getStatus();
			appInfo.setOffSaleDate(new Date());
			switch (status) {
			case 2: // 当状态为审核通过时，可以进行上架操作
				onSale(appInfo);
				break;
			case 5:// 当状态为下架时，可以进行上架操作
				onSale(appInfo);
				break;
			case 4:// 当状态为上架时，可以进行下架操作
				offSale(appInfo);
				break;
			default:
				b=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//上架
	@Override
	public boolean onSale(AppInfo appInfo) {
		boolean b=false;
		appInfo.setStatus(4);
		if (App(appInfo)) {
			appInfo.setStatus(2);
			b=Version(appInfo);
		}
		return b;
	}
	
	//下架
	@Override
	public boolean offSale(AppInfo appInfo) {
		appInfo.setStatus(5);
		return App(appInfo);
	}

	//修改app信息
	@Override
	public boolean App(AppInfo appInfo) {
		boolean b=false;
		try {
			if (appInfoDao.updateAppInfo(appInfo)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//修改app版本信息
	@Override
	public boolean Version(AppInfo appInfo) {
		boolean b=false;
		try {
			AppVersion appVersion = new AppVersion();
			appVersion.setId(appInfo.getVersionId());
			appVersion.setPublishStatus(appInfo.getStatus());
			appVersion.setModifyBy(appInfo.getModifyBy());
			appVersion.setModifyDate(new Date());
			if (appVersionDao.updateAppVersion(appVersion)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
