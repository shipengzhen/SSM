package com.bdqn.spz.jboa.service;

import com.bdqn.spz.jboa.pojo.Employee;

/**
 * Service��ְ���ӿ�
 * @author ʩ����
 *
 */
public interface IEmployeeService {

	/**
	 * ���ݹ��ź������ѯְ��
	 * @param sn
	 * @param passWord
	 * @return Employee
	 */
	Employee findEmployee(String sn,String passWord);
	
	/**
	 * ��ѯԱ����ְλ
	 * @param sn
	 * @return String
	 */
	String findPositionNameCnBySn(String sn);
}
