<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add">
a:<input type="number" name="a">
b:<input type="number" name="b">
<input type="submit">
</form>





</body>
</html>
<%if(request.getAttribute("sum")!=null) {%>
	<% int sum=(int)request.getAttribute("sum");%>
	<h1>The sum is <%= sum %></h1>
	
	
<%} %>


