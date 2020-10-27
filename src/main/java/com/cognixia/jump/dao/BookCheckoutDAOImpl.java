package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.BookCheckout;
import com.cognixia.jump.model.Patron;

public class BookCheckoutDAOImpl implements BookCheckoutDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<BookCheckout> getAllCheckouts(Patron patron) {
		
		ArrayList<BookCheckout> result = new ArrayList<BookCheckout>();
		
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement("select * from book_checkout where patron_id = ?")) {
			pstmt.setInt(1, patron.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("checkout_id");
				int patronId = rs.getInt("patron_id");
				String isbn = rs.getString("isbn");
				Date checkoutDate = rs.getDate("checkedout");
				Date dueDate = rs.getDate("due_date");
				Date returnedDate = rs.getDate("returned");
				
				BookCheckout chk = new BookCheckout(id, patronId, isbn, checkoutDate, dueDate, returnedDate);
				result.add(chk);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<BookCheckout> getAllNonReturnedCheckouts(Patron patron) {

		ArrayList<BookCheckout> result = new ArrayList<BookCheckout>();
		
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement("select * from book_checkout "
				+ "where patron_id = ? and returned is null")) {
			pstmt.setInt(1, patron.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("checkout_id");
				int patronId = rs.getInt("patron_id");
				String isbn = rs.getString("isbn");
				Date checkoutDate = rs.getDate("checkedout");
				Date dueDate = rs.getDate("due_date");
				Date returnedDate = rs.getDate("returned");
				
				BookCheckout chk = new BookCheckout(id, patronId, isbn, checkoutDate, dueDate, returnedDate);
				result.add(chk);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public boolean addBookCheckout(BookCheckout checkout) {
		
		try (PreparedStatement pstmt = conn.prepareStatement("insert into book_checkout values(null, ?,?,?,?,?)")
				) {
			
			pstmt.setInt(1, checkout.getPatronId());
			pstmt.setString(2, checkout.getIsbn());
			pstmt.setDate(3, checkout.getCheckoutDate());
			pstmt.setDate(4, checkout.getDueDate());
			pstmt.setDate(5, checkout.getReturnedDate());
			
			int count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean returnBookCheckout(BookCheckout checkout) {

		try (PreparedStatement pstmt = conn.prepareStatement("update book_checkout "
				+ "set returned = current_date() "
				+ "where checkout_id = ?")
				) {
			pstmt.setInt(1, checkout.getId());
			
			int count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
