package com.bdqn.spz.jboa.dao.position;

import com.bdqn.spz.jboa.pojo.Position;

/**
 * Dao层职位接口
 * @author 施鹏振
 */
public interface IPositionDao {

	/**
	 * 查询职位
	 * @param position
	 * @return
	 */
	Position selectPosition(String nameCn); 
}
