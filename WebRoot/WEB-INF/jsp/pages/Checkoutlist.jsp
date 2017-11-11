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
    
    <title>Checkout</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/usermin.js"></script>
	<script type="text/javascript" src="js/opration.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>

  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
   <div class="p_left">
   <form action="checkoutlist?page=${currentPage}" method="post">
    	<table>
    		<tbody>
	    		<tr>
		    		<td><b><input type="checkbox" id="all" style="cursor:hand;" title="该页面不支持"/></b></td>
	  				<td><b>行号</b></td>
	  				<td><b>商品编码</b></td>
	  				<td><b>商品名称</b></td>
	  				<td><b>商品属性</b></td>
	  				<td><b>生产地址</b></td>
	  				<td><b>出库仓库</b></td>
	  				<td><b>数量</b></td>
	  				<td><b>仓库区域</b></td>
	  				<td><b>状态</b></td>
	  				<td><b>出库日期</b></td>
	    		</tr>
    		</tbody>
    		<tbody>
    		<s:iterator status="indexsno" value="checkoutlist">
    			<s:if test="#indexsno.odd">
    			<tr bgcolor="#FFFF99">
    				<td><b><input type="checkbox" name="pk_id" value="${pkOut}" style="cursor:hand;" title="选择"/></b></td>
    				<td><b><s:property value="#indexsno.count"/></b></td>
    				<td><b><s:property value="codes" /></b></td>
					<td><b><s:property value="names" /></b></td>
					<td><b><s:property value="proAttribute" /></b></td>
					<td><b><s:property value="proAddress" /></b></td>
					<td><b><s:property value="stores.storename" /></b></td>
					<td><b><s:property value="checkoutNum" /></b></td>
					<td><b><s:property value="areaStore.areaname" /></b></td>
					<td><b><s:property value="status" /></b></td>
					<td><b><s:property value="outstoreDate" /></b></td>
    			</tr>
    			</s:if>
    			<s:else>
    			<tr>
    				<td><b><input type="checkbox" name="pk_id" value="${pkOut}" style="cursor:hand;" title="选择"/></b></td>
    				<td><b><s:property value="#indexsno.count"/></b></td>
    				<td><b><s:property value="codes" /></b></td>
					<td><b><s:property value="names" /></b></td>
					<td><b><s:property value="proAttribute" /></b></td>
					<td><b><s:property value="proAddress" /></b></td>
					<td><b><s:property value="stores.storename" /></b></td>
					<td><b><s:property value="checkoutNum" /></b></td>
					<td><b><s:property value="areaStore.areaname" /></b></td>
					<td><b><s:property value="status" /></b></td>
					<td><b><s:property value="outstoreDate" /></b></td>
    			</tr>
    			</s:else>
    		</s:iterator>
    		</tbody>
    		<tbody>
        <tr>
        <td colspan="11">
      	 	 共有${total}条记录
        	    共<s:property value="totalPage"/>页    
           	 当前第<s:property value="currentPage"/>页 
            
            <s:if test="%{currentPage != 1&& total!=0}">
	           	<a href="checkoutlist?page=1">首页</a>
	            <a href="checkoutlist?page="+${currentPage-1}>上一页</a>
         	</s:if>
            <s:if test="%{currentPage != totalPage&& total!=0}">
	         	<a href="checkoutlist?page=<s:property value="%{currentPage+1}"/>">下一页</a>
	        	<a href="checkoutlist?page=<s:property value="totalPage"/>">尾页</a>
            </s:if>
        </td>
        </tr>
        </tbody>
   		</table>
   		<input class="btn" type="button" value="添加" onclick="addcheckout();"/><input class="btn" type="button" value="确认" onclick="checkout();"/><input class="btn" type="submit" value="刷新"/>
	</form>
	</div>
  </body>
</html>
