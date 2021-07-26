package com.project.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.example.domain.Product;
import com.project.example.domain.Comment;
import com.project.example.domain.ListVo;


@Mapper
public interface CommentMapper {
	public List<Comment> selectCommentList(ListVo listvo);

	public int commentCount(Product product);
	
	public void insertComment(Comment comment);
	
	public void commentDelete(int cId);
	
	public void editComment(Comment comment);
	
	public void updateComment(Comment comment);
	
	public void updateReComment(Comment comment);

}
