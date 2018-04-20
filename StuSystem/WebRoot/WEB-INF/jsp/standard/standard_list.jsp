<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${css}/bootstrap.css" />
<script src="${js}/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
<title>信息管理系统</title>
<script type="text/javascript">
	function page_nav(frm, num) {
		if (typeof (frm) != 'object') {
			frm = document.forms[0];
		}
		frm.currentPageNo.value = num;
		frm.submit();
	}


	$(function() {
		var sz = $(".standardId");
		//多选
		$("#standardId").change(function() {
			for (var i = 0; i < sz.length; i++) {
				sz[i].checked = this.checked;
			};
		});


		//删除
		$("#del").click(function() {
			var standardIds = new Array();
			for (var i = 0; i < sz.length; i++) {
				if (sz[i].checked == true) {
					standardIds.push(sz[i].value);
				};
			};
			location.href="standard_del?standardIds="+standardIds;
			/* $.ajax({
				type : "GET", //请求类型
				url : "standard_del", //请求的url
				//transition:true,
				data:{"standardIds":standardIds},
				dataType : "json", //ajax接口（请求url）返回的数据类型
				success : function(data) { //data：返回数据（json对象）
					alert(data);
					//location.href="standard_list";
				},
				error : function(data) { //当访问时候，404，500 等非200的错误状态码
					alert("删除失败");
				}
			}); */
		});
		//新增
		$("#add").click(function() {
			location.href="standard_add";
		});
	});
</script>
<style type="text/css">
.row {
	border: 1px red solid;
}

.row>div {
	border: 1px red solid;
	height: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<form id="form" action="standard_list" method="post">
					<input type="text" name="stdNum" value="" /> <input type="hidden"
						name="currentPageNo" value="1" /> <input type="hidden"
						name="pageSize" value="5">
					<button type="submit">提交检索</button>
					<a href="standard_add"><input type="button" value="新增标准" /></a>
					<input id="del" type="button" value="删除标准" />
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-1">
				<input type="checkbox" id="standardId" />
			</div>
			<div class="col-md-2">标准号</div>
			<div class="col-md-2">中文名称</div>
			<div class="col-md-1">版本</div>
			<div class="col-md-2">发布日期</div>
			<div class="col-md-2">实施日期</div>
			<div class="col-md-2">操作</div>
		</div>
		<c:forEach var="standard" items="${paging.list}">
			<div class="row">
				<div class="col-md-1">
					<input type="checkbox" class="standardId" value="${standard.id}" />
				</div>
				<div class="col-md-2">${standard.stdNum}</div>
				<div class="col-md-2">${standard.zhname}</div>
				<div class="col-md-1">${standard.version}</div>
				<div class="col-md-2">
					<fmt:formatDate value="${standard.releaseDate}" />
				</div>
				<div class="col-md-2">
					<fmt:formatDate value="${standard.implDate}" />
				</div>
				<div class="col-md-2">
					<a href="standard_modify?standardId=${standard.id}">修改</a>
				</div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<c:if test="${paging.currentPageNo>1}">
					<a href="javascript:page_nav(document.forms[0],1);">首页</a>
					<a
						href="javascript:page_nav(document.forms[0],${paging.currentPageNo-1});">上一页</a>
				</c:if>
				<c:if test="${paging.currentPageNo<paging.totalPageCount}">
					<a
						href="javascript:page_nav(document.forms[0],${paging.currentPageNo+1});">下一页</a>
					<a
						href="javascript:page_nav(document.forms[0],${paging.totalPageCount});">尾页</a>
				</c:if>
				&nbsp;&nbsp;第
				${paging.currentPageNo}页/共${paging.totalPageCount}页&nbsp;&nbsp;共${paging.totalCount}条记录
			</div>
		</div>
	</div>
</body>
</html>