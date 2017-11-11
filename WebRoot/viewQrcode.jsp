<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>viewQrcode.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
	<script type="text/javascript">
	function GetQueryString(name)
	{
	 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	 var r = window.location.search.substr(1).match(reg);
	 if(r!=null)
	 {
	 	return unescape(r[2]); 
	 }
	 return null;
	}

	function showQrCode()
	{
		var path=GetQueryString("path");
		var img=document.getElementById("img");
		img.innerHTML='<img src="'+path+'" height="300" width="300" />';
	}
 
	</script>
  </head>
  
  <body onload="showQrCode();">
	   <div id="img">
	   </div>
  </body>
</html>
