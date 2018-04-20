package com.bdqn.ms.service;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.ms.entity.Result;

/**
 * Service层成绩接口
 * @author 施鹏振
 *
 */
@Transactional()
public interface IResultService {

	/**
	 * 通过学号查询学生成绩
	 * @param studentNo
	 * @return List<Result>
	 */
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED)
	public Result getResults(int studentNo);
}
