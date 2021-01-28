package Models;

public class Apprenant extends User {
   private int idPromotion;

	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	   
	public Apprenant(int id, String nomComplet, String email, int idPromotion) {
		super(id, nomComplet, email);
		this.idPromotion = idPromotion;
	}
	
	public Apprenant(String nomComplet, String email, String password, int idPromotion) {
		super(nomComplet, email, password);
		this.idPromotion = idPromotion;
	}

}