package beans;

public class Product {
	private int productId;
	private String name;
	private float price;
	private byte[] img;
	private float quantity;
	
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
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Product(int productId, String name, float price, byte[] img, float quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
	}
	public Product(String name, float price, byte[] img, float quantity) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
		this.quantity = quantity;
	}
	public Product(String name, float price, float quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

