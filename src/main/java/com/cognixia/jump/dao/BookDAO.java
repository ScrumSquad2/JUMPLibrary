package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Book;

public interface BookDAO {
	
	public List<Book> getAllBooks();
	
	public Book getBookByIsbn(String isbn);
	
	public boolean addBook(Book book);
	
	public boolean deleteBookByIsbn(String isbn);
	
	public boolean updateBook(Book book);

}
