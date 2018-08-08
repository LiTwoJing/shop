<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
</head>
<body>
	<h1>注册页面</h1>
	<f:form action="" method="post" commandName="customer">
		<div>
			<label for="username">用户名</label>
			<f:input type="text" path="username" id="username"/>
			<f:errors path="username" cssClass="errors"></f:errors>
		</div>
		
		<div>
			<label for="password">密码</label>
			<f:input type="password" path="password" id="password"/>
			<f:errors path="password" cssClass="errors"></f:errors>
		</div>
	
		<div>
			<label for="sex">性别</label>
			<f:radiobutton path="sex" value="男"/>男
			<f:radiobutton path="sex" value="女"/>女
		</div>
	
		<div>
			<button type="submit">注册</button>
		</div>
	</f:form>
</body>
</html>