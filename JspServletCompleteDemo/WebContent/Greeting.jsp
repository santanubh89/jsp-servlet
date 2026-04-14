<%@page import="com.app.model.UserModel"%>
<%@page import="com.app.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greeting Page!</title>
</head>
<body>

<h1>This page is generated from Greeting.jsp</h1>

<!------------------------------------------------------ Using Java Codes to Read Attributes from Request, Session and Application Scope ------------------------------------------------------>
<br /><h2>Using Java Codes</h2>
<h2>Hello, <%=session.getAttribute("username")%></h2>

<%
// UserModel user = (UserModel)session.getAttribute("userinfo");
UserModel user = (UserModel)request.getAttribute("userinfo");
pageContext.setAttribute("session_username", request.getParameter("username")+"session" , PageContext.SESSION_SCOPE);
pageContext.setAttribute("application_username", request.getParameter("username")+"application" , PageContext.APPLICATION_SCOPE);
%>

<h4>
<br />User's name is: <%=user.getUserName()%>
<br />User's location is: <%=user.getCity()%>
<br />User's Pin is: <%=user.getPincode()%>
</h4>

<!-- Using EL -->
<br /><h2>Using Expression Language</h2>
<h3>Request scope message: ${requestScope.greetingMessage}</h3>
<h3>Request scope message2: ${greetingMessage}</h3>
<h3>Cookie: ${cookie.username.value}</h3>
<h3>Param: ${param.username eq 'username1'} </h3>
<h3>Session Scope: ${sessionScope.userinfo}</h3>
<h3>Session Scope2: ${userinfo}</h3>

<!---------------------------------------------------------------------------------------------- Using JSTL Core Tags ---------------------------------------------------------------------------------------------->
<br /><h2>Using JSTL</h2>
<jsp:useBean id="userinfo" class="com.app.model.UserModel" scope="request">
</jsp:useBean>
<h4>
<br />User's name is: <jsp:getProperty property="userName" name="userinfo"/>
<br />User's location is: <jsp:getProperty property="city" name="userinfo"/>
<br />User's Pincode is: <jsp:getProperty property="pincode" name="userinfo"/>
</h4>

<jsp:useBean id="newuser" class="com.app.model.UserModel" scope="request">
	<jsp:setProperty name="newuser" property="userName" value="new user name"/>
	<jsp:setProperty name="newuser" property="city" value="new user's city"/>
	<jsp:setProperty name="newuser" property="pincode" value="new user's pin"/>
</jsp:useBean>
<br /><h4>Value set for new user: <%=newuser %></h4>

	<c:set var="jstlParam" value="JSTLSetParam" scope="session" />
	
	<c:out value="out.print using JSTL"></c:out>
	
	<c:forEach items="${associatedUsers}" var="user">
		<br /> Name: ${user.userName}, City: ${user.city}
	</c:forEach>
	
	<h2>Fetching from DB using JSTL</h2>
	
<!---------------------------------------------------------------------------------------------- Using JSTL Data Source ---------------------------------------------------------------------------------------------->
	
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" user="root" password="System123" url="jdbc:mysql://localhost:3306/sys"/>
	
	<h3>Specific User with ID Specified</h3>
	<sql:query var="user1" dataSource="${db}" sql="select * from userdata where userid=?" scope="session">
		<sql:param value="1" />
	</sql:query>
	
	<c:forEach items="${user1.rows}" var="user">
		<br /><c:out value="${user.userid}" />:<c:out value="${user.username}" />:<c:out value="${user.userlocation}" />
	</c:forEach>
	
	<h3>All Users</h3>
	
	<sql:query var="allUser" dataSource="${db}" sql="select * from userdata" scope="session" />
	
	<c:forEach items="${allUser.rows}" var="user">
		<br /><c:out value="${user.userid}" />:<c:out value="${user.username}" />:<c:out value="${user.userlocation}" />
	</c:forEach>
	
<!---------------------------------------------------------------------------------------------- Using JSTL Functions ---------------------------------------------------------------------------------------------->

	<c:set var="str" value = "Santanu is writing JSP" />
	<h3>Length : ${fn:length(str) }</h3>
	<h3>Contains JSP : ${fn:contains(str, 'JSP') }</h3>
	<h3>Contains Servlet : ${fn:contains(str, 'Servlet') }</h3>
	<h3>Upper Case : ${fn:toUpperCase(str) }</h3>
	<h3> Split: <br />
	<c:forEach items="${fn:split(str, ' ') }" var="val">
		${val}<br />
	</c:forEach>
	</h3>
	
<!---------------------------------------------------------------------------------------------- Other Demos ---------------------------------------------------------------------------------------------->	
	
	
	<br />
	<br /><h2>Other Demos</h2>
	<br />Hello Servlet<form action="Hello" method="Get"><input type="submit"></form>
	<br />Hello JSP<form action="Hello.jsp" method="Get"><input type="submit"></form>
	<br />Processor Servlet<form action="Processor" method="Get"><input type="submit"></form>
	<br />UserServlet <form action="userDetails.html" method="Get"><input type="submit"></form>
	<br />UserForm 2<form action="UserForm2" method="Get"><input type="submit"></form>
	<br />Redirecting Servlet<form action="RedirectingServlet" method="Get"><input type="submit"></form>
	<br />Initialized JSP Param<form action="InitJSP" method="Get"><input type="submit"></form>
	<br />User Registration Form<form action="userRegistrationForm.jsp" method="Get"><input type="submit"></form>
	<br />File Download<form action="Download" method="Get"><input type="submit"></form>
	<br />File Upload<form action="uploader.jsp" method="Get"><input type="submit"></form>
	<br />
	
<form action="Logout.jsp">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>