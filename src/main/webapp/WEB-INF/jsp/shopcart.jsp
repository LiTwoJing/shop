<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/assets/css/app.css" rel="stylesheet">
</head>
<body>
<t:layout title="购物车详情">
	<div>
	<table>
		<tr>
			<th>&#12288;商品&#12288;</th>
			<th>&#12288;数量&#12288;&#12288;</th>
			<th>单价&#12288;</th>
			<th>&#12288;操作&#12288;</th>
		</tr>
		<tr style="color: blue">
			<c:forEach items="${shopcarts.items}" var="shopcart">
				<td>&#12288;${shopcart.cellphone.cellphone}</td>
				<td>
          			<form action="${contextPath}/uc/shopping-cart/item-dec" method="post" class="inline">
            			<sec:csrfInput />
            			<input type="hidden" name="cellphoneId" value="${shopcart.cellphone.id}">
            			<button type="submit">-1</button>
          			</form>        
         			${shopcart.amount}
          			<form action="${contextPath}/uc/shopping-cart/item-inc" method="post" class="inline">
            			<sec:csrfInput />
           				<input type="hidden" name="cellphoneId" value="${shopcart.cellphone.id}">
            			<button type="submit">+1</button>
          			</form>          
        		</td>
				<td>${shopcart.cellphone.price/100}</td>
				<td>
					<form action="${contextPath}/uc/shopcart/delect" method="post" style="display: inline-block;">
						<sec:csrfInput/>
							<input name="cellphoneId" type="hidden" value="${shopcart.cellphone.id}"/>
							&#12288;<button type="submit" style="margin-top: 5%">删除</button>		
					</form>
				</td>
			</c:forEach>
		</tr>	
	</table>
	</div>
	<div style="margin-top: 0.2%;margin-bottom: 0.2% ">
		<c:if test="${shopcarts.Tototal()== 0}">
			<label style="font-size: 18px;">&#12288;&#12288;空空如也</label>
		</c:if>
	</div>
	<div style="color: red; font-size: 18px">
		&nbsp;&nbsp;总计：￥ ${shopcarts.Tototal()/100}
	</div>
	
	<div>
		<a href="${contextPath}/uc/order/delit/ready">结算</a>
	</div>
</t:layout>
</body>
</html>