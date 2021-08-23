package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.DateInfo;
import com.project.example.domain.Order;
import com.project.example.domain.OrderDetail;

@Mapper
public interface OrderMapper {

	public List<Order> readOrder();

	public Order readOrderDetails(Order order);
	
	public List<Order>  orderListDetail(Order order);
	
	public void orderDetailDelete(OrderDetail orderdetail);

	public void updateOrderDetail(OrderDetail orderdetail);
	
	public List<Order> readSales_days(DateInfo dateinfo);
	
	public List<Order> readSales_oneday(DateInfo dateinfo);
	
	public List<Order> readSales_month(DateInfo dateinfo);
	
	public List<Order> readSales_year(DateInfo dateinfo);
	
	public void orderList(Order order);
	
	public void order_detailList(Order order);
	
	public void updateState(Order order);
	
}
