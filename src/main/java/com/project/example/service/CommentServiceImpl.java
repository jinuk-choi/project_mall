package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Product;
import com.project.example.domain.Comment;
import com.project.example.domain.ListVo;
import com.project.example.mapper.CommentMapper;


@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired CommentMapper commentmapper;
	
	@Override
	public List<Comment> selectCommentList(ListVo listvo) {
		return commentmapper.selectCommentList(listvo);
	}
	
	@Override
	public int commentCount(Product product) {
		return commentmapper.commentCount(product);
	}
	
	@Override
	public void insertComment(Comment comment) {
		commentmapper.insertComment(comment);
		
	}
	
	@Override
	public void commentDelete(int cId) {
		commentmapper.commentDelete(cId);
	}
	
	@Override
	public void editComment(Comment comment) {
		commentmapper.editComment(comment);
	}

}
