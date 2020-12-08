package consoleEmployees.app;

public class Personne {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Personne(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void afficher() {
		System.out.print("je suis "+getName()+", j'ai "+getAge()+" ans");
		
	}

}
