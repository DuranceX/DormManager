package top.young.model;

public class User {
	private String id;
	private String username;
	private String password;
	private int identity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password,int identity) {
		super();
		this.username = username;
		this.password = password;
		this.identity = identity;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public User(String id, String username, String password, int identity) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.identity = identity;
	}
	
}
