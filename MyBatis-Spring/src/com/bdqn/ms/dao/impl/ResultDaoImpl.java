package com.bdqn.ms.dao.impl;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bdqn.ms.dao.IResultDao;
import com.bdqn.ms.entity.Result;

/**
 * Dao��ɼ�ʵ����
 * @author ʩ����
 *
 */
public class ResultDaoImpl extends SqlSessionDaoSupport implements IResultDao {

	/**
	 * ͨ��ѧ�Ų�ѯѧ���ɼ�
	 * @param studentNo
	 * @return List<Result>
	 */
	@Override
	public Result getResults(int studentNo) {
		return getSqlSession().getMapper(IResultDao.class).getResults(studentNo);
	}
}
