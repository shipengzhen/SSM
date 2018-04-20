<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
		$(function(){
			$("#go").click(function(){
				var currentPageNo=$("input[name=currentPageNo]").val();
				var url="${pageContext.request.contextPath }/user/userPaging?userName=${userName}&userRole=${userRole}&currentPageNo="+currentPageNo;//服务器端URL地址，name为用户名文本框获取的值
				location.href=url;
			});
		});
	</script>
<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${totalCount}条记录&nbsp;&nbsp;${currentPageNo}/${totalPageCount}页</li>
				<c:if test="${currentPageNo>1}">
					<a href="${pageContext.request.contextPath }/user/userPaging?userName=${userName}&userRole=${userRole}&currentPageNo=1">首页</a>
					<a href="${pageContext.request.contextPath }/user/userPaging?userName=${userName}&userRole=${userRole}&currentPageNo=${currentPageNo-1}">上一页</a>
				</c:if>
				<c:if test="${currentPageNo<totalPageCount}">
					<a href="${pageContext.request.contextPath }/user/userPaging?userName=${userName}&userRole=${userRole}&currentPageNo=${currentPageNo+1}">下一页</a>
					<a href="${pageContext.request.contextPath }/user/userPaging?userName=${userName}&userRole=${userRole}&currentPageNo=${totalPageCount}">尾页</a>
				</c:if>
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="currentPageNo" id="inputPage" class="page-key" />页
	     <button id="go" type="button" class="page-btn" >GO</button>
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/rollpage.js"></script>
</html>