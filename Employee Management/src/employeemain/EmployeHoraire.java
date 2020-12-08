package employeemain;

class EmployeHoraire extends Employee{
private  int taux,heures;
public EmployeHoraire(String nom,int taux,int heures) {
	
	super(nom);
	this.taux=taux;
	this.heures=heures;
	this.nom=nom;
	}
 double salaireMensuel() {
	double salaireMensuel=this.heures*this.taux;
	return salaireMensuel;
}
}
