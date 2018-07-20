<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
	<style type="text/css">
		.sou{
			display: inline-block;
		}
	
	</style>
</head>
<t:layout title="首页">
	<div>
		<f:form action="" method="post" commandName="cellphone">
			<div class="sou">
				<f:select path="brand">
					<f:option value="">请选择品牌</f:option>
					<f:option value="红米">红米</f:option>
					<f:option value="oppo">oppo</f:option>
				</f:select>
			</div>
			<div class="sou">
				<f:select path="os">
					<f:option value="">请选择操作系统</f:option>
						<f:option value="Android">Android</f:option>
						<f:option value="ios">ios</f:option>
				</f:select>
			</div>
			<div class="sou">
				<f:select path="cpuBrand">
					<f:option value="">请选择cpu</f:option>
						<f:option value="骁龙">
							骁龙
						</f:option>
						<f:option value="联发科">
							联发科
						</f:option>
				</f:select>
			</div>
			<div class="sou">
				<f:select path="ram">
					<f:option value="">请选择运存</f:option>
						<f:option value="4096">
							4096
						</f:option>
						<f:option value="128">
							128
						</f:option>
				</f:select>
			</div>
			<div class="sou">
				<f:select path="storage">
					<f:option value="">请选择固存</f:option>
						<f:option value="128">
						128
						</f:option>
						<f:option value="64">
						64
						</f:option>
				</f:select>
			</div>
			<button type="submit">搜索</button>
		</f:form>
	</div>
	
	<div>
		<label></label>
		<ul>
			<c:forEach items="${ces2}" var="c">
				<li><a href="${contextPath}/cellphone/${c.id}/cellphone-list"> ${c.cellphone}</a></li>
			</c:forEach>
		</ul>
	</div>
	

	<h3>商品列表</h3>	
	<ul>
		
		<li style="list-style: none; display: inline-block;" >商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >品牌&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >型号&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >操作系统&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >cpu&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >运存&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >固存&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >颜色&nbsp;&nbsp;&nbsp;</li>
		<li style="list-style: none; display: inline-block;" >描述&nbsp;&nbsp;&nbsp;</li>
		<c:forEach items="${ces}" var="ce">
			<li style="list-style: none;">
				${ce.cellphone}&nbsp;&nbsp;&nbsp;&nbsp;${ce.brand}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ce.model}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ce.os}&nbsp;&nbsp;&nbsp;&nbsp;
				${ce.cpuBrand}&nbsp;&nbsp;&nbsp;&nbsp;${ce.ram}&nbsp;&nbsp;&nbsp;&nbsp;${ce.storage}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${ce.color}&nbsp;&nbsp;&nbsp;&nbsp;${ce.description}
			</li>
		</c:forEach>
	</ul>
</t:layout>