package com.bdqn.spz.jboa.dao.expenseaccount;

import java.util.List;


import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Dao层报销单接口
 * 
 * @author 施鹏振
 *
 */
public interface IExpenseAccountDao {

	/**
	 * 查询报销单数量
	 * 
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectExpenseAccountCount(ExpenseAccount expenseAccount) throws Exception;

	/**
	 * 查询报销单
	 * @param paging
	 * @return List<ExpenseAccount>
	 * @throws Exception
	 */
	List<ExpenseAccount> selectExpenseAccounts(Paging<ExpenseAccount> paging) throws Exception;
	
	/**
	 * 新增报销单
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertExpenseAccount(ExpenseAccount expenseAccount) throws Exception;
	
	/**
	 * 查询某用户最新的报销单
	 * @return ExpenseAccount
	 */
	ExpenseAccount selectNewExpenseAccount(String createSn) throws Exception;
	
	/**
	 * 删除报销单
	 * @param expenseAccountId
	 * @return Integer
	 */
	Integer deleteExpenseAccount(Integer expenseAccountId)throws Exception;
	
	/**
	 * 查询报销单
	 * @param expenseAccountId
	 * @return ExpenseAccount
	 * @throws Exception
	 */
	ExpenseAccount selectExpenseAccount(Integer expenseAccountId)throws Exception;
	
	/**
	 * 修改报销单
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateExpenseAccount(ExpenseAccount expenseAccount)throws Exception;
}
