package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;

@WebServlet("/patron")
public class PatronServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public void init() {
		//TODO initialize the DAO class
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/addPatron":
			insertPatron(request, response);
			break;
		case "/updatePatron":
			break;
		case "/listCurrent":
			break;
		case "/listReturned":
			break;
		case "/addCheckout":
			break;
		case "/returnCheckout":
			break;
		default:
			response.sendRedirect("/");
			break ;
		}
		
	}
	
	private void insertPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		final String stat = "INSERT INTO patron(first_name, last_name, username, password, account_frozen) \n"
				+ "	values(?, ?, ?, ?, false)";
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		try (PreparedStatement ptsmt = conn.prepareStatement(stat)) {
			ptsmt.setString(1, firstName);
			ptsmt.setString(2, lastName);
			ptsmt.setString(3, userName);
			ptsmt.setString(4, password);
			int count = ptsmt.executeUpdate();
			if (count != 0) {
				System.out.println("sucess add patron");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		
		//TODO get the Connection and destroy
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
