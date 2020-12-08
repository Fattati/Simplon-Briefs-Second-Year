package consoleEmployees.app;

public class Medecin extends Personne {

	public Medecin(String name, int age) {
		super(name, age);
		
	}
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.print(" et je travaille en tant que medecin !\n");
	}

}
