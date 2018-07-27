<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<style type="text/css">
	div{
		margin-bottom: 10px;
	}
	
	li{
		margin-top: 5px;
	}
	</style>

</head>

<t:layout title="手机详情页">
	<h3>手机详情</h3>
	<div>
		<ul>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200" >商品</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.cellphone}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">品牌</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.brand}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">型号</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.model}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">操作系统</label>
				<li style="list-style: none;">&#12288;&#12288;&#12288;&#12288;${cellphones.os}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">cpu</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.cpuBrand}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">运存</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.ram}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">固存</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.storage}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">颜色</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.color}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">描述</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.description}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">价格</label>
				<li style="list-style: none;">&#12288;&#12288;${cellphones.price}</li>
			</div>
			<div>
				<label for="cellphone" style="font-size: 110%;font-weight: 200">cpu核心数</label>
				<li style="list-style: none;">&#12288;&#12288;&#12288;&#12288;${cellphones.cpucorenumber}</li>
			</div>
		</ul>
	</div>
	
	<div>
		<form action="${contextPath}/uc/shopcart/add" method="post" >
		<sec:csrfInput/>
			<input name="cellphoneId" type="hidden" value="${cellphones.id}" />
			<button type="submit">添加到购物车</button>
		</form>
	</div>
</t:layout>