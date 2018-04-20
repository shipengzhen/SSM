<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${css}/bootstrap.css" />
<script src="${js}/jquery-1.12.4.js" type="text/javascript"
	charset="utf-8"></script>
<title>信息管理系统</title>
<style type="text/css">
.row {
	border: 1px red solid;
}

.row>div {
	border: 1px red solid;
	height: 30px;
}
</style>
<script type="text/javascript">
$(function(){
	$("input[name=stdNum]").blur(function(){
		var stdNum=$("input[name=stdNum]").val();
		$.ajax({
			type:"get",
			url:"dostdnum",
			data:{"stdNum":stdNum},
			dataType:"json",
			success:function(data){
				if(data.result=="no"){
					alert("已存在");
				}else{
					alert("可以使用");
				}	
			},
			error:function(){
				alert("类型获取失败！");
			}
		});
	});
});
</script>
<c:if test="${uploadFileError!=null}">
	<script type="text/javascript">
		alert(${uploadFileError});
	</script>
</c:if>
</head>
<body>
	<form id="form" action="standard_add" method="post" enctype="multipart/form-data">
		<div class="container">
			<h1>增加标准信息</h1>
			<div class="row">
				<div class="col-md-6">标准号:</div>
				<div class="col-md-6">
					<input type="hidden" name="id" value="${standard.id}">
					<input type="text" name="stdNum" value="${standard.stdNum}" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">中文名称:</div>
				<div class="col-md-6">
					<input type="text" name="zhname" value="${standard.zhname}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">版本:</div>
				<div class="col-md-6">
					<input type="text" name="version" value="${standard.version}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">关键字/词:</div>
				<div class="col-md-6">
					<input type="text" name="keys" value="${standard.keys}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">发布日期(yyyy-MM-dd):</div>
				<div class="col-md-6">
					<input type="date" name="releaseDate" value="<fmt:formatDate value="${standard.releaseDate}"/>" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">实施日期(yyyy-MM-dd):</div>
				<div class="col-md-6">
					<input type="date" name="implDate" value="<fmt:formatDate value="${standard.implDate}"/>"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">附件:</div>
				<div class="col-md-6">
					<input type="file" name="attach" value="${standard.packagePath}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<button type="submit">保存</button>
					<button type="reset">重置</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>