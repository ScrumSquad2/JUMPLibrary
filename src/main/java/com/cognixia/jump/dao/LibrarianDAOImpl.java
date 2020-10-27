package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Librarian;

public class LibrarianDAOImpl implements LibrarianDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Librarian> getAllLibrarians() {
		
		ArrayList<Librarian> result = new ArrayList<Librarian>();
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from librarian");
				ResultSet rs = pstmt.executeQuery();
			) {
			
			while(rs.next()) {
				int libId = rs.getInt("librarian_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Librarian librarian = new Librarian(libId, username, password);
				result.add(librarian);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public Librarian getLibrarianByUser(String user) throws ItemNotFoundInDatabaseException {
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement("select * from librarian where username = ?")
				) {
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int libId = rs.getInt("librarian_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Librarian librarian = new Librarian(libId, username, password);
				return librarian;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new ItemNotFoundInDatabaseException(user, "librarian");
		
	}

	@Override
	public boolean addLibrarian(Librarian libr) throws UsernameAlreadyExistsException {
		
		if (UsernameChecker.doesDuplicateUsernameExist(libr)) {
			throw new UsernameAlreadyExistsException(libr.getUserName(), "librarian");
		}
		
		try (PreparedStatement pstmt = conn.prepareStatement("insert into librarian values(?,?,?)")) {
			pstmt.setInt(1, libr.getLibrarianId());
			pstmt.setString(2, libr.getUserName());
			pstmt.setString(3, libr.getPassword());
			
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteLibrarianByUser(String user) {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from librarian where username = ?")) {
			
			pstmt.setString(1, user);
			int count = pstmt.executeUpdate();
			if(count == 1) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateLibrarian(Librarian libr) throws UsernameAlreadyExistsException {
		
		if (UsernameChecker.doesDuplicateUsernameExist(libr)) {
			throw new UsernameAlreadyExistsException(libr.getUserName(), "librarian");
		}
		
		try (PreparedStatement pstmt = conn.prepareStatement("update librarian "
				+ "set username = ?, "
				+ "password = ? "
				+ "where librarian_id = ?")) {
			
			pstmt.setString(1, libr.getUserName());
			pstmt.setString(2, libr.getPassword());
			pstmt.setInt(3, libr.getLibrarianId());
			
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
