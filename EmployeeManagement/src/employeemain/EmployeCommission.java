


package employeemain;

class EmployeCommission extends Employee{
	private double ventes;
	private double commision;
	private double salaireBase;
public EmployeCommission(String nom, double salaireBase,double ventes,double commision) {
		
		super(nom);
		this.nom=nom;
		this.salaireBase=salaireBase;
		this.ventes=ventes;
		this.commision=commision;
		}
double salaireMensuel() {
	double salaireMensuel=this.salaireBase+this.ventes*this.commision;
	return salaireMensuel;
}


}
