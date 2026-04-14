package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectingServlet")
public class RedirectingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("doGet Served at: ").append(request.getContextPath());
		if(request.getParameter("username")==null){
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Why haven't you provided the username?");
		}else
		response.sendRedirect(request.getContextPath()+"/FirstServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("doPost Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/FirstServlet").forward(request, response);
	}

}
