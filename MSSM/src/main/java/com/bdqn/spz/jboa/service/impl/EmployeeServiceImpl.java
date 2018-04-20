package com.bdqn.spz.jboa.service.impl;

import com.bdqn.spz.jboa.dao.employee.IEmployeeDao;
import com.bdqn.spz.jboa.pojo.Employee;
import com.bdqn.spz.jboa.service.IEmployeeService;

/**
 * Service层职工实现类
 * @author 施鹏振
 *
 */
public class EmployeeServiceImpl implements IEmployeeService {

	//职工
	private IEmployeeDao employeeDao;
	
	
	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}


	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	//根据工号和密码查询职工
	@Override
	public Employee findEmployee(String sn, String passWord) {
		Employee employee1=null;
		try {
			Employee employee=new Employee();
			employee.setSn(sn);
			employee.setPassWord(passWord);
			employee1=employeeDao.selectEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return employee1;
	}

	//查询员工的职位
	@Override
	public String findPositionNameCnBySn(String sn) {
		String string=null;
		try {
			string=employeeDao.selectPositionNameCnBySn(sn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return string;
	}

}
