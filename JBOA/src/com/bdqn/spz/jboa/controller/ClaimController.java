package com.bdqn.spz.jboa.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bdqn.spz.jboa.pojo.CheckResult;
import com.bdqn.spz.jboa.pojo.Employee;
import com.bdqn.spz.jboa.pojo.ExpenseAccount;
import com.bdqn.spz.jboa.pojo.Leave;
import com.bdqn.spz.jboa.service.IEmployeeService;
import com.bdqn.spz.jboa.service.IExpenseAccountService;
import com.bdqn.spz.jboa.service.ILeaveService;
import com.bdqn.spz.jboa.tools.Page;
import com.bdqn.spz.jboa.tools.Paging;

/**
 * 申请控制器
 * 
 * @author 施鹏振
 */
@RequestMapping("/sys/claim")
public class ClaimController {

	// 报销单
	private IExpenseAccountService expenseAccountService;

	public IExpenseAccountService getExpenseAccountService() {
		return expenseAccountService;
	}

	public void setExpenseAccountService(IExpenseAccountService expenseAccountService) {
		this.expenseAccountService = expenseAccountService;
	}

	// 职工
	private IEmployeeService employeeService;

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 请假
	private ILeaveService leaveService;

	public ILeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(ILeaveService leaveService) {
		this.leaveService = leaveService;
	}

	// 跳转主页面
	@RequestMapping("/index")
	public String index() {
		return Page.INDEX;
	}

	// 处理报销单查询业务
	public ExpenseAccount componentExpenseAccount(ExpenseAccount expenseAccount, HttpSession session) {
		String createSn = ((Employee) session.getAttribute("employee")).getSn();
		String positionNameCn = ((Employee) session.getAttribute("employee")).getPositionNameCn();
		if (positionNameCn.equals("员工")) {
			expenseAccount.setCreateSn(createSn);
			// expenseAccount.setStatus("新创建");
		} else if (positionNameCn.equals("财务")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("已审批");
		} else if (positionNameCn.equals("部门经理")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("已提交");
		} else if (positionNameCn.equals("总经理")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("待审批");
		}
		return expenseAccount;
	};

	// 跳转查看报销单页面
	@RequestMapping("/expenseaccount_list")
	public String expenseAccountView(Model model, HttpSession session, String error) {
		try {
			Paging<ExpenseAccount> paging = new Paging<ExpenseAccount>();
			ExpenseAccount expenseAccount = new ExpenseAccount();
			paging.setT(componentExpenseAccount(expenseAccount, session));// 传入参数对象
			paging.setPageSize(5);// 页大小
			paging.setCurrentPageNo(1);// 当前页
			model.addAttribute("paging", expenseAccountService.findExpenseAccounts(paging));
			model.addAttribute("error", error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_LIST;
	}

	// 查询报销单(分页)
	@RequestMapping(value = "/expenseaccount_list", method = RequestMethod.POST)
	public String expenseAccountView(ExpenseAccount expenseAccount, Paging<ExpenseAccount> paging, Model model,
			HttpSession session) {
		try {
			paging.setT(componentExpenseAccount(expenseAccount, session));// 传入参数对象
			model.addAttribute("paging", expenseAccountService.findExpenseAccounts(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_LIST;
	}

	// 跳转新增报销单页面
	@RequestMapping("/expenseaccount_edit")
	public String expenseAccountEdit(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		model.addAttribute("createSn", employee.getSn());
		model.addAttribute("createName", employee.getName());
		model.addAttribute("createTime", new Date());
		return Page.EXPENSEACCOUNT_EDIT;
	}

	// 新增报销单
	@RequestMapping(value = "/expenseaccount_edit", method = RequestMethod.POST)
	public String expenseAccountEdit(ExpenseAccount expenseAccount) {
		String page = null;
		try {
			if (expenseAccountService.addExpenseAccount(expenseAccount)) {
				page = "redirect:/sys/claim/expenseaccount_list";
			} else {
				page = "redirect:/sys/claim/expenseaccount_edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}

	// 删除报销单
	@RequestMapping("/expenseaccount_delete")
	public String expenseAccountDelete(Integer expenseAccountId) {
		String page = null;
		try {
			if (expenseAccountService.amputateExpenseAccount(expenseAccountId)) {
				page = "redirect:/sys/claim/expenseaccount_list";
			} else {
				page = "redirect:/sys/claim/expenseaccount_list?error=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}

	// 查看报销单详情
	@RequestMapping("/expenseaccount_view")
	public String expenseAccountView(Integer expenseAccountId, Model model) {
		try {
			model.addAttribute("expenseAccount", expenseAccountService.findExpenseAccount(expenseAccountId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_VIEW;
	}

	// 跳转修改报销单页面
	@RequestMapping("/expenseaccount_modify")
	public String expenseAccountModify(Integer expenseAccountId, Model model) {
		try {
			model.addAttribute("expenseAccount", expenseAccountService.findExpenseAccount(expenseAccountId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_MODIFY;
	}

	// 修改报销单
	@RequestMapping(value = "/expenseaccount_modify", method = RequestMethod.POST)
	public String expenseAccountModify(ExpenseAccount expenseAccount) {
		String page = null;
		try {
			if (expenseAccountService.modifyExpenseAccount(expenseAccount)) {
				page = "redirect:/sys/claim/expenseaccount_list";
			} else {
				page = "redirect:/sys/claim/expenseaccount_modify";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}

	// 跳转审核报销单页面
	@RequestMapping("/expenseaccount_check")
	public String expenseAccountCheck(Integer expenseAccountId, Model model) {
		try {
			model.addAttribute("expenseAccount", expenseAccountService.findExpenseAccount(expenseAccountId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_CHECK;
	}

	// 审核报销单
	@RequestMapping(value = "/expenseaccount_check", method = RequestMethod.POST)
	public String expenseAccountCheck(CheckResult checkResult, HttpSession session, ExpenseAccount expenseAccount) {
		String page = null;
		try {
			checkResult.setCheckSn(((Employee) session.getAttribute("employee")).getSn());// 审核人
			checkResult.setCheckTime(new Date());// 审核时间
			if (expenseAccountService.checkExpenseAccount(checkResult, expenseAccount)) {
				page = "redirect:/sys/claim/expenseaccount_list";
			} else {
				page = "redirect:/sys/claim/expenseaccount_check";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	}

	// 请假业务
	public Leave componentLeave(HttpSession session, Leave leave) {
		String employeeSn = ((Employee) session.getAttribute("employee")).getSn();
		String positionNameCn = ((Employee) session.getAttribute("employee")).getPositionNameCn();
		if (positionNameCn.equals("员工")) {
			leave.setEmployeeSn(employeeSn);
		} else if (positionNameCn.equals("部门经理")) {
			leave.setNextCheckSn(employeeSn);
			leave.setStatus("待审批");
		}
		return leave;
	}

	// 跳转查看请假列表
	@RequestMapping("/leave_list")
	public String leaveList(HttpSession session, Model model) {
		try {
			Paging<Leave> paging = new Paging<Leave>();
			Leave leave = new Leave();
			paging.setT(componentLeave(session, leave));// 传入参数对象
			paging.setPageSize(5);// 页大小
			paging.setCurrentPageNo(1);// 当前页
			model.addAttribute("paging", leaveService.findLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_LIST;
	}

	// 查看请假列表
	@RequestMapping(value = "/leave_list", method = RequestMethod.POST)
	public String leaveList(Leave leave, Paging<Leave> paging, Model model, HttpSession session) {
		try {
			paging.setT(componentLeave(session, leave));// 传入参数对象
			model.addAttribute("paging", leaveService.findLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_LIST;
	}

	// 跳转新增请假页面
	@RequestMapping("/leave_edit")
	public String leaveEdit(Model model) {
		try {
			model.addAttribute("leaveTypes", leaveService.findLeaveTypes());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_EDIT;
	};

	// 新增请假详情
	@RequestMapping(value = "/leave_edit", method = RequestMethod.POST)
	public String leaveEdit(Leave leave, HttpSession session) {
		String page = null;
		try {
			leave.setEmployeeSn(((Employee) session.getAttribute("employee")).getSn());
			if (leaveService.addLeave(leave)) {
				page = "redirect:/sys/claim/leave_list";
			} else {
				page = "redirect:/sys/claim/leave_edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return page;
	};

	// 查看请假
	@RequestMapping("/leave_view")
	public String leaveView(Integer leaveId, Model model) {
		try {
			model.addAttribute("leave", leaveService.findLeave(leaveId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_VIEW;
	};

	// 跳转审批请假页面
	@RequestMapping("/leave_check")
	public String leaveCheck(Integer leaveId, Model model) {
		try {
			model.addAttribute("leave", leaveService.findLeave(leaveId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_CHECK;
	};

	// 跳转审批请假页面
	@RequestMapping(value = "/leave_check", method = RequestMethod.POST)
	public String leaveCheck(Leave leave) {
		try {
			leaveService.checkLeave(leave);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return  "redirect:/sys/claim/leave_list";
	};
}
