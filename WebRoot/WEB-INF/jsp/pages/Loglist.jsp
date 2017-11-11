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
    
    <title>查看日志</title>
    <link rel="shortcut icon" href="image/favicon.ico" sizes="48*48" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script src="js/usermin.js"></script>
	<script src="js/myalert.js"></script>
	-->
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	

  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
   <div class="p_left">
    <form action="loglist?page=${currentPage }" method="post" ><!-- focus="login" -->
      <table border="0">
      <tbody>
        <tr>
         
          <td><b>行号</b></td>
          <td><b>登入用户</b></td>
          <td><b>操作记录</b></td>
          <td><b>删除来源</b></td>
          <td><b>时间戳</b></td>
        </tr>
        </tbody>
        <tbody>
        <s:iterator status="indexsno" value="loglist">
        <s:if test="#indexsno.odd">
        <tr bgcolor="#FFFF99">
        
          <td><b><s:property value="#indexsno.count"/></b></td>
          <td><b><s:property value="loginer" /></b></td>
          <td><b><s:property value="operationContent" /></b></td>
          <td><b><s:property value="delfrom" /></b></td>
          <td><b><s:property value="ts" /></b></td>
        </tr>
        </s:if>
        <s:else>
        <tr>
          
          <td><b><s:property value="#indexsno.count"/></b></td>
          <td><b><s:property value="loginer" /></b></td>
          <td><b><s:property value="operationContent" /></b></td>
          <td><b><s:property value="delfrom" /></b></td>
          <td><b><s:property value="ts" /></b></td>
        </s:else>
        </s:iterator>
        </tbody>
        <tbody>
        <tr>
        <td colspan="5">
      	 	 共有${total}条记录
        	    共<s:property value="totalPage"/>页    
           	 当前第<s:property value="currentPage"/>页 
            
            <s:if test="%{currentPage != 1 && total!=0}">
	           	<a href="loglist.action?page=1">首页</a>
	            <a href="loglist.action?page="+${currentPage-1}>上一页</a>
         	</s:if>
            <s:if test="%{currentPage != totalPage && total!=0}">
	         	<a href="loglist.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
	        	<a href="loglist.action?page=<s:property value="totalPage"/>">尾页</a>
            </s:if>
        </td>
        </tr>
        </tbody>
      </table>
      <input type="submit" value="刷新"/> 
    </form>
    </div>
  </body>
</html>
