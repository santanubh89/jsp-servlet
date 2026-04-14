<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>This is an error page for exception<br></h1>
<%
if(exception instanceof NullPointerException){
	out.println("Null pointer is thrown");
}else if(exception instanceof IllegalArgumentException){
	out.println("IllegalArgumentException is thrown");
}else if(exception instanceof SecurityException){
	out.println("SecurityException is thrown");
}
out.println("Message is: "+exception.getMessage());
%>
</body>
</html>