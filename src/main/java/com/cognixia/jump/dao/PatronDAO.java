package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Patron;

public interface PatronDAO {
	
	public List<Patron> getAllPatrons();
	
	public Patron getPatronById(int id) throws ItemNotFoundInDatabaseException;
	
	public Patron getPatronByUser(String userName) throws ItemNotFoundInDatabaseException;
	
	public boolean addPatron(Patron patron) throws UsernameAlreadyExistsException;
	
	public boolean deletePatronById(int id);
	
	public boolean updatePatron(Patron patron) throws UsernameAlreadyExistsException;
	
	public boolean freezePatron(Patron patron);
	
	public boolean unfreezePatron(Patron patron);

}
