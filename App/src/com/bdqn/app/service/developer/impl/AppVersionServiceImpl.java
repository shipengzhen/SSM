package com.bdqn.app.service.developer.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.app.dao.appinfo.IAppInfoDao;
import com.bdqn.app.dao.appversion.IAppVersionDao;
import com.bdqn.app.pojo.AppVersion;
import com.bdqn.app.service.developer.IAppVersionService;

/**
 * App版本Service层实现类
 * @author 施鹏振
 */
public class AppVersionServiceImpl implements IAppVersionService {

	//dao层对象
	private IAppVersionDao appVersionDao;

	public IAppVersionDao getAppVersionDao() {
		return appVersionDao;
	}

	public void setAppVersionDao(IAppVersionDao appVersionDao) {
		this.appVersionDao = appVersionDao;
	}

	private IAppInfoDao appInfoDao;
	
	public IAppInfoDao getAppInfoDao() {
		return appInfoDao;
	}

	public void setAppInfoDao(IAppInfoDao appInfoDao) {
		this.appInfoDao = appInfoDao;
	}

	// 查询app版本
	@Override
	public List<AppVersion> getAppVersions(Integer appInfoId) {
		List<AppVersion> appVersions=new ArrayList<AppVersion>();
		try {
			appVersions=appVersionDao.findAppVersions(appInfoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appVersions;
	}

	//新增App版本
	@Override
	public boolean addAppVersion(AppVersion appVersion) {
		boolean b=false;
		try {
			if (appVersionDao.insertAppVersion(appVersion)>0) {
				if (appInfoDao.updateVersionId(appVersion.getAppId())>0) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询最新版本信息
	@Override
	public AppVersion getNewAppVersion(Integer appId) {
		AppVersion appVersion=null;
		try {
			appVersion=appVersionDao.findNewAppVersion(appId);
		} catch (Exception e) {
		}
		return appVersion;
	}

	//删除apk文件的服务器存储路径
	@Override
	public boolean deleteApkLocPath(Integer verId) {
		boolean b=false;
		try {
			if (appVersionDao.updateApkLocPath(verId)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//查询apk文件的服务器存储路径
	@Override
	public String getApkLocPath(Integer verId) {
		String string=null;
		try {
			string=appVersionDao.findApkLocPath(verId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

	//修改App版本
	@Override
	public boolean modifyAppVersion(AppVersion appVersion) {
		boolean b=false;
		try {
			if (appVersionDao.updateAppVersion(appVersion)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
