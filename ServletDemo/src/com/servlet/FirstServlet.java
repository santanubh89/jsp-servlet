package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Initializing Servlet: " + config.getServletName());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DO GET CALLED");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DO POST CALLED");
		response.setContentType("text/html");
		PrintWriter pw = null;
		pw = response.getWriter();
		
		HttpSession session = request.getSession();
		if(null!=request.getParameter("username") && !request.getParameter("username").equals("")){
			session.setAttribute("username", request.getParameter("username"));
			//Below will be accessible across sessions
			ServletContext context = getServletContext();
			ServletContext context1 = request.getServletContext();
			//System.out.println("Both Same? "+(context==context1)+" "+(context.equals(context1)));
			context.setAttribute("username", request.getParameter("username"));
		}
		response.getWriter().append("Hello, "+getServletContext().getAttribute("username"));
		response.getWriter().append("Hello, "+session.getAttribute("username"));
		
		pw.write("<h1>Hello World!!</h1>");
		pw.write("DO POST Called with: " + "<br/>");
		// getInitParameter or getServletConfig.getInitParameter
		pw.write("INIT PARAM : " + getInitParameter("param1") + "<br/>");
		pw.write("REQUEST PARAM : " + request.getParameter("username") + "<br/>");
		pw.write("REQUEST PARAM : " + request.getParameter("password") + "<br/>");
		pw.write("REQUEST PARAM : " + request.getParameter("role") + "<br/>");
		String[] locations = request.getParameterValues("location"); // Multiple
																		// values
		if (null != locations && locations.length > 0) {
			for (String location : locations) {
				pw.write("REQUEST PARAM : " + location + "<br/>");
			}
		}
		if (null!=request.getParameter("username") && request.getParameter("username").equals("abcd")) {
			throw new NullPointerException("Hello Null");
		}
		// getServletContext.getInitParameter or
		// getServletConfig.getServletContext.getInitParameter
		pw.write("CONTEXT PARAM : " + getServletContext().getInitParameter("context-param1") + "<br/>");
		pw.write("ATTRIBUTE : " + request.getAttribute("attr1") + "<br/>");
		pw.write("DO POST WORKING--INSIDE SERVLET" + "<br/>");
		pw.write("//-------WHOLE REQUEST-------//" + "<br/>");
		pw.write("WHOLE REQUEST");
		pw.write("AUTH TYPE : " + request.getAuthType() + "<br/>");
		pw.write("CHAR ENCODING : " + request.getCharacterEncoding() + "<br/>");
		pw.write("CONTENT LENGTH : " + request.getContentLength() + "<br/>");
		pw.write("CONTENT TYPE : " + request.getContentType() + "<br/>");
		pw.write("LOCAL ADDRESS : " + request.getLocalAddr() + "<br/>");
		pw.write("LOCAL PORT : " + request.getLocalPort() + "<br/>");
		pw.write("REMOTE ADDRESS : " + request.getRemoteAddr() + "<br/>");
		pw.write("REMOTE HOSTNAME : " + request.getRemoteHost() + "<br/>");
		pw.write("REMOTE PORT : " + request.getRemotePort() + "<br/>");
		pw.write("METHOD : " + request.getMethod() + "<br/>");
		pw.write("PROTOCOL : " + request.getProtocol() + "<br/>");
		pw.write("QUERY STRING : " + request.getQueryString() + "<br/>");
		pw.write("REMOTE USER : " + request.getRemoteUser() + "<br/>");
		pw.write("REQUESTED SESSION ID : " + request.getRequestedSessionId() + "<br/>");
		pw.write("REQUESTED URI : " + request.getRequestURI() + "<br/>");
		pw.write("SCHEME : " + request.getScheme() + "<br/>");
		pw.write("SERVER NAME : " + request.getServerName() + "<br/>");
		pw.write("SERVER PORT : " + request.getServerPort() + "<br/>");
		pw.write("SERVLET PATH : " + request.getServletPath() + "<br/>");
		pw.write("DISPATCHER TYPE : " + request.getDispatcherType() + "<br/>");
		pw.write("//-------WHOLE REQUEST-------//" + "<br/>");
		
		pw.write("//-------SESSION INFO-------//" + "<br/>");
		pw.write("SESSION ID1 : " + request.getSession().getId() + "<br/>");
		pw.write("SESSION ID2 : " + request.getSession(false).getId() + "<br/>");
		pw.write("MAX INACTIVE : " + request.getSession(false).getMaxInactiveInterval() + "<br/>");
		pw.write("LAST ACCESSED : " + request.getSession(false).getLastAccessedTime() + "<br/>");
		pw.write("//-------SESSION INFO-------//" + "<br/>");
		if(null==request.getRequestedSessionId() || !request.getRequestedSessionId().equals(request.getSession(false).getId())){
			pw.write("<h1>SESSION TIMEOUT</h1>" + "<br/>");
		}
		
		Cookie[] cookies = request.getCookies();
		if(null!=cookies && cookies.length > 0){
			for(Cookie cookie : cookies){
				pw.write("Cookies: "+cookie.getName()+" "+cookie.getValue());
			}
		}
	}

}
