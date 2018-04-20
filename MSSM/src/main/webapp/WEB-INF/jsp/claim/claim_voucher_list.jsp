<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="${css}/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${js}/common.js"></script>
<script type="text/javascript" src="${js}/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${js}/My97DatePicker/WdatePicker.js"></script>
<script>
	function delVoucher(id) {
		if (!confirm('确定删除报单吗')) {
			return;
		}
		location.href = "expenseaccount_delete?expenseAccountId=" + id;
	}
</script>
<c:if test="${error!=null && error!=''}">
	<script>
		alert("删除失败");
	</script>
</c:if>
<div class="action  divaction">
	<div class="t">报销单列表</div>
	<div class="pages">
		<div class="forms">
			<form action="expenseaccount_list" name="queryForm" method="post">
				<label>报销单状态</label> <select name="status">
					<c:choose>
						<c:when test="${paging.t.status==null||paging.t.status==''}">
							<option value="">全部</option>
							<option value="新创建">新创建</option>
							<option value="已付款">已付款</option>
							<option value="已提交">已提交</option>
							<option value="已打回">已打回</option>
							<option value="已审批">已审批</option>
							<option value="已终止">已终止</option>
							<option value="已打回">已打回</option>
						</c:when>
						<c:otherwise>
							<c:if test="${paging.t.status=='新创建'}">
								<option value="新创建" selected="selected">新创建</option>
							</c:if>
							<c:if test="${paging.t.status!='新创建'}">
								<option value="新创建">新创建</option>
							</c:if>
							<c:if test="${paging.t.status=='已付款'}">
								<option value="已付款" selected="selected">已付款</option>
							</c:if>
							<c:if test="${paging.t.status!='已付款'}">
								<option value="已付款">已付款</option>
							</c:if>
							<c:if test="${paging.t.status=='已提交'}">
								<option value="已提交" selected="selected">已提交</option>
							</c:if>
							<c:if test="${paging.t.status!='已提交'}">
								<option value="已提交">已提交</option>
							</c:if>
							<c:if test="${paging.t.status=='已打回'}">
								<option value="已打回" selected="selected">已打回</option>
							</c:if>
							<c:if test="${paging.t.status!='已打回'}">
								<option value="已打回">已打回</option>
							</c:if>
							<c:if test="${paging.t.status=='已审批'}">
								<option value="已审批" selected="selected">已审批</option>
							</c:if>
							<c:if test="${paging.t.status!='已审批'}">
								<option value="已审批">已审批</option>
							</c:if>
							<c:if test="${paging.t.status=='已终止'}">
								<option value="已终止" selected="selected">已终止</option>
							</c:if>
							<c:if test="${paging.t.status!='已终止'}">
								<option value="已终止">已终止</option>
							</c:if>
							<c:if test="${paging.t.status=='已打回'}">
								<option value="已打回" selected="selected">已打回</option>
							</c:if>
							<c:if test="${paging.t.status!='已打回'}">
								<option value="已打回">已打回</option>
							</c:if>
						</c:otherwise>
					</c:choose>
				</select> <label for="time">开始时间</label> <input type="text" Class="Wdate"
					name="createTime" readonly="readonly" onclick="WdatePicker();"
					value="<fmt:formatDate value="${paging.t.createTime}"/>">
					<label for="end-time">结束时间</label> <input type="text" Class="Wdate"
					name="modifyTime" readonly="readonly" onclick="WdatePicker();"
					value="<fmt:formatDate value="${paging.t.modifyTime}"/>">
					 <input type="hidden"
					name="currentPageNo" value="1" /> <input type="hidden"
					name="pageSize" value="5" /> <input type="submit" value="查询">
			</form>
		</div>
		<!--增加报销单 区域 开始-->
		<table width="90%" border="0" cellspacing="0" cellpadding="0"
			class="list items">
			<tr class="even">
				<td>编号</td>
				<td>填报日期</td>
				<td>填报人</td>
				<td>总金额</td>
				<td>状态</td>
				<td>待处理人</td>
				<td>操作</td>
			</tr>
			<c:forEach var="expenseAccount" items="${paging.list}">
				<tr>
					<td><a href="">${expenseAccount.id}</a></td>
					<td><fmt:formatDate value="${expenseAccount.createTime}" /></td>
					<td>${expenseAccount.createName}</td>
					<td>${expenseAccount.toatlAccount}</td>
					<td>${expenseAccount.status}</td>
					<td>${expenseAccount.nextCheckName}</td>
					<td>
						<c:if test="${expenseAccount.createSn==employee.sn}">
							<c:if test="${expenseAccount.status == '新创建'||expenseAccount.status == '已打回'}">
								<a href="expenseaccount_modify?expenseAccountId=${expenseAccount.id}"> <img src="${images}/edit.gif" width="16"height="16" />修改</a>
								<a onClick="delVoucher(${expenseAccount.id})" href="#"><img src="${images}/delete.gif"width="16"height="16" />删除</a>
							</c:if> 
							<a href="expenseaccount_edit"><img src="${images}/save.gif" width="16"height="16" />新增</a>
						</c:if>
						<a href="expenseaccount_view?expenseAccountId=${expenseAccount.id}"><img src="${images}/search.gif" width="16"height="15" />查看</a>
						<c:if test="${expenseAccount.nextCheckSn==employee.sn}">
							<c:if test="${expenseAccount.status == '已提交' || expenseAccount.status == '侍审批' || expenseAccount.status == '已审批'}">
								<a href="expenseaccount_check?expenseAccountId=${expenseAccount.id}"><img src="${images}/sub.gif" width="16"height="16" />审核</a>
							</c:if>
						</c:if>
					<td>
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
	</div>
</div>