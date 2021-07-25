package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Category;
import com.project.example.domain.DateInfo;
import com.project.example.domain.Product;

@Mapper
public interface ProductMapper {

	public List<Product> lowCgData(int id);
	
	public List<Product> lowCgData_all();
	
	public List<Product> CgData_Date(Category category);
	
	public List<Product> CgData_AllTime(Category category);
	
	public List<Product> salesbytime(DateInfo dateinfo);
	
	public List<Product> salesbytime(Category category);
	
	public List<Product> readAllProduct();
	
	public List<Product> readProduct(Product product);
	
	public void createProduct(Product product);

	public void createImage(Product product);
	
	public void productDelete(Product product);
	
	public void product_img_Delete(Product product);
	
	public void productDataUpdate(Product product);
	
	public void productImgUpdate(Product product);
	
	public List<Product> imageByRank();
	
	public List<Product> imageTop();
	
	public List<Product> imageShortTop();
	
	public List<Product> imageLongTop();

	public List<Product> imagePants();
	
	public List<Product> imageLongPants();
	
	public List<Product> imageShortPants();
	
}
