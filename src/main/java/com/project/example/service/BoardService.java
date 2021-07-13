package com.project.example.service;

import java.util.List;

import com.project.example.domain.Board;

public interface BoardService {

	public List<Board> selectBoardList();
	
	public Board selectBoardDetail(int bId);
	
	public void deleteBoard(int bId);
	
	
}
