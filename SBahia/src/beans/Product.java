package beans;

public class Product {
	private int id;
	private String name;
	private String price;
	private String img;
	private String quantity;
	private int vote;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public Product(String name, String price, String img, String quantity, int vote) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
		this.vote = vote;
	}
}

