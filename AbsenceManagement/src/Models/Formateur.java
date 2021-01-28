package Models;

public class Formateur extends User {
	public Formateur(int id, String nomuser, String email) {
		super(id, nomuser, email);
	}
	
	public Formateur(String nomuser, String email, String password) {
		super(nomuser, email, password);
	}
}