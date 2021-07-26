package com.project.example.service;

import java.util.List;

import com.project.example.domain.Product;
import com.project.example.domain.Comment;
import com.project.example.domain.ListVo;

public interface CommentService {
	public List<Comment> selectCommentList(ListVo listvo);

	public int commentCount(Product product);
	
	public void insertComment(Comment comment);
	
	public void editComment(Comment comment);
	
	public void commentDelete(int cId);

}
