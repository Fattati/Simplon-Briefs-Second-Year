package dao;

import java.sql.SQLException;

import web.VoteModel;

public interface VoteDao {
	
	public VoteModel getProductVote(int id);
	public void setProductVote(int userId,int productId) throws SQLException;

}
