<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
		<tr>
			<td>3</td>
			<td>4</td>
		</tr>
	</table>
	
	<table border="1px solid black;">
	<%for(int i = 2 ; i <= 9 ; i ++){%>
		<tr>
		<%for(int j = 1 ; j <=9; j++){%>
			<td><%=i%>*<%=j %>=<%=i*j %></td>
		<%}%>
		</tr>
		<%}%>
	</table>
</body>
</html>