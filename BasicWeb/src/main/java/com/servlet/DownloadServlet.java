package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownloadServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=downloadname.pdf");
		FileInputStream in = new FileInputStream("E:\\Apache Tomcat\\8.0.30\\sample.pdf");
		int read = 0;
		byte[] bytes = new byte[8192];
		OutputStream os = response.getOutputStream();
		while ((read = in.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		in.close();
		os.flush();
		os.close();
	}

}
