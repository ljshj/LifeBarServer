<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>手机培训平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="手机,短信,培训">
	<meta http-equiv="description" content="登陆页面">

	<link rel="stylesheet" href="../util/extjs/resources/css/ext-all.css" type="text/css"/>
	<link rel="stylesheet" href="../util/extjs/examples/ux/statusbar/css/statusbar.css" type="text/css"/>
	<link rel="stylesheet" href="../util/css/IconCls.css" type="text/css"></link>
	
	<script type="text/javascript" src="../util/extjs/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="../util/extjs/ext-all.js"></script>
	<script type="text/javascript" src="../util/extjs/debug.js"></script>
	<script type="text/javascript" src="../util/extjs/jquery.js"></script>
	<script type="text/javascript" src="../util/extjs/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../util/extjs/examples/ux/statusbar/StatusBar.js"></script>
  	<script type="text/javascript" src="../util/myjs/mainFrm.js"></script>
  	
  </head>
  
  <body>
  	<div id="header">
		<span id="welcome"><img src="../util/css/images/user_suit.png">登录用户：${user.userName}</span>
		<span id="time">2008-12-28</span>
		<span id="QQ"><a href="http://sighttp.qq.com/cgi-bin/check?sigkey=65542448cb0e4239edf239dbf1af4dd7d2a02a36fe1653fbb73e151ed2089f68"; target=_blank; onclick="var tempSrc='http://sighttp.qq.com/wpa.js?rantime='+Math.random()+'&sigkey=65542448cb0e4239edf239dbf1af4dd7d2a02a36fe1653fbb73e151ed2089f68';var oldscript=document.getElementById('testJs');var newscript=document.createElement('script');newscript.setAttribute('type','text/javascript'); newscript.setAttribute('id', 'testJs');newscript.setAttribute('src',tempSrc);if(oldscript == null){document.body.appendChild(newscript);}else{oldscript.parentNode.replaceChild(newscript, oldscript);}return false;"><img border="0" SRC='http://wpa.qq.com/pa?p=1:910247464:45' alt="QQ交流"></a></span>
	</div>
	<div id="footer">
		<div id="tac"><a href="http://www.segns.com/SMST"> @技术支持：成都共享教育网络技术有限公司  </a></div>
		<div id="copyright"><a href="mailto:yuwenkangywk001@163.com" target=_blank;> © 2010  WANGSHIQING </a></div>
	</div>
	
  	
  </body>
</html>
