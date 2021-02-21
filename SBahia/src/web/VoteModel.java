package web;

public class VoteModel {
	private int productId;
	private int voteNumber;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(int voteNumber) {
		this.voteNumber = voteNumber;
	}
	public VoteModel() {
		super();
	}
	public VoteModel(int productId, int voteNumber) {
		super();
		this.productId = productId;
		this.voteNumber = voteNumber;
	}
}
