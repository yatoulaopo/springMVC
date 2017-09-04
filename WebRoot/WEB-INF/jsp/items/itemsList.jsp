<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>这是商品查询页面，一个是食品，一个是数码</h1>
<c:if test="${items0 !=null }">
<h3>商品名称：${items0.name}</h3>
</c:if>
<c:if test="${items1 != null}">
	<h3>商品名称：${items1.name}</h3>
</c:if>
<c:if test="${list != null}">
	<c:forEach items="${list }" var="items2">
		<h3>商品名称：${items2.name}</h3>
	</c:forEach>
</c:if>

</body>
</html>