package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.db.UserDatabase;
import com.app.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean loginValid = true;
		if (username == null || "".equals(username)) {
			loginValid = false;
		}
		if (password == null || "".equals(password)) {
			loginValid = false;
		}
		request.getSession().setAttribute("username", username);
		User user;
		if (null != username) {
			user = new UserDatabase().userData.get(username);
			if (null != user)
				request.setAttribute("userDetail", user);
		}
		if (loginValid)
			/* response.sendRedirect("success.jsp"); */
			request.getRequestDispatcher("success.jsp").forward(request, response);
		else
			response.sendRedirect(getServletContext().getContextPath());
		/* request.getRequestDispatcher("/").forward(request, response); */
	}

}
