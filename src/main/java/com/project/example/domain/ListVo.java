package com.project.example.domain;

public class ListVo {
	int id;		//상품후기 리스트를 담기위해 사용
	int pageNum;
	
	public ListVo() {
	}
	
	public ListVo(int id, int pageNum) {
		this.id = id;
		this.pageNum = pageNum;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
