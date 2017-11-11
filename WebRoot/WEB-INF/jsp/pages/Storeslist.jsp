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
    
    <title>仓库信息</title>
    <link rel="shortcut icon" href="image/favicon.ico" sizes="48*48" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/usermin.js"></script>
  </head>
  
  <body>
   <div align="center"><hr color="#8B785F"></div>
    <div class="p_left">
    <form action="storelist.action?page=${currentPage }" method="post">
    	<table>
    		<tbody>
	    		<tr>
		    		<td><b><input type="checkbox" id="all" onclick="selectall();"  style="cursor:hand;" title="全选/全消"/></b></td>
	  				<td><b>行号</b></td>
	  				<td><b>仓库编码</b></td>
	  				<td><b>仓库名称</b></td>
	    		</tr>
    		</tbody>
    		<tbody>
    		<s:iterator status="indexsno" value="storelist">
    			<s:if test="#indexsno.odd">
    			<tr bgcolor="#FFFF99">
    				<td><b><input type="checkbox" name="pk_id" value="${pkStore}" style="cursor:hand;" title="选择"/></b></td>
    				<td><b><s:property value="#indexsno.count"/></b></td>
    				<td><b><s:property value="storeid" /></b></td>
					<td><b><s:property value="storename" /></b></td>
    			</tr>
    			</s:if>
    			<s:else>
    			<tr>
    				<td><b><input type="checkbox" name="pk_id" value="${pkStore}" style="cursor:hand;" title="选择"/></b></td>
    				<td><b><s:property value="#indexsno.count"/></b></td>
    				<td><b><s:property value="storeid" /></b></td>
					<td><b><s:property value="storename" /></b></td>
    			</tr>
    			</s:else>
    		</s:iterator>
    		</tbody>
    		<tbody>
        <tr>
        <td colspan="4">
      	 	 共有${total}条记录
        	    共<s:property value="totalPage"/>页    
           	 当前第<s:property value="currentPage"/>页 
            
            <s:if test="%{currentPage != 1 && total!=0}">
	           	<a href="storelist.action?page=1">首页</a>
	            <a href="storelist.action?page="+${currentPage-1}>上一页</a>
         	</s:if>
            <s:if test="%{currentPage != totalPage && total!=0}">
	         	<a href="storelist.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
	        	<a href="storelist.action?page=<s:property value="totalPage"/>">尾页</a>
            </s:if>
        </td>
        </tr>
        </tbody>
   		</table>
   		<input class="btn" type="button" value="添加" onclick="addstore();"/>
   		<input class="btn" type="button" value="删除" onclick="delstore();"/>
   		<input class="btn" type="submit" value="刷新" />
	</form>
	</div>
  </body>
</html>
