<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
	</head>
	<body>
		<div class="right" style="background: #FFFFFF;">
			<div class="location">
				<strong>你现在所在的位置是:</strong>
				<span>供应商管理页面 >> 供应商添加页面</span>
			</div>
			<div class="providerAdd">
				<%-- <fm:form method="post" modelAttribute="provider">
					<div>
						<label for="proCode">供应商编码：</label>
						<fm:input path="proCode" />
						<fm:errors path="proCode" style="color:red" />
					</div>
					<div>
						<label for="proName">供应商名称：</label>
						<fm:input path="proName" />
						<fm:errors path="proName" style="color:red" />
					</div>
					<div>
						<label for="proContact">联系人：</label>
						<fm:input path="proContact" />
						<fm:errors path="proContact" style="color:red" />

					</div>
					<div>
						<label for="proPhone">联系电话：</label>
						<fm:input path="proPhone" />
						<fm:errors path="proPhone" style="color:red" />
					</div>
					<div>
						<label for="proAddress">联系地址：</label>
						<fm:input path="proAddress" />
					</div>
					<div>
						<label for="proFax">传真：</label>
						<fm:input path="proFax" />
					</div>
					<div>
						<label for="proDesc">描述：</label>
						<fm:input path="proDesc" />
					</div>
					<div class="providerAddBtn">
						<input type="submit" value="保存">
						<input type="button" id="back" name="back" value="返回">
					</div>
				</fm:form> --%>
				<form id="providerForm" name="providerForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/provider/addProvider.html">
					<input type="hidden" name="method" value="add">
					<!--div的class 为error是验证错误，ok是验证成功-->
					<div class="">
						<label for="proCode">供应商编码：</label>
						<input type="text" name="proCode" id="proCode" value="">
						<!-- 放置提示信息 -->
						<font color="red"></font>
					</div>
					<div>
						<label for="proName">供应商名称：</label>
						<input type="text" name="proName" id="proName" value="">
						<font color="red"></font>
					</div>
					<div>
						<label for="proContact">联系人：</label>
						<input type="text" name="proContact" id="proContact" value="">
						<font color="red"></font>

					</div>
					<div>
						<label for="proPhone">联系电话：</label>
						<input type="text" name="proPhone" id="proPhone" value="">
						<font color="red"></font>
					</div>
					<div>
						<label for="proAddress">联系地址：</label>
						<input type="text" name="proAddress" id="proAddress" value="">
					</div>
					<div>
						<label for="proFax">传真：</label>
						<input type="text" name="proFax" id="proFax" value="">
					</div>
					<div>
						<label for="proDesc">描述：</label>
						<input type="text" name="proDesc" id="proDesc" value="">
					</div>
					<div>
						<label for="a_companyLicPicPath">企业营业执照：</label>
						<input type="file" name="attachs" id="a_companyLicPicPath" />
						${uploadFileError}
						<font color="red"></font>
					</div>
					<div>
						<label for="a_orgCodePicPath">组织机构代码证：</label>
						<input type="file" name="attachs" id="a_orgCodePicPath" />
						${uploadOcError}
						<font color="red"></font>
					</div>
					<div class="providerAddBtn">
						<input type="submit" name="add" id="add" value="保存">
						<input type="reset" id="back" name="back" value="返回">
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/common.js"></script>
	</body>
</html>