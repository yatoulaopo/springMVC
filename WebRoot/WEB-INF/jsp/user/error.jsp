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

<c:if test="${errorList != null }">
	<c:forEach items="${errorList }" var="error">
	<h1>Controller用validator校验器捕获到错误后，在这里显示</h1>
		<h3 style="color:red;">${error.defaultMessage}</h3><br/>
	</c:forEach>
</c:if>
<c:if test="${message != null }">
	<h1>全局异常解析器出现异常跳转到这个error.jsp页面</h1>
	<h3 style="color:red;">${message}</h3><br/>
</c:if>
</body>
</html>