package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/HelloServer" }, initParams = {@WebInitParam(name = "greetingMessage", value = "Redirected Greeting")})
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Initializing Servlet: "+config.getServletName());
		Enumeration<String> configs = config.getInitParameterNames();
		while (configs.hasMoreElements()) {
			String cel = configs.nextElement();
			System.out.println(cel+": "+config.getInitParameter(cel));
		}
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inside HelloServlet.Init()....");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		/* Servlet Context */
		ServletContext context = getServletContext();

		System.out.println("Global Param: " + context.getInitParameter("GlobalParam"));
		System.out.println("Context Path: " + context.getContextPath());
		System.out.println("Servlet Context Name: " + context.getServletContextName());

		context.setAttribute("servletContextParam", "servletContextParamValue");
		
		/* Servlet Config */
		ServletConfig config = getServletConfig();
		String greetingMessage = config.getInitParameter("greetingMessage");
		
		/* Cookie */
		Cookie[] cookies = request.getCookies();
		System.out.println("Cookie Length: "+cookies.length);
		for (Cookie cookie : cookies) {
			System.out.println("Cookie: "+cookie.getName()+" "+cookie.getValue());
		}

		/* Response Writing */
		writer.println("<html><h1>" + greetingMessage + "</h1>");
		String threadIdentifier = "Servlet: " + config.getServletName() + "; Object:" + hashCode() + "; Thread ID:" + Thread.currentThread().getId();
		writer.println("<h2>" + threadIdentifier + "</h2>");
		writer.println("<h3>doGet Served at: " + request.getContextPath() + "</h3>");
		
		writer.println("<h4>Request Username Stored in Session from Hello JSP: " + request.getSession().getAttribute("session_username") + "</h4>");
		writer.println("<h4>Request Username Stored in Application from Hello JSP: " + getServletContext().getAttribute("application_username") + "</h4>");
		
		writer.println("<h4>Session Param set in Greeting.jsp using JSTL: " + request.getSession().getAttribute("jstlParam") + "</h4></html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside do Post");
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside HelloServlet.destroy....");
	}

}
