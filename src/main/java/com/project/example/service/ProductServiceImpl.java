package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Category;
import com.project.example.domain.DateInfo;
import com.project.example.domain.Product;
import com.project.example.mapper.ProductMapper;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

	@Autowired 
	ProductMapper productmapper; 
	
	@Override
	public List<Product> lowCgData(int id){
		return productmapper.lowCgData(id);
	};
	
	@Override
	public List<Product> lowCgData_all(){
		return productmapper.lowCgData_all();
	};
	
	@Override
	public List<Product> CgData_Date(Category category){
		return productmapper.CgData_Date(category);
	};
	
	@Override
	public List<Product> CgData_AllTime(Category category){
		return productmapper.CgData_AllTime(category);
	};
	
	@Override
	public List<Product> salesbytime(DateInfo dateinfo){
		return productmapper.salesbytime(dateinfo);
	}

	@Override
	public List<Product> salesbytime(Category category){
		return productmapper.salesbytime(category);
	}
	
	@Override
	public List<Product> readAllProduct(){
		return productmapper.readAllProduct();
	};
	
	@Override
	public List<Product> readProduct(Product product){
		return productmapper.readProduct(product);
	};
	
	
	@Override
	public void createProduct(Product product){
		productmapper.createProduct(product);
	};
	
	@Override
	public void createImage(Product product){
		productmapper.createImage(product);
	};
	
	@Override
	public void productDelete(Product product) {
		productmapper.productDelete(product);
	};
	
	@Override
	public void product_img_Delete(Product product) {
		productmapper.product_img_Delete(product);
	};
	
	@Override
	public void productDataUpdate(Product product) {
		productmapper.productDataUpdate(product);
	};
	
	@Override
	public void productImgUpdate(Product product) {
		productmapper.productImgUpdate(product);
	};
	
	@Override
	public List<Product> imageByRank() {
		return productmapper.imageByRank();
	};
	
	@Override
	public List<Product> imageTop(){
		return productmapper.imageTop();
	};
	
	@Override
	public List<Product> imageShortTop(){
		return productmapper.imageShortTop();
	};
	
	@Override
	public List<Product> imageLongTop(){
		return productmapper.imageLongTop();
	};
	
	@Override
	public List<Product> imagePants(){
		return productmapper.imagePants();
	};
	
	@Override
	public List<Product> imageLongPants(){
		return productmapper.imageLongPants();
	};
	
	@Override
	public List<Product> imageShortPants(){
		return productmapper.imageShortPants();
	};
	
	
}


