package com.bdqn.spz.jboa.service;



import java.util.List;

import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service层请假接口
 * @author 施鹏振
 *
 */
public interface ILeaveService {

	/**
	 * 查询请假列表(分页)
	 * @param paging
	 * @return Paging<Leave>
	 */
	Paging<Leave> findLeaves(Paging<Leave> paging);
	
	/**
	 * 查询休假类型
	 * @return List<String>
	 */
	List<String> findLeaveTypes();
	
	/**
	 * 添加请假
	 * @param leave
	 * @return boolean
	 */
	boolean addLeave(Leave leave);
	
	/**
	 * 查询请假详情
	 * @param leaveId
	 * @return Leave
	 */
	Leave findLeave(Integer leaveId);
	
	/**
	 * 审核请假
	 * @param leave
	 * @return boolean
	 */
	boolean checkLeave(Leave leave);
}
