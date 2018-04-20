package com.bdqn.ms.service.impl;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bdqn.ms.dao.IResultDao;
import com.bdqn.ms.entity.Result;
import com.bdqn.ms.service.IResultService;

/**
 * Service��ɼ�ʵ����
 * @author ʩ����
 *
 */
//ע������bean��������
@Scope("singleton")
//ע������Service
@Service("ResultServiceImpl")
public class ResultServiceImpl implements IResultService {

	//ע������Ը�ֵ
	@Resource
	private IResultDao resultDao;
	
	
	/*public IResultDao getResultDao() {
		return resultDao;
	}


	public void setResultDao(IResultDao resultDao) {
		this.resultDao = resultDao;
	}*/


	/**
	 * ͨ��ѧ�Ų�ѯѧ���ɼ�
	 * @param studentNo
	 * @return List<Result>
	 */
	@Override
	public Result getResults(int studentNo) {
		
		return resultDao.getResults(studentNo);
	}

}
