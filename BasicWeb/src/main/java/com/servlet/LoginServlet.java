package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean validated = false;
		
		if(null!=username && username.length()>0 && username.equals("validuser")){// Hardcoded username password
			if(null!=password && password.length()>0 && password.equals("validpass")){
				validated = true;
				HttpSession session = request.getSession();
				session.setAttribute("loginuser", username);
			}
		}
		
		if(validated){
			//request.getRequestDispatcher("/PostLogin").forward(request, response);
			response.sendRedirect("PostLogin");
			//return;
		}else{
			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
			response.sendRedirect("Login.jsp");
			//return;
		}
	}

}
