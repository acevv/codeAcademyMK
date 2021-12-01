package org.test.dbConn;

public class UserDAO {

	private Integer id;
	private String name;
	private String email;
	private String user_pass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public UserDAO(Integer id, String name, String email, String user_pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.user_pass = user_pass;
	}
	public UserDAO() {
		super();
	}

	

}
