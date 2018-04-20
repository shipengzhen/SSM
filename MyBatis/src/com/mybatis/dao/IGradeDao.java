package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.entity.Grade;

/**
 * ��ͽӿ�
 * @author ʩ����
 *
 */
public interface IGradeDao {
	/**
	 * �������
	 * @param grade
	 * @return
	 */
	public int insertGrade(Grade grade);
	/**
	 * ͨ�����Id�޸��������(ʹ��@paramע��ʵ�ֶ�������)
	 * @param gradeId
	 * @return
	 */
	public int updateGradeName(@Param("gradeId")int gradeId,@Param("gradeName")String gradeName);
	/**
	 * ͨ�����Idɾ�����
	 * @param gradeId
	 * @return
	 */
	public int deleteGrade(int gradeId);
	
	/**
	 * ��ѯ���꼶ѧ����Ϣ
	 * @return List<Grade>
	 */
	public List<Grade> getStudent();
	
}
