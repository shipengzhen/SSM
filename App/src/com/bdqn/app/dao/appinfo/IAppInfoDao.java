package com.bdqn.app.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.app.pojo.AppCategory;
import com.bdqn.app.pojo.AppInfo;
import com.bdqn.app.pojo.DataDictionary;

/**
 * AppDao��ӿ�
 * 
 * @author ʩ����
 *
 */
public interface IAppInfoDao {

	/**
	 * APP״̬������ƽ̨
	 * 
	 * @param typeName
	 * @return List<DataDictionary>
	 * @throws Exception
	 */
	List<DataDictionary> findValueName(String typeName) throws Exception;

	/**
	 * һ����,��������
	 * 
	 * @param parentId
	 * @return List<AppCategory>
	 * @throws Exception
	 */
	List<AppCategory> findCategoryLevel(Integer parentId) throws Exception;

	/**
	 * ��ѯapp��Ϣ(��ҳ)
	 * 
	 * @param appInfo
	 * @param currentPageNo
	 * @param pageSize
	 * @return List<AppInfo>
	 * @throws Exception
	 */
	List<AppInfo> findAppInfos(@Param("appInfo") AppInfo appInfo, @Param("currentPageNo") Integer currentPageNo,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * ��ѯapp��Ϣ������(��ҳ)
	 * 
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer findAppInfosCount(@Param("appInfo")AppInfo appInfo) throws Exception;
	
	/**
	 * ����App��Ϣ
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertAppInfo(@Param("appInfo")AppInfo appInfo)throws Exception;
	
	/**
	 * ��ѯApp��Ϣ
	 * @param appInfoId
	 * @return AppInfo
	 * @throws Exception
	 */
	AppInfo findAppInfo(Integer appInfoId)throws Exception;
	
	/**
	 * �ж�APKName�Ƿ����
	 * @param APKName
	 * @return Integer
	 */
	Integer findAppInfoCount(String APKName)throws Exception;
	
	/**
	 * ɾ��AppLogo
	 * @param appInfoId
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppLogo(Integer appInfoId)throws Exception;
	
	/**
	 * �޸�App��Ϣ
	 * @param appInfo
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateAppInfo(@Param("appInfo")AppInfo appInfo)throws Exception;
	
	/**
	 * �޸�App���°汾
	 * @param appId
	 * @return Integer
	 */
	Integer updateVersionId(Integer appId);
	
	/**
	 * ����appIdɾ��App��Ϣ
	 * @param appId
	 * @return Integer
	 */
	Integer deleteAppInfoByAppId(Integer appId)throws Exception;
}
