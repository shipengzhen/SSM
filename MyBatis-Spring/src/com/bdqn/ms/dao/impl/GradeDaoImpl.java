package com.bdqn.ms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import com.bdqn.ms.dao.IGradeDao;
import com.bdqn.ms.entity.Grade;

/**
 * Dao�����ʵ����
 * @author ʩ����
 *
 */
public class GradeDaoImpl implements IGradeDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	/**
	 * ��ѯȫ�����
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getAllGrades() {
		return sqlSessionTemplate.getMapper(IGradeDao.class).getAllGrades();
	}

}
