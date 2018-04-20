package com.bdqn.spz.jboa.service.impl;

import java.util.Date;
import java.util.List;

import com.bdqn.spz.jboa.dao.employee.IEmployeeDao;
import com.bdqn.spz.jboa.dao.leave.ILeaveDao;
import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.service.ILeaveService;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service层请假实现类
 * 
 * @author 施鹏振
 *
 */
public class LeaveServiceImpl implements ILeaveService {

	// 请假
	private ILeaveDao leaveDao;

	public ILeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(ILeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	// 职员
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// 查询请假列表(分页)
	@Override
	public Paging<Leave> findLeaves(Paging<Leave> paging) {
		try {
			paging.setTotalCount(leaveDao.selectLeaveCount(paging.getT()));// 记录总数
			paging.setList(leaveDao.selectLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return paging;
	}

	// 查询休假类型
	@Override
	public List<String> findLeaveTypes() {
		List<String> leaveTypes = null;
		try {
			leaveTypes = leaveDao.selectLeaveType();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return leaveTypes;
	}

	// 添加请假
	@Override
	public boolean addLeave(Leave leave) {
		boolean b = false;
		try {
			leave.setStatus("待审批");
			leave.setCreateTime(new Date());
			leave.setNextCheckSn(employeeDao.selectSn(leave.getEmployeeSn(),"部门经理"));
			if (leaveDao.insertLeave(leave) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	//查询请假详情
	@Override
	public Leave findLeave(Integer leaveId) {
		Leave leave=null;
		try {
			leave=leaveDao.selectLeave(leaveId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return leave;
	}

	//审核请假
	@Override
	public boolean checkLeave(Leave leave) {
		boolean b=false;
		try {
			leave.setModifyTime(new Date());
			if (leaveDao.updateLeave(leave)>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

}
