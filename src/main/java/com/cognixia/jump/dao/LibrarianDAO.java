package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Librarian;

public interface LibrarianDAO {
	
	public List<Librarian> getAllLibrarians();
	
	public Librarian getLibrarianByUser(String user) throws ItemNotFoundInDatabaseException;
	
	public boolean addLibrarian(Librarian libr) throws UsernameAlreadyExistsException;
	
	public boolean deleteLibrarianByUser(String user);
	
	public boolean updateLibrarian(Librarian libr);

}
