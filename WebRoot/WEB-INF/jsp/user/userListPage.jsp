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
<h2>分页显示用户列表</h2>
<c:if test="${pageBean != null }">
	<c:if test="${pageBean.userList != null }">
	<table border="1" bordercolor="black" cellspacing="0" cellpadding="3" width="70%" style="text-alin:center;">
		<tr>
			<td>id</td>
			<td>username</td>
			<td>city</td>
			<td>country</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.userList }" var="user">
		
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.city}</td>
			<td>${user.country}</td>
			<td><a href="${pageContext.request.contextPath}/user/findUserById.action?id=${user.id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/deleteUserById.action?id=${user.id}">删除</a></td>
		</tr>
		
		</c:forEach>
		<tr>
			<td colspan="5" align="right" style="text-align: right;"><a href="${pageContext.request.contextPath }/user/queryUserListPage.action?page=${pageBean.page-1}">上一页</a>&nbsp;&nbsp;&nbsp;${pageBean.page}&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/user/queryUserListPage.action?page=${pageBean.page+1}">下一页</a></td>
		</tr>
	</table>
	</c:if>
</c:if>
</body>
</html>