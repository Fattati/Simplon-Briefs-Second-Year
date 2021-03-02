package beans;

import java.util.*;
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
	@Column(name = "animalType")
	private String animalType;
	@Column(name = " rendezvousDate")
	private Date rendezvousDate;
	
	 @ManyToOne
	 @JoinColumn(name = "userid")
	    private User user;
	 
	  @OneToMany(mappedBy = "rendezvous", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Message> messages;
	
	
	
	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rendezvous(String title, String animalType, Date rendezvousDate, User user) {
		super();
		this.title = title;
		this.animalType = animalType;
		this.rendezvousDate = rendezvousDate;
		this.user = user;
	}
	public Rendezvous(int rendezvous_id, String title, String animalType, Date rendezvousDate, User user) {
		super();
		this.rendezvous_id = rendezvous_id;
		this.title = title;
		this.animalType = animalType;
		this.rendezvousDate = rendezvousDate;
		this.user = user;
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
	public User getUser() {
        return user;
    }

    public void setUtilisateur(User utilisateur) {
        this.user = utilisateur;
    }

}
