package com.bdqn.spz.jboa.dao.expenseaccountdetail;

import java.util.List;

import com.bdqn.spz.jboa.pojo.ExpenseAccountDetail;

/**
 * Dao层报销单详情接口
 * @author 施鹏振
 *
 */
public interface IExpenseAccountDetailDao {

	/**
	 * 新增一条或多条报销单详情
	 * @param expenseAccountDetails
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertExpenseAccountDetailDaos(List<ExpenseAccountDetail> expenseAccountDetails)throws Exception;
	
	/**
	 * 删除一条或多条报销单详情
	 * @param expenseAccountId
	 * @return Integer
	 */
	Integer deleteExpenseAccountDetailDaos(Integer expenseAccountId);
	
	/**
	 * 查询一条或多条报销单详情
	 * @param expenseAccountId
	 * @return List<ExpenseAccountDetail>
	 */
	List<ExpenseAccountDetail> selectExpenseAccountDetailDaos(Integer expenseAccountId);
}
