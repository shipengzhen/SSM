package com.bdqn.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.bdqn.spring.dao.IGradeDao;
import com.bdqn.spring.entity.Grade;
import com.bdqn.spring.uitl.SpringUtil;


/**
 * ���ʵ����
 * @author ʩ����
 *
 */
/*@Component("IGradeDao")��<bean id="IGradeDao" class="com.bdqn.spring.dao.IGradeDao">����һ��
 * @Repositoy:���ڱ�עDao��
 * @Service:���ڱ�עҵ����
 * @Controller:���ڱ�ע��������
 */
@Repository("GradeDaoImpl")
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
