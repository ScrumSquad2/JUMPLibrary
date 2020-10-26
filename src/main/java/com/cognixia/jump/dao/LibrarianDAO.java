package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Librarian;

public interface LibrarianDAO {
	
	public List<Librarian> getAllLibrarians();
	
	public Librarian getLibrarianByUser(String user);
	
	public boolean addLibrarian(Librarian libr);
	
	public boolean deleteLibrarianByUser(String user);
	
	public boolean updateLibrarian(Librarian libr);

}
