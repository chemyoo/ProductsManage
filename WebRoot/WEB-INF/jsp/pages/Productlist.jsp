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
    <title>商品信息</title>
    <link rel="shortcut icon" href="image/favicon.ico" sizes="48*48" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/showdiag.css">
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>

	<script src="js/usermin.js"></script>
	<script src="js/myalert.js"></script>
	<script src="js/opration.js"></script>
	<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
	<script src="js/showDiag.js"></script>
 
  </head>
  
  <body>
   <div align="center"><hr color="#8B785F"></div>
    <div class="p_left">
    <form action="productlist.action?page=${currentPage}" method="post">
    	<table>
    		<tbody>
	    		<tr>
		    		<td><b><input type="checkbox" id="all" onclick="selectall();"  style="cursor:hand;" title="全选/全消"/></b></td>
	  				<td><b>行号</b></td>
	  				<td><b>商品编码</b></td>
	  				<td><b>商品名称</b></td>
	  				<td><b>商品属性</b></td>
	  				<td><b>生产地址</b></td>
	  				<td><b>仓库</b></td>
	  				<td><b>数量</b></td>
	  				<td><b>仓库区域</b></td>
	  				<td><b>最后入库日期</b></td>
	  				<td><b>二维码</b></td>
	    		</tr>
    		</tbody>
    		<tbody>
    			<s:iterator status="indexsno" value="productlist">
    				<s:if test="#indexsno.odd">
  						<tr bgcolor="#FFFF99">
  							<td><input type="checkbox" name="pk_id" value="${pkPro}" style="cursor:hand;" title="选择"/></td>
  							<td><b><s:property value="#indexsno.count"/></b></td>
  							<td><b><s:property value="codes" /></b></td>
  							<td><b><s:property value="names" /></b></td>
  							<td><b><s:property value="proAttribute" /></b></td>
  							<td><b><s:property value="proAddress" /></b></td>
  							<td><b><s:property value="stores.storename" /></b></td>
  							<td><b><s:property value="totalnum" /></b></td>
  							<td><b><s:property value="areaStore.areaname" /></b></td>
  							<td><b><s:property value="instoreDate" /></b></td>
  							<s:if test="%{qrCode!=null}">
  							<td><b><a href="javascript:showBg(${indexsno.count});" onMouseMove="c$.mmove(this,'<%=basePath%>${qrCode}');" onMouseOut="c$.mout();">查看二维码</a>
  									<div id="fullbg" name="bg${indexsno.count}"></div> 
									<div id="dialog" name="dg${indexsno.count}"> 
									<p class="close"><span onclick="closeBg();" style="cursor:pointer;" title="关闭"><font color="red">关闭</font></span></p> 
									<div><img src="${qrCode}"  height="300" width="300"></img></div> 
									</div>
  								</b></td>
  							</s:if>
  							<s:else>
  							<td><b><a href="toQrCode.action?pk=${pkPro}">生成二维码</a></b></td>
  							</s:else>
  						</tr>
  					</s:if>
  					<s:else>
  						<tr>
  							<td><input type="checkbox" name="pk_id" value="${pkPro}" style="cursor:hand;" title="选择"/></td>
  							<td><b><s:property value="#indexsno.count"/></b></td>
  							<td><b><s:property value="codes" /></b></td>
  							<td><b><s:property value="names" /></b></td>
  							<td><b><s:property value="proAttribute" /></b></td>
  							<td><b><s:property value="proAddress" /></b></td>
  							<td><b><s:property value="stores.storename" /></b></td>
  							<td><b><s:property value="totalnum" /></b></td>
  							<td><b><s:property value="areaStore.areaname" /></b></td>
  							<td><b><s:property value="instoreDate" /></b></td>
  							<s:if test="%{qrCode!=null}">
  							<td><b><a href="javascript:showBg(${indexsno.count});" onMouseMove="c$.mmove(this,'<%=basePath%>${qrCode}');" onMouseOut="c$.mout();">查看二维码</a>
  									<div id="fullbg" name="bg${indexsno.count}"></div> 
									<div id="dialog" name="dg${indexsno.count}"> 
									<p class="close"><span onclick="closeBg();" style="cursor:pointer;" title="关闭"><font color="red">关闭</font></span></p> 
									<div><img src='<%=basePath%>${qrCode}' height="300" width="300"></div> 
									</div>
  								</b></td>
  							</s:if>
  							<s:else>
  							<td><b><a href="toQrCode.action?pk=${pkPro}">生成二维码</a></b></td>
  							</s:else>
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
	           	<a href="productlist.action?page=1">首页</a>
	            <a href="productlist.action?page="+${currentPage-1}>上一页</a>
         	</s:if>
            <s:if test="%{currentPage != totalPage&& total!=0}">
	         	<a href="productlist.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
	        	<a href="productlist.action?page=<s:property value="totalPage"/>">尾页</a>
            </s:if>
        </td>
        </tr>
        </tbody>
    	</table>
    	<input class="btn" type="button" value="添加商品" onclick="opration(0);"/>
    	<input class="btn" type="button" value="修改" onclick="opration(2);"/>
    	<input class="btn" type="button" value="删除" onclick="opration(1);"/>
    	<input class="btn" type="submit" value="刷新" />
    </form>
    </div>
  </body>
</html>
