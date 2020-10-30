package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;

public class BookDAOImpl implements BookDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Book> getAllBooks() {

		ArrayList<Book> result = new ArrayList<Book>();
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from book");
				ResultSet rs = pstmt.executeQuery();
			) {
			
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String desc = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date addedToLibrary = rs.getDate("added_to_library");
				
				Book book = new Book(isbn, title, desc, rented, addedToLibrary);
				result.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Book getBookByIsbn(String isbn) throws ItemNotFoundInDatabaseException {
		
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement("select * from book where isbn = ?")
			) {
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String desc = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date addedToLibrary = rs.getDate("added_to_library");
				
				Book book = new Book(isbn, title, desc, rented, addedToLibrary);
				return book;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new ItemNotFoundInDatabaseException(isbn, "book");
		
	}

	@Override
	public boolean addBook(Book book) {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into book values(?,?,?,false,current_date())")) {
			
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDesc());
			
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBookByIsbn(String isbn) {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from book where isbn = ?")) {
			
			pstmt.setString(1, isbn);
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		try (PreparedStatement pstmt = conn.prepareStatement("update book "
				+ "set title = ?, "
				+ "descr = ?, "
				+ "rented = ?, "
				+ "added_to_library = ? "
				+ "where isbn = ?")) {
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getDesc());
			pstmt.setBoolean(3, book.getRented());
			pstmt.setDate(4, book.getAddedToLibrary());
			pstmt.setString(5, book.getIsbn());
			
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Book> getBooksByTitle(String searchTitle) {

		ArrayList<Book> result = new ArrayList<Book>();

		try (PreparedStatement pstmt = conn.prepareStatement("select * from book WHERE title LIKE ?");
				) {
			pstmt.setString(1, "%"+searchTitle+"%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String desc = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date addedToLibrary = rs.getDate("added_to_library");

				Book book = new Book(isbn, title, desc, rented, addedToLibrary);
				result.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
