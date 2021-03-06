package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Board;
import com.project.example.domain.Pagination;
import com.project.example.domain.Search;

@Mapper
public interface BoardMapper {

	public List<Board> selectBoardList(Pagination pagination);
	
	public Board selectBoardDetail(int aIdx);
	
	public void deleteBoard(int aIdx);
	
	public int countBoard(Search search);
	
	public void insertBoard(Board board);
	
	public void editBoard(Board board);
	
	public int count(Board board);
	
	public void updateBoard(Board board);
	
	public void updateReBoard(Board board);
}
