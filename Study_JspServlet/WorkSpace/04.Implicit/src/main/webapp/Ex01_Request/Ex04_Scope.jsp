<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 스코프 ( 데이터 전달 범위 )</h1>
	<p> 데이터를 전달하는 범위가 각각의 스코프(비율,배율)마다 차이가 있음</p>
	<p>많은 데이터를 사용하지 않음. 계속 전달을 하면 메모리에 기억을 해두고 유지를 해아함</p>
	<p>많은 데이터를 사용하는 경우 , 계속 메모리에 누적시켜두면 홈페이지 자체가 느려짐 ex)employees의 모든 내용.</p>
	<p> PageContext (JSP 페이지 내부에서만 데이터를 전달하는 목적으로 사용되는 객체 .(사용빈도가 매우 낮음) </p>
	<p>※ Request ※( 요청이 들어왔을때 , Forward(페이지 요청)시에 딱 한번만 데이터를 유지함. URL=>Servlet , Servlet=>URL)</p>
	<p>※ Session ※(브라우저 내에서는 계속해서 유지되는 정보 , 주로 로그인 정보나 상태 정보등으로 건수가 많은 데이터가 아닌 경우 )</p>
	<p> ApplicationContext ( 어플리케이션이 완전히 종료되지 않는한 계속해서 유지됨->버전 정보 , 특정한 업데이트를 위한값 외에는 저장x)</p>
	<% 
		pageContext.setAttribute("pageCtx", "KYM_PAGE_CTX");//페이지 내에서만 사용하는 객체
		request.setAttribute("req", "KYM_REQ");
		//Request => 1. getPrameter ( URL 또는 FORM태그를 이용한경우 내부 태그를 name으로 구분하여 파라메터가 String으로 들어있음)
		//        => 2. Attribute <= 어떤 요청을 통해서 오거나 Request가 Forward라는 기능으로 페이지 전환을 하는경우 Object 들어있음
		session.setAttribute("session", "KYM_SESSION");
		application.setAttribute("app", "KYM_APPV1.1");
		
	%>
	<p>PageContext : <%=pageContext.getAttribute("pageCtx") %>
	<p>request : <%=request.getAttribute("req") %>
	<p>session : <%=session.getAttribute("session") %>
	<p>application : <%=application.getAttribute("app") %>
	<jsp:forward page="Ex04_ScopeResult.jsp"></jsp:forward>
	
	<!-- <a href="Ex04_ScopeResult.jsp">다음 페이지로 이동 ScopeResult</a>
	 -->
</body>
</html>