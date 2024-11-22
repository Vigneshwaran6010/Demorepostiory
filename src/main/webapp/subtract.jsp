<%@page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="sub">
A:<input type="number" name="a"> 
B:<input type="number" name="b">
<input type="submit">


</form>
</body>
</html>


<%! @WebServlet("/sub") %>
<%!class Subtract extends HttpServlet{%>
<%!protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,java.io.IOException { %>
<%! int a=Integer.parseInt(req.getParameter("a")); %>
<%! int b=Integer.parseInt(req.getParameter("b")); %>
<%! int sub=a-b; %>
<%! req.setAttribute("sub", sub); %>
<%! req.getRequestDispatcher("subtract.jsp").forward(req, resp); %>

<%!} %>
<%!} %>


<%if(request.getAttribute("sub")!=null){ %>
<% int sub=(int)request.getAttribute("sub"); %>
<h1>The sub is <%= sub %>/h1>
<%} %>

