package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;

public class LibrarianServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2218635759124092047L;
	
	private LibrarianDAO librianDAO;
	
	@Override
	public void init() {
		
		// creates connection and the DAO once needed
		librarianDAO = new librarianDAOImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		// pull data from database
		List<Librarian> allLibrarians = librarianDAO.getallPatrons();
		
		// put data into the request object
		request.setAttribute("allLibrarians", allLibrarians);
		
		// find jsp for list of librarian
		RequestDispatcher dispatcher = request.getRequestDispatcher("[insert path here]");
		
		// redirect to jsp and pass along request and response objects
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		
		//close connection, ConnectionManager uses Singleton Design so closes same connection
		
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
