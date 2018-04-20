package com.bdqn.spring.service;

/**
 * 年纪业务逻辑接口
 * @author 施鹏振
 *
 */
public interface IGradeService {


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
