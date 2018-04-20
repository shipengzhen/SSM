package com.bdqn.spring.service.impl;

import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.service.IGradeService;
import com.bdqn.spring.uitl.SpringUtil;


/**
 * ���ҵ���߼�ʵ����
 * @author ʩ����
 *
 */
public class GradeServiceImpl implements IGradeService {

	
	
	/**
	 * ��������Ϣ
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId, String gradeName) {
		IGradeDao gradeDao=(IGradeDao)SpringUtil.getObject("GradeDaoImpl");
		gradeDao.addGrade(gradeId, gradeName);
	}

	/**
	 * ��ӡ�����Ϣ
	 */
	@Override
	public void printGrade() {
		IGradeDao gradeDao=(IGradeDao)SpringUtil.getObject("GradeDaoImpl");
		gradeDao.printGrade();
	}

}
