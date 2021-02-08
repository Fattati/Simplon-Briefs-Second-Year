package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Article;

public class ArticleDaoImp implements ArticleDao {

	@Override
	public Article save(Article a) {
		Connection connection=DbConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("INSERT INTO ARTICLES (name) VALUES (?)");
			ps.setString(1, a.getName());
			ps.executeUpdate(); //execute query
			PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID) as MAXID FROM ARTICLES");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				a.setId(rs.getLong("MAX_ID"));
			}
			ps.close(); //close object statement
			//connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Article> search(String n) {
		List<Article> articles=new ArrayList<Article>();
		Connection connection=DbConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM ARTICLES WHERE name LIKE ?");
			ps.setString(1, n);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Article a=new Article();
				a.setId(rs.getLong("id"));
				a.setName(rs.getString("name"));
				articles.add(a);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return articles;
	}

	@Override
	public Article update(Article a) {
		Connection connection=DbConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("UPDATE ARTICLES SET NAME=? WHERE ID=?");
			ps.setString(1, a.getName());
			ps.setLong(2, a.getId());
			ps.executeUpdate(); //execute query
			ps.close(); //close object statement
			//connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void delete(long id) {
		System.out.print("id");
			Connection connection=DbConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("DELETE FROM ARTICLES WHERE id=?");
				ps.setLong(1, id);
				ps.executeUpdate();
				ps.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public Article getArticle(Long id) {
		Article a=null;
		Connection connection=DbConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM ARTICLES WHERE ID= ?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a=new Article();
				a.setId(rs.getLong("id"));
				a.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return a;
	}
}
