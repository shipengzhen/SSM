package com.bdqn.spz.jboa.dao.position;

import com.bdqn.spz.jboa.pojo.Position;

/**
 * Dao��ְλ�ӿ�
 * @author ʩ����
 */
public interface IPositionDao {

	/**
	 * ��ѯְλ
	 * @param position
	 * @return
	 */
	Position selectPosition(String nameCn); 
}
