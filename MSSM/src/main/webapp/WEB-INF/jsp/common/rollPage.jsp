<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<div class="page-bar">
	<c:if test="${param.currentPageNo>1}">
		<a href="javascript:page_nav(${param.formName},1);">首页</a>  
		<a href="javascript:page_nav(${param.formName},<c:out value="${param.currentPageNo-1}"/>);">上一页</a>
	</c:if>
	<c:if test="${param.currentPageNo<param.totalPageCount}">
		<a href="javascript:page_nav(${param.formName},<c:out value="${param.currentPageNo+1}" />);">下一页</a>
		<a href="javascript:page_nav(${param.formName},<c:out value="${param.totalPageCount}"/>);">尾页</a>
	</c:if> 
	&nbsp;&nbsp;第 ${param.currentPageNo}页/共${param.totalPageCount}页&nbsp;&nbsp;共${param.totalCount}条记录
</div>