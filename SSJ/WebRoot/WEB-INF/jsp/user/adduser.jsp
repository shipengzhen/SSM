﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>用户管理页面 >> 用户添加页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/adduser">
			<!-- <input type="hidden" name="method" value="add"> -->
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div>
				<label for="userCode">用户编码：</label>
				<input type="text" name="userCode" id="userCode">
				<!-- 放置提示信息 -->
				<font color="red"></font>
			</div>
			<div>
				<label for="userName">用户名称：</label>
				<input type="text" name="userName" id="userName">
				<font color="red"></font>
			</div>
			<div>
				<label for="userPassword">用户密码：</label>
				<input type="password" name="userPassword" id="userPassword">
				<font color="red"></font>
			</div>
			<div>
				<label for="ruserPassword">确认密码：</label>
				<input type="password" name="ruserPassword" id="ruserPassword">
				<font color="red"></font>
			</div>
			<div>
				<label>用户性别：</label>
				<select name="gender" id="gender">
					<option value="1" selected="selected">男</option>
					<option value="2">女</option>
				</select>
			</div>
			<div>
				<label for="birthday">出生日期：</label>
				<input type="text" Class="Wdate" id="birthday" name="birthday" readonly="readonly" onclick="WdatePicker();">
				<font color="red"></font>
			</div>
			<div>
				<label for="phone">用户电话：</label>
				<input type="text" name="phone" id="phone">
				<font color="red"></font>
			</div>
			<div>
				<label for="address">用户地址：</label>
				<input name="address" id="address">
			</div>
			<div>
				<label>用户角色：</label>
				<!-- 列出所有的角色分类 -->
				<select name="userRole" id="userRole">
					<option value="1">系统管理员</option>
					<option value="2">经理</option>
					<option value="3" selected="selected">普通用户</option>
				</select>
				<font color="red"></font>
			</div>
			<div>
           		<input type="hidden" id="errorinfo" value="${uploadFileError}"/>
                <label for="a_idPicPath">证件照</label>
                <input type="file" name="attach" id="a_idPicPath"/>
                 <font color="red"></font>
            </div>
			<div class="providerAddBtn">
				<input type="submit" name="add" id="add" value="保存">
				<input type="reset" id="back" name="back" value="返回">
			</div>
		</form>
		<%-- <fm:form method="post" modelAttribute="user">
			 <fm:errors path="userCode"/><br/>
			用户编码:<fm:input path="userCode"/><br/>
			<fm:errors path="userName"/><br/>
			用户名称:<fm:input path="userName"/><br/>
			<fm:errors path="userPassword"/><br/>
			用户密码:<fm:input path="userPassword"/><br/>
			确认密码:<fm:input path=""/><br/>
			<fm:errors path="birthday"/><br/>
			用户生日:<fm:input path="birthday" Class="Wdate" readonly="readonly" onclick="WdatePicker();"/><br/>
			用户地址:<fm:input path="address"/><br/>
			联系电话:<fm:input path="phone"/><br/>
			用户角色:
			<fm:radiobutton path="userRole" value="1"/>系统管理员
			<fm:radiobutton path="userRole" value="2"/>经理
			<fm:radiobutton path="userRole" value="3" checked="checked"/>普通用户
			<br/>
			<div>
           		<input type="hidden" id="errorinfo" value="${photo}"/>
                <label for="a_idPicPath">证件照</label>
                <input type="file" name="photo" id="a_idPicPath"/>
                 <font color="red"></font>
            </div>
			<input type="submit" value="保存"/>
		</fm:form> --%>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>