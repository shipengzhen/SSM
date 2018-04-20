package com.bdqn.spz.jboa.dao.leave;

import java.util.List;

import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Dao����ٽӿ�
 * @author ʩ����
 */
public interface ILeaveDao {

	/**
	 * ��ѯ����б������
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectLeaveCount(Leave leave)throws Exception;
	
	/**
	 * ��ѯ����б�(��ҳ)
	 * @param paging
	 * @return List<Leave>
	 * @throws Exception
	 */
	List<Leave> selectLeaves(Paging<Leave> paging)throws Exception;
	
	/**
	 * ��ѯ�ݼ�����
	 * @return List<String>
	 * @throws Exception
	 */
	List<String> selectLeaveType()throws Exception;
	
	/**
	 * �������
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertLeave(Leave leave)throws Exception;
	
	/**
	 * ��ѯ�������
	 * @param leaveId
	 * @return Leave
	 * @throws Exception
	 */
	Leave selectLeave(Integer leaveId)throws Exception;
	
	/**
	 * �޸����
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateLeave(Leave leave)throws Exception;
}
