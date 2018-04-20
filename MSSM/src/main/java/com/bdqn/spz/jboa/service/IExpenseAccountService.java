package com.bdqn.spz.jboa.service;

import com.bdqn.spz.jboa.pojo.CheckResult;
import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service�㱨�����ӿ�
 * @author ʩ����
 */
public interface IExpenseAccountService {

	/**
	 * ��ѯ����������
	 * @param expenseAccount
	 * @return Integer
	 */
	Integer findExpenseAccountCount(ExpenseAccount expenseAccount);

	/**
	 * ��ѯ������(��ҳ)
	 * @param paging
	 * @return Paging<ExpenseAccount>
	 */
	Paging<ExpenseAccount> findExpenseAccounts(Paging<ExpenseAccount> paging);
	
	/**
	 * ����������������
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean addExpenseAccount(ExpenseAccount expenseAccount);
	
	/**
	 * ɾ��������������
	 * @param expenseAccountId
	 * @return boolean
	 */
	boolean amputateExpenseAccount(Integer expenseAccountId);
	
	/**
	 * ��ѯ������������
	 * @param expenseAccountId
	 * @return ExpenseAccount
	 */
	ExpenseAccount findExpenseAccount(Integer expenseAccountId);
	
	/**
	 * �޸ı�����
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean modifyExpenseAccount(ExpenseAccount expenseAccount);
	
	/**
	 * ��˱�����
	 * @param checkResult
	 * @param expenseAccount
	 * @return boolean
	 */
	boolean checkExpenseAccount(CheckResult checkResult,ExpenseAccount expenseAccount);
}
