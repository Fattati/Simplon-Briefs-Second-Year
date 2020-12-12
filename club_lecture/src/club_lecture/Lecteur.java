package club_lecture;
//MEHDI SNAIKI & REDA FATTATI
class Lecteur extends Bienfaiteur {
private String prenom;
private String téléphone;

public Lecteur(String child) {
	super(child);
	System.out.println("entrez prenom du Lecteur");
	this.prenom = s.next();
	System.out.println("entrez téléphone du Lecteur");
	this.téléphone = s.next();
	
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getTéléphone() {
	return téléphone;
}

public void setTéléphone(String téléphone) {
	this.téléphone = téléphone;
}
public void afficherbien() {
	
	System.out.println("id lecteur: "+this.getId_user());
	System.out.println("nom du lecteur: "+this.getNom());
	System.out.println("prenom lecteur: "+this.getPrenom());
	System.out.println("telephone lecteur: "+this.getTéléphone());
	System.out.println("mail lecteur: "+this.getMail());
	System.out.println("livres lu: "+this.getL());
	
}
public void modifier() {
	
	System.out.println("entrez le nouveau nom ");
	this.nom=s.next();
	System.out.println("entrez le nouveau prenom ");
	this.prenom=s.next();
	System.out.println("entrez le nouveau telephone ");
	this.téléphone=s.next();
	System.out.println("entrez le nouveau mail ");
	this.mail=s.next();
	System.out.println("entrez le nouveau nombre des livres donné ");
	this.L=s.nextInt();
	
}




}
