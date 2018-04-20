package com.bdqn.spring.service.impl;

import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.service.IGradeService;
import com.bdqn.spring.uitl.SpringUtil;


/**
 * 年纪业务逻辑实现类
 * @author 施鹏振
 *
 */
public class GradeServiceImpl implements IGradeService {

	
	
	/**
	 * 添加年纪信息
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId, String gradeName) {
		IGradeDao gradeDao=(IGradeDao)SpringUtil.getObject("GradeDaoImpl");
		gradeDao.addGrade(gradeId, gradeName);
	}

	/**
	 * 打印年纪信息
	 */
	@Override
	public void printGrade() {
		IGradeDao gradeDao=(IGradeDao)SpringUtil.getObject("GradeDaoImpl");
		gradeDao.printGrade();
	}

}
