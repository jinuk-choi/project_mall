package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Board;
import com.project.example.mapper.BoardMapper;



@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList() {
		return boardMapper.selectBoardList();
	}


	@Override
	public Board selectBoardDetail(int bId) {
		return boardMapper.selectBoardDetail(bId);
	}
	
	@Override
	public void deleteBoard(int bId){
		boardMapper.deleteBoard(bId);
	}

}
