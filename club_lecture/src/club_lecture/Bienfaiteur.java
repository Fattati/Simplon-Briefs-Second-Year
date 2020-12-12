package club_lecture;
import java.util.*; 
public class Bienfaiteur {
	protected  int Id_user;
	protected  String nom;
	protected  String mail;
	protected  int L;
	Scanner s = new Scanner(System.in);
	
public Bienfaiteur() {
	System.out.println("entrez l'identifiant du bienfaiteur");
	this.Id_user = s.nextInt();
	System.out.println("entrez le nom du bienfaiteur");
	this.nom = s.next();
	System.out.println("entrez l'email du bienfaiteur");
	this.mail = s.next();
	System.out.println("entrez lle nombre de livres donné par le  bienfaiteur");
	this.L = s.nextInt();
}
public Bienfaiteur(String child) {
	System.out.println("entrez l'identifiant du lecteur");
	this.Id_user = s.nextInt();
	System.out.println("entrez le nom du lecteur");
	this.nom = s.next();
	System.out.println("entrez l'email du lecteur");
	this.mail = s.next();
	System.out.println("entrez lle nombre de livres lu par le  lecteur");
	this.L = s.nextInt();
}
public int getId_user() {
	return Id_user;
}
public void setId_user(int id_user) {
	Id_user = id_user;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public int getL() {
	return L;
}
public void setCarte(int L) {
	this.L = L;
}
public void afficherbien() {
	
	System.out.println("id bien: "+this.getId_user());
	System.out.println("nom du bien: "+this.getNom());
	System.out.println("mail bien: "+this.getMail());
	System.out.println("livres donné: "+this.getL());
}
public void modifier() {
	
	System.out.println("entrez le nouveau nom ");
	this.nom=s.next();
	System.out.println("entrez le nouveau mail ");
	this.mail=s.next();
	System.out.println("entrez le nouveau nombre des livres donné ");
	this.L=s.nextInt();
	
}
}
