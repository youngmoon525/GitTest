<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>PageContext : <%=pageContext.getAttribute("pageCtx") %>
	<!-- PageContext 페이지 내에서만 데잍가 유지됨(지역변수와 유사함)  -->
	<p>request : <%=request.getAttribute("req") %>
	<!-- Forwoard라는 페이지 요청이 있을때만 다음페이지로 전송,넘어가는 처리가 됨 ( 메소드 파라메터부와 유사) -->
	<p>session : <%=session.getAttribute("session") %>
	<!-- 전역변수 ( 필드 ) 유사함 크롬창을 새로 띄우거나(브라우저 다른것) 또는 서버가 (리스타트되면서 유지가 되고 안되고가 랜덤함.)  -->
	
	<p>application : <%=application.getAttribute("app") %>
</body>
</html>