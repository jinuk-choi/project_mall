package com.project.example.service;

import java.util.List;

import com.project.example.domain.Board;
import com.project.example.domain.Pagination;
import com.project.example.domain.Search;

public interface BoardService {

	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int aIdx);
	
	public void deleteBoard(int aIdx);
	
	public int countBoard(Search search);
	
	public void insertBoard(Board board);
	
	public void editBoard(Board board);
	
	public int count(Board board);
	
	
}
