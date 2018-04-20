package com.bdqn.spz.jboa.service;



import java.util.List;

import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service����ٽӿ�
 * @author ʩ����
 *
 */
public interface ILeaveService {

	/**
	 * ��ѯ����б�(��ҳ)
	 * @param paging
	 * @return Paging<Leave>
	 */
	Paging<Leave> findLeaves(Paging<Leave> paging);
	
	/**
	 * ��ѯ�ݼ�����
	 * @return List<String>
	 */
	List<String> findLeaveTypes();
	
	/**
	 * ������
	 * @param leave
	 * @return boolean
	 */
	boolean addLeave(Leave leave);
	
	/**
	 * ��ѯ�������
	 * @param leaveId
	 * @return Leave
	 */
	Leave findLeave(Integer leaveId);
	
	/**
	 * ������
	 * @param leave
	 * @return boolean
	 */
	boolean checkLeave(Leave leave);
}
