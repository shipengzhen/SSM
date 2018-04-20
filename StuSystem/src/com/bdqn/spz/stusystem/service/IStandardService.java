package com.bdqn.spz.stusystem.service;


import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Service���׼��Ϣ�ӿ�
 * @author ʩ����
 *
 */
public interface IStandardService {

	/**
	 * ��ѯ��׼��Ϣ(��ҳ)
	 * @param paging
	 * @return Paging<Standard>
	 */
	Paging<Standard> findStandards(Paging<Standard> paging);
	
	/**
	 * ɾ��һ���������׼��Ϣ
	 * @param standardIds
	 * @return boolean
	 */
	boolean amputateStandards(Integer[] standardIds);
	
	/**
	 * ������׼��Ϣ
	 * @param standard
	 * @return boolean
	 */
	boolean addStandard(Standard standard);
	
	/**
	 * �жϱ�׼��Ϣ�Ƿ����
	 * @param stdNum
	 * @return boolean
	 */
	boolean findStandard(String stdNum);
	
	/**
	 * ��ѯ��׼��Ϣ
	 * @param standardId
	 * @return Standard
	 */
	Standard findStandard(Integer standardId);
	
	/**
	 * �޸ı�׼��Ϣ
	 * @param standard
	 * @return boolean
	 */
	boolean modifyStandard(Standard standard);
}
