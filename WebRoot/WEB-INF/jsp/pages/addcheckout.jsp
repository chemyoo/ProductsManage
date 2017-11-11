<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addCheckin.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	 <script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
	 <script type="text/javascript" src="js/opration.js"></script>
	 <script type="text/javascript" src="js/usermin.js"></script>
	 <script type="text/javascript" src="js/laydate/laydate.js"></script>	
  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
   <div class="p_left">
    <form action="savecheckout" method="post" onsubmit="return cheakoutall();">
    	<table>
    		<tr>
    			<td>模糊查找：</td><td><input type="text" name="name"/></td><td colspan="2"><span id="message"></span></td>
    			<td><input type="hidden" name="pk" id="pk"/></td>
    		</tr>
    		<tr>
    			<td>商品名称：</td><td><select name="proname" style="width:155px;" id="proname" onchange="getdate();"></select></td>
    			<td>商品编码：</td><td><input type="text" name="procode" id="procode" disabled="disabled"/></td>
    		</tr>
    		<tr>
    			<td>商品属性：</td><td><input type="text" name="attribute" id="attribute" disabled="disabled"/></td>
    			<td>生产地址：</td><td><input type="text" name="address" id="address" disabled="disabled"/></td>
    		</tr>
    		<tr>
    			<td>仓库：</td><td><input type="text" name="store" id="store" disabled="disabled"/></td>
    			<td>仓库区域：</td><td><input type="text" name="area" id="area" disabled="disabled"/></td>
    		</tr>
    		<tr>
    			<td>添加日期：</td><td><input type="text" style="width:153px" class="laydate-icon span1-1" id="Calendar" name="intodate"/></td>
    			<td>数量：</td><td><input type="text" name="num" id="num" onblur="checknum();" onkeyup="checknum();"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" height="10px" align="center"><span id="checkresult"></span></td>
    		</tr>
    	</table>
    	<input class="btn" type="submit" value="确定" /><input class="btn" type="reset" value="取消" onmouseup="clearselectvalue()"/>
    </form>
    </div>
<script type="text/javascript">
$(document).ready(function(){ 
query.inintEvent(); /*方法绑定到输入框*/
}); 
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
}(); 
</script>
  </body>
</html>
