package com.cognixia.jump.dao;

public class ItemNotFoundInDatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8612900014003153610L;
	
	public ItemNotFoundInDatabaseException(String id, String table) {
		super("A query for the ID \"" + id + "\" in the target table \"" + table + "\" failed to return any results.");
	}
	
	public ItemNotFoundInDatabaseException(int id, String table) {
		super("A query for the ID \"" + id + "\" in the target table \"" + table + "\" failed to return any results.");
	}

}
