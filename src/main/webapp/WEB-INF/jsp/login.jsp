<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<form action="" method="post">
		<sec:csrfInput/>
		
		<c:if test="${error}">
			<h2 style="color: red;">用户名或密码错误</h2>
		</c:if>
		
		<c:if test="${param.logout != null}">
			<h3 style="color: blue;">用户已退出请重新登录</h3>
		</c:if>
	<div>
		<input type="text" name="username" id="username"/>用户名
	</div>
	
	<div>
		<input type="password" name="password" id="password"/>密码
	</div>
	
		<button type="submit"> 登录</button>
	</form>
</body>
</html>