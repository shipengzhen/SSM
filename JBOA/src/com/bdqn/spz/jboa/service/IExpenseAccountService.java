package com.bdqn.spz.jboa.service;

import com.bdqn.spz.jboa.pojo.CheckResult;
import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service层报销单接口
 * @author 施鹏振
 */
public interface IExpenseAccountService {

	/**
	 * 查询报销单数量
	 * @param expenseAccount
	 * @return Integer
	 */
	Integer findExpenseAccountCount(ExpenseAccount expenseAccount);

	/**
	 * 查询报销单(分页)
	 * @param paging
	 * @return Paging<ExpenseAccount>
	 */
	Paging<ExpenseAccount> findExpenseAccounts(Paging<ExpenseAccount> paging);
	
	/**
	 * 新增报销单及详情
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean addExpenseAccount(ExpenseAccount expenseAccount);
	
	/**
	 * 删除报销单及详情
	 * @param expenseAccountId
	 * @return boolean
	 */
	boolean amputateExpenseAccount(Integer expenseAccountId);
	
	/**
	 * 查询报销单及详情
	 * @param expenseAccountId
	 * @return ExpenseAccount
	 */
	ExpenseAccount findExpenseAccount(Integer expenseAccountId);
	
	/**
	 * 修改报销单
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean modifyExpenseAccount(ExpenseAccount expenseAccount);
	
	/**
	 * 审核报销单
	 * @param checkResult
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean checkExpenseAccount(CheckResult checkResult,ExpenseAccount expenseAccount);
}
