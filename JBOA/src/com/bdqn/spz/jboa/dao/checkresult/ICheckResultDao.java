package com.bdqn.spz.jboa.dao.checkresult;

import java.util.List;

import com.bdqn.spz.jboa.pojo.CheckResult;

/**
 * Dao层报销单审核接口
 * @author 施鹏振
 *
 */
public interface ICheckResultDao {

	/**
	 * 查询一条或多条报销单审核结果
	 * @param expenseAccountId
	 * @return List<CheckResult>
	 * @throws Exception
	 */
	List<CheckResult> selectCheckResults(Integer expenseAccountId)throws Exception;
	
	/**
	 * 新增报销单审核结果
	 * @param checkResult
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertCheckResult(CheckResult checkResult)throws Exception;
}
