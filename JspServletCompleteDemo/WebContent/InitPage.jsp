<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
public void jspInit() {
	String username = getServletConfig().getInitParameter("DefaultUser");
	getServletContext().setAttribute("DefaultUser", username);
}

%>

<%
String username = request.getParameter("username");
if (null == username){
	username = getServletConfig().getInitParameter("DefaultUser");
}
%>

<h3>Hello, <%=username %></h3>
<h4>Default Value from Servlet Context: <%=application.getAttribute("DefaultUser") %></h4>
<h4>Default Value from Page Context: <%=pageContext.getAttribute("DefaultUser", PageContext.APPLICATION_SCOPE) %></h4>

<jsp:useBean id="calc" scope="page" class="com.app.backbean.Calculator" />

<h4>Square of 5 is: <%= calc.square(5) %></h4>
<h4>Cube of 5 is: <%= calc.cube(5) %></h4>

</body>
</html>