<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
	</div>
	<div class="search">
		<form method="post" action="${pageContext.request.contextPath }/user/findUsers">
			<span>用户名：</span><input name="userName" class="input-text" type="text">
			<span>用户角色：</span> 
			<select name="userRole">
				<c:if test="${roles!= null }">
					<option value="0">--请选择--</option>
					<c:forEach var="role" items="${roles}">
						<option value="${role.id}">
								${role.roleName}
						</option>
					</c:forEach>
				</c:if>
			</select> 
			<input value="查 询" type="submit" id="searchbutton">
			<a href="${pageContext.request.contextPath }/user/adduser.html" >添加用户</a>
		</form>
	</div>
	<!--用户-->
	<table class="providerTable" cellspacing="0" cellpadding="0">
		<tr class="firstTr">
			<th width="10%">用户编码</th>
			<th width="20%">用户名称</th>
			<th width="10%">性别</th>
			<th width="10%">年龄</th>
			<th width="10%">电话</th>
			<th width="10%">用户角色</th>
			<th width="30%">操作</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr class="userMessage">
				<input type="hidden" value="${user.id}"/>
				<td><span>${user.userCode}</span></td>
				<td><span>${user.userName}</span></td>
				<td><span>
					<c:if test="${user.gender==1}">女</c:if>
					<c:if test="${user.gender==2}">男</c:if>
				</span></td>
				<td><span>${user.birthday}</span></td>
				<td><span>${user.phone}</span></td>
				<td><span>${user.userRole}</span></td>
				<td>
					<span><a class="viewUser" href="${pageContext.request.contextPath }/user/userview.html?userId=${user.id}">
						<img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看" />
					</a></span>
					<span><a class="modifyUser" href="javascript:;" userid=${user.id }>
						<img src="${pageContext.request.contextPath }/statics/images/xiugai.png"alt="修改" title="修改" />
					</a></span>
					<span><a class="deleteUser"href="">
					<img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除" />
					</a></span>
				</td>
			</tr>
		</c:forEach>
		</table>
	<input type="hidden" id="totalPageCount" value="${totalPageCount}" />
	<c:import url="rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}" />
		<c:param name="currentPageNo" value="${currentPageNo}" />
		<c:param name="totalPageCount" value="${totalPageCount}" />
	</c:import>
	<h2 id="v_userCode"></h2>
	<h2 id="v_userName"></h2>
	<h2 id="v_gender"></h2>
	<h2 id="v_birthday"></h2>
	<h2 id="v_phone"></h2>
	<h2 id="v_address"></h2>
	<h2 id="v_userRoleName"></h2>
</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该用户吗？</p>
			<a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
