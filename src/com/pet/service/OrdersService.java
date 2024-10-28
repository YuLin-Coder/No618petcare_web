package com.pet.service;

import java.util.List;

import com.pet.entity.Orders;
//
public interface OrdersService {
  
    int addOrders(Orders record);//添加
   
   
    List<Orders> getPage(int pageNum, int pageSize);//分页查询
 
    List<Orders> findOrdersByMap(String name);//条件查询
    int queryOrdersCount();//统计数量
    int deleteOrders(Integer id);//根据id数量
    
    List<Orders> findMyOrders(int uid);//条件查询
}
   
