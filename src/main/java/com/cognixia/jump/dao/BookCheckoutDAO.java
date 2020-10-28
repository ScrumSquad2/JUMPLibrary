package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.BookCheckout;
import com.cognixia.jump.model.Patron;

public interface BookCheckoutDAO {
	
	public List<BookCheckout> getAllCheckouts(Patron patron);
	
	public List<BookCheckout> getAllNonReturnedCheckouts(Patron patron);
	
	public BookCheckout getBookCheckoutById(int id) throws ItemNotFoundInDatabaseException;

	public boolean addBookCheckout(BookCheckout checkout);
	
	public boolean returnBookCheckout(BookCheckout checkout);
	
}
