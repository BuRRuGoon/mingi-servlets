package org.mingi.servlets.chap11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//register/step1 : RegisterStep1Servlet -> /WEB-INF/jsp/register/step1.jsp
@WebServlet("/register/step1")
public class RegisterStep1Servlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/register/step1.jsp")
				.forward(request, response);
	}
}
