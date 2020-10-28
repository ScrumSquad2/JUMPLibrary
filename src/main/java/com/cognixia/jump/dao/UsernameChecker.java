package com.cognixia.jump.dao;

import com.cognixia.jump.model.Librarian;
import com.cognixia.jump.model.Patron;

public class UsernameChecker {
	
	public static boolean doesDuplicateUsernameExist(Patron patron) {
		
		PatronDAO dao = new PatronDAOImpl();
		try { 
			Patron dupl = dao.getPatronByUser(patron.getUserName());
			if (dupl.getPatronId() != patron.getPatronId()) {
				return true;
			}
			return false;
		} catch (ItemNotFoundInDatabaseException e) {
			return false;
		}
		
	}
	
	public static boolean doesDuplicateUsernameExist(Librarian librarian) {
		
		LibrarianDAO dao = new LibrarianDAOImpl();
		try {
			Librarian dupl = dao.getLibrarianByUser(librarian.getUserName());
			if (dupl.getLibrarianId() != librarian.getLibrarianId()) {
				return true;
			}
			return false;
		} catch (ItemNotFoundInDatabaseException e) {
			return false;
		}
		
	}
	

}
