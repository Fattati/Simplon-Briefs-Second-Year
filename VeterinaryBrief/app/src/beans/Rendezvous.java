package beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rendezvous")
public class Rendezvous {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "rendezvousid")
	private int rendezvous_id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "animalType")
	private String animalType;
	@Column(name = " rendezvousDate")
	private Date rendezvousDate;
	
	 @ManyToOne
	 @JoinColumn(name = "userid")
	    private User users;
	 
	  @OneToMany(mappedBy = "rendezvous", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Message> messages;
	
	
	
	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rendezvous(String title, String description, String animalType, Date rendezvousDate) {
		super();
		this.title = title;
		this.description = description;
		this.animalType = animalType;
		this.rendezvousDate = rendezvousDate;
	}
	public Rendezvous(int rendezvous_id, String title, String description, String animalType, Date rendezvousDate) {
		super();
		this.rendezvous_id = rendezvous_id;
		this.title = title;
		this.description = description;
		this.animalType = animalType;
		this.rendezvousDate = rendezvousDate;
	}
	public int getRendezvous_id() {
		return rendezvous_id;
	}
	public void setRendezvous_id(int rendezvous_id) {
		this.rendezvous_id = rendezvous_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public Date getRendezvousDate() {
		return rendezvousDate;
	}
	public void setRendezvousDate(Date rendezvousDate) {
		this.rendezvousDate = rendezvousDate;
	}

}
