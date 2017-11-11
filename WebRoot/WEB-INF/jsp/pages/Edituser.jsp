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
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bodycss.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
   td.text{ text-align:right;color:red;height:60px;}
   table{border-size:1px;height:240px;width:400px;}
   div.top{margin:100px;}
   </style>
   <script type="text/javascript">
   function validata(pwd)
   {
       var pass=document.formshow.old_passwd;
       var pass1=document.formshow.new_passwd;
       var pass2=document.formshow.rep_passwd;
       var message=document.getElementById("mess");
       var n=0;
        if(pass.value!=pwd)
	   {
	   	  pass.style.borderColor="red";
          message.innerHTML="原密码输入错误";
          pass.focus();
          return false;
	   }  
       if(pass.value!=""&&pass1.value!=""&&pass2.value!="")
       {
       
               if(pass1.value.length<6||pass1.value.length>17)
		       {
		          pass1.style.borderColor="red";
		          message.innerHTML="密码不符合规范<br/>长度应大于6位,小于17位";
		          n=1;
                  pass1.focus();
		       }
		       else if(pass1.value==pass2.value)
		       {
		       		alert("修改成功");
		       		return true;
		       }
		       else
			   {
			   		pass2.style.borderColor="red";
			       	message.innerHTML="两次输入密码不一致";n=1;
			       	pass2.focus();
		       }
       }
       else if(pass.value=="")
       {
          pass.style.borderColor="red";
          message.innerHTML="请输入原密码";
          pass.focus();
       }
       else if(n==0)
       {
          pass.style.borderColor="green";
       }
       if(pass1.value=="")
       {
          pass1.style.borderColor="red";
         
          if(pass.value!="")
          {pass1.focus(); message.innerHTML="请设置新密码";}
       }
       else if(n==0)
       {
          pass1.style.borderColor="green";
       }
       if(pass2.value=="")
       {
          pass2.style.borderColor="red";
         
           if(pass.value!=""&&pass1.value!="")
           {pass2.focus(); message.innerHTML="请确认新密码";}
           
       }
       else if(n==0)
       {
          pass2.style.borderColor="green";
       }
        n=0;
        return false;
   }
   function mycheck(p)
   {
         var message=document.getElementById("mess");
        if(p.value!="")
        {
            p.style.borderColor="green";
            message.innerHTML="";
        }
        else
        {
            p.style.borderColor="red";
        }
   }
   </script>
  </head>
  
  <body>
  <div><hr color="#8B785F"></div>
   <div class="p_left">
  <div align="center" class="top">
    <form onSubmit="return validata('${sys.passward}');" action="editsuccess.action?pk=${sys.pkUserid}" name="formshow" method="post">
    <table>
    <tr>
    <td class="text">帐号名：</td>
    <td><input type="text" name="acount" value="<s:property value='sys.userAccount'/>" style="height=30px; border-style:solid;border-size:1px;border-color:green;width:180px;color:red" disabled="disabled" /></td>
    </tr>
   <tr>
     <td class="text">原 密 码：</td><td><input type="password" name="old_passwd" value="" style="height=30px; border-style:solid;border-size:1px;border-color:green;width:180px;" onblur="mycheck(old_passwd);"></td>
   </tr>
   <tr>
     <td class="text">新 密 码：</td><td><input type="password" name="new_passwd" value="" style="height=30px;border-style:solid;border-size:1px;border-color:green;width:180px;" onblur="mycheck(new_passwd);"></td>
   </tr>
   <tr>
     <td class="text">确认密码：</td><td><input type="password" name="rep_passwd" value="" style="height=30px;border-style:solid;border-size:1px;border-color:green;width:180px;" onblur="mycheck(rep_passwd);"></td>
   <tr> 
   <tr>
   <td colspan=2 align="center"><input type="submit" class="btn" value="确  认"/><input type="reset" value="重 置" class="btn" style="margin:0,0,0,20;"/>
   <!-- style="background-color:red;width:80px;border:0;height:30px;" -->
   </tr>
   <tr>
   <td colspan=2 align="center" height="60px"><font color="red" size=+1><div id="mess"></div></font></td>
   </tr>
   </table>
    </form>
</div>
</div>
  </body>
</html>
