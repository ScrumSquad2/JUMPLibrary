package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Patron;

public class PatronDAOImpl implements PatronDAO {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Patron> getAllPatrons() {

		ArrayList<Patron> result = new ArrayList<Patron>();
	
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from patron");
				ResultSet rs = pstmt.executeQuery();
			){
			
			while(rs.next()) {
				int id = rs.getInt("patron_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				boolean accountFrozen = rs.getBoolean("account_frozen");
				
				Patron patron = new Patron(id, firstName, lastName, userName, password, accountFrozen);
				result.add(patron);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public Patron getPatronById(int id) throws ItemNotFoundInDatabaseException {
		
		ResultSet rs = null;
		try (PreparedStatement pstmt
				= conn.prepareStatement("select * from patron where patron_id = ?");
			) {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				boolean accountFrozen = rs.getBoolean("account_frozen");
				
				Patron patron = new Patron(id, firstName, lastName, userName, password, accountFrozen);
				return patron;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new ItemNotFoundInDatabaseException(id, "patron");
		
	}

	@Override
	public boolean addPatron(Patron patron) {

		try(PreparedStatement pstmt = conn.prepareStatement("insert into patron values(null, ?,?,?,?,?)")) {
			pstmt.setString(1, patron.getFirstName());
			pstmt.setString(2, patron.getLastName());
			pstmt.setString(3, patron.getUserName());
			pstmt.setString(4, patron.getPassword());
			pstmt.setBoolean(5, patron.getAccountFrozen());
			
			int updated = pstmt.executeUpdate();
			if (updated == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePatronById(int id) {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from patron where patron_id = ?")) {
			pstmt.setInt(1, id);
			
			int updated = pstmt.executeUpdate();
			if (updated == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updatePatron(Patron patron) {

		try (PreparedStatement pstmt = conn.prepareStatement("update patron"
				+ " set first_name = ?, last_name = ?, username = ?,"
				+ " password = ?, account_frozen = ? where patron_id = ?");) {
			
			pstmt.setString(1, patron.getFirstName());
			pstmt.setString(2, patron.getLastName());
			pstmt.setString(3, patron.getUserName());
			pstmt.setString(4, patron.getPassword());
			pstmt.setBoolean(5, patron.getAccountFrozen());
			pstmt.setInt(6, patron.getPatronId());
			
			int updated = pstmt.executeUpdate();
			if (updated == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
