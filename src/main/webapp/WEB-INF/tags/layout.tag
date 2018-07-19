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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>

<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
<style>
.menu {
	display: inline-block;
}
</style>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
	<div class="header">
		<ul class="menu">
			<li style="display: inline-block;">登陆用户</li>
			<!--                                principal属性可以拿到当前登录的用户详情（UserDetailsImpl） -->
			<li style="display: inline-block;">&nbsp;&nbsp;<sec:authentication property="principal.username" /></li>
		</ul>
		<div style="display: inline-block;">
			<!-- springsecurity默认的退出路径是：POST /logout，注意：springsecurity自带处理 -->
			<form action="${contextPath}/logout" method="post"
				style="display: inline;">
				<sec:csrfInput />
				&nbsp;&nbsp;
				<button type="submit">退出</button>
			</form>
		</div>
		<ul class="menu">
			<li style="list-style: none;">购物车</li>
		</ul>
	</div>
	</sec:authorize>
	
<sec:authorize access="isAnonymous()">
	<div class="header">
		<ul class="menu">
			<li style="display: inline-block;"><a href="${contextPath}/login">登陆</a></li>
		</ul>
		<ul class="menu">
			<li style="display: inline-block;"><a href="${contextPath}/user/delit">注册</a></li>
		</ul>
	</div>
</sec:authorize>
	<div class="content">
		<!-- 取tag参数值 -->
		<h1>${title}</h1>
		<!-- 把t:layout标签的内容插入此处 -->
		<jsp:doBody />
	</div>
	<div class="footer">copyright 2018</div>
</body>
</html>
