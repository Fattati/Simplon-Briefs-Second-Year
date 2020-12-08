package employee.app;


class EmployeeFix extends Employee{
	double salaireBase;
	public EmployeeFix(String nom, double salaireBase) {
		
		super(nom);
		this.nom=nom;
		this.salaireBase=salaireBase;
		}
	double salaireMensuel() {
		return this.salaireBase;
	}
}