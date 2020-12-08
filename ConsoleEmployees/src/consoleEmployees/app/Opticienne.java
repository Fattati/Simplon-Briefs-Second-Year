package consoleEmployees.app;

public class Opticienne extends Personne {

	public Opticienne(String name, int age) {
		super(name, age);
		
	}
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.print(" et je travaille en tant que opticienne !");
	}

}
