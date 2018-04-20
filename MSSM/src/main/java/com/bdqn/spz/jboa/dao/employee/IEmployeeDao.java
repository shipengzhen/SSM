package com.bdqn.spz.jboa.dao.employee;

import org.apache.ibatis.annotations.Param;

import com.bdqn.spz.jboa.pojo.Employee;

/**
 * Dao��ְ���ӿ�
 * @author ʩ����
 *
 */
public interface IEmployeeDao {

	/**
	 * ��ѯְ��
	 * @param employee
	 * @return Employee
	 * @throws Exception
	 */
	Employee selectEmployee(Employee employee)throws Exception;
	
	/**
	 * ��ѯԱ���ϼ�
	 * @param sn
	 * @param nameCn
	 * @return String
	 */
	String selectSn(@Param("sn")String sn,@Param("nameCn")String nameCn)throws Exception;
	
	/**
	 * ��ѯԱ����ְλ
	 * @param sn
	 * @return String
	 * @throws Exception
	 */
	String selectPositionNameCnBySn(String sn)throws Exception;
}
