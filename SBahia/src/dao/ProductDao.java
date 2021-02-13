package dao;

import java.util.List;

import beans.Product;

public interface ProductDao {
	public Product save(Product p);
	public List<Product> search (String n);
	public Product update(Product p);
	public void delete(int productId);
	public Product getProduct(int productId);
}
