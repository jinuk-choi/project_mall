package com.project.example.domain;

public class Board {
	private int aIdx;
	private String uId;
	private int aCount;
	private int rownum;
	private String aTitle;
	private String aContent;
	private String aWriter;
	private String aDate;
	private User user;
	private int aGroup;
	private int aOrder;
	private int aDepth;
	public int getaIdx() {
		return aIdx;
	}
	public void setaIdx(int aIdx) {
		this.aIdx = aIdx;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getaCount() {
		return aCount;
	}
	public void setaCount(int aCount) {
		this.aCount = aCount;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getaWriter() {
		return aWriter;
	}
	public void setaWriter(String aWriter) {
		this.aWriter = aWriter;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getaGroup() {
		return aGroup;
	}
	public void setaGroup(int aGroup) {
		this.aGroup = aGroup;
	}
	public int getaOrder() {
		return aOrder;
	}
	public void setaOrder(int aOrder) {
		this.aOrder = aOrder;
	}
	public int getaDepth() {
		return aDepth;
	}
	public void setaDepth(int aDepth) {
		this.aDepth = aDepth;
	}
	@Override
	public String toString() {
		return "Board [aIdx=" + aIdx + ", uId=" + uId + ", aCount=" + aCount + ", rownum=" + rownum + ", aTitle="
				+ aTitle + ", aContent=" + aContent + ", aWriter=" + aWriter + ", aDate=" + aDate + ", user=" + user
				+ ", aGroup=" + aGroup + ", aOrder=" + aOrder + ", aDepth=" + aDepth + ", getaIdx()=" + getaIdx()
				+ ", getuId()=" + getuId() + ", getaCount()=" + getaCount() + ", getRownum()=" + getRownum()
				+ ", getaTitle()=" + getaTitle() + ", getaContent()=" + getaContent() + ", getaWriter()=" + getaWriter()
				+ ", getaDate()=" + getaDate() + ", getUser()=" + getUser() + ", getaGroup()=" + getaGroup()
				+ ", getaOrder()=" + getaOrder() + ", getaDepth()=" + getaDepth() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
