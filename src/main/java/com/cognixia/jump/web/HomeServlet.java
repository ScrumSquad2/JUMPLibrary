package com.cognixia.jump.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("Home action: " + action);
		switch (action) {
		case "/librarianSignin":
			signInPatron(request, response);
			break;
		case "/patronSignin":
			signInLibrarian(request, response);
			break;
		default:
			response.sendRedirect("/");
			break;
		}
	}
	
	private void signInLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("librarian", true);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void signInPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("librarian", false);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
