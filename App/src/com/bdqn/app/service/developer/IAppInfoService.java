package com.bdqn.app.service.developer;

import java.util.List;

import com.bdqn.app.pojo.AppCategory;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.DataDictionary;

/**
 * AppService��ӿ�
 * 
 * @author ʩ����
 *
 */
public interface IAppInfoService {

	/**
	 * APP״̬
	 * 
	 * @return List<DataDictionary>
	 */
	List<DataDictionary> getAppType();

	/**
	 * ����ƽ̨
	 * 
	 * @return List<DataDictionary>
	 */
	List<DataDictionary> getAppPlatform();

	/**
	 * һ������
	 * 
	 * @return List<AppCategory>
	 */
	List<AppCategory> getCategoryLevel1();

	/**
	 * ��,��������
	 * 
	 * @param parentId
	 * @return List<AppCategory>
	 */
	List<AppCategory> getCategoryLevel(Integer parentId);

	/**
	 * ģ����ѯapp��Ϣ(��ҳ)
	 * 
	 * @param appInfo
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<AppInfo>
	 */
	List<AppInfo> getAppInfos(AppInfo appInfo, Integer currentPageNo, Integer pageSize);

	/**
	 * ģ����ѯapp��Ϣ������(��ҳ)
	 * 
	 * @param appInfo
	 * @return Integer
	 */
	Integer getAppInfosCount(AppInfo appInfo);
	
	/**
	 * ����App��Ϣ
	 * @param appInfo
	 * @return boolean
	 * @throws Exception
	 */
	boolean addAppInfo(AppInfo appInfo);
	
	/**
	 * ��ѯApp��Ϣ
	 * @param appInfoId
	 * @return AppInfo
	 */
	AppInfo getAppInfo(Integer appInfoId);
	
	/**
	 * �ж�APKName�Ƿ����
	 * @param APKName
	 * @return boolean
	 */
	boolean getApkexist(String APKName);
	
	/**
	 * ɾ��AppLogo
	 * @param appInfoId
	 * @return boolean
	 */
	boolean deleteAppLogo(Integer appInfoId);
	
	/**
	 * �޸�App��Ϣ
	 * @param appInfo
	 * @return boolean
	 */
	boolean modifyAppInfo(AppInfo appInfo);
	
	/**
	 * ����appIdɾ��app��Ϣ���汾��Ϣ
	 * @param appId
	 * @return boolean
	 */
	boolean deleteAppByAppId(Integer appId);
	
	/**
	 * �޸�App״̬
	 * @param appId
	 * @param devId
	 * @return boolean
	 */
	boolean modifyAppStatusByAppId(Integer appId,Integer devId);
	
	/**
	 * �ϼ�
	 * @param appInfo
	 * @return boolean
	 */
	boolean onSale(AppInfo appInfo);
	
	/**
	 *  �¼�
	 * @param appInfo
	 * @return boolean
	 */
	boolean offSale(AppInfo appInfo);
	
	/**
	 * �޸�app��Ϣ
	 * @param appInfo
	 * @return boolean
	 */
	boolean App(AppInfo appInfo);
	
	/**
	 * �޸�app�汾��Ϣ
	 * @param appInfo
	 * @return boolean
	 */
	boolean Version(AppInfo appInfo);
}
