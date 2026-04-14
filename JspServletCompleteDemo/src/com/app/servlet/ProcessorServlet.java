package com.app.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<html><h1>Request Inside ProcessorServlet</h1><h3>");
		response.getWriter().print("<br/>Attributes: "+request.getAttributeNames());
		response.getWriter().print("<br/>Context Path: "+request.getContextPath());
		response.getWriter().print("<br/>----Headers----");
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			response.getWriter().print("<br/>"+header+"::"+request.getHeader(header));
		}
		
		response.getWriter().print("<br/>----Headers----");
		response.getWriter().print("<br/>Local Address: "+request.getLocalAddr());
		response.getWriter().print("<br/>Local Name: "+request.getLocalName());
		response.getWriter().print("<br/>Local Port: "+request.getLocalPort());
		response.getWriter().print("<br/>Method: "+request.getMethod());
		response.getWriter().print("<br/>Path Info: "+request.getPathInfo());
		response.getWriter().print("<br/>Protocol: "+request.getProtocol());
		response.getWriter().print("<br/>Query String: "+request.getQueryString());
		response.getWriter().print("<br/>Remote Address: "+request.getRemoteAddr());
		response.getWriter().print("<br/>Remote Host: "+request.getRemoteHost());
		response.getWriter().print("<br/>Remote Port: "+request.getRemotePort());
		response.getWriter().print("<br/>Remote User: "+request.getRemoteUser());
		response.getWriter().print("<br/>Requested Session ID: "+request.getRequestedSessionId());
		response.getWriter().print("<br/>Server Name: "+request.getServerName());
		response.getWriter().print("<br/>Server Port: "+request.getServerPort());
		
		response.getWriter().print("<br/>Parameters:");
		Enumeration<String> parameters = request.getParameterNames();
		while (parameters.hasMoreElements()) {
			String parameter = parameters.nextElement();
			response.getWriter().print("<br/>"+parameter+"::"+request.getParameter(parameter));
		}
		
		response.getWriter().print("</h3></html>");
	}

}
