package Models;

import java.sql.Date;

public class Presence {
   private int id;
   private int idApprenat;
   private int idFormateur;
   private Boolean absence;
   private Date dateAbsence;
   private float dureAbsence;
   private Boolean justifier;
   
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdApprenat() {
		return idApprenat;
	}
	public void setIdApprenat(int idApprenat) {
		this.idApprenat = idApprenat;
	}
	public int getIdFormateur() {
		return idFormateur;
	}
	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}
	public Boolean getAbsence() {
		return absence;
	}
	public void setAbsence(Boolean absence) {
		this.absence = absence;
	}
	public Date getDateAbsence() {
		return dateAbsence;
	}
	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}
	public float getDureAbsence() {
		return dureAbsence;
	}
	public void setDureAbsence(float dureAbsence) {
		this.dureAbsence = dureAbsence;
	}
	public Boolean getJustifier() {
		return justifier;
	}
	public void setJustifier(Boolean justifier) {
		this.justifier = justifier;
	}
	
	public Presence(int id, int idApprenat, int idFormateur, Boolean absence, Date dateAbsence, float dureAbsence, Boolean justifier) {
		super();
		this.id = id;
		this.idApprenat = idApprenat;
		this.idFormateur = idFormateur;
		this.absence = absence;
		this.dateAbsence = dateAbsence;
		this.dureAbsence = dureAbsence;
		this.justifier = justifier;
	}
	
	public Presence(int idApprenat, int idFormateur, Boolean absence, Date dateAbsence, float dureAbsence){
		super();
		this.idApprenat = idApprenat;
		this.idFormateur = idFormateur;
		this.absence = absence;
		this.dateAbsence = dateAbsence;
		this.dureAbsence = dureAbsence;
	}

   
}