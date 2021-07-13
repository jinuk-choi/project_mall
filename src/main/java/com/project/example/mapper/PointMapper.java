package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Point;
import com.project.example.domain.User;

@Mapper
public interface PointMapper {

	public List<Point> read_point();
	
	public Point sumPointById(Point point);
	
	public void createPoint(Point point);
	
	public Point checkId(Point point);
	
	public void join(User user);
	
}
