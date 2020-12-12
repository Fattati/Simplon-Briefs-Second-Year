package club_lecture;
import java.util.*; 

public class Lecture_main {

	public static void main(String[] args) {
		String entity;
		String option;
		
		
		
		Scanner s = new Scanner(System.in);
		ArrayList <Livre> fiction = new ArrayList <Livre>();
		ArrayList <Bienfaiteur> bien = new ArrayList <Bienfaiteur>();
		ArrayList <Lecteur> lect = new ArrayList <Lecteur>();
		
		while(1==1) {
			
			
			
		System.out.println("choisir l'entité voulu:");
		System.out.println("1-livres");
		System.out.println("2-Lecteur");
		System.out.println("3-bienfaiteur");
		System.out.println("0-quitter");
		entity = s.next();
		
		
		switch(entity) {
		
		
		
	//livres	
		
		case "1":
			
			System.out.println("1-ajouter");
			System.out.println("2-modifier");
			System.out.println("3-suprimer");
			System.out.println("4-rechercher");
			System.out.println("5-consulter");
			System.out.println("0-quitter");
			option = s.next();
			int quitterLivre = 0;
			
			switch(option) {
			case"1":
				do {
					
					fiction.add(new Livre());
					System.out.println("voulez vous quitter");
					System.out.println("1-oui");
					System.out.println("0-non");
					
					quitterLivre= s.nextInt();
					
				}
				while( quitterLivre== 0) ;
				break;
			case"2":
				System.out.println("donnez l'identifiant à modifier");
				int modifié = s.nextInt();
				int trouvés=0;
				for(int i=0;i<fiction.size();i++) {
					if(fiction.get(i).getId_livre()==modifié) {
						fiction.get(i).afficherLivre();	
						fiction.get(i).modifier();
						trouvés++;
					}
					
				}
				if(trouvés==0) {
					System.out.println("ce livre n'existe pas");
				}
				break;
			case"3":
				System.out.println("donnez l'identifiant du livre que vous voulez suprimer");
				int remove = s.nextInt();
				for(int i=0;i<fiction.size();i++) {
					if(fiction.get(i).getId_livre()== remove) {
						fiction.remove(i);	
					}	
				}
				break;
			case"4":
				System.out.println("donnez l'identifiant à rechercher");
				int recherche = s.nextInt();
				int trouvé=0;
				for(int i=0;i<fiction.size();i++) {
					if(fiction.get(i).getId_livre()==recherche) {
						fiction.get(i).afficherLivre();	
						trouvé++;
					}
					
				}
				if(trouvé==0) {
					System.out.println("ce livre n'existe pas");
				}
				
				break;
			case"5":
				for(int i=0;i<fiction.size();i++) {
					fiction.get(i).afficherLivre();	
				}
				
				break;
			case"0":
				break;
			}
			
			break;
			
			
			
			
			
			
			
		
			
	//Leteurs
		case "2":
			System.out.println("1-ajouter");
			System.out.println("2-modifier");
			System.out.println("3-suprimer");
			System.out.println("4-rechercher");
			System.out.println("5-consulter");
			System.out.println("0-quitter");
			option = s.next();
			int quitterlect = 0;
			
			switch(option) {
			case"1":
				do {
					
					lect.add(new Lecteur("child"));
					System.out.println("voulez vous quitter");
					System.out.println("1-oui");
					System.out.println("0-non");
					
					quitterlect= s.nextInt();
					
				}
				while( quitterlect== 0) ;
				break;
			case"2":
				System.out.println("donnez l'identifiant à modifier");
				int modifié = s.nextInt();
				int trouvés=0;
				for(int i=0;i<lect.size();i++) {
					if(lect.get(i).getId_user()==modifié) {
						lect.get(i).afficherbien();	
						lect.get(i).modifier();
						trouvés++;
					}
					
				}
				if(trouvés==0) {
					System.out.println("ce bien lecteur n'existe pas");
				}
				break;
			case"3":
				System.out.println("donnez l'identifiant du lecteur que vous voulez suprimer");
				int remove = s.nextInt();
				int found=0;
				for(int i=0;i<lect.size();i++) {
					if(lect.get(i).getId_user()== remove) {
						lect.remove(i);	
						found++;
					}	
				}
				if(found==0) {
					System.out.println("ce lecteur n'existe pas");
				}
				
				break;
			case"4":
				System.out.println("donnez l'identifiant à rechercher");
				int recherche = s.nextInt();
				int trouvé=0;
				for(int i=0;i<lect.size();i++) {
					if(lect.get(i).getId_user()==recherche) {
						lect.get(i).afficherbien();	
						trouvé++;
					}
					
				}
				if(trouvé==0) {
					System.out.println("ce lecteur n'existe pas");
				}
				
				break;
			case"5":
				int counter_super=0;
				for(int i=0;i<lect.size();i++) {
					if(lect.get(i).getL()>4) {
						counter_super++;
					}
				}
				System.out.println("le nombre des lectuers est"+lect.size());
				System.out.println("le nombre des lecteurs super-fidels est"+counter_super);
				break;
			case"0":
				break;
			}
			
			
			
			
			break;
			
			
			
			
			
			
			
			
			
			
			
			
			
	//bienfaiteur
		case "3":
			
			System.out.println("1-ajouter");
			System.out.println("2-modifier");
			System.out.println("3-suprimer");
			System.out.println("4-rechercher");
			System.out.println("5-consulter");
			System.out.println("0-quitter");
			option = s.next();
			int quitterbien = 0;
			
			switch(option) {
			case"1":
				do {
					
					bien.add(new Bienfaiteur());
					System.out.println("voulez vous quitter");
					System.out.println("1-oui");
					System.out.println("0-non");
					
					quitterbien= s.nextInt();
					
				}
				while( quitterbien== 0) ;
				break;
			case"2":
				System.out.println("donnez l'identifiant à modifier");
				int modifié = s.nextInt();
				int trouvés=0;
				for(int i=0;i<bien.size();i++) {
					if(bien.get(i).getId_user()==modifié) {
						bien.get(i).afficherbien();	
						bien.get(i).modifier();
						trouvés++;
					}
					
				}
				if(trouvés==0) {
					System.out.println("ce bien faiteur n'existe pas");
				}
				break;
			case"3":
				System.out.println("donnez l'identifiant du livre que vous voulez suprimer");
				int remove = s.nextInt();
				for(int i=0;i<bien.size();i++) {
					if(bien.get(i).getId_user()== remove) {
						bien.remove(i);	
					}	
				}
				break;
			case"4":
				System.out.println("donnez l'identifiant à rechercher");
				int recherche = s.nextInt();
				int trouvé=0;
				for(int i=0;i<bien.size();i++) {
					if(bien.get(i).getId_user()==recherche) {
						bien.get(i).afficherbien();	
						trouvé++;
					}
					
				}
				if(trouvé==0) {
					System.out.println("ce bienteur n'existe pas");
				}
				
				break;
			case"5":
				int counter_super=0;
				for(int i=0;i<bien.size();i++) {
					if(bien.get(i).getL()>3) {
						counter_super++;
					}
				}
				System.out.println("le nombre des bienfaiteur est"+bien.size());
				System.out.println("le nombre des bienfaiteur super-fidels est"+counter_super);
				break;
			case"0":
				break;
			}
			
			break;
			
			
			
			
			
			
			
			
			
	//stop program
		case "0":
			break;
		  }
		}
	}

}
