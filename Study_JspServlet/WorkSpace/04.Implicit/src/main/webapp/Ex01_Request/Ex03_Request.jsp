<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 페이지</h1>
	<!-- url mapping /jdbclogin을 만들고 ( servlet) Ex03_Request
		현재 JSP페이지에서 id와 pw를 전송하게 처리해보기.
		전송방식을 민감한정보인id와pw는 Post로한다.(URL에 노출x)
	  -->
	  <form action="../jdbclogin" method="post"> 
	  	<input type="text" name="id" placeholder="아이디">
	  	<input type="text" name="pw" placeholder="비밀번호">
	  	<input type="submit" value="로그인">
	  </form>
	  
</body>
</html>