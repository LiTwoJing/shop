<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<t:layout title="收货地址详情页">
		<div>
			<table>
				<tr>
					<th>收货人姓名&#12288;</th>				
					<th>收货人手机号码&#12288;</th>				
					<th>详细地址&#12288;</th>				
					<th>操作</th>				
				</tr>
				
				<c:forEach items="${shopAddress}" var="shopaddress">
				<tr>
						<td>${shopaddress.username}&#12288;</td>
						<td>${shopaddress.cellphonenum}&#12288;</td>
						<td>${shopaddress.detailaddress}</td>
						<td>
							<div style="display: inline-block;">
							<form action="${contextPath}/uc/shopaddress/delect" method="post">
							<sec:csrfInput/>
								<input type="hidden" name="id" value="${shopaddress.id}"/>
								<button type="submit" type="submit" style="color:blue; text-decoration:underline; border: 0; background: white; font-size: 16px">删除</button>
							</form>
							</div>
							<div style="display: inline-block;">
							&#12288;<a href="${contextPath}/uc/shopaddress/update/${shopaddress.id}">编辑</a>
							</div>
						</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
	</t:layout>
</body>
</html>