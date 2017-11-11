function addarea()
{
	location="addarea.action";//提交给后台执行
}
function delarea()
{
	  var conditions=document.getElementsByName("pk_id");
	  var num=0;
	  var pks=new Array();
	  for(var i=0;i<conditions.length;i++)
	  {
		  if(conditions[i].checked)
		  {
			  //alert("删除");
			  pks[num]=conditions[i].value;
			  num++;
		  }
	  //	else
	  //		alert("没有选中任何记录！");
	  }
	  if(num!=0)
	  {
		  if(confirm("确定删除这"+num+"条记录吗?"))
			  location="deletearea.action?pk_id="+pks;
	  }
	  else if(num==0) 
		  myalert("没有选中任何记录！");
}
function opration(way)
{
	if(way==0)
	{
		location="getdataTo.action";
		return false;
	}
	var conditions=document.getElementsByName("pk_id");
	var num=0;
	var pks=new Array();
	for(var i=0;i<conditions.length;i++)
	  {
		  if(conditions[i].checked)
		  {
			  //alert("删除");
			  pks[num]=conditions[i].value;
			  num++;
		  }
	  //	else
	  //		alert("没有选中任何记录！");
	  }
	if(way==1)
	{
		if(num!=0)
		  {
			  if(confirm("确定删除这"+num+"条记录吗?"))
				  location="delpro.action?pk_id="+pks;
		  }
		  else if(num==0) 
			  alert("没有选中任何记录！");
	}
	if(way==2)
	{
		if(num>1)
		 {
			for(var i=0;i<conditions.length;i++)
			  {
				 conditions[i].checked=false;
			  }
			 document.getElementById("all").checked=false;
			 alert("修改时只能选择一条数据,已清除所选记录");
			 return false;
		 }
			else if(num==0)
		 {
		 	myalert("请选择一条记录！~");
		 	return false;
		 }
			 
		 else
		 {
			 for(var i=0;i<conditions.length;i++)
			  {
				 if(conditions[i].checked)
					 location="editpro.action?pk="+conditions[i].value;
			  }
			 
		 }
	 }
}


function addcheckin()
{
	location="addcheckin.action";
}

function addcheckout()
{
	location="addcheckout.action";
}

function checkin()
{
	var conditions=document.getElementsByName("pk_id");
	var num=0;
	var pk;
	for(var i=0;i<conditions.length;i++)
	 {
		  if(conditions[i].checked)
		  {
			  //alert("删除");
			  pk=conditions[i].value;
			  num++;
		  }
	 }
	if(num==1)
	{
		location="checkinsure.action?pk="+pk;
	}
	else
		if(num==0)
		{
			alert("请选择要操作的行！");
		}
	else if(num>1)
	{
		for(var i=0;i<conditions.length;i++)
		 {
			 conditions[i].checked=false;
		 }
		alert("选择了太多行了！");
	}
}
function checkout()
{
	var conditions=document.getElementsByName("pk_id");
	var num=0;
	var pk;
	for(var i=0;i<conditions.length;i++)
	 {
		  if(conditions[i].checked)
		  {
			  //alert("删除");
			  pk=conditions[i].value;
			  num++;
		  }
	 }
	if(num==1)
	{
		location="checkoutsure.action?pk="+pk;
	}
	else
		if(num==0)
		{
			alert("请选择要操作的行！");
		}
	else if(num>1)
	{
		for(var i=0;i<conditions.length;i++)
		 {
			 conditions[i].checked=false;
		 }
		alert("选择了太多行了！");
	}
}
var arraydata=new Array();
var query = { 
	    inintEvent: function(){ 
	        $("input[name='name']").unbind("keyup keydown"); 
	        $("input[name='name']").bind("keyup keydown", function(){ 
	        	query.queryData($(this).val()); 
	        }); 
	    }, 
	    
	    queryData:function(name){ 
	    	if(name=="")
	    		return;
	        var parameter = { 
	            name:name/*入参,为什么用这样表示,形参:实参？*/
	        }; 

	        $.post("proquerylike.action",parameter,function(data){ /*userJSON_checkname为action的名字*/
	                /*这里的参数date就是在struct.xml里面定义的参数checkresult，也即action的一个属性值*/ 
	        	var arry=new Array();
	        	arraydata=arry;
	            if(data=="ZERO"){ 
	            	$("#proname").empty();
	                $("#message").text("✘ 仓库中没有找到该商品");
	                $("#message").css("color","red"); 
	                getdate();
	            }else{ 
	                $("#message").text("✔");
	                $("#message").css("color","green");
	                arry=data.split(";");
	                arraydata=arry;
	                $("#proname").empty();
	                for(var i=0;i<arry.length-1;i++)
	                {
	                	var detail=arry[i].split(",");
	                	//$("#proname").css("width","150px");
	                	//jQuery("<option></option>").attr({val:'detail[1]',text:'detail[2]'}).appendTo("#proname");
	                	 jQuery("<option value="+detail[0]+">"+detail[1]+"</option>").appendTo("#proname");
	                	 
	                }
	                getdate();
	                
	            } 
	            
	        }); 
	        
	    } 
	}; 

function getdate()
{
//	var checkIndex=$("#select_id ").get(0).selectedIndex;  //获取Select选择的索引值  
//	alert(arraydata);
	var index=$("#proname").get(0).selectedIndex;
	if(index>-1)
	{
		$("#procode").val(arraydata[index].split(",")[0]);
		$("#attribute").val(arraydata[index].split(",")[2]);
		$("#address").val(arraydata[index].split(",")[3]);
		$("#store").val(arraydata[index].split(",")[4]);
		$("#area").val(arraydata[index].split(",")[5]);
		$("#pk").val(arraydata[index].split(",")[6]);
	}
	else
	{
		$("#procode").val("");
		$("#attribute").val("");
		$("#address").val("");
		$("#store").val("");
		$("#area").val("");
		$("#pk").val("");
		$("#num").val("");
		$("#Calendar").val("");
	}
	
}
var flag=false;
function checknum()
{
	var index=$("#proname").get(0).selectedIndex;
	if(index>-1)
	{
		var num=$("#num").val();
		$("#num").css("border-style","");
		$("#num").css("border-color","");
		if(isNaN(num))
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("数量填写错误！");
			$("#num")[0].focus();
//			$("#num").focus(function(){
			$("#num").css("border-style","solid");
			$("#num").css("border-color","red");
//			});
			flag=false;
		}
		else
		{
			flag=true;
		}
	}
	else
	{
		$("#num").val("");
		flag=false;
	}
}


function cheakall()
{
	checknum();
	var index=$("#proname").get(0).selectedIndex;
	if(index<0)
	{
		$("#checkresult").css("color","red");
		$("#checkresult").text("请选择商品！");
		return false;
	}
	else if($("#Calendar").val()=="")
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("请输入添加日期！");
			return false;
		}
	else
		if($("#num").val()=="")
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("请输入正确输入数量！");
			flag=false;
		}
	return flag&&true;
}
function clearselectvalue()
{
	$("#checkresult").text("");
	$("#proname").empty();
}
$(function(){
	$(".btn").mouseup(function(){
		$(this).attr("disable","true");
	});
});

function cheakoutall()
{
	checknum();
	var index=$("#proname").get(0).selectedIndex;
	if(index<0)
	{
		$("#checkresult").css("color","red");
		$("#checkresult").text("请选择商品！");
		return false;
	}
	else if($("#Calendar").val()=="")
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("请输入添加日期！");
			return false;
		}
	else
		if($("#num").val()=="")
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("请输入正确输入数量！");
			flag=false;
		}
		else if($("#num").val()>arraydata[index].split(",")[7])
		{
			$("#checkresult").css("color","red");
			$("#checkresult").text("出库数量大于库存数量！");
			flag=false;
		}
	return flag&&true;
}