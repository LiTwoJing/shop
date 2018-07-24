<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
label{
	style="display: inline-block;"
}
.li{
	style="list-style: none;color: blue; display: inline-block;"
}

</style>
</head>
<body>
	<h1>购物车详情</h1>
	<div>
			<label>&#12288;&#12288;&nbsp; 商品&#12288;&#12288;&#12288;&nbsp;</label>
			<label>数量&#12288;&#12288; </label>
			<label>单价&#12288;&#12288; </label>
			<label>操作&#12288;&#12288; </label>
		<ul>
				<c:forEach items="${shopcarts.items}" var="shopcart">
					<div>
						<li style="list-style: none;color: blue; display: inline-block;">${shopcart.cellphone.cellphone}</li>
						<li style="list-style: none;color: blue; display: inline-block;">&#12288;&#12288; ${shopcart.amount}</li>
						<li style="list-style: none;color: blue; display: inline-block;">&nbsp;&nbsp;&#12288;&#12288;${shopcart.cellphone.price/100}&#12288;&nbsp;&nbsp;</li>
						<form action="${contextPath}/uc/shopcart/delect" method="post" style="display: inline-block;">
						<sec:csrfInput/>
								<input name="cellphoneId" type="hidden" value="${shopcart.cellphone.id}"/>
								<button type="submit" style="margin-top: 15%">删除</button>		
						</form>
					</div>
				</c:forEach>
		</ul>
	</div>
	<div style="color: red; font-size: 18px">
		&nbsp;&nbsp;总计：￥ ${shopcarts.Tototal()/100}
	</div>
</body>
</html>