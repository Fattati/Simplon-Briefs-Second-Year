package Models;

public abstract class User {
   private int id;
   private String nomuser;
   private String email;
   private String password;
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnomuser() {
		return nomuser;
	}
	public void setnomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id, String nomuser, String email) {
		this.id = id;
		this.nomuser = nomuser;
		this.email = email;
	}
	
	public User(String nomuser, String email, String password) {
		this.nomuser = nomuser;
		this.email = email;
		this.password = password;
	}
	
	

}