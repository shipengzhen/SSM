package com.bdqn.spring.service;

/**
 * ���ҵ���߼��ӿ�
 * @author ʩ����
 *
 */
public interface IGradeService {


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
