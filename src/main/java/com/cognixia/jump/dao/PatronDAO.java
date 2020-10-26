package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Patron;

public interface PatronDAO {
	
	public List<Patron> getAllPatrons();
	
	public Patron getPatronById(int id);
	
	public boolean addPatron(Patron patron);
	
	public boolean deletePatronById(int id);
	
	public boolean updatePatron(Patron patron);

}
