<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
	<script type="text/javascript" src="js/ValidateStore.js"></script>

  </head>
  
 <body>
<form id="tea_reg" method="post" name="tea_reg">
用户名：<input name="name" type="text" id="name" size="20" maxlength="255" />
<label id="message">验证用户名</label>
</form>
<script type="text/javascript">
$(document).ready(function(){ 
    check.inintEvent(); /*方法绑定到输入框*/
}); 
$(document).ready(function(){ 
    checkcode.inintEvent(); /*方法绑定到输入框*/
}); 
</script>
</body>
</html>
