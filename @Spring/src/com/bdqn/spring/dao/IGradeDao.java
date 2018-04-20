package com.bdqn.spring.dao;

/**
 * 年纪dao层接口
 * @author 施鹏振
 *
 */
public interface IGradeDao {

	/**
	 * 添加年纪信息
	 * @param gradeId
	 * @param gradeName
	 */
	public void addGrade(int gradeId,String gradeName);
	
	/**
	 * 打印年纪信息
	 */
	public void printGrade();
}
