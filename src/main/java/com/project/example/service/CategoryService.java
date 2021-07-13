package com.project.example.service;

import java.util.List;

import com.project.example.domain.Category;

public interface CategoryService {

	public List<Category> readCategory();
	
	public List<Category> readCategory_name();
	
	public int findCg_id(String name);
	
	public void categoryUpdate(Category category);
	
	public int nextCategory(Category category);
	
	public void categoryAdd(Category category);
}
