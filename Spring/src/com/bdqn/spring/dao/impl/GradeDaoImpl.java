package com.bdqn.spring.dao.impl;

import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.entity.Grade;
import com.bdqn.spring.uitl.SpringUtil;

/**
 * ���ʵ����
 * @author ʩ����
 *
 */
public class GradeDaoImpl implements IGradeDao {

	/**
	 * ��������Ϣ
	 * @param gradeId
	 * @param gradeName
	 */
	@Override
	public void addGrade(int gradeId,String gradeName) {
		Grade grade=(Grade)SpringUtil.getObject("Grade");
		grade.setGradeId(gradeId);
		grade.setGradeName(gradeName);
		System.out.println("���ID:"+grade.getGradeId()+"\t�������:"+grade.getGradeName());
	}

	/**
	 * ��ӡ�����Ϣ
	 */
	@Override
	public void printGrade() {
		Grade grade=(Grade)SpringUtil.getObject("Grade");
		System.out.println("���ID:"+grade.getGradeId()+"\t�������:"+grade.getGradeName());
	}

}
