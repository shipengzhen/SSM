package com.bdqn.spz.jboa.service;

import com.bdqn.spz.jboa.pojo.Employee;

/**
 * Service层职工接口
 * @author 施鹏振
 *
 */
public interface IEmployeeService {

	/**
	 * 根据工号和密码查询职工
	 * @param sn
	 * @param passWord
	 * @return Employee
	 */
	Employee findEmployee(String sn,String passWord);
	
	/**
	 * 查询员工的职位
	 * @param sn
	 * @return String
	 */
	String findPositionNameCnBySn(String sn);
}
