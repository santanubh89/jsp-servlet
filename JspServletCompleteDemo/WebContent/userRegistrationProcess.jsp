<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="com.app.model.UserModel" scope="request">
<jsp:setProperty property="userId" name="user" param="userId"/>
<jsp:setProperty property="userName" name="user" />
<jsp:setProperty property="city" name="user" />
<jsp:setProperty property="state" name="user" />
<jsp:setProperty property="pincode" name="user" param="pinCode"/>
</jsp:useBean>

<h3>Hello, <jsp:getProperty property="userName" name="user"/></h3>

</body>
</html>