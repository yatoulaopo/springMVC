<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<!--点击批量删除，传递的是数组 listId-->
	function deleteByIdArray(){
		document.form1.action="${pageContext.request.contextPath}/user/deleteUserByIdArray.action";
		document.form1.submit();
	}

</script>

<style type="text/css">
	table tr td{text-align:center;}
	
</style>
</head>
<body>
<h3>所有的用户列表</h3>
<c:if test="${listUser!=null && listUser.size()!=0 }">
	<form name="form1" method="post" >
	<table border="1" cellspacing="0" width="" style="text-alin:center;">
		<tr>
			<td>选择</td>
			<td>id</td>
			<td>username</td>
			<td>city</td>
			<td>country</td>
			<td>createTime</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${listUser}" var="user">
			<tr>
				<!-- 数组的参数绑定 -->
				<td><input type="checkbox" name="listId" value="${user.id}"/></td>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.city}</td>
				<td>${user.country}</td>
				<td><fmt:formatDate value='${user.createTime}' pattern="yyyy-MM-dd"/></td>
				<td>
					<c:if test="${user.filename != null}">
						<img alt="" src="/pic/${user.filename}" width="100" height="100"/>
					</c:if>
				</td>
				<td><a href="${pageContext.request.contextPath}/user/findUserById.action?id=${user.id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/deleteUserById.action?id=${user.id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8"><input type="button" value="批量删除" onclick="deleteByIdArray()"/></td>
		</tr>
	</table>
	</form>
</c:if>
</body>
</html>