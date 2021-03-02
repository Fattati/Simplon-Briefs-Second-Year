package beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "messageid")
	private int message_id;
	@Column(name = "content")
	private String content;
	@Column(name = "date")
	private Date mesageDate;
	
	 @ManyToOne
	 @JoinColumn(name = "userid")
	 private User user;
	 @ManyToOne
	 @JoinColumn(name = "rendezvousid")
	 private Rendezvous rendezvous;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String content, Date mesageDate) {
		super();
		this.content = content;
		this.mesageDate = mesageDate;
	}
	public Message(int message_id, String content, Date mesageDate) {
		super();
		this.message_id = message_id;
		this.content = content;
		this.mesageDate = mesageDate;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getMesageDate() {
		return mesageDate;
	}
	public void setMesageDate(Date mesageDate) {
		this.mesageDate = mesageDate;
	}

}
