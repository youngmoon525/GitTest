<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>변수 사용해보기</h3>
	<%! int sVal = 0; %><!-- 전역 변수  -->
	<%  int lVal = 0; %><!-- 로직코드(지역변수)  -->
	<p>sVal <%=++sVal %></p><!-- syso(str[0] + str[1])  -->
	<p>lVal <%=++lVal %></p>
	<!-- 지역변수(로직코드) 블럭킹을 통해서 4의 크기를 가진 배열을 만든다. 배열은
	 각각의 index에 T , E , S , T라는 문자열이 들어있어야한다.
	 배열을 만든후 표현문 태그로 각각의 문자를 출력해보기.
	 정답:배열을 만든 후 jsp페이지에 T E S T 가 각각 배열을 이용해서 출력되면 된다.
	  -->
	 <% String[] strArr = new String[4];
	 	strArr[0] = "T";
	 	strArr[1] = "E";
	 	strArr[2] = "S";
	 	strArr[3] = "T";
	 	String[] strArr2 = { "T" , "E" , "S" , "T"} ;
	 	ArrayList<String> strList = new ArrayList<>();
	 	strList.add("T");
	 	strList.add("E");
	 	strList.add("S");
	 	strList.add("T");
	 	
	 %>
	 <p><%=strArr[0]+strArr[1]+strArr[2]+strArr[3] %><%=strArr[1] %></p>
	 <p><%=strList.get(0) + strList.get(1) +strList.get(2) +strList.get(3)%></p>
	
	
	
	
</body>
</html>