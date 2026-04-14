<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!public int sum(int num1, int num2) {
			return num1 + num2;
		}%>

<%

int n1 = Integer.valueOf(request.getParameter("num1"));
int n2 = Integer.valueOf(request.getParameter("num2"));

if (n1==n2) throw new Exception ("Numbers are same");

%>

<%
		int i = 5;
		int j = 7;
		int k = i + j;
		%>

<h3>Sum is: <%=sum(n1, n2) %></h3>

</body>
</html>