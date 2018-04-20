package com.mybatis.dao.impl;

import java.util.List;

import com.mybatis.dao.IGradeDao;
import com.mybatis.entity.Grade;
import com.mybatis.util.MyBatisUtil;

/**
 * 年纪实现类
 * @author 施鹏振
 *
 */
public class GradeDaoImpl extends MyBatisUtil implements IGradeDao {

	/**
	 * 新增年纪
	 * @param grade
	 * @return
	 */
	@Override
	public int insertGrade(Grade grade) {
		return getSqlSession().getMapper(IGradeDao.class).insertGrade(grade);
	}

	/**
	 * 通过年纪Id修改年纪名称(使用@param注解实现多参数入参)
	 * @param gradeId
	 * @return
	 */
	@Override
	public int updateGradeName(int gradeId, String gradeName) {
		return getSqlSession().getMapper(IGradeDao.class).updateGradeName(gradeId, gradeName);
	}

	/**
	 * 通过年纪Id删除年纪
	 * @param gradeId
	 * @return
	 */
	@Override
	public int deleteGrade(int gradeId) {
		return getSqlSession().getMapper(IGradeDao.class).deleteGrade(gradeId);
	}

	/**
	 * 查询各年级学生信息
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getStudent() {
		return getSqlSession().getMapper(IGradeDao.class).getStudent();
	}

}
