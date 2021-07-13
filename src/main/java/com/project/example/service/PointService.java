package com.project.example.service;

import java.util.List;

import com.project.example.domain.Point;
import com.project.example.domain.User;

public interface PointService {

	public List<Point> read_point();
	
	public Point sumPointById(Point point);
	
	public void createPoint(Point point);
	
	public Point checkId(Point point);
	
	public void join(User user);
}
