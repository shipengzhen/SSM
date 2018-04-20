package com.bdqn.spz.jboa.service.impl;

import java.util.Date;
import java.util.List;

import com.bdqn.spz.jboa.dao.employee.IEmployeeDao;
import com.bdqn.spz.jboa.dao.leave.ILeaveDao;
import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.service.ILeaveService;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service�����ʵ����
 * 
 * @author ʩ����
 *
 */
public class LeaveServiceImpl implements ILeaveService {

	// ���
	private ILeaveDao leaveDao;

	public ILeaveDao getLeaveDao() {
		return leaveDao;
	}

	public void setLeaveDao(ILeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	// ְԱ
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// ��ѯ����б�(��ҳ)
	@Override
	public Paging<Leave> findLeaves(Paging<Leave> paging) {
		try {
			paging.setTotalCount(leaveDao.selectLeaveCount(paging.getT()));// ��¼����
			paging.setList(leaveDao.selectLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return paging;
	}

	// ��ѯ�ݼ�����
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

	// ������
	@Override
	public boolean addLeave(Leave leave) {
		boolean b = false;
		try {
			leave.setStatus("������");
			leave.setCreateTime(new Date());
			leave.setNextCheckSn(employeeDao.selectSn(leave.getEmployeeSn(),"���ž���"));
			if (leaveDao.insertLeave(leave) > 0) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	//��ѯ�������
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

	//������
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
