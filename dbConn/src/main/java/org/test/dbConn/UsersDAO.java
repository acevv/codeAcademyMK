package org.test.dbConn;

import java.util.List;

public interface UsersDAO {

	public String insertUserInDB(Korisnik user);
	public List<Korisnik> getAllUsers();
	public Korisnik getUserByID(Integer id);
	
	public String insertUserInDBwithPreparedStatement(Korisnik user);

}
