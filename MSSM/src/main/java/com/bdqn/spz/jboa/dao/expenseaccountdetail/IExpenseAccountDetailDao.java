package com.bdqn.spz.jboa.dao.expenseaccountdetail;

import java.util.List;

import com.bdqn.spz.jboa.pojo.ExpenseAccountDetail;

/**
 * Dao�㱨��������ӿ�
 * @author ʩ����
 *
 */
public interface IExpenseAccountDetailDao {

	/**
	 * ����һ�����������������
	 * @param expenseAccountDetails
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertExpenseAccountDetailDaos(List<ExpenseAccountDetail> expenseAccountDetails)throws Exception;
	
	/**
	 * ɾ��һ�����������������
	 * @param expenseAccountId
	 * @return Integer
	 */
	Integer deleteExpenseAccountDetailDaos(Integer expenseAccountId);
	
	/**
	 * ��ѯһ�����������������
	 * @param expenseAccountId
	 * @return List<ExpenseAccountDetail>
	 */
	List<ExpenseAccountDetail> selectExpenseAccountDetailDaos(Integer expenseAccountId);
}
