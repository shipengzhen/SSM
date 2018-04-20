package com.bdqn.ms.service;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.ms.entity.Result;

/**
 * Service��ɼ��ӿ�
 * @author ʩ����
 *
 */
@Transactional()
public interface IResultService {

	/**
	 * ͨ��ѧ�Ų�ѯѧ���ɼ�
	 * @param studentNo
	 * @return List<Result>
	 */
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED)
	public Result getResults(int studentNo);
}
