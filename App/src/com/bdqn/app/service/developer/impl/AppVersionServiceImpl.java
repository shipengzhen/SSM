package com.bdqn.app.service.developer.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.app.dao.appinfo.IAppInfoDao;
import com.bdqn.app.dao.appversion.IAppVersionDao;
import com.bdqn.app.pojo.AppVersion;
import com.bdqn.app.service.developer.IAppVersionService;

/**
 * App�汾Service��ʵ����
 * @author ʩ����
 */
public class AppVersionServiceImpl implements IAppVersionService {

	//dao�����
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

	// ��ѯapp�汾
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

	//����App�汾
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

	// ��ѯ���°汾��Ϣ
	@Override
	public AppVersion getNewAppVersion(Integer appId) {
		AppVersion appVersion=null;
		try {
			appVersion=appVersionDao.findNewAppVersion(appId);
		} catch (Exception e) {
		}
		return appVersion;
	}

	//ɾ��apk�ļ��ķ������洢·��
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

	//��ѯapk�ļ��ķ������洢·��
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

	//�޸�App�汾
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
