<%@page import="kym.KymVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기까지옴</h1>
	<h3>웹에서는 데이터를 태그형태나 아니면 jstl , EL등으로 표현을 할때 getter & setter를 많이 이용함</h3>
	<h3>보통 데이터를 전달하고 readOnly 데이터를 읽어서 쓰는용도로만 VO(Value Object)라는 명칭을 새로만듬(==DTO)</h3>
	<c:forEach items="${list}" var="vo">
		<p>${vo.field1}</p>
		<p>${vo.field2}</p>
	</c:forEach>
	<% ArrayList<KymVO> list =(ArrayList<KymVO>) request.getAttribute("list");
	for(KymVO vo : list) {%>
		<p><%=vo.getField1() %></p>
		<p><%=vo.getField2() %></p>
	
	<%} %>
</body>
</html>