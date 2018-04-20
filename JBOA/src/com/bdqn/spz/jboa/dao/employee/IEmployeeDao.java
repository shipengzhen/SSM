package com.bdqn.spz.jboa.dao.employee;

import org.apache.ibatis.annotations.Param;

import com.bdqn.spz.jboa.pojo.Employee;

/**
 * Dao层职工接口
 * @author 施鹏振
 *
 */
public interface IEmployeeDao {

	/**
	 * 查询职工
	 * @param employee
	 * @return Employee
	 * @throws Exception
	 */
	Employee selectEmployee(Employee employee)throws Exception;
	
	/**
	 * 查询员工上级
	 * @param sn
	 * @param nameCn
	 * @return String
	 */
	String selectSn(@Param("sn")String sn,@Param("nameCn")String nameCn)throws Exception;
	
	/**
	 * 查询员工的职位
	 * @param sn
	 * @return String
	 * @throws Exception
	 */
	String selectPositionNameCnBySn(String sn)throws Exception;
}
