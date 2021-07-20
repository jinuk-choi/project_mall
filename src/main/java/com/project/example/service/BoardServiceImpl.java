package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Board;
import com.project.example.mapper.BoardMapper;
import com.project.example.domain.Pagination;
import com.project.example.domain.Search;



@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList(Pagination pagination) {
		return boardMapper.selectBoardList(pagination);
	}


	@Override
	public Board selectBoardDetail(int aIdx) {
		return boardMapper.selectBoardDetail(aIdx);
	}
	
	@Override
	public void deleteBoard(int aIdx){
		boardMapper.deleteBoard(aIdx);
	}
	
	
	public int countBoard(Search search) {
		return boardMapper.countBoard(search);
	}
	
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
		
		if (board.getaGroup() == 0) {
			boardMapper.updateBoard(board);
		
		} else { 
			boardMapper.updateReBoard(board);
		}
		
	}
	
	public void editBoard(Board board) {
		boardMapper.editBoard(board);
	
	}
	
	public int count(Board board) {
		return boardMapper.count(board);
	}

}
