function showBg(n) { 
var bh = $("body").height(); 
var bw = $("body").width(); 
//$("#fullbg")
$("div[name='bg"+n+"']").css({ 
height:bh, 
width:bw, 
display:"block" 
}); 
$("div[name='dg"+n+"']").show(); 
} 
//关闭灰色 jQuery 遮罩 
function closeBg() { 
	$("#fullbg,#dialog").hide(); 
} 

var c$={}; 
var w$=function(s){document.write(s);} 
var o$=function(id){return document.getElementById(id);} 
w$("<div id=\"ts\" style=\"position:absolute;background-color:#FFFFE6;font-size: 12px;padding: 3px; border: 1px solid #FFCC99;display:none\"></div>"); 


c$.mmove=function(o,s){ 
//alert(typeof(s)); 
var evt=event||window.event; 
var x=evt.clientX+5; 
var y=evt.clientY+20; 
o$("ts").style.left=x+"px"; 
o$("ts").style.top=y+"px"; 
if(s==""||typeof(s)=="undefined"){ 
o$("ts").innerHTML=o.innerHTML; 
}else{ 
o$("ts").innerHTML='<img src="'+s+'" height="200" width="200"/>';
} 
o$("ts").style.display=""; 
} 
c$.mout=function(){ 
o$("ts").style.display="none"; 
} 