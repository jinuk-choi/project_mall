package com.project.example.domain;

public class Search {
	
	private int type;		//type별 게시글 검색을 구현 제목=1,내용=2,제목및내용=3
	private String keyword;
	
	public final static int NONE = 0;
	public final static int TITLE = 1;
	public final static int CONTENT = 2;
	public final static int TITLE_CONTENT = 3;
	
	public Search() {
		this(NONE, "");
	} 
	
	public Search(int type, String keyword) {
		this.type = type;
		this.keyword = keyword;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}

