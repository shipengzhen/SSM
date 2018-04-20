<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="${css}/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function checkLeave(status){
		   		if(!confirm('确定'+status+'请假吗')) return;
		   		document.leaveForm.status.value = status;
		   		document.leaveForm.submit();
		   		
		   	}
		</script>
	</head>
<body>
<div class="action  divaction">
			<div class="t">
				查看请假
			</div>
			<div class="pages">
				<!--增加报销单 区域 开始-->
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>
						基本信息
					</caption>
					<tr>
						<td width="36%">
							姓名:${leave.employeeName}
						</td>
						<td width="64%">
							部门:${leave.departmentName}
						</td>
					</tr>
					<tr>
						<td>
							开始时间:<fmt:formatDate value="${leave.startTime}" />
						</td>
						<td>
							结束时间:<fmt:formatDate value="${leave.endTime}" />
						</td>
					</tr>
					<tr>
						<td>
							请假天数:${leave.leaveDay}
						</td>
						<td>
							休假类型:${leave.leaveType}
						</td>
					</tr>
					<tr>
						<td>
							请假事由:${leave.reason}
						</td>
						<td>
							审批状态:${leave.status}
						</td>
					</tr>
				</table>
				<p>
					-------------------------------------------------------------------------------
				</p>
			<form name="leaveForm" method="post" action="leave_check">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<tr><td>审批意见:</td></tr>
					<tr><td><textarea name="approveOpinion" class="textarea">${leave.approveOpinion}</textarea></td></tr>
					<!--表单提交行-->
					<tr>
						<td colspan="4" class="submit">
							<input type="button" name="button" id="button" value="审批通过"
							class="submit_01" onclick="checkLeave('已审批 ')" />
							<input type="hidden" id="leaveId" name="id" value="${leave.id}"/>
							<input type="hidden" id="status" name="status" value=""/>
							<input type="button" name="button" id="button" value="打回"
							class="submit_01" onclick="checkLeave('已打回 ')" />
						</td>
					</tr>
	
				</table>
				</form>
				<!--增加报销单 区域 结束-->
			</div>
		</div>
	</body>
</html>