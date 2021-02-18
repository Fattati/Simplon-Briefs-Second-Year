package dao;

import java.sql.SQLException;
import java.util.List;

import beans.Product;

public interface ProductDao {
	public Product save(Product p) throws SQLException;
	public List<Product> search (String n) throws SQLException;
	public Product update(Product p) throws SQLException;
	public void delete(int productId) throws SQLException;
	public Product getProduct(int productId);
	public List<Product> getAllProducts();
}
