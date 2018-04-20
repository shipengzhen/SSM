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
 * ���������
 * 
 * @author ʩ����
 */
@RequestMapping("/sys/claim")
public class ClaimController {

	// ������
	private IExpenseAccountService expenseAccountService;

	public IExpenseAccountService getExpenseAccountService() {
		return expenseAccountService;
	}

	public void setExpenseAccountService(IExpenseAccountService expenseAccountService) {
		this.expenseAccountService = expenseAccountService;
	}

	// ְ��
	private IEmployeeService employeeService;

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// ���
	private ILeaveService leaveService;

	public ILeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(ILeaveService leaveService) {
		this.leaveService = leaveService;
	}

	// ��ת��ҳ��
	@RequestMapping("/index")
	public String index() {
		return Page.INDEX;
	}

	// ����������ѯҵ��
	public ExpenseAccount componentExpenseAccount(ExpenseAccount expenseAccount, HttpSession session) {
		String createSn = ((Employee) session.getAttribute("employee")).getSn();
		String positionNameCn = ((Employee) session.getAttribute("employee")).getPositionNameCn();
		if (positionNameCn.equals("Ա��")) {
			expenseAccount.setCreateSn(createSn);
			// expenseAccount.setStatus("�´���");
		} else if (positionNameCn.equals("����")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("������");
		} else if (positionNameCn.equals("���ž���")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("���ύ");
		} else if (positionNameCn.equals("�ܾ���")) {
			expenseAccount.setNextCheckSn(createSn);
			expenseAccount.setStatus("������");
		}
		return expenseAccount;
	};

	// ��ת�鿴������ҳ��
	@RequestMapping("/expenseaccount_list")
	public String expenseAccountView(Model model, HttpSession session, String error) {
		try {
			Paging<ExpenseAccount> paging = new Paging<ExpenseAccount>();
			ExpenseAccount expenseAccount = new ExpenseAccount();
			paging.setT(componentExpenseAccount(expenseAccount, session));// �����������
			paging.setPageSize(5);// ҳ��С
			paging.setCurrentPageNo(1);// ��ǰҳ
			model.addAttribute("paging", expenseAccountService.findExpenseAccounts(paging));
			model.addAttribute("error", error);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_LIST;
	}

	// ��ѯ������(��ҳ)
	@RequestMapping(value = "/expenseaccount_list", method = RequestMethod.POST)
	public String expenseAccountView(ExpenseAccount expenseAccount, Paging<ExpenseAccount> paging, Model model,
			HttpSession session) {
		try {
			paging.setT(componentExpenseAccount(expenseAccount, session));// �����������
			model.addAttribute("paging", expenseAccountService.findExpenseAccounts(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.EXPENSEACCOUNT_LIST;
	}

	// ��ת����������ҳ��
	@RequestMapping("/expenseaccount_edit")
	public String expenseAccountEdit(Model model, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		model.addAttribute("createSn", employee.getSn());
		model.addAttribute("createName", employee.getName());
		model.addAttribute("createTime", new Date());
		return Page.EXPENSEACCOUNT_EDIT;
	}

	// ����������
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

	// ɾ��������
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

	// �鿴����������
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

	// ��ת�޸ı�����ҳ��
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

	// �޸ı�����
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

	// ��ת��˱�����ҳ��
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

	// ��˱�����
	@RequestMapping(value = "/expenseaccount_check", method = RequestMethod.POST)
	public String expenseAccountCheck(CheckResult checkResult, HttpSession session, ExpenseAccount expenseAccount) {
		String page = null;
		try {
			checkResult.setCheckSn(((Employee) session.getAttribute("employee")).getSn());// �����
			checkResult.setCheckTime(new Date());// ���ʱ��
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

	// ���ҵ��
	public Leave componentLeave(HttpSession session, Leave leave) {
		String employeeSn = ((Employee) session.getAttribute("employee")).getSn();
		String positionNameCn = ((Employee) session.getAttribute("employee")).getPositionNameCn();
		if (positionNameCn.equals("Ա��")) {
			leave.setEmployeeSn(employeeSn);
		} else if (positionNameCn.equals("���ž���")) {
			leave.setNextCheckSn(employeeSn);
			leave.setStatus("������");
		}
		return leave;
	}

	// ��ת�鿴����б�
	@RequestMapping("/leave_list")
	public String leaveList(HttpSession session, Model model) {
		try {
			Paging<Leave> paging = new Paging<Leave>();
			Leave leave = new Leave();
			paging.setT(componentLeave(session, leave));// �����������
			paging.setPageSize(5);// ҳ��С
			paging.setCurrentPageNo(1);// ��ǰҳ
			model.addAttribute("paging", leaveService.findLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_LIST;
	}

	// �鿴����б�
	@RequestMapping(value = "/leave_list", method = RequestMethod.POST)
	public String leaveList(Leave leave, Paging<Leave> paging, Model model, HttpSession session) {
		try {
			paging.setT(componentLeave(session, leave));// �����������
			model.addAttribute("paging", leaveService.findLeaves(paging));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return Page.LEAVE_LIST;
	}

	// ��ת�������ҳ��
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

	// �����������
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

	// �鿴���
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

	// ��ת�������ҳ��
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

	// ��ת�������ҳ��
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
