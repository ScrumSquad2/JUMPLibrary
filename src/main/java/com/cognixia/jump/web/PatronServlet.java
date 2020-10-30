package com.cognixia.jump.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.cognixia.jump.dao.BookDAO;
import com.cognixia.jump.dao.BookDAOImpl;
import com.cognixia.jump.dao.ItemNotFoundInDatabaseException;
import com.cognixia.jump.dao.PatronDAO;
import com.cognixia.jump.dao.PatronDAOImpl;
import com.cognixia.jump.dao.UsernameAlreadyExistsException;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.BookCheckout;
import com.cognixia.jump.model.MessageConstant;
import com.cognixia.jump.model.Patron;

@WebServlet("/patron/*")
public class PatronServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
    private PatronDAO patronDAO;
    private BookCheckoutDAO bookCheckoutDAO;
	private BookDAO bookDAO;
    private static Patron patron;
	
	@Override
	public void init() {
		
		patronDAO = new PatronDAOImpl();
		bookCheckoutDAO = new BookCheckoutDAOImpl();
		bookDAO = new BookDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		switch(action) {
		case "/newPatron":
			newPatron(request, response);
			break;
		case "/addPatron":
			insertPatron(request, response);
			break;
		case "/listAllBooks":
			listAllBooks(request, response);
			break;
		case "/loginPatron":
			loginPatron(request, response);
			break;
		case "/displayProfile":
			displayProfile(request, response);
			break;
		case "/logoutPatron":
			logoutPatron(request, response);
			break;
		case "/editPatron":
			editPatron(request, response);
			break;
		case "/updatePatron":
			updatePatron(request, response);
			break;
		case "/listCurrent":
			listCurrent(request, response);
			break;
		case "/listReturned":
			listReturned(request, response);
			break;
		case "/addCheckout":
			addCheckout(request, response);
			break;
		case "/returnCheckout":
			returnCheckout(request, response);
			break;
		case "/searchBooks":
			searchBooks(request, response);
			break;
		default:
			response.sendRedirect("/JUMPLibrary");
			break ;
		}
		
	}
	
	private void newPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patronSignup.jsp");
		System.out.println("send to dispatcher");
		dispatcher.forward(request, response);
	}
	
	private void insertPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean accountFrozen = true;
		
		try {
			Patron newPatron = new Patron(0, firstName, lastName, userName, password, accountFrozen);
			patronDAO.addPatron(newPatron);
			System.out.println("Sucess add " + patron);
			patron = newPatron;
			listAllBooks(request, response);
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username alredy exist");
			request.setAttribute("message", MessageConstant.DUPLICATE_USERNAME);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/patronSignup.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	private void listAllBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		List<Book> allBooks = bookDAO.getAllBooks();
		request.setAttribute("allBooks", allBooks);
		request.setAttribute("patron", patron);
		System.out.println("allBooks: " + allBooks);
		//TODO: change the jsp to the list jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patronBook.jsp");
		System.out.println("send to dispatcher");
		dispatcher.forward(request, response);
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
				request.setAttribute("message", MessageConstant.INVALID_PASSWORD);
				request.getRequestDispatcher("/index.jsp").forward(request, response);		
			} else {
				listAllBooks(request, response);
			}
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
			System.out.println("Cannot found patron");
			patron = null;
			request.setAttribute("message", MessageConstant.INVALID_USERNAME);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);		
		}
	}
	
	private void displayProfile(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		request.setAttribute("patron", patron);
		request.getRequestDispatcher("/patronProfile.jsp").forward(request, response);
	}
	
	private void logoutPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron != null)
			patron = null;
		response.sendRedirect("/JUMPLibrary");
	}
	
	private void editPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		request.setAttribute("patron", patron);
		request.getRequestDispatcher("/patron-form.jsp").forward(request, response);
	}
	
	private void updatePatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		int patronId = Integer.parseInt(request.getParameter("patronId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("new-password");
		boolean accountFrozen = false;
		if (!password.equals(patron.getPassword())) {
			request.setAttribute("message", MessageConstant.INVALID_PASSWORD);
			request.setAttribute("patron", patron);
			request.getRequestDispatcher("/patron-form.jsp").forward(request, response);
		} else if (newPassword != null && !newPassword.isEmpty()) {
			password = newPassword;
		}
		
		try {
			Patron newPatron = new Patron(patronId, firstName, lastName, userName, password, accountFrozen);
			patronDAO.updatePatron(newPatron);
			patron = newPatron;
			System.out.println("Sucess update " + userName);
			request.setAttribute("patron", patron);
			request.getRequestDispatcher("/patron-form.jsp").forward(request, response);
		} catch (UsernameAlreadyExistsException e) {
			request.setAttribute("message", MessageConstant.DUPLICATE_USERNAME);
			request.setAttribute("patron", patron);
			request.getRequestDispatcher("/patron-form.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	private void listCurrent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		System.out.println("patronID: " + patron.getPatronId());
		List<BookCheckout> bookCheckouts;
		bookCheckouts = bookCheckoutDAO.getAllNonReturnedCheckouts(patron);
		System.out.println("bookCheckouts: " + bookCheckouts);

		request.setAttribute("bookCheckouts", bookCheckouts);
		// TODO change to correct jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patronReturn.jsp");
		System.out.println("send");
		dispatcher.forward(request, response);
	}
	
	private void listReturned(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		System.out.println("patronID: " + patron.getPatronId());
		List<BookCheckout> bookCheckouts;
		bookCheckouts = bookCheckoutDAO.getAllCheckouts(patron);
		System.out.println("bookCheckouts: " + bookCheckouts);

		request.setAttribute("isHistory", true);
		request.setAttribute("bookCheckouts", bookCheckouts);
		// TODO change to correct jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patronReturn.jsp");
		System.out.println("send");
		dispatcher.forward(request, response);
	}

	private void addCheckout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");		
		String isbn = request.getParameter("isbn");
		Date checkoutDate = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);
		Date dueDate = new Date(c.getTimeInMillis());
		if (bookCheckoutDAO.addBookCheckout(
				new BookCheckout(0, patron.getPatronId(), isbn, checkoutDate, dueDate, null)))
			System.out.println("Sucess add BookCheckout " + isbn);
		listAllBooks(request, response);
	}
	
	private void returnCheckout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (patron == null)
			response.sendRedirect("/JUMPLibrary");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
				bookCheckoutDAO.returnBookCheckout(bookCheckoutDAO.getBookCheckoutById(id));
				System.out.println("Sucess returned checkout " + id);
		} catch (ItemNotFoundInDatabaseException e) {
			e.printStackTrace();
		}
		listCurrent(request, response);
	}
	
	private void searchBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String search = request.getParameter("search-books");
		if (search == null || search.isEmpty()) {
			listAllBooks(request, response);
		} else if (search.length() == 10 && search.matches("[0-9]+")) {
			try {
				List<Book> allBooks = new ArrayList<>();
				allBooks.add(bookDAO.getBookByIsbn(search));
				request.setAttribute("allBooks", allBooks);
				request.setAttribute("patron", patron);
				request.getRequestDispatcher("/patronBook.jsp").forward(request, response);
			} catch (ItemNotFoundInDatabaseException e) {
				listAllBooks(request, response);
			}
		} else {
			List<Book> allBooks = bookDAO.getBooksByTitle(search);
			request.setAttribute("allBooks", allBooks);
			request.setAttribute("patron", patron);
			request.getRequestDispatcher("/patronBook.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
