<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大青鸟办公自动化管理系统</title>
<link href="${css}/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${js}/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	//明细条数
	var rowNumber = 0;
	//总金额
	var totalAccount = 0;
	//删除明细
	function delRow(id) {
		var account = $("#account" + id).val();
		$("#myTable tr").eq(id + 1).remove();
		//var rowNumber=$("#rowNumber").val();
		for (var s = id + 1; s < rowNumber; s++) {
			$("#item" + s).attr("name", "expenseAccountDetails[" + (s - 1) + "].item");
			$("#item" + s).attr("id", "item" + (s - 1));
			$("#account" + s).attr("name", "expenseAccountDetails[" + (s - 1) + "].account");
			$("#account" + s).attr("id", "account" + (s - 1));
			$("#desc" + s).attr("name", "expenseAccountDetails[" + (s - 1) + "].desc");
			$("#desc" + s).attr("id", "desc" + (s - 1));
			var js = "delRow(" + (s - 1) + ");";
			var newclick = eval("(false||function (){" + js + "});");
			$("#DelRow" + s).unbind('click').removeAttr('onclick').click(newclick);
			$("#DelRow" + s).attr("id", "DelRow" + (s - 1));
		}
		--rowNumber;
		//计算
		var acc=totalAccount;
		totalAccount = parseFloat(totalAccount) - parseFloat(account);
		if(totalAccount.toString()=='NaN'){
			totalAccount = acc;
		}
		$("#totalAccount").attr("value", totalAccount);
	}
	//是否要提交(提交的类型)
	function submitClaimVoucher(action) {
		//取消跳出
		if (!confirm("确定" + action + "报销单吗")) {
			return;
		}
		;
		var claimForm = $("form[name='claimForm']");
		var status = $("#status");
		if (action == '保存') {
			status.val("新创建");
		} else {
			status.val("已提交");
		}
		claimForm.submit();
	}

	$(function() {
		if ($("#rowNumber").value == '' || $("#rowNumber").value == null) {
			rowNumber = 0;
		} else {
			rowNumber = $("#rowNumber");
		}
		//表单提交校验
		//$("#myTable tr").eq(0).hide();
		var claimForm = $("form[name='claimForm']");
		claimForm.submit(function() {
			var b = true;
			var event = $("#event").val();
			if (rowNumber < 1) {
				$("#notices").text("* 添加报销单的明细，至少一条 ！");
				b = false;
			} else if (event == null || event == '') {
				$("#notices").text("* 事由不能为空");
				b = false;
			}
			$("#notice").text("*");
			b=false;
			for (var s = 0; s < rowNumber; s++) {
				b=true;
				$("#account" + s).next(".notice").text("*");
				$("#desc" + s).next(".notice").text("*");
				var account = $("#account" + s).val();
				var reg = /^[0-9]+(.[0-9]{1,3})?$/;
				if (reg.test(account) == false) {
					$("#notices").text("* 请规范输入(数字)!");
					b=false;
				}
				var desc = $("#desc" + s).val();
				if (desc == null || desc == '') {
					$("#notices").text("* 费用说明不能为空  !");
					b = false;
				}
			}
			$(".buttons").hide();
			return b;
		});
		//添加明细
		$("#AddRow").click(function() {
			var tr = $("#myTable tr").eq(0).clone();
			++rowNumber;
			var j = rowNumber - 1;
			var item = $("#item").val();
			var account = $("#account").val();
			var reg = /^[0-9]+(.[0-9]{1,3})?$/;
			var acc=totalAccount;
			totalAccount = parseFloat(totalAccount) + parseFloat(account);
			if(totalAccount.toString()=='NaN'){
				totalAccount = acc;
			}
			var desc = $("#desc").val();
			tr.find("td").get(0).innerHTML = "<input  name=expenseAccountDetails[" + j + "].item id=item" + j + " type=hidden value=" + item + " />" + item;
			if (reg.test(account) == false) {
				tr.find("td").get(1).innerHTML = "<input  name=expenseAccountDetails[" + j + "].account id=account" + j + " type=hidden value=" + account + " /><span class=notice>请规范输入(数字)</span>";
			}else if(account==''||account==null){
				tr.find("td").get(1).innerHTML = "<input  name=expenseAccountDetails[" + j + "].account id=account" + j + " type=hidden value=" + account + " /><span class=notice>项目金额不能为空</span>";
			} else {
				tr.find("td").get(1).innerHTML = "<input  name=expenseAccountDetails[" + j + "].account id=account" + j + "  type=hidden value=" + account + " />" + account;
			}
			if (desc == '') {
				tr.find("td").get(2).innerHTML = "<input  name=expenseAccountDetails[" + j + "].desc  id=desc" + j + " type=hidden value=" + desc + " /><span class=notice>费用说明不能为空</span>";
			} else {
				tr.find("td").get(2).innerHTML = "<input  name=expenseAccountDetails[" + j + "].desc  id=desc" + j + " type=hidden value=" + desc + " />" + desc;
			}
			tr.find("td").get(3).innerHTML = "<input type=button name=DelRow" + j + " id=DelRow" + j + " onclick=delRow(" + j + ") value=" + '删除' + " />";
			tr.find("td").get(3).innerHTML = "<img src=${images}/delete.gif width=16 height=16 id=DelRow" + j + " onclick=delRow(" + j + ") />";
			tr.show();
			tr.appendTo("#myTable");
			//总金额
			$("#totalAccount").attr("value", totalAccount);
			$("#account").attr("value", "");
			$("#desc").attr("value", "");
		});
	});
</script>
</head>
<body>
	<div class="action  divaction">
		<div class="t">报销单添加</div>
		<div class="pages">
			<form action="expenseaccount_edit" name="claimForm" method="post">
				<input type="hidden" id="rowNumber" name="rowNumber" value="" />
				<table width="90%" border="0" cellspacing="0" cellpadding="0"
					class="addform-base">
					<tr>
						<td>*填报人：</td>
						<td><input type="hidden" name="createSn" value="${createSn}" />
							<input type="text" style="border: 0px" name="createName"
							value="${createName}" /></td>
						<td>*填报时间：</td>
						<td><input type="text" name="createTime" readonly="readonly"
							style="border: 0px"
							value="<fmt:formatDate value="${createTime}"/>" /></td>
					</tr>
					<tr>
						<td>*总金额：￥</td>
						<td><input type="text" id="totalAccount" name="toatlAccount"
							readonly="readonly" style="border: 0px" /></td>
						<td>*状态：</td>
						<td><input type="text" id="status" name="status" value="新创建"
							readonly="readonly" style="border: 0px" /></td>
					</tr>
					<tr>
						<td colspan="4"><span class="notice" id="notices">*</span></td>
					</tr>
				</table>
				<table id="myTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<tr>
						<td width="30%">项目类别</td>
						<td width="30%">项目金额</td>
						<td width="30%">费用说明</td>
						<td width="10%">操作</td>
					</tr>
				</table>
				<table id="detailTable" width="90%" border="0" cellspacing="0"
					cellpadding="0" class="addform-base">
					<tr>
						<td width="30%"><select name="item" id="item">
								<option value="城际交通费">城际交通费</option>
								<option value="市内交通费">市内交通费</option>
								<option value="通讯费">通讯费</option>
								<option value="礼品费">礼品费</option>
								<option value="办公费">办公费</option>
								<option value="交际餐费">交际餐费</option>
								<option value="餐补">餐补</option>
								<option value="住宿费">住宿费</option>
						</select></td>
						<td width="30%"><input type="text" name="account"
							id="account" /><span class='notice'>*</span></td>
						<td width="30%"><input type="text" name="desc" id="desc" /><span
							class='notice'>*</span></td>
						<td width="10%"><img src="${images}/add.gif" width="16"
							height="16" id="AddRow" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>*事由：</td>
						<td colspan="3"><textarea rows="5" cols="66" name="event"
								id="event"></textarea></td>
					</tr>
					<tr align="center" colspan="4">
						<td>&nbsp;</td>
						<td><input type="button" id="1" name="1" value="保存"
							onclick="submitClaimVoucher('保存')" class="submit_01" /> <input
							type="button" id="2" name="2" value="提交" class="submit_01"
							onclick="submitClaimVoucher('提交')" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
