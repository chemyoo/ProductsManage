var flag=false;
var check = { 
    inintEvent: function(){ 
        $("input[name='name']").unbind("blur"); /*移动开输入框的时候就会响应，user.User_LogName为输入框的名字*/
        $("input[name='name']").bind("blur", function(){ 
        	check.checkData($(this).val()); 
        }); 
    }, 
    
    checkData:function(name){ 
    	if(name=="")
    		return;
        var parameter = { 
            name:name/*入参,为什么用这样表示,形参:实参？*/
        }; 

        $.post("checkdata.action",parameter,function(data){ /*userJSON_checkname为action的名字*/
                /*这里的参数date就是在struct.xml里面定义的参数checkresult，也即action的一个属性值*/ 
        	flag=false;
            if(data=="ok"){ 
                $("#message2").text("✔");
                $("#message2").css("color","green"); 
            }else{ 
                $("#message2").text("✘ 名称已存在");
                $("#message2").css("color","red"); 
                flag=flag||false;
            } 
            
        }); 
        
    } 
}; 
var checkcode = { 
	    inintEvent: function(){ 
	        $("input[name='code']").unbind("blur"); /*移动开输入框的时候就会响应，user.User_LogName为输入框的名字*/
	        $("input[name='code']").bind("blur", function(){ 
	        	checkcode.checkData($(this).val()); 
	        }); 
	    }, 
	    
	    checkData:function(code){ 
	    	if(code=="")
	    		return;
	        var parameter = { 
	            code:code/*入参,为什么用这样表示,形参:实参？*/
	        }; 

	        $.post("checkdatacode.action",parameter,function(data){ /*userJSON_checkname为action的名字*/
	                /*这里的参数date就是在struct.xml里面定义的参数checkresult，也即action的一个属性值*/ 
	        	flag=false;
	            if(data=="ok"){ 
	                $("#message1").text("✔");
	                $("#message1").css("color","green"); 
	            }else{ 
	                $("#message1").text("✘ 已存在该编码");
	                $("#message1").css("color","red"); 
	                flag=flag||false;
	            } 
	            
	        }); 
	        
	    } 
	}; 
function returnflag()
{
	var code=document.getElementById("code");
	var name=document.getElementById("name");
	name.style.borderColor="";
	code.style.borderColor="";
	if(code.value=="")
	{
		alert("请输入仓库编码！");
		code.style.borderColor="red";
		$("#message1").text("");
		code.focus();
		return false;
	}
	else if(name.value=="")
	{
		alert("请输入仓库名称！");
		name.style.borderColor="red";
		$("#message2").text("");
		name.focus();
		return false;
	}
	if($("#message1").text()=="✔"&&$("#message2").text()=="✔")
	{
		flag=flag||true;
	}
	return flag;
}
var account = { 
	    inintEvent: function(){ 
	        $("input[name='username']").unbind("blur"); /*移动开输入框的时候就会响应，user.User_LogName为输入框的名字*/
	        $("input[name='username']").bind("blur", function(){ 
	        	account.checkData($(this).val()); 
	        }); 
	    }, 
	    
	    checkData:function(username){ 
	    	if(username=="")
	    		return;
	        var parameter = { 
	        		username:username/*入参,为什么用这样表示,形参:实参？*/
	        }; 

	        $.post("checkaccount.action",parameter,function(data){ /*userJSON_checkname为action的名字*/
	                /*这里的参数date就是在struct.xml里面定义的参数checkresult，也即action的一个属性值*/ 
	        	flag=false;
	        	if(data=="errinput")
	        	{
	        		$("#message0").text("✘ 用户名只能由数字字母组成！");
	                $("#message0").css("color","red"); 
	                flag=flag||false;
	        	}
	        	else if(data=="ok"){ 
	                $("#message0").text("✔");
	                $("#message0").css("color","green"); 
	            }else{ 
	                $("#message0").text("✘ 名称已存在");
	                $("#message0").css("color","red"); 
	                flag=flag||false;
	            } 
	            
	        }); 
	        
	    } 
	}; 