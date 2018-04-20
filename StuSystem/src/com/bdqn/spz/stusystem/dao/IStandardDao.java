package com.bdqn.spz.stusystem.dao;

import java.util.List;

import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Dao层标准信息接口
 * @author 施鹏振
 *
 */
public interface IStandardDao {

	/**
	 * 查询标准信息数量
	 * @param stdNum
	 * @return Integer
	 */
	Integer selectStandardCount(String stdNum) throws Exception;
	
	/**
	 * 查询标准信息(分页)
	 * @param paging
	 * @return List<Standard>
	 */
	List<Standard> selectStandards(Paging<Standard> paging)throws Exception;
	
	/**
	 * 删除一条或多条标准信息
	 * @param standardIds
	 * @return Integer
	 */
	Integer deleteStandards(Integer[] standardIds)throws Exception;
	
	/**
	 * 新增标准信息
	 * @param standard
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertStandard(Standard standard) throws Exception;
	
	/**
	 * 查询标准信息通过stdNum
	 * @param stdNum
	 * @return Standard
	 * @throws Exception
	 */
	Standard selectStandardByStdNum(String stdNum)throws Exception;
	
	/**
	 * 查询标准信息通过ID
	 * @param standardId
	 * @return Standard
	 * @throws Exception
	 */
	Standard selectStandardById(Integer standardId)throws Exception;
	
	/**
	 * 修改标准信息
	 * @param standard
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateStandard(Standard standard) throws Exception;
	
	
}
