package com.bdqn.ms.dao;

import java.util.List;

import com.bdqn.ms.entity.Grade;

/**
 * Dao层年纪接口
 * @author 施鹏振
 *
 */
public interface IGradeDao {

	/**
	 * 查询全部年纪
	 * @return List<Grade>
	 */
	public List<Grade> getAllGrades();
}
