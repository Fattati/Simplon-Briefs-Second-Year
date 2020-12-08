package employee.app;


abstract class Employee {
protected String nom;
	
	public Employee(String nom) {
		this.nom=nom;
		}
	abstract double salaireMensuel();

}
