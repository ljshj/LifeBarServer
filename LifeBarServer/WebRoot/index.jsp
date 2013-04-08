<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>手机培训平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="手机,短信,培训">
	<meta http-equiv="description" content="首页">
	
	<meta http-equiv="refresh" content="0;url=pages/login.jsp">
	 
  </head>
  
  <body>
  	<!-- 
  	<a href="http://sighttp.qq.com/cgi-bin/check?sigkey=65542448cb0e42397c12902aa88c25aa5916fee953a219da6bd08cce5e159e2c"; target=_blank; onclick="var tempSrc='http://sighttp.qq.com/wpa.js?rantime='+Math.random()+'&sigkey=65542448cb0e42397c12902aa88c25aa5916fee953a219da6bd08cce5e159e2c';var oldscript=document.getElementById('testJs');var newscript=document.createElement('script');newscript.setAttribute('type','text/javascript'); newscript.setAttribute('id', 'testJs');newscript.setAttribute('src',tempSrc);if(oldscript == null){document.body.appendChild(newscript);}else{oldscript.parentNode.replaceChild(newscript, oldscript);}return false;"><img border="0" SRC='http://wpa.qq.com/pa?p=1:910247464:49' alt=""></a>
  	-->
  </body>
</html>
