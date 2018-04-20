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
 * AppService��ʵ����
 * 
 * @author ʩ����
 *
 */
public class AppInfoServiceImpl implements IAppInfoService {

	// dao��app��Ϣ����
	private IAppInfoDao appInfoDao;

	public IAppInfoDao getAppInfoDao() {
		return appInfoDao;
	}

	public void setAppInfoDao(IAppInfoDao appInfoDao) {
		this.appInfoDao = appInfoDao;
	}

	// dao��app�汾��Ϣ����
	private IAppVersionDao appVersionDao;

	public IAppVersionDao getAppVersionDao() {
		return appVersionDao;
	}

	public void setAppVersionDao(IAppVersionDao appVersionDao) {
		this.appVersionDao = appVersionDao;
	}

	// APP״̬
	@Override
	public List<DataDictionary> getAppType() {
		List<DataDictionary> dataDictionaries = null;
		try {
			dataDictionaries = appInfoDao.findValueName("APP״̬");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDictionaries;
	}

	// ����ƽ̨
	@Override
	public List<DataDictionary> getAppPlatform() {
		List<DataDictionary> dataDictionaries = null;
		try {
			dataDictionaries = appInfoDao.findValueName("����ƽ̨");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataDictionaries;
	}

	// һ������
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

	// ��,��������
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

	// ģ����ѯapp��Ϣ(��ҳ)
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

	// ģ����ѯapp��Ϣ������(��ҳ)
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

	// ����App��Ϣ
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

	// ��ѯApp��Ϣ
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

	// �ж�APKName�Ƿ����
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

	// ɾ��AppLogo
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

	// �޸�App��Ϣ
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

	// ����appIdɾ��app��Ϣ���汾��Ϣ
	@Override
	public boolean deleteAppByAppId(Integer appId) {
		boolean b = false;
		try {
			// 1 ��ɾ�汾��Ϣ
			// <1> ɾ���ϴ���apk�ļ�
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
			// <2> ɾ��app_version������
			appVersionDao.deleteVersionByAppId(appId);
			// 2 ��ɾapp������Ϣ
			// <1> ɾ���ϴ���logoͼƬ
			AppInfo appInfo = appInfoDao.findAppInfo(appId);
			if (appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")) {
				File file = new File(appInfo.getLogoLocPath());
				if (file.exists()) {
					if (!file.delete()) {
						throw new Exception();
					}
				}
			}
			// <2> ɾ��app_info������
			if (appInfoDao.deleteAppInfoByAppId(appId) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	// �޸�App״̬
	@Override
	public boolean modifyAppStatusByAppId(Integer appId,Integer devId) {
		boolean b=true;
		try {
			AppInfo appInfo=appInfoDao.findAppInfo(appId);
			appInfo.setDevId(devId);
			Integer status =appInfo.getStatus();
			appInfo.setOffSaleDate(new Date());
			switch (status) {
			case 2: // ��״̬Ϊ���ͨ��ʱ�����Խ����ϼܲ���
				onSale(appInfo);
				break;
			case 5:// ��״̬Ϊ�¼�ʱ�����Խ����ϼܲ���
				onSale(appInfo);
				break;
			case 4:// ��״̬Ϊ�ϼ�ʱ�����Խ����¼ܲ���
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

	//�ϼ�
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
	
	//�¼�
	@Override
	public boolean offSale(AppInfo appInfo) {
		appInfo.setStatus(5);
		return App(appInfo);
	}

	//�޸�app��Ϣ
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

	//�޸�app�汾��Ϣ
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
