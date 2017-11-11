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
    
    <title>添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
  </head>
  
  <script type="text/javascript" src="js/laydate/laydate.js"></script>
  <script type="text/javascript">
  function validata()
  {
	  var code=document.getElementById("pcode").value.trim();
	  var name=document.getElementById("pname").value.trim();
	  var selecttion=document.getElementById("selection").value;
	  var store=document.getElementById("pstore").value;
	  var num=document.getElementById("pnum").value.trim();
	  var area=document.getElementById("parea").value;
	  var cal=document.getElementById("Calendar").value.trim();
	  if(code==""||""==name||store==""||""==num||area==""||""==cal)
	  		alert("除生产地址外，其它都必须填写");
	  else if(selecttion==-1)
	  	 alert("请选择商品属性");
	  else if(store==-1)
	  	alert("请选择仓库");
	  else if(area==-1)
	  	alert("请选择仓库区域");
	  else if(isNaN(num))
	  	alert("数量填写错误");
	  else 
	     return true;
	  return false;
  }
  </script>
  
<body>
<div><hr color="#8B785F"></div>
 <div class="p_left">
<form action="addproduct.action" onsubmit="return validata();" method="post">
	<table>
    	<tr>
        	<td>商品编码：</td><td><input type="text" name="code" id="pcode"/></td><td>商品名称：</td><td><input type="text" id="pname" name="name"/></td>
            
        </tr>
        <tr>
        	<td>商品属性：</td>
            <td>
            	<select width="160" height="30" id="selection" name="select" >
            		 <option value="-1" selected="selected">请选择商品属性</option>
               		 <option value="0">易潮湿</option>
                     <option value="1">贵重品</option>
                     <option value="2">易碎品</option>
                     <option value="3">易燃品</option>
                     <option value="4">危险品</option>
                     <option value="5">易爆炸</option>
                     <option value="6">毒性物品</option>
                </select>
            </td>
            <td>生产地址:</td><td><input type="text" name="address"/></td>
        </tr>
        <tr>
        	<td>仓库:
        	<td><s:select theme="simple" size="1" title="仓库" cssStyle="width:150px;overflow-y:auto" list="storelist" headerKey="-1" headerValue="请选择..." required="true" listValue="storename" listKey="pkStore" name="store" id="pstore" value="pkStore"/></td>
            <td>数量:</td><td><input type="text" name="num" id="pnum"/></td>
        </tr>
        <tr>
        	<td>仓库区域:</td>
        	<td><s:select theme="simple" title="仓库区域" cssStyle="width:150px;overflow-y:auto" list="arealist" headerKey="-1" headerValue="请选择..." required="true" listValue="areaname" listKey="areaid" name="area" id="parea" value="areaid"/></td>
            <td>最后入库日期:</td><td><input type="text" style="width:153px" class="laydate-icon span1-1" id="Calendar" name="intodate"/></td>
        </tr>
        <tr>
        	<td  colspan="2" align="right"><input class="btn" type="submit" value="提交"/></td>
        	<td  colspan="2" align="left"><input class="btn" type="reset" value="重置"/></td>
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