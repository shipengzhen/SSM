package com.bdqn.spring.dao;

/**
 * ���dao��ӿ�
 * @author ʩ����
 *
 */
public interface IGradeDao {

	/**
	 * ��������Ϣ
	 * @param gradeId
	 * @param gradeName
	 */
	public void addGrade(int gradeId,String gradeName);
	
	/**
	 * ��ӡ�����Ϣ
	 */
	public void printGrade();
}
