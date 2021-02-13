package beans;

import java.util.Calendar;

public class Vote {
	private int voteId;
	private int productId;
	private int userId;
	private Calendar voteDate;
	
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Calendar getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Calendar voteDate) {
		this.voteDate = voteDate;
	}
	public Vote(int voteId, int productId, int userId, Calendar voteDate) {
		super();
		this.voteId = voteId;
		this.productId = productId;
		this.userId = userId;
		this.voteDate = voteDate;
	}
}
