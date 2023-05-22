<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Request 객체의 속성</h1>
	<table border="1">
		<tr>
			<td> 서버 도메인명</td>
			<td> <%=request.getServerName() %></td>
		</tr>
		<tr>
			<td> 서버 포트</td>
			<td> <%=request.getServerPort() %></td>
		</tr>
		<tr>
			<td> 요청 URL </td>
			<td> <%=request.getRequestURL() %></td>
		</tr>
		<tr>
			<td> 요청 URI </td>
			<td> <%=request.getRequestURI() %></td>
		</tr>
		<tr>
			<td> 요청 Method </td>
			<td> <%=request.getMethod() %></td>
		</tr>
		<tr> 
			<td> 요청 Param</td>
			<td> <%=request.getParameter("param1") %></td>
		</tr>
	</table>
	
</body>
</html>