var flag=false;
var check = { 
//    inintEvent: function(){ 
//        $("input[name='submit']").unbind("click mouseover"); /*移动开输入框的时候就会响应，user.User_LogName为输入框的名字*/
//        $("input[name='submit']").bind("click mouseover", function(){ 
//        	check.checkData($("input[name='account']").val(),$("input[name='passwd']").val()); 
//        }); 
//    }, 
    
    checkData:function(account,passwd){ 
    	if(account==""||passwd=="")
    		return;
        var parameter = { 
        		account:account,/*入参,为什么用这样表示,形参:实参？*/
        		passwd:passwd
        }; 

        $.post("logincheck.action",parameter,function(data){ /*userJSON_checkname为action的名字*/
                /*这里的参数date就是在struct.xml里面定义的参数checkresult，也即action的一个属性值*/
        	flag=false;
        	if(data=="fail")
        	{
        		$("#message").text("✘ 服务器无响应,	请联系管理员");
                $("#message").css("color","red"); 
                flag = flag||false;
        	}
        	else if(data=="err"){ 
            	 $("#message").text("✘ 帐号或密码错误");
                 $("#message").css("color","red"); 
                 flag = flag||false;
            }
            else if(data=="forbidden"){ 
           	 $("#message").text("✘ 该帐号已被系统禁用，请联系管理员");
             $("#message").css("color","red"); 
             flag = flag||false;
            }
            else if(data=="notavailbe")
            {
            	$("#message").text("✘ 该帐号未启用，请联系管理员");
                $("#message").css("color","red"); 
                flag = flag||false;
            }
            else { 
            	flag = flag||true; 
            } 
        	if(flag)
        	{
        		$("#submit").remove();
        		$(form1).submit();
        	}
        }); 
        
    } 
}; 
function checkdata()
{
	$("#message").text("");
   var f=document.form1;
   if(f.account.value!="")
   {
      if(f.passwd.value!="")
      {
     	  if(!(/^[0-9a-zA-Z]*$/.test(f.account.value)))
     	  { 
	     	   checkaccount();
     	  }
     	  else
     	  {
     		   check.checkData($("input[name='account']").val(),$("input[name='passwd']").val()); 
     	  }
      }
      else
      {
         alert("请填写密码...");
      }
   }
   else
   {
	   alert("请填写帐号...");
   }
}
function checkaccount()
{
	var f=document.form1;
	var m=document.getElementById("message");
	var v=f.account.value;
	if(!(/^[0-9a-zA-Z]*$/.test(v)))
	{
		m.innerHTML="<font size=+1>* </font>✘ 帐号输入错误,帐号由数字和字母(可混合组成)组成";
		f.account.focus();
	}
	else
	{
		m.innerHTML="";
	}
}