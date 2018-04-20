<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="top">
	<div class="global-width">
		<img src="${images}/logo.gif" class="logo" />
	</div>
</div>

<div class="status">
	<div class="global-width">
		<span class="usertype">【登录角色：${employee.positionNameCn}】</span>${employee.name}你好！欢迎访问青鸟办公管理系统！
		<a href="${path}/dropout">退出</a>
	</div>
</div>
