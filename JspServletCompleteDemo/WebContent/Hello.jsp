<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>Hello, JSP</h1>

		<%@ include file="included.jsp" %>
		
		<h4>The date is: =<%= new Date() %></h4>

<h3>The Request Username is: <%=request.getParameter("username") %></h3>
		
<%
pageContext.setAttribute("session_username", request.getParameter("username") , PageContext.SESSION_SCOPE);
pageContext.setAttribute("application_username", request.getParameter("username")+"user" , PageContext.APPLICATION_SCOPE);


%>



 		
 	</body>
</html>