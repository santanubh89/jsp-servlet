<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN PAGE</h1>
	<form action="FirstServlet" method="post">
		<!-- <form action="index.jsp" method="post"> -->
		<input name="username" /> <input name="password" /><br />
		<input type="radio" name="role" value="user">User<br />
		<input type="radio" name="role" value="admin">Administrator<br />
		<input type="radio" name="role" value="tester">Tester<br />
		<select name="location" multiple="multiple">
			<option value="en-in">India</option>
			<option value="en-gb">Britain</option>
			<option value="en-us">America</option>
		</select> <br />
		<input value="Submit Name" type="submit" />
		<%
			out.print("<br>Username in Request: " + request.getParameter("name"));
			out.print("<br>Username in Session: " + session.getAttribute("username"));
			out.print("<br>Username in Application: " + application.getAttribute("username"));
			out.print("<br>Username in Page: " + pageContext.getAttribute("username"));
		%>
	</form>
</body>
</html>