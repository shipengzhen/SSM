<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="${css}/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<div class="action  divaction">
			<div class="t">查看报销单</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<caption>基本信息</caption>
					<tr>
						<td>编&nbsp;&nbsp;号:${expenseAccount.id}</td>
						<td>填&nbsp;写&nbsp;人:${expenseAccount.createName}</td>
						<td>部&nbsp;&nbsp;门:${expenseAccount.departmentName}</td>
						<td>职&nbsp;&nbsp;&nbsp;&nbsp;位:${expenseAccount.positionName}</td>
					</tr>
					<tr>
						<td>总金额:${expenseAccount.toatlAccount}</td>
						<td>填报时间:<fmt:formatDate value="${expenseAccount.createTime}" /></td>
						<td>状态:${expenseAccount.status}</td>
						<td>待处理人:${expenseAccount.nextCheckName}</td>
					</tr>
					<tr>
						<td colspan="4">
							<p>-------------------------------------------------------------------------------------------------------</p>
						</td>
					</tr>
				</table>
				<p>&nbsp;</p>
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<tr>
						<td>项目类别</td>
						<td>项目金额</td>
						<td>费用说明</td>
					</tr>
					<c:forEach var="expenseAccountDetail" items="${expenseAccount.expenseAccountDetails}">
						<tr>
							<td>${expenseAccountDetail.item}</td>
							<td>￥${expenseAccountDetail.account}</td>
							<td>${expenseAccountDetail.desc}</td>
						</tr>
					</c:forEach>
				</table>
				<p>&nbsp;</p>
				<p>-------------------------------------------------------------------------------------------------------</p>
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<c:forEach var="checkResult" items="${expenseAccount.checkResults}">
						<tr>
							<td width="27%">审核时间:<fmt:formatDate value="${checkResult.checkTime}" /></td>
							<td width="20%">审核人:${checkResult.checkName}</td>
						</tr>
						<tr>
							<td width="38%">审核结果:<span class="red"><strong>${checkResult.result}</strong></span></td>
							<td>审核意见:${checkResult.comment}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3">
							<p>-------------------------------------------------------------------------------------------------------</p>
						</td>
					</tr>
				</table>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>
					<input type="button" value="返回" onclick="window.history.go(-1)"
						class="submit_01" />
				</p>
			</div>
		</div>
</body>
</html>