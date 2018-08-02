<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<t:layout title="订单表详情页">
		<div>
			<table>
				<tr>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>收货人姓名</th>
					<th>手机号码</th>
					<th>详细地址</th>
					<th>订单创建时间</th>
					<th>订单状态</th>
					<th></th>
					
				</tr>
				
				<c:forEach items="${OrdersItem}" var="OrdersItems">
				<tr>
					<td>${OrdersItems.cellphone.cellphone}</td>
					<td>${OrdersItems.cellphone.price}</td>
					<td>${OrdersItems.amount}</td>
					<td>${OrdersItems.orders.shopAddress.username}</td>
					<td>${OrdersItems.orders.shopAddress.cellphonenum}</td>
					<td>${OrdersItems.orders.shopAddress.detailaddress}</td>
					<td>${OrdersItems.orders.findtime}</td>
					<td>${OrdersItems.orders.stateText()}</td>
					<td>
						<form action="${contextPath}/uc/orders/${OrdersItems.orders.id}/pay" method="post">
							<sec:csrfInput/>
							<button type="submit">支付宝支付</button>
						</form>
					</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
	</t:layout>
</body>
</html>