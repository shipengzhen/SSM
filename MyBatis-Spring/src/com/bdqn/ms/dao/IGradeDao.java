package com.bdqn.ms.dao;

import java.util.List;

import com.bdqn.ms.entity.Grade;

/**
 * Dao����ͽӿ�
 * @author ʩ����
 *
 */
public interface IGradeDao {

	/**
	 * ��ѯȫ�����
	 * @return List<Grade>
	 */
	public List<Grade> getAllGrades();
}
