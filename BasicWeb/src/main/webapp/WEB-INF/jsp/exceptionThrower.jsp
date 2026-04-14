<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/WEB-INF/jsp/exceptionError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
<%
if(null==request.getParameter("name")){
	throw new NullPointerException("Name cannot be empty");
}else if(request.getParameter("name").equals("user")){
	throw new SecurityException("User does not have access");
}else if(request.getParameter("name").length()<4){
	throw new IllegalArgumentException("Name is too small");
}

%>
</body>
</html>