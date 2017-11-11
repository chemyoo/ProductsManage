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
    
    <title>用户管理</title>
    <link rel="shortcut icon" href="image/favicon.ico" sizes="48*48" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/usermin.js"></script>
	<script src="js/myalert.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>

  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
 <div class="p_left">
  <form action="sysuserlist.action?page=${currentPage}" method="post">
  	<table cellspacing="0" cellpadding="0" width="100%" border="0" bordercolor="#8B785F" style="text-align:center">
  		<tbody>
  			<tr bgcolor="#CCFFCC">
  				<td><b><input type="checkbox" id="all" onclick="selectall();"  style="cursor:hand;" title="全选/全消"/></b></td>
  				<td><b>行号</b></td>
  				<td><b>帐号</b></td>
  				<td><b>密码</b></td>
  				<td><b>状态</b></td>
  				<td><b>用户角色</b></td>
  				<td><b>创建时间</b></td>
  			</tr>
  		</tbody>
  		<tbody>
  		<s:iterator status="indexsno" value="sysuserlist">
  			<s:if test="#indexsno.odd">
  			<tr bgcolor="#F4D79F">
  			<s:if test="userrole!=0">
  				<td><input type="checkbox" name="pk_id" value="${pkUserid}" style="cursor:hand;" title="选择"/></td>
  			</s:if>
  			<s:else><td style="cursor:hand;" title="预置用户,不可操作!">&nbsp;</td></s:else>
  				<td><b><s:property value="#indexsno.count"/> </b></td>
	  			<td><b><s:property value="userAccount"/></b></td>
	  			<td><b>********</b></td>
	  			<td><b><s:if test="status==1">已启用</s:if><s:elseif test="status==0">已禁用</s:elseif><s:else>未设置</s:else></b></td>
	  			<td><b><s:if test="userrole==1">普通用户</s:if><s:elseif test="userrole==0">预置用户</s:elseif></b></td>
	  			<td><b><s:property value="ts"/></b></td>
  			</tr>
  			</s:if>
  			<s:else>
  				<tr>
	  			<s:if test="userrole!=0">
  					<td><input type="checkbox" name="pk_id" value="${pkUserid}" style="cursor:hand;" title="选择"/></td>
	  			</s:if>
	  			<s:else><td style="cursor:hand;" title="预置用户,不可操作!">&nbsp;</td></s:else>
	  			<td><b><s:property value="#indexsno.count"/> </b></td>
	  			<td><b><s:property value="userAccount"/></b></td>
	  			<td><b>********</b></td>
	  			<td><b><s:if test="status==1">已启用</s:if><s:elseif test="status==0">已禁用</s:elseif><s:else>未设置</s:else></b></td>
	  			<td><b><s:if test="userrole==1">普通用户</s:if><s:elseif test="userrole==0">预置用户</s:elseif></b></td>
	  			<td><b><s:property value="ts"/></b></td>
  			</tr>
  			</s:else>
  		</s:iterator>
  		</tbody>
  	   <tbody>
        <tr>
        <td colspan="7">
      	 	 共有${total}条记录
        	    共<s:property value="totalPage"/>页    
           	 当前第<s:property value="currentPage"/>页 
            
            <s:if test="%{currentPage != 1 && total!=0}">
	           	<a href="arealist.action?page=1">首页</a>
	            <a href="arealist.action?page="+${currentPage-1}>上一页</a>
         	</s:if>
            <s:if test="%{currentPage != totalPage && total!=0}">
	         	<a href="arealist.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
	        	<a href="arealist.action?page=<s:property value="totalPage"/>">尾页</a>
            </s:if>
        </td>
        </tr>
        </tbody>
  	   
  	</table>
  	<input class="btn" type="button" value="添加" onclick="adduser();"/>
  	<input class="btn" type="button" value="删除" onclick="del();"/>
  	<input class="btn" type="button" value="启用" onclick="available();"/>
  	<input class="btn" type="button" value="禁用" onclick="forbidden();"/>
  	<input class="btn" class="btn" type="button" value="修改" onclick="edit();"/>
  	<input class="btn" type="submit" value="刷新"/>
  </form>
</div>
  </body>
</html>
