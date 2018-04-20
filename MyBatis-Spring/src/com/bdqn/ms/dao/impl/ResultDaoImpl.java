package com.bdqn.ms.dao.impl;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bdqn.ms.dao.IResultDao;
import com.bdqn.ms.entity.Result;

/**
 * Dao层成绩实现类
 * @author 施鹏振
 *
 */
public class ResultDaoImpl extends SqlSessionDaoSupport implements IResultDao {

	/**
	 * 通过学号查询学生成绩
	 * @param studentNo
	 * @return List<Result>
	 */
	@Override
	public Result getResults(int studentNo) {
		return getSqlSession().getMapper(IResultDao.class).getResults(studentNo);
	}
}
