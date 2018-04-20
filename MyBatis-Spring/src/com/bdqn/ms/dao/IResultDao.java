package com.bdqn.ms.dao;


import com.bdqn.ms.entity.Result;

/**
 * Dao层成绩接口
 * @author 施鹏振
 *
 */
public interface IResultDao {

	/**
	 * 通过学号查询学生成绩
	 * @param studentNo
	 * @return List<Result>
	 */
	public Result getResults(int studentNo);
}
