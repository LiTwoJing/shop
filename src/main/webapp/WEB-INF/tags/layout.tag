<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- 调用该tag时还需传参title以指定页面标题 -->
<%@ attribute name="title" required="true"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
<link href="${contextPath}/assets/css/app.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<style>
.menu {
	display: inline-block;
}
.div{position:absolute; right: 0px; top: 0px;}
</style>
</head>
<body>
<div class="div">
	<sec:authorize access="isAuthenticated()">
	<div class="header">
		<ul class="menu">
			<li style="display: inline-block;">登陆用户</li>
			<!--                                principal属性可以拿到当前登录的用户详情（UserDetailsImpl） -->
			<li style="display: inline-block;">&nbsp;&nbsp;<sec:authentication property="principal.username" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li style="list-style: none;padding-top: 4px"><a href="${contextPath}/uc/shopcart">购物车</a></li>
			<li style="list-style: none;display: inline-block;"><a href="${contextPath}/uc/shopaddress">收货地址管理</a></li>
		</ul>
		<div style="right:10%;">&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&nbsp;&nbsp;&nbsp;
			<form action="${contextPath}/logout" method="post"
				style="display: inline;">
				<sec:csrfInput />
				<button type="submit">退出</button>
			</form>
				
		</div>
		
	</div>
	</sec:authorize>
</div>
<div class="div">
<sec:authorize access="isAnonymous()">
	<div class="header">
		<ul class="menu">
			<li style="display: inline-block;"><a href="${contextPath}/login">登陆</a></li>
		</ul>
		<ul class="menu">
			<li style="display: inline-block;"><a href="${contextPath}/user/delit">注册</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</ul>
	</div>
</sec:authorize>
</div>
	<div class="content">
		<!-- 取tag参数值 -->
		<h1>${title}</h1>
		<!-- 把t:layout标签的内容插入此处 -->
		<jsp:doBody />
	</div>
	<div class="footer">copyright 2018</div>
</body>
</html>
