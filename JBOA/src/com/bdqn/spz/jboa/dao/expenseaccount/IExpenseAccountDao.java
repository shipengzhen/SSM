package com.bdqn.spz.jboa.dao.expenseaccount;

import java.util.List;


import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Dao�㱨�����ӿ�
 * 
 * @author ʩ����
 *
 */
public interface IExpenseAccountDao {

	/**
	 * ��ѯ����������
	 * 
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectExpenseAccountCount(ExpenseAccount expenseAccount) throws Exception;

	/**
	 * ��ѯ������
	 * @param paging
	 * @return List<ExpenseAccount>
	 * @throws Exception
	 */
	List<ExpenseAccount> selectExpenseAccounts(Paging<ExpenseAccount> paging) throws Exception;
	
	/**
	 * ����������
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertExpenseAccount(ExpenseAccount expenseAccount) throws Exception;
	
	/**
	 * ��ѯĳ�û����µı�����
	 * @return ExpenseAccount
	 */
	ExpenseAccount selectNewExpenseAccount(String createSn) throws Exception;
	
	/**
	 * ɾ��������
	 * @param expenseAccountId
	 * @return Integer
	 */
	Integer deleteExpenseAccount(Integer expenseAccountId)throws Exception;
	
	/**
	 * ��ѯ������
	 * @param expenseAccountId
	 * @return ExpenseAccount
	 * @throws Exception
	 */
	ExpenseAccount selectExpenseAccount(Integer expenseAccountId)throws Exception;
	
	/**
	 * �޸ı�����
	 * @param expenseAccount
	 * @return Integer
	 * @throws Exception
	 */
	Integer updateExpenseAccount(ExpenseAccount expenseAccount)throws Exception;
}
