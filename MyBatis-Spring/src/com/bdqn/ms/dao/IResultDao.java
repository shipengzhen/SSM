package com.bdqn.ms.dao;


import com.bdqn.ms.entity.Result;

/**
 * Dao��ɼ��ӿ�
 * @author ʩ����
 *
 */
public interface IResultDao {

	/**
	 * ͨ��ѧ�Ų�ѯѧ���ɼ�
	 * @param studentNo
	 * @return List<Result>
	 */
	public Result getResults(int studentNo);
}
