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
 * Service层报销单实现类
 * 
 * @author 施鹏振
 */
public class ExpenseAccountServiceImpl implements IExpenseAccountService {

	// 报销单
	private IExpenseAccountDao expenseAccountDao;

	public IExpenseAccountDao getExpenseAccountDao() {
		return expenseAccountDao;
	}

	public void setExpenseAccountDao(IExpenseAccountDao expenseAccountDao) {
		this.expenseAccountDao = expenseAccountDao;
	}

	// 职员
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// 报销单详情
	private IExpenseAccountDetailDao expenseAccountDetailDao;

	public IExpenseAccountDetailDao getExpenseAccountDetailDao() {
		return expenseAccountDetailDao;
	}

	public void setExpenseAccountDetailDao(IExpenseAccountDetailDao expenseAccountDetailDao) {
		this.expenseAccountDetailDao = expenseAccountDetailDao;
	}

	// 报销单审核结果
	private ICheckResultDao checkResultDao;

	public ICheckResultDao getCheckResultDao() {
		return checkResultDao;
	}

	public void setCheckResultDao(ICheckResultDao checkResultDao) {
		this.checkResultDao = checkResultDao;
	}

	// 职位
	private IPositionDao positionDao;

	public IPositionDao getPositionDao() {
		return positionDao;
	}

	public void setPositionDao(IPositionDao positionDao) {
		this.positionDao = positionDao;
	}

	// 查询报销单数量
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

	// 查询报销单(分页)
	@Override
	public Paging<ExpenseAccount> findExpenseAccounts(Paging<ExpenseAccount> paging) {
		try {
			paging.setTotalCount(expenseAccountDao.selectExpenseAccountCount(paging.getT()));// 记录总数
			paging.setList(expenseAccountDao.selectExpenseAccounts(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return paging;
	}

	// 添加报销单及详情
	@Override
	public boolean addExpenseAccount(ExpenseAccount expenseAccount) {
		boolean b = false;
		try {
			if (expenseAccount.getStatus().equals("新创建")) {
				expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
			} else {
				expenseAccount.setNextCheckSn(employeeDao.selectSn(expenseAccount.getCreateSn(), "部门经理"));
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

	// 删除报销单及详情
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

	// 查询报销单及详情
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

	// 修改报销单
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
					if (expenseAccount.getStatus().equals("新创建")) {
						expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
					} else {
						expenseAccount.setNextCheckSn(employeeDao.selectSn(expenseAccount.getCreateSn(), "部门经理"));
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

	// 审核报销单
	@Override
	public boolean checkExpenseAccount(CheckResult checkResult, ExpenseAccount expenseAccount) {
		boolean b = false;
		try {
			if (checkResultDao.insertCheckResult(checkResult) > 0) {
				String result = checkResult.getResult();
				if (result.equals("打回")) {
					expenseAccount.setStatus("已打回");
					expenseAccount.setNextCheckSn(expenseAccount.getCreateSn());
				} else if (result.equals("拒绝")) {
					expenseAccount.setStatus("已终止");
					expenseAccount.setNextCheckSn("");
				} else if (result.equals("通过")) {
					String checkSn = checkResult.getCheckSn();
					String PositionNameCn = employeeDao.selectPositionNameCnBySn(checkSn);
					if (PositionNameCn.equals("部门经理")) {
						departmentMnager(expenseAccount);
					} else if (PositionNameCn.equals("总经理")) {
						generalMnager(expenseAccount);
					} else if (PositionNameCn.equals("财务")) {
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

	// 部门经理审核
	public void departmentMnager(ExpenseAccount expenseAccount) throws Exception {
		Employee employee = new Employee();
		if (expenseAccount.getToatlAccount() >= 5000) {
			expenseAccount.setStatus("待审批");
			// 查询总经理
			employee.setPositionId(positionDao.selectPosition("总经理").getId());
			expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
		} else {
			expenseAccount.setStatus("已审批");
			// 查询财务工号
			employee.setPositionId(positionDao.selectPosition("财务").getId());
			expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
		}
	}

	// 总经理审核
	public void generalMnager(ExpenseAccount expenseAccount) throws Exception {

		Employee employee = new Employee();
		expenseAccount.setStatus("已审批");
		// 查询财务工号
		employee.setPositionId(positionDao.selectPosition("财务").getId());
		expenseAccount.setNextCheckSn(employeeDao.selectEmployee(employee).getSn());
	}

	// 财务审核
	public void finance(ExpenseAccount expenseAccount) throws Exception {
		expenseAccount.setStatus("已付款");
		expenseAccount.setNextCheckSn("");
	}
}
