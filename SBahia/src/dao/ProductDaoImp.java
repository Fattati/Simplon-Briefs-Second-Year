package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;

public class ProductDaoImp implements ProductDao {

	@Override
	public Product save(Product p) throws SQLException {
		PreparedStatement statement = null;
		
		Connection connection=DatabaseConnection.getConnection();
		statement = connection.prepareStatement("INSERT INTO PRODUCT (name,quantity,price,img) VALUES (?,?,?,?)");
		statement.setString(1, p.getName());
		statement.setFloat(2, p.getQuantity());
		statement.setFloat(3, p.getPrice());
		statement.setBytes(4, p.getImg());
		statement.executeUpdate();
		PreparedStatement statement2=connection.prepareStatement("SELECT MAX(ID) as MAXID FROM ARTICLES");
		ResultSet rs=statement2.executeQuery();
		if(rs.next()) {
			p.setProductId(rs.getInt("MAX_ID"));
		}
		statement.close();
		return p;
	}

	@Override
	public List<Product> search(String n) throws SQLException {
		Connection connection=DatabaseConnection.getConnection();
		List<Product> product = new ArrayList<Product>();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCT where name Like ?");
		statement.setString(1, "%"+n+"%");
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Product p = new Product();
			p.setProductId(rs.getInt("productId"));
			p.setName(rs.getString("name"));
			p.setQuantity(rs.getFloat("quantity"));
			p.setPrice(rs.getFloat("price"));
			p.setImg(rs.getBytes("img"));
			product.add(p);	
		}
		return product;
	}

	@Override
	public Product update(Product p) throws SQLException {
		Connection connection=DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE public.product SET name=?, quantity=?, price=?,img=? WHERE productid = ?");
		statement.setString(1,p.getName());
		statement.setFloat(2,p.getQuantity());
		statement.setFloat(3, p.getPrice());
		statement.setBytes(4, p.getImg());
		statement.setInt(5,p.getProductId());
		System.out.println(p.getName() + " " + p.getQuantity() + " " + p.getPrice() + " " + p.getProductId() );
		statement.executeUpdate();		
		statement.close();
	return  p;
	}

	@Override
	public void delete(int productId) throws SQLException{
		Connection connection=DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE productid=?");
		statement.setInt(1, productId);
		statement.executeUpdate();
		
	}

	@Override
	public Product getProduct(int productId) {
		Connection connection=DatabaseConnection.getConnection();
		Product product = new Product();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE productid= ?");
			statement.setInt(1, productId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("productId"));
				p.setName(rs.getString("name"));
				p.setQuantity(rs.getFloat("quantity"));
				p.setPrice(rs.getFloat("price"));
				p.setImg(rs.getBytes("img"));
				product = p;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Connection connection=DatabaseConnection.getConnection();
		List<Product> product = new ArrayList<Product>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM public.product ORDER BY productid ASC ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("ProductId"));
				p.setName(rs.getString("name"));
				p.setQuantity(rs.getFloat("quantity"));
				p.setPrice(rs.getFloat("price"));
				p.setImg(rs.getBytes("img"));
				product.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
