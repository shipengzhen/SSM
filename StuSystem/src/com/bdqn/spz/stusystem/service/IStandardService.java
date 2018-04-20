package com.bdqn.spz.stusystem.service;


import com.bdqn.spz.stusystem.pojo.Standard;
import com.bdqn.spz.stusystem.tools.Paging;

/**
 * Service层标准信息接口
 * @author 施鹏振
 *
 */
public interface IStandardService {

	/**
	 * 查询标准信息(分页)
	 * @param paging
	 * @return Paging<Standard>
	 */
	Paging<Standard> findStandards(Paging<Standard> paging);
	
	/**
	 * 删除一条或多条标准信息
	 * @param standardIds
	 * @return boolean
	 */
	boolean amputateStandards(Integer[] standardIds);
	
	/**
	 * 新增标准信息
	 * @param standard
	 * @return boolean
	 */
	boolean addStandard(Standard standard);
	
	/**
	 * 判断标准信息是否存在
	 * @param stdNum
	 * @return boolean
	 */
	boolean findStandard(String stdNum);
	
	/**
	 * 查询标准信息
	 * @param standardId
	 * @return Standard
	 */
	Standard findStandard(Integer standardId);
	
	/**
	 * 修改标准信息
	 * @param standard
	 * @return boolean
	 */
	boolean modifyStandard(Standard standard);
}
