package com.project.example.domain;

public class Comment {
	
	private int cId;		//상품후기의 기본키
	private int id;			//상품번호
	private String uId;		//사용자 ID
	private int cRating;	//별점
	private String cContent;//내용
	private String cDate;	//작성날짜
	private User user;		//사용자VO
	private Product product;//상품VO
	private boolean bTn;	//버튼 활성화 및 비활성화를 구분하기위하여 사용
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getcRating() {
		return cRating;
	}
	public void setcRating(int cRating) {
		this.cRating = cRating;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isbTn() {
		return bTn;
	}
	public void setbTn(boolean bTn) {
		this.bTn = bTn;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", id=" + id + ", uId=" + uId + ", cRating=" + cRating + ", cContent=" + cContent
				+ ", cDate=" + cDate + ", user=" + user + ", getcId()=" + getcId() + ", getuId()=" + getuId()
				+ ", getcRating()=" + getcRating() + ", getcContent()=" + getcContent() + ", getcDate()=" + getcDate()
				+ ", getUser()=" + getUser() + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
