<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function requestJson(){
		$.ajax({
			type:'post',
			contentType:'application/json;charset=utf-8',
			url:'${pageContext.request.contextPath}/user/requestJson.action',
			data:'{"city":"罗马","country":"意大利",}',
			success:function(data){
				alert(data.country);
			}
		});
	}
</script>
</head>
<body>
<!-- 客户端传进服务器是json，服务器返回来的也是json -->
<input type="button" onclick="requestJson()" value="传json，返回json"/>
</body>
</html>