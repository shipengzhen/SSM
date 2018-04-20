package com.bdqn.ms.service;

import java.util.List;

import com.bdqn.ms.entity.Grade;

/**
 * Service层年纪接口
 * @author 施鹏振
 *
 */
public interface IGradeService {

	/**
	 * 查询全部年纪
	 * @return List<Grade>
	 */
	public List<Grade> getAllGrades();
}
