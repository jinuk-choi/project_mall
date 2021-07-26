package com.project.example.domain;

public class Comment {
	
	private int cId;
	private int pId;
	private String uId;
	private int cRating;
	private String cContent;
	private String cDate;
	private User user;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
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
	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", pId=" + pId + ", uId=" + uId + ", cRating=" + cRating + ", cContent="
				+ cContent + ", cDate=" + cDate + ", user=" + user + ", getcId()=" + getcId() + ", getpId()=" + getpId()
				+ ", getuId()=" + getuId() + ", getcRating()=" + getcRating() + ", getcContent()=" + getcContent()
				+ ", getcDate()=" + getcDate() + ", getUser()=" + getUser() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
