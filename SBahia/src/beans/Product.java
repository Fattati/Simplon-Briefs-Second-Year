package beans;

public class Product {
	private int productId;
	private String name;
	private float price;
	private String img;
	private int quantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(String name, float price, String img, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
	}
}

