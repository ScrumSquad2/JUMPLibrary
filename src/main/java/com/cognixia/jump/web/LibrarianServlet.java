package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDAO;
import com.cognixia.jump.dao.BookDAOImpl;
import com.cognixia.jump.dao.ItemNotFoundInDatabaseException;
import com.cognixia.jump.dao.LibrarianDAO;
import com.cognixia.jump.dao.LibrarianDAOImpl;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOImpl;
import com.cognixia.jump.dao.UsernameAlreadyExistsException;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;



@WebServlet("/librarian/*")
public class LibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private LibrarianDAO librarianDAO;
	private BookDAO bookDAO;
	private PatronDAO patronDAO;
	private static Librarian librarian;
	//private static Patron patron;
	
	@Override
	public void init() {
		// creates connection and the DAO once needed
		librarianDAO = new LibrarianDAOImpl();
		bookDAO = new BookDAOImpl();
		patronDAO = new PatronDAOImpl();
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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		switch(action) {
		case "/listAllBooks":
			listAllBooks(request,response);
			break;
		case "/addBook":
			addBook(request,response);
			break;
		case "/updateBook":
			updateBook(request,response);
			break;
		case "/listAllPatrons":
			listAllPatrons(request,response);
			break;
		case "/freezePatron":
			freezePatron(request, response);
			break;
		case "/unfreezePatron":
			unfreezePatron(request, response);
			break;
		case "/loginLibrarian":
			loginLibrarian(request,response);
			break;
		case "/logoutLibrarian":
			logoutLibrarian(request,response);
			break;
		case "/updateLibrarian":
			updateLibrarian(request,response);
			break;
		case "/editLibrarian":
			editLibrarian(request, response);
			break;
		}
	}
	
	// Note: Will add librarian functions after sending changes to master
	private void listAllBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		List<Book> allBooks = bookDAO.getAllBooks();
		request.setAttribute("allBooks", allBooks);
		System.out.println("All Books: " + allBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianBook.jsp");
		System.out.println("Send to dispatcher");
		dispatcher.forward(request, response);
	}
	
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		if (bookDAO.addBook(
				new Book(isbn, title, desc, false, null))) {
			System.out.println("New book added: " + title);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianAddBook.jsp");
			System.out.println("Send to dispatcher");
			dispatcher.forward(request, response);
		}
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		if(bookDAO.updateBook(
				new Book(isbn, title, desc, false, null))) {
			System.out.println("Book updated: " + title);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianAddBook.jsp");
			System.out.println("Send to dispatcher");
			dispatcher.forward(request, response);
		}
	}
	
	/**private void addLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Librarian newLibrarian = new Librarian(userName, password);
			librarianDAO.addLibrarian(newLibrarian);
			System.out.println("New librarian added: " + librarian);
			librarian = newLibrarian ;
			listAllBooks(request, response);
		} catch (UsernameAlreadyExistsException e) {
			newLibrarian(request, response);
			e.printStackTrace();
		}
	}
	**/
	
	private void listAllPatrons(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		List<Patron> allPatrons = patronDAO.getAllPatrons();
		request.setAttribute("allPatrons", allPatrons);
		System.out.println("All Patrons: " + allPatrons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarianPatron.jsp");
		System.out.println("Send to dispatcher");
		dispatcher.forward(request, response);	
	}
	
	private void freezePatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		try {
			Patron patron = patronDAO.getPatronById(patronId);
			patronDAO.freezePatron(patron);
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
		}
		listAllPatrons(request, response);
	}
	
	private void unfreezePatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		try {
			Patron patron = patronDAO.getPatronById(patronId);
			patronDAO.unfreezePatron(patron);
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
		}
		listAllPatrons(request, response);
	}
	
	private void loginLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("login");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			 librarian = librarianDAO.getLibrarianByUser(userName);
			if (!librarian.getPassword().equals(password)) {
				librarian = null;
				System.out.println("Invalid password");
				response.sendRedirect("/JUMPLibrary");
			} else {
				listAllBooks(request, response);
			}
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
			System.out.println("Cannot find librarian");
			librarian = null;
			response.sendRedirect("/JUMPLibrary");
		}	
	}
	
	private void logoutLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (librarian != null)
			librarian = null;
		response.sendRedirect("/JUMPLibrary");
	}
	
	private void updateLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			Librarian newLibrarian = new Librarian(librarian.getLibrarianId(), userName, password);
			librarianDAO.updateLibrarian(newLibrarian);
			librarian = newLibrarian;
			System.out.println("Librarian :" + userName);
			request.setAttribute("librarian", librarian);
			request.getRequestDispatcher("/librarian-form.jsp").forward(request, response);
		} catch (UsernameAlreadyExistsException e) {
			request.setAttribute("librarian", librarian);
			request.getRequestDispatcher("/librarian-form.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	private void editLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		if (librarian == null)
			response.sendRedirect("/JUMPLibrary");
		request.setAttribute("librarian", librarian);
		request.getRequestDispatcher("/librarian-form.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request, response);
	}
}