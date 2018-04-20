package com.bdqn.spz.stusystem.dao;

import java.util.List;

import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Dao���׼��Ϣ�ӿ�
 * @author ʩ����
 *
 */
public interface IStandardDao {

	/**
	 * ��ѯ��׼��Ϣ����
	 * @param stdNum
	 * @return Integer
	 */
	Integer selectStandardCount(String stdNum) throws Exception;
	
	/**
	 * ��ѯ��׼��Ϣ(��ҳ)
	 * @param paging
	 * @return List<Standard>
	 */
	List<Standard> selectStandards(Paging<Standard> paging)throws Exception;
	
	/**
	 * ɾ��һ���������׼��Ϣ
	 * @param standardIds
	 * @return Integer
	 */
	Integer deleteStandards(Integer[] standardIds)throws Exception;
	
	/**
	 * ������׼��Ϣ
	 * @param standard
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertStandard(Standard standard) throws Exception;
	
	/**
	 * ��ѯ��׼��Ϣͨ��stdNum
	 * @param stdNum
	 * @return Standard
	 * @throws Exception
	 */
	Standard selectStandardByStdNum(String stdNum)throws Exception;
	
	/**
	 * ��ѯ��׼��Ϣͨ��ID
	 * @param standardId
	 * @return Standard
	 * @throws Exception
	 */
	Standard selectStandardById(Integer standardId)throws Exception;
	
	/**
	 * �޸ı�׼��Ϣ
	 * @param standard
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateStandard(Standard standard) throws Exception;
	
	
}
