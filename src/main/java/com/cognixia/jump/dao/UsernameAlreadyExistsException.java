package com.cognixia.jump.dao;

public class UsernameAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4737187014721876263L;
	
	public UsernameAlreadyExistsException (String username, String table) {
		super("The username \"" + username + "\" already exists in the target table \"" + table + "\".");
	}
	
	

}
