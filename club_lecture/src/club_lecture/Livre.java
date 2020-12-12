package club_lecture;
import java.util.*; 
public class Livre {
	//attributes
	private int id_livre;
	private String titre;
	private String edition;
	private String date;
	//scanner
	Scanner s = new Scanner(System.in);
	//getter
	public int getId_livre() {
		return id_livre;
	}
	//constructor
	public Livre() {
		System.out.println("entrez l'identifiant du livre");
		
		
	
		
		this.id_livre = s.nextInt();
		System.out.println("entrez le nom du livre");
		
		this.titre = s.next();;
		System.out.println("entrez  l'edition");
		
		this.edition = s.next();
		System.out.println("entrez la date de publication du livre");
		
		this.date = s.next();
		
	}
	//getters andsetters
	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	//show
	public void afficherLivre() {
		
			System.out.println("code du livre: "+this.getId_livre());
			System.out.println("nom du livre: "+this.getTitre());
			System.out.println("edition du livre: "+this.getEdition());
			System.out.println("date de publication du livre: "+this.getDate());
	}
	//modifier
	public void modifier() {
		
		System.out.println("entrez le nouveau nom ");
		this.titre=s.next();
		System.out.println("entrez la nouvelle edition ");
		this.edition=s.next();
		System.out.println("entrez la nouvelle date de publication ");
		this.date=s.next();
		
	}
	
	
	
	
}
