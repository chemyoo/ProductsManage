<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提示页面</title>
    
    <link rel="shortcut icon" href="image/favicon.ico" sizes="48*48" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	<script type="text/javascript" src="js/myalert.js"></script>
	<script type="text/javascript">
	function show(name,pass)
	{
		myalert("用户名："+name+"<br>默认密码："+pass);
	}
	</script>
  </head>
  		
  <body onload="show('${name}','${pass}')">
  <div align="center"><hr color="#8B785F"><a href="sysuserlist.action">返回用户列表</a></div>
  
  </body>
</html>
