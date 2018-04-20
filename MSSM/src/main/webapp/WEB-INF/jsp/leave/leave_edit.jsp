<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="${css}/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${js}/common.js"></script>
<script type="text/javascript" src="${js}/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${js}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function submitLeave(){
		if(!confirm('确定提交请假申请吗')) return;
		$("form[name=leaveForm]").submit();	
	}
	$(function() {
		var leaveType=$("#leaveType");
		var startTime;
		var endTime;
		var reason=$("#reason").val();
		leaveType.click(function(){
			startTime=$("#startTime").val();
			endTime=$("#endTime").val();
			startTime=Date.parse(startTime);
			endTime=Date.parse(endTime);
			var leaveDay=(endTime-startTime)/1000/60/60/24;
			$("#leaveDay").val(leaveDay);
		});
		
		var leaveForm = $("form[name=leaveForm]");
		var b=true;
		//表单提交校验
		leaveForm.submit(function() {
			startTime=$("#startTime").val();
			endTime=$("#endTime").val();
			if(startTime==null||startTime==''){
				alert("请选择开始时间");
				b=false;
			}else if(endTime==null||endTime==''){
				alert("请选择结束时间");
				b=false;
			}else if(leaveType.val()=='请选择'){
				alert("请选择休假类型");
				b=false;
			}else if(reason==null||reason==''){
				alert("请填写事由");
				b=false;
			}
			return b;
		});
	});
</script>
</head>
<body>
	<div class="action divaction">
		<div class="t">请假申请</div>
		<div class="pages">
			<!--请假申请 区域 开始-->
			<form action="leave_edit" name="leaveForm" method="post">
				<table class="leave">
					<tr>
						<td class="width1"><label for="name">姓名:</label></td>
						<td class="width2">
							<input readonly="readonly" style="border: 0px;" value="${employee.name}"/>
							<input type="hidden" name="employeeSn" value="${employee.sn}"/>
						</td>
						<td class="width1"><label>部门:</label></td>
						<td class="width2">
							<input readonly="readonly" style="border: 0px;" value="${employee.departmentName}"/>
						</td>
       				</tr>
			        <tr>
			         <td class="width1"><label for="time">开始时间:</label></td>
			         <td class="width2"><input id="startTime" type="text" Class="Wdate" name="startTime" readonly="readonly" onclick="WdatePicker();" /></td>
			         <td class="width1"><label for="end-time">结束时间:</label></td>
			         <td class="width2"><input id="endTime" type="text" Class="Wdate" name="endTime" readonly="readonly" onclick="WdatePicker();" /></td>
			       </tr>
			        <tr>
			         <td class="width1"><label for="size">请假天数:</label></td>
			         <td class="width2"><input id="leaveDay" readonly="readonly" style="border: 0px; width: 15px;" type="text" name="leaveDay"/>(天)</td>
			         <td class="width1"><label>休假类型:</label></td>
			         <td class="width2">
			            <select id="leaveType" name="leaveType" style="width:140px;">
			            	<option>请选择</option>
			            	<c:forEach var="leaveType" items="${leaveTypes}">
			            		<option>${leaveType}</option>
			            	</c:forEach>
			            </select>
			         </td>
			       </tr>
			       <tr>
			         <td class="width1"><label>请假事由:</label></td>
			         <td colspan="3">
			          	<textarea id="reason" name="reason" class="textarea">
			          	</textarea>
			          </td>
			       </tr>
     			</table>
		      	<div class="forms ">
		          <p class="marg">
		           <input name="button" type="button"  value="提交流程" class="submit_01" onClick="submitLeave()"/>
		           <input name="" type="button"  value="取消"  class="submit_01"/>
		          </p>
		     	</div>
     		</form>
		</div>
	</div>
</body>
</html>
