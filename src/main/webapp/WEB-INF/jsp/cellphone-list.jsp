<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<t:layout title="首页">
	<h3>商品列表</h3>
	<ul>
		<li style="list-style: none; display: inline-block;" >商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >名称&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >品牌&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >型号&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >操作系统&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >cpu&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >运存&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >固存&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >颜色&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >描述&nbsp;&nbsp;&nbsp;</li>
		<c:forEach items="${cellphone}" var="cellphone">
			<li style="list-style: none;">
				${cellphone.cellphone}&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.brand}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.model}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.os}&nbsp;&nbsp;&nbsp;&nbsp;
				${cellphone.cpuBrand}&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.ram}&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.storage}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${cellphone.color}&nbsp;&nbsp;&nbsp;&nbsp;${cellphone.description}
			</li>
		</c:forEach>
	</ul>
</t:layout>