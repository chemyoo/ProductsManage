<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EditProduct.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	<script type="text/javascript" src="js/laydate/laydate.js"></script>
  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
   <div class="p_left">
     <form action="SaveEditProduct.action" method="post">
     <input type="hidden" name="pk" value="${product.pkPro}"/> 
     	<table>
     		<tr>
     			<td>商品编码:</td><td><input type="text" name="code" value="<s:property value='product.codes'/>" disabled=disabled/></td>
     			<td>商品名称:</td><td><input type="text" name="name" value="<s:property value='product.names'/>"/></td>
     		</tr>
     		<tr>
     			<td>商品属性:</td><td><input type="text" name="Attribute" value="<s:property value='product.proAttribute'/>"/></td>
     			<td>生产地址:</td><td><input type="text" name="Address" value="<s:property value='product.proAddress'/>"/></td>
     		</tr>
     		<tr>
     			<td>仓库:</td>
     			<td>
     				<s:select theme="simple" size="1" title="仓库" cssStyle="width:150px;overflow-y:auto" list="storelist"  required="true" listValue="storename" listKey="pkStore" name="store" id="pstore" value="%{product.stores.pkStore}"/>
     			</td>
     			<td>数量:</td><td><input type="text" name="totalnum" value="<s:property value='product.totalnum'/>" readonly="readonly"/></td>
     		</tr>
     		<tr>
     			<td>仓库区域:</td>
     			<td>
     				<s:select theme="simple" size="1" title="仓库区域" cssStyle="width:150px;overflow-y:auto" list="arealist"  required="true" listValue="areaname" listKey="areaid" name="area" id="parea" value="%{product.areaStore.areaid}"/>
     			</td>
     			<!--  input type="text" value="<s:property value='product.areaStore.areaname'/>"/>-->
     			<td>最后入库日期:</td><td>
     			<input type="text" style="width:153px" class="laydate-icon span1-1" id="Calendar" name="intodate" value="<s:property value='product.instoreDate'/>"/>
     			</td>
     		</tr>
     		<tr height="30">
     		</tr>
     		<tr>
     			<td colspan="4">
     				<input class="btn" type="submit" value="确定"/>
     				<input class="btn" type="reset" value="取消"/>
     			</td>
     		</tr>
     	</table>
     </form>
     </div>
     <script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}(); 
</script>
  </body>
</html>
