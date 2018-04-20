package com.bdqn.spz.jboa.dao.checkresult;

import java.util.List;

import com.bdqn.spz.jboa.pojo.CheckResult;

/**
 * Dao�㱨������˽ӿ�
 * @author ʩ����
 *
 */
public interface ICheckResultDao {

	/**
	 * ��ѯһ���������������˽��
	 * @param expenseAccountId
	 * @return List<CheckResult>
	 * @throws Exception
	 */
	List<CheckResult> selectCheckResults(Integer expenseAccountId)throws Exception;
	
	/**
	 * ������������˽��
	 * @param checkResult
	 * @return Integer
	 * @throws Exception
	 */
	Integer insertCheckResult(CheckResult checkResult)throws Exception;
}
