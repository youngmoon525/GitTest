<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page errorPage="Ex02_Error.jsp" %>
	<!-- 자바코드로 오류를 발생시키기  -->
	<%
		String[] str =new String [1];
		str[10] = "a";
	%>
	<h1>오류 발생 페이지 메인</h1>
</body>
</html>