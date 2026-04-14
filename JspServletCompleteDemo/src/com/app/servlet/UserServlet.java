package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {
	
	
	public UserServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("Get with User name "+request.getSession().getAttribute("username"));
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Do Post Invoke");
		String username = request.getParameter("username");
		response.getWriter().println("<br/>Username: "+username);
		response.getWriter().println("<br/>Password: "+request.getParameter("password"));
		response.getWriter().println("<br/>citizenship: "+request.getParameter("citizenship"));
		response.getWriter().println("<br/>communication: "+request.getParameter("communication"));
		response.getWriter().println("<br/>location: "+request.getParameterValues("location"));
		
		HttpSession session = request.getSession();
		if (null!= username) {
			session.setAttribute("username", username);
		}
		
		ServletContext context = getServletContext();
		
		response.getWriter().println("<br />Username in Request: "+username + " && Username in Session: "+session.getAttribute("username"));
		response.getWriter().println("<br/>Servlet Context Param: "+context.getAttribute("servletContextParam"));
	}
	
}
