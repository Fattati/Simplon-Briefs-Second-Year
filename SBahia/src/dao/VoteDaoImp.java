package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.VoteModel;

public class VoteDaoImp implements VoteDao {

	@Override
	public VoteModel getProductVote(int id) {
		Connection connection=DatabaseConnection.getConnection();
		VoteModel vModel = new VoteModel();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT  productid,count(*) as number FROM public.vote where  productid = ? group by productid");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				vModel.setProductId(rs.getInt("productId"));
				vModel.setVoteNumber(rs.getInt("number"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vModel;
	}

	@Override
	public void setProductVote(int userId, int productId) throws SQLException {
		Connection connection=DatabaseConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO public.vote(userid, productid) VALUES (?, ?)");
		statement.setInt(1, userId);
		statement.setInt(2, productId);
		statement.executeUpdate();
		statement.close();
		
	}

}
