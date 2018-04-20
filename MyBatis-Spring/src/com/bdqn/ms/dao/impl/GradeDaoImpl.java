package com.bdqn.ms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import com.bdqn.ms.dao.IGradeDao;
import com.bdqn.ms.entity.Grade;

/**
 * Dao层年纪实现类
 * @author 施鹏振
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
	 * 查询全部年纪
	 * @return List<Grade>
	 */
	@Override
	public List<Grade> getAllGrades() {
		return sqlSessionTemplate.getMapper(IGradeDao.class).getAllGrades();
	}

}
