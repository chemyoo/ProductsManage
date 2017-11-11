// JavaScript Document
function del()
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
		  location="delete.action?pk_id="+pks;
  }
  else if(num==0) 
	  alert("没有选中任何记录！");
}
function forbidden()
{
  var conditions=document.getElementsByName("pk_id");
  var num=0;
  var pks=new Array();
  for(var i=0;i<conditions.length;i++)
  {
	  if(conditions[i].checked)
	  {
		  pks[num]=conditions[i].value;
		  num++;
	  }
  }
  if(num!=0)
  {
	  if(confirm("确定要禁用这"+num+"个帐号吗?"))
		  location="forbidden.action?pk_id="+pks;
  }
  else if(num==0) 
	  alert("没有选中任何记录！");
}
function available()
{
  var conditions=document.getElementsByName("pk_id");
  var num=0;
  var pks=new Array();
  for(var i=0;i<conditions.length;i++)
  {
	  if(conditions[i].checked)
	  {
		  pks[num]=conditions[i].value;
		  num++;
	  }
  }
  if(num!=0)
  {
	  if(confirm("确定要启用这"+num+"个帐号吗?"))
		  location="available.action?pk_id="+pks;
  }
  else if(num==0) 
	  alert("没有选中任何记录！");
}
function selectall()
{
	var selectall=document.getElementById("all");
	var conditions=document.getElementsByName("pk_id");
	if(selectall.checked)
	{
		 for(var i=0;i<conditions.length;i++)
		  {
			 conditions[i].checked=true;
		  }
	}
	else
	{
		for(var i=0;i<conditions.length;i++)
		  {
			 conditions[i].checked=false;
		  }
	}
}
function edit()
{
	var num=0;
	var conditions=document.getElementsByName("pk_id");
	 for(var i=0;i<conditions.length;i++)
	  {
		  if(conditions[i].checked)
		  {
			  num++;
		  }
	  }
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
				 location="edituser.action?pk="+conditions[i].value;
		  }
		 
	 }
}
function adduser()
{
	location="/ProductsManage/Addsys_user.htm";
}
function addstore()//添加仓库
{
	location="/ProductsManage/AddStore.html";
}
function editstore()//修改仓库
{
	
}
function delstore()//删除仓库
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
			  location="deletestore.action?pk_id="+pks;
	  }
	  else if(num==0) 
		  myalert("没有选中任何记录！");
}
function unDodel()
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
		  if(confirm("确定还原这"+num+"条记录吗?"))
			  location="undodel.action?pk_id="+pks;
	  }
	  else if(num==0) 
		  myalert("没有选中任何记录！");
}

function dodelDate()
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
		  if(confirm("确定彻底删除这"+num+"条记录吗，删除后将不可还原?"))
			  location="clearlog.action?pk_id="+pks;
	  }
	  else if(num==0) 
		  myalert("没有选中任何记录！");
}