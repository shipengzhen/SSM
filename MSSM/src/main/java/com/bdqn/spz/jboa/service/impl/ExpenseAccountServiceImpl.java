package com.bdqn.spz.jboa.service.impl;

import java.util.Date;
import java.util.List;

import com.bdqn.spz.jboa.dao.checkresult.ICheckResultDao;
import com.bdqn.spz.jboa.dao.employee.IEmployeeDao;
import com.bdqn.spz.jboa.dao.expenseaccount.IExpenseAccountDao;
import com.bdqn.spz.jboa.dao.expenseaccountdetail.IExpenseAccountDetailDao;
import com.bdqn.spz.jboa.dao.position.IPositionDao;
import com.bdqn.spz.jboa.pojo.CheckResult;
import com.bdqn.spz.jboa.pojo.Employee;
import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.pojo.ExpenseAccountDetail;
import com.bdqn.spz.jboa.service.IExpenseAccountService;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * Service�㱨����ʵ����
 * 
 * @author ʩ����
 */
public class ExpenseAccountServiceImpl implements IExpenseAccountService {

	// ������
	private IExpenseAccountDao expenseAccountDao;

	public IExpenseAccountDao getExpenseAccountDao() {
		return expenseAccountDao;
	}

	public void setExpenseAccountDao(IExpenseAccountDao expenseAccountDao) {
		this.expenseAccountDao = expenseAccountDao;
	}

	// ְԱ
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// ����������
	private IExpenseAccountDetailDao expenseAccountDetailDao;

	public IExpenseAccountDetailDao getExpenseAccountDetailDao() {
		return expenseAccountDetailDao;
	}

	public void setExpenseAccountDetailDao(IExpenseAccountDetailDao expenseAccountDetailDao) {
		this.expenseAccountDetailDao = expenseAccountDetailDao;
	}

	// ��������˽��
	private ICheckResultDao checkResultDao;

	public ICheckResultDao getCheckResultDao() {
		return checkResultDao;
	}

	public void setCheckResultDao(ICheckResultDao checkResultDao) {
		this.checkResultDao = checkResultDao;
	}

	// ְλ
	private IPositionDao positionDao;

	public IPositionDao getPositionDao() {
		return positionDao;
	}

	public void setPositionDao(IPositionDao positionDao) {
		this.positionDao = positionDao;
	}

	// ��ѯ����������
	@Override
	public Integer findExpenseAccountCount(ExpenseAccount expenseAccount) {
		Integer count = null;
		try {
			count = expenseAccountDao.selectExpenseAccountCount(expenseAccount);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return count;
	}

	// ��ѯ������(��ҳ)
	@Override
	public Paging<ExpenseAccount> findExpenseAccounts(Paging<ExpenseAccount> paging) {
		try {
			paging.setTotalCount(expenseAccountDao.selectExpenseAccountCount(paging.getT()));// ��¼����
			paging.setList(expenseAccountDao.selectExpenseAccounts(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return paging;
	}

	// ��ӱ�����������
	@Override
	public boolean addExpenseAccount(ExpenseAccount expenseAccount) {
		boolean b = false;
		try {
			if (expenseAccount.getStatus().equals("�´���")) {
				expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
			} else {
				expenseAccount.setNextCheckSn(employeeDao.selectSn(expenseAccount.getCreateSn(), "���ž���"));
			}
			if (expenseAccountDao.insertExpenseAccount(expenseAccount) > 0) {
				List<ExpenseAccountDetail> expenseAccountDetails = expenseAccount.getExpenseAccountDetails();
				for (ExpenseAccountDetail expenseAccountDetail : expenseAccountDetails) {
					expenseAccountDetail
							.setMainId(expenseAccountDao.selectNewExpenseAccount(expenseAccount.getCreateSn()).getId());
				}
				if (expenseAccountDetailDao.insertExpenseAccountDetailDaos(expenseAccountDetails) > 0) {
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	// ɾ��������������
	@Override
	public boolean amputateExpenseAccount(Integer expenseAccountId) {
		boolean b = false;
		try {
			if (expenseAccountDetailDao.deleteExpenseAccountDetailDaos(expenseAccountId) > 0) {
				if (expenseAccountDao.deleteExpenseAccount(expenseAccountId) > 0) {
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	// ��ѯ������������
	@Override
	public ExpenseAccount findExpenseAccount(Integer expenseAccountId) {
		ExpenseAccount expenseAccount = null;
		try {
			expenseAccount = expenseAccountDao.selectExpenseAccount(expenseAccountId);
			expenseAccount
					.setExpenseAccountDetails(expenseAccountDetailDao.selectExpenseAccountDetailDaos(expenseAccountId));
			expenseAccount.setCheckResults(checkResultDao.selectCheckResults(expenseAccountId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return expenseAccount;
	}

	// �޸ı�����
	@Override
	public boolean modifyExpenseAccount(ExpenseAccount expenseAccount) {
		boolean b = false;
		try {
			if (expenseAccountDetailDao.deleteExpenseAccountDetailDaos(expenseAccount.getId()) > 0) {
				List<ExpenseAccountDetail> expenseAccountDetails = expenseAccount.getExpenseAccountDetails();
				for (ExpenseAccountDetail expenseAccountDetail : expenseAccountDetails) {
					expenseAccountDetail
							.setMainId(expenseAccountDao.selectNewExpenseAccount(expenseAccount.getCreateSn()).getId());
				}
				if (expenseAccountDetailDao
						.insertExpenseAccountDetailDaos(expenseAccount.getExpenseAccountDetails()) > 0) {
					if (expenseAccount.getStatus().equals("�´���")) {
						expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
					} else {
						expenseAccount.setNextCheckSn(employeeDao.selectSn(expenseAccount.getCreateSn(), "���ž���"));
					}
					expenseAccount.setModifyTime(new Date());
					if (expenseAccountDao.updateExpenseAccount(expenseAccount) > 0) {
						b = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	// ��˱�����
	@Override
	public boolean checkExpenseAccount(CheckResult checkResult, ExpenseAccount expenseAccount) {
		boolean b = false;
		try {
			if (checkResultDao.insertCheckResult(checkResult) > 0) {
				String result = checkResult.getResult();
				if (result.equals("���")) {
					expenseAccount.setStatus("�Ѵ��");
					expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
				} else if (result.equals("�ܾ�")) {
					expenseAccount.setStatus("����ֹ");
					expenseAccount.setNextCheckSn("");
				} else if (result.equals("ͨ��")) {
					String checkSn = checkResult.getCheckSn();
					String PositionNameCn = employeeDao.selectPositionNameCnBySn(checkSn);
					if (PositionNameCn.equals("���ž���")) {
						departmentMnager(expenseAccount);
					} else if (PositionNameCn.equals("�ܾ���")) {
						generalMnager(expenseAccount);
					} else if (PositionNameCn.equals("����")) {
						finance(expenseAccount);
					}
				}
				if (expenseAccountDao.updateExpenseAccount(expenseAccount) > 0) {
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}

	// ���ž������
	public void departmentMnager(ExpenseAccount expenseAccount) throws Exception {
		Employee employee = new Employee();
		if (expenseAccount.getToatlAccount() >= 5000) {
			expenseAccount.setStatus("������");
			// ��ѯ�ܾ���
			employee.setPositionId(positionDao.selectPosition("�ܾ���").getId());
			expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
		} else {
			expenseAccount.setStatus("������");
			// ��ѯ���񹤺�
			employee.setPositionId(positionDao.selectPosition("����").getId());
			expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
		}
	}

	// �ܾ������
	public void generalMnager(ExpenseAccount expenseAccount) throws Exception {

		Employee employee = new Employee();
		expenseAccount.setStatus("������");
		// ��ѯ���񹤺�
		employee.setPositionId(positionDao.selectPosition("����").getId());
		expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
	}

	// �������
	public void finance(ExpenseAccount expenseAccount) throws Exception {
		expenseAccount.setStatus("�Ѹ���");
		expenseAccount.setNextCheckSn("");
	}
}
