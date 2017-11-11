<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>head</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/layout.css">
    <style type="text/css">
    .head{float:right;top:20px;display:inline-block;right:20px; color:#E5E2C9}
    a:link{color:#8B785F;}
    a:visited{color:#8B785F;}
    a:hover{color:black;}
    a:active{color:black;}
    </style>

  </head>
 <body>
 <div><hr color="#8B785F"></div>
  <div class="wrapper col1">
	  <div id="header">
		    <div id="logo">
		      <h1>商品管理系统</h1>
		    </div>
		    <div class="fl_right">
		      <ul>
		        <li class="last">账号:${session['user']}</li>
		        <li ><a title="注销登入" href="logout" target="_top">? 注销</a></li>
		      </ul>
		    </div>
	  </div>
</div>
</body>
</html>
