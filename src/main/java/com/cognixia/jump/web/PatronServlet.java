package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookCheckoutDAO;
import com.cognixia.jump.dao.BookCheckoutDAOImpl;
import com.cognixia.jump.dao.ItemNotFoundInDatabaseException;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOImpl;
import com.cognixia.jump.dao.UsernameAlreadyExistsException;
import com.cognixia.jump.model.BookCheckout;
import com.cognixia.jump.model.Patron;

@WebServlet("/patron/*")
public class PatronServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private PatronDAO patronDAO;
    private BookCheckoutDAO bookCheckoutDAO;
    private static Patron patron;
	
	@Override
	public void init() {
		
		patronDAO = new PatronDAOImpl();
		bookCheckoutDAO = new BookCheckoutDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getPathInfo();
		
		switch(action) {
		case "/addPatron":
			insertPatron(request, response);
			break;
		case "/loginPatron":
			loginPatron(request, response);
			break;
		case "/logoutPatron":
			logoutPatron(request, response);
			break;
		case "/updatePatron":
			updatePatron(request, response);
			break;
		case "/listCurrent":
			listCurrent(request, response);
			break;
		case "/listReturned":
			break;
		case "/addCheckout":
			addCheckout(request, response);
			break;
		case "/returnCheckout":
			returnCheckout(request, response);
			break;
		default:
			response.sendRedirect("/JUMPLibrary");
			break ;
		}
		
	}
	
	private void insertPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean accountFrozen = false;
		
		try {
			Patron newPatron = new Patron(0, firstName, lastName, userName, password, accountFrozen);
			patronDAO.addPatron(newPatron);
			System.out.println("Sucess add " + patron);
			patron = newPatron;
			
			request.setAttribute("patron", patron);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/patron-form.jsp");
			System.out.println("send to dispatcher");
			dispatcher.forward(request, response);
		} catch (UsernameAlreadyExistsException e) {
			response.sendRedirect("JUMPLibrary/signUp.jsp");
			e.printStackTrace();
		}
	}
	
	private void loginPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("login");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			 patron = patronDAO.getPatronByUser(userName);
			if (!patron.getPassword().equals(password)) {
				patron = null;
				System.out.println("Invalid password");
				response.sendRedirect("/JUMPLibrary");
			} else {
				System.out.println("send");
				request.setAttribute("patron", patron);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/patron-form.jsp");
				System.out.println("send to dispatcher");
				dispatcher.forward(request, response);
			}
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
			System.out.println("Cannot found patron");
			response.sendRedirect("/JUMPLibrary");
		}
	}
	
	private void logoutPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron != null)
			patron = null;
		response.sendRedirect("/JUMPLibrary");
	}
	
	private void updatePatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean accountFrozen = false;
		
		try {
			patronDAO.updatePatron(
					new Patron(patronId, firstName, lastName, userName, password, accountFrozen));
			System.out.println("Sucess update " + userName);
		} catch (UsernameAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listCurrent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		List<BookCheckout> bookCheckouts;
		try {
			bookCheckouts = bookCheckoutDAO.getAllCheckouts(patronDAO.getPatronById(patronId));
			System.out.println("bookCheckouts: " + bookCheckouts);
			
			request.setAttribute("bookCheckouts", bookCheckouts);
			// TODO change to correct jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
			System.out.println("send");
			dispatcher.forward(request, response);	
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
		}
	}
	
	private void addCheckout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		String isbn = request.getParameter("isbn");
		Date checkoutDate = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);
		Date dueDate = new Date(c.getTimeInMillis());
		if (bookCheckoutDAO.addBookCheckout(
				new BookCheckout(0, patronId, isbn, checkoutDate, dueDate, null)))
			System.out.println("Sucess add BookCheckout " + isbn);
	}
	
	private void returnCheckout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("checkoutID"));
		if (bookCheckoutDAO.returnBookCheckout(new BookCheckout(id, 0, null, null, null, null)))
			System.out.println("Sucess returned checkout " + id);
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
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
