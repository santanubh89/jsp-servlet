<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.backbean.ApplicationBackbean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p><h1>This is the index page</h1>
	<p><h1>Program flow will start from here</h1>
	<p><h1>My name is : <%=request.getParameter("username")%></h1>

	This is the home page!!!!

	<%!public int add(int a, int b) {
		return a + b;
	}%>
	Current time:
	<%=new Date()%>
	<%
		String formattedTime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
		formattedTime = sdf.format(new Date());
		out.print("<br>Printing with out object: " + formattedTime);
	%>

	<br>Current time: <%=formattedTime%>

	<br>Sum of 5 and 6 is : <%=add(5, 6)%>

	<%
		if (null != request.getParameter("name")) {
			session.setAttribute("username0", request.getParameter("name") + "session");
			//application.setAttribute("username", request.getParameter("name"));
			pageContext.setAttribute("username1", (request.getParameter("name") + "page"), PageContext.PAGE_SCOPE);
			pageContext.setAttribute("username2", (request.getParameter("name") + "app"), PageContext.APPLICATION_SCOPE);
		}

		out.print("<br>Username in Request: " + request.getParameter("name"));
		out.print("<br>Username in Session: " + session.getAttribute("username0"));
		out.print("<br>Username in Application: " + application.getAttribute("username2"));
		out.print("<br>Username in Page: " + pageContext.getAttribute("username1"));

		out.print("<br>Request: " + request.getQueryString() + " " + request.getServletPath());
		ApplicationBackbean.doSomething();
		out.print("<br>");
		out.print("<br>" + application.getFilterRegistrations());
		out.print("<br>Page: " + pageContext.getAttribute("username1"));
		out.print("<br>Find: " + pageContext.findAttribute("username0"));
		out.print("<br>----------------------------------------------------------------------");
	%>

	<%@include file="WEB-INF/jsp/Login.jsp"%>

	<a href="initializer.jsp">This JSP overrides init method</a>
	<br />
	<a href="uploader.jsp">This JSP will upload a file</a>
	<br />
	<a href="FirstServlet">This is the first servlet</a>
	<br />
	<a href="Download">This Servlet downloads a file</a>
	<br />

</body>
</html>