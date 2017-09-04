<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td{text-align:center;}
</style>
</head>
<body>
<h1>查询所有订单</h1>
<c:if test="${ordersList!=null && ordersList.size()!=0}">
	<table border="1" bordercolor="black" cellspacing="0" cellpadding="3" width="40%" style="text-alin:center;">
		<tr>
			<td>id</td>
			<td>user_id</td>
			<td>createTime</td>
		</tr>
		<c:forEach items="${ordersList}" var="order">
			<tr>
				<td>${order.id}</td>
				<td>${order.user_id}</td>
				<td>${order.createTime}</td>
			</tr>
		</c:forEach>
	</table>
	
</c:if>
</body>
</html>