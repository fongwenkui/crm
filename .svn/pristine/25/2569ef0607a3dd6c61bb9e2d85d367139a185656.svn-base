<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#linkMan==null?'添加':'编辑'" />联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
function submitForm(){
	if($("#cust_id").val()==""){
		var cust_name=$("#cust_name").val();
		var id="";
		$.ajax({
			url:"${pageContext.request.contextPath}/CustomerAction_getIdByName",
			data:{"param_name":cust_name},
			success:function(data){
				document.getElementById("cust_id").value=data["cust_id"];
				//$("#cust_id").val(data["cust_id"]);
				
			},
			dataType:"json",
			type:"POST",
			async: false
		});
	}
	$("#pageForm").submit();
}
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=pageForm name=form1
		action="${pageContext.request.contextPath }/LinkManAction_add"
		method=post>
		<input type="hidden" id="lkm_id" name="lkm_id" value="<s:property value="#linkMan.lkm_id" />">
		<input type="hidden" id="cust_id" name="customer.cust_id" value="<s:property value="#linkMan.customer.cust_id" />" />

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; <s:property value="#linkMan==null?'添加':'编辑'" />联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
								<input type="text" id="cust_name" value="<s:property value="#linkMan.customer.cust_name" />" style="WIDTH: 180px"/>
								<input type="button" value="选择客户" onclick="window.open('${pageContext.request.contextPath}/CustomerAction_list?select=true','', 'width=600,height=300')" />
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2	type="text"	value="<s:property value="#linkMan.lkm_name" />"	style="WIDTH: 180px" maxLength=50 name="lkm_name">
								</td>
								<td>联系人性别：</td>
								<td>
								<input type="radio" value="1" <s:property value="#linkMan.lkm_gender=='1'?'checked':''" /> name="lkm_gender">男
								<input type="radio" value="2" <s:property value="#linkMan.lkm_gender=='1'?'':'checked'" /> name="lkm_gender">女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2 value="<s:property value="#linkMan.lkm_mobile" />"
								style="WIDTH: 180px" maxLength=50 name="lkm_phone">
								</td>
								<td>联系人手机 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2 value="<s:property value="#linkMan.lkm_phone" />"
								style="WIDTH: 180px" maxLength=50 name="lkm_mobile">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=button onclick="submitForm()"
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
