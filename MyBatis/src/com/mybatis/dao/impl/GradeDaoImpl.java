package com.mybatis.dao.impl;

import java.util.List;

import com.mybatis.dao.IGradeDao;
import com.mybatis.entity.Grade;
import com.mybatis.util.MyBatisUtil;

/**
 * ���ʵ����
 * @author ʩ����
 *
 */
public class GradeDaoImpl extends MyBatisUtil implements IGradeDao {

	/**
	 * �������
	 * @param grade
	 * @return
	 */
	@Override
	public int insertGrade(Grade grade) {
		return getSqlSession().getMapper(IGradeDao.class).insertGrade(grade);
	}

	/**
	 * ͨ�����Id�޸��������(ʹ��@paramע��ʵ�ֶ�������)
	 * @param gradeId
	 * @return
	 */
	@Override
	public int updateGradeName(int gradeId, String gradeName) {
		return getSqlSession().getMapper(IGradeDao.class).updateGradeName(gradeId, gradeName);
	}

	/**
	 * ͨ�����Idɾ�����
	 * @param gradeId
	 * @return
	 */
	@Override
	public int deleteGrade(int gradeId) {
		return getSqlSession().getMapper(IGradeDao.class).deleteGrade(gradeId);
	}

	/**
	 * ��ѯ���꼶ѧ����Ϣ
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getStudent() {
		return getSqlSession().getMapper(IGradeDao.class).getStudent();
	}

}
