<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td{text-align:left;}
</style>
</head>
<body>
<h1>批量更新用户</h1>
<c:if test="${listUser!=null && listUser.size()!=0 }">
	<form name="form3" action="${pageContext.request.contextPath}/user/updateUserBatch.action" method="post">
	<table border="0" cellspacing="0" width="20%" style="text-alin:center;">
		
		<c:forEach items="${listUser}" var="user" varStatus="status">
			<tr>
				<td colspan="2"><input type="hidden" name="listUser[${status.index}].id" value="${user.id} "/></td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="listUser[${status.index}].username" value="${user.username} "/></td>
			</tr>
			<tr>
				<td>所属城市:</td>
				<td><input type="text" name="listUser[${status.index}].city" value="${user.city} "/></td>
			</tr>
			<tr>
				<td>所属国家:</td>
				<td><input type="text" name="listUser[${status.index}].country" value="${user.country} "/></td>
			</tr>
			<tr>
				<td>创建时间:</td>
				<td><input type="text" name="listUser[${status.index}].createTime" value='<fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd"/>'/></td>
			</tr>
			<tr><td colspan="2"><hr color="red" size="1"/></td></tr>
		</c:forEach>
			<tr>
				<td style="text-align:center;" colspan="2"><input type="submit" value="批量更新"/></td>
			</tr>
	</table>
	</form>
</c:if>
</body>
</html>