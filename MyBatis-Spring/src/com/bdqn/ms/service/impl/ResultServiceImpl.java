package com.bdqn.ms.service.impl;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bdqn.ms.dao.IResultDao;
import com.bdqn.ms.entity.Result;
import com.bdqn.ms.service.IResultService;

/**
 * Service层成绩实现类
 * @author 施鹏振
 *
 */
//注解配置bean的作用域
@Scope("singleton")
//注解配置Service
@Service("ResultServiceImpl")
public class ResultServiceImpl implements IResultService {

	//注解给属性赋值
	@Resource
	private IResultDao resultDao;
	
	
	/*public IResultDao getResultDao() {
		return resultDao;
	}


	public void setResultDao(IResultDao resultDao) {
		this.resultDao = resultDao;
	}*/


	/**
	 * 通过学号查询学生成绩
	 * @param studentNo
	 * @return List<Result>
	 */
	@Override
	public Result getResults(int studentNo) {
		
		return resultDao.getResults(studentNo);
	}

}
