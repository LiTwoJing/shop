<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/assets/css/app.css" rel="stylesheet">
</head>
<body>
	<t:layout title="订单创建页">
		<table>
		<tr>
			<th>&#12288;商品&#12288;</th>
			<th>&#12288;单价&#12288;&#12288;</th>
			<th>数量</th>
		</tr>
		<tr style="color: blue">
			<c:forEach items="${shopcarts.items}" var="shopcart">
				<td>&#12288;${shopcart.cellphone.cellphone}</td>
				<td>${shopcart.cellphone.price/100}</td>
				<td>${shopcart.amount}</td>
			</c:forEach>
		</tr>	
	</table>
	<div style="color: red; font-size: 18px">
		&nbsp;&nbsp;总计：￥ ${shopcarts.Tototal()/100}
	</div>
	<f:form action="" method="post" commandName="ordersForm">
		<sec:csrfInput/>
		<label for="shopAddressid">请选择地址</label>
		<c:forEach items="${shopAddress}" var="shopaddress">
			 <div>
				<f:radiobutton path="shopAddressid" value="${shopaddress.id}"/>${shopaddress.detailaddress}
			</div> 
		</c:forEach>
		<div>
			<button type="submit">提交订单</button>
		</div>
	</f:form>
	</t:layout>
</body>
</html>