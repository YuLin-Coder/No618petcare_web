package com.pet.service.impl;

import java.util.List;

import com.pet.dao.OrdersDao;
import com.pet.dao.impl.OrdersDaoImpl;
import com.pet.entity.Orders;
import com.pet.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{
	private OrdersDao dao=new OrdersDaoImpl();

	public int addOrders(Orders record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	

	public List<Orders> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	
	public List<Orders> findOrdersByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryOrdersCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteOrders(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}



	@Override
	public List<Orders> findMyOrders(int uid) {
		// TODO Auto-generated method stub
		return dao.findMyOrders(uid);
	}

	

	
}
