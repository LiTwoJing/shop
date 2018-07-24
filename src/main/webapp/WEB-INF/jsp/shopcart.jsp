<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>购物车详情</h1>
	<div>
		<ul>
				<c:forEach items="${shopcarts.items}" var="shopcart">
					<label style="color: blue">商品</label>
					<li style="list-style: none;">&#12288;&#12288; ${shopcart.cellphone.cellphone}</li>
					<label style="color: blue">数量</label>
					<li style="list-style: none;">&#12288;&#12288; ${shopcart.amount}</li>
					<label style="color: blue">单价</label>
					<li style="list-style: none;">&#12288;&#12288;${shopcart.cellphone.price}</li>
					<form action="" method="post">
							<input name="cellphoneId" type="hidden" value="${shopcart.cellphone.id}"/>
							<button type="submit">删除</button>		
					</form>
				</c:forEach>
		</ul>
	</div>
		
</body>
</html>