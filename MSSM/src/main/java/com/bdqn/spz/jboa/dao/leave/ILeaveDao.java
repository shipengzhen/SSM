package com.bdqn.spz.jboa.dao.leave;

import java.util.List;

import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Dao层请假接口
 * @author 施鹏振
 */
public interface ILeaveDao {

	/**
	 * 查询请假列表的数量
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectLeaveCount(Leave leave)throws Exception;
	
	/**
	 * 查询请假列表(分页)
	 * @param paging
	 * @return List<Leave>
	 * @throws Exception
	 */
	List<Leave> selectLeaves(Paging<Leave> paging)throws Exception;
	
	/**
	 * 查询休假类型
	 * @return List<String>
	 * @throws Exception
	 */
	List<String> selectLeaveType()throws Exception;
	
	/**
	 * 新增请假
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertLeave(Leave leave)throws Exception;
	
	/**
	 * 查询请假详情
	 * @param leaveId
	 * @return Leave
	 * @throws Exception
	 */
	Leave selectLeave(Integer leaveId)throws Exception;
	
	/**
	 * 修改请假
	 * @param leave
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateLeave(Leave leave)throws Exception;
}
