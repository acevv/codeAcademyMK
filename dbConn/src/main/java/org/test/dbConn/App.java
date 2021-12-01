package org.test.dbConn;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {

		UsersDAO dao = new UsersDAOImpl();

		Korisnik user1 = new Korisnik(1, "Aleksandar", "aleksandar@emailcom", "@l3ks@nd@r");
//		dao.insertUserInDB(user1);

		Korisnik user2 = new Korisnik(2, "Dimitar", "dimitar@gmail.com", "d1m!t@r");
//		dao.insertUserInDB(user2);
		List<Korisnik> allUsers = new ArrayList<Korisnik>();

		allUsers = dao.getAllUsers();
		
		for (Korisnik korisnik : allUsers) {
			System.out.println(korisnik.getName());
		}

//		System.out.println(allUsers.get(0).getName());
//		Korisnik user3 = new Korisnik();
//		user3 = dao.getUserByID(2);
//		System.out.println(user3.getName());
		
//		Korisnik user4 = new Korisnik(5, "Mite", "mitkoe@email.com", "T133");
//		System.out.println(dao.insertUserInDBwithPreparedStatement(user4));
		
		

	}
}
