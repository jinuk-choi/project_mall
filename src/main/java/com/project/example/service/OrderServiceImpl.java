package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.DateInfo;
import com.project.example.domain.Order;
import com.project.example.domain.OrderDetail;
import com.project.example.mapper.OrderMapper;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderMapper ordermapper;
	
	@Override
	public List<Order> readOrder(){
		return ordermapper.readOrder();
	}
	
	@Override
	public Order readOrderDetails(Order order){
		return ordermapper.readOrderDetails(order);
	}
	
	@Override
	public List<Order> orderListDetail(Order order){
		return ordermapper.orderListDetail(order);
	}

	@Override
	public void orderDetailDelete(OrderDetail orderdetail) {
		ordermapper.orderDetailDelete(orderdetail);
	}
	
	@Override
	public void updateOrderDetail(OrderDetail orderdetail) {
		ordermapper.updateOrderDetail(orderdetail);
	}
	
	@Override
	public List<Order> readSales_days(DateInfo dateinfo) {
		return ordermapper.readSales_days(dateinfo);
	}
	
	@Override
	public List<Order> readSales_oneday(DateInfo dateinfo){
		return ordermapper.readSales_oneday(dateinfo);
	}
	
	@Override
	public List<Order> readSales_month(DateInfo dateinfo){
		return ordermapper.readSales_month(dateinfo);
	}
	
	@Override
	public List<Order> readSales_year(DateInfo dateinfo){
		return ordermapper.readSales_year(dateinfo);
	}
	
	@Override
	public void orderList(Order order){
		ordermapper.orderList(order);
		ordermapper.order_detailList(order);
	}
	
	
	
}
