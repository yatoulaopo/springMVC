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
<h1>用户修改表单页面</h1>
<c:if test="${user != null }">
	<form action="${pageContext.request.contextPath}/user/updateUser.action" method="post">
	<table border="0" bordercolor="black" cellspacing="0" cellpadding="3" style="text-alin:center;">
		<tr>
			
			<td><input type="hidden" value="${user.id}" name="id"/></td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td><input type="text" value="${user.username }" name="username"/></td>
		</tr>
		<tr>
			<td>所属城市:</td>
			<td><input type="text" value="${user.city }" name="city"/></td>
		</tr>
		<tr>
			<td>所属国家:</td>
			<td><input type="text" value="${user.country }" name="country"/></td>
		</tr>
		<tr>
			<td>创建时间:</td>
			<td><input type="text" value="${user.createTime }" name="createTime"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"/></td>
			
		</tr>
	</table>
	</form>
</c:if>
</body>
</html>