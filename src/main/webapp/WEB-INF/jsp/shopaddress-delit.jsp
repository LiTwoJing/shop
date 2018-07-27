<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="button" value="${shopAddresss.id==null ? '添加' : '修改'}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<t:layout title="收货地址管理">
		<div>
			<form action="" method="post">
			<sec:csrfInput/>
				<input type="hidden" value="${shopAddresss.id}"/>
				<div>
					<label for="username">收货人姓名</label>
					<input type="text" name="username" id="username" value="${shopAddresss.username}"/>
				</div>
				<div>
					<label for="cellphonenum">收货人手机号码</label>
					<input type="text" name="cellphonenum" id="cellphonenum" value="${shopAddresss.cellphonenum}"/>
				</div>
				<div>
					<label for="detailaddress">详细地址</label>
					<input type="text" name="detailaddress" id="detailaddress" value="${shopAddresss.detailaddress}"/>
				</div>
				<button type="submit">${button}</button>
			</form>		
		</div>
	</t:layout>
</body>
</html>