<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="${css}/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${js}/common.js"></script>
<script type="text/javascript" src="${js}/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${js}/My97DatePicker/WdatePicker.js"></script>
<div class="action  divaction">
	<div class="t">请假列表</div>
	<div class="pages">
		<div class="forms">
			<form action="leave_list" name="queryForm" method="post">
				<label for="time">开始时间</label>
				<input type="text" Class="Wdate" name="startTime" readonly="readonly" onclick="WdatePicker();" />
				<label for="end-time">结束时间</label>
				<input type="text" Class="Wdate" name="endTime" readonly="readonly" onclick="WdatePicker();" />
				<input type="hidden" name="currentPageNo" value="1" />
				<input type="hidden" name="pageSize" value="5" /> 
				<input type="submit" Class="submit_01" value="查询" />
			</form>
		</div>
		<!--增加报销单 区域 开始-->
		<table width="90%" border="0" cellspacing="0" cellpadding="0"
			class="list items">
			<tr class="even">
				<td>编号</td>
				<td>名称</td>
				<td>发起时间</td>
				<td>审批时间</td>
				<td>审批意见</td>
				<td>审批状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="leave" items="${paging.list}">
				<tr>
					<td>${leave.id}</td>
					<td>${leave.employeeName}请假${leave.leaveDay}天</td>
					<td><fmt:formatDate value="${leave.createTime}"/></td>
					<td><fmt:formatDate value="${leave.modifyTime}"/></td>
					<td>${leave.approveOpinion}</td>
					<td>${leave.status}</td>
					<td>
						<a href="leave_view?leaveId=${leave.id}"><img src="${images}/search.gif" width="16" height="15" />查看</a>
						<c:if test="${leave.nextCheckSn==employee.sn}">
							<c:if test="${leave.status=='待审批'}"> 
								<a href="leave_check?leaveId=${leave.id}"><img src="${images}/sub.gif" width="16"height="16" />审核</a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="12" align="center">
					<c:import url="../common/rollPage.jsp" charEncoding="UTF-8">
						<c:param name="formName" value="document.forms[0]" />
						<c:param name="totalCount" value="${paging.totalCount}" />
						<c:param name="totalPageCount" value="${paging.totalPageCount}" />
						<c:param name="currentPageNo" value="${paging.currentPageNo}" />
					</c:import>
				</td>
			</tr>
		</table>
		<!--请假 区域 结束-->
	</div>
</div>