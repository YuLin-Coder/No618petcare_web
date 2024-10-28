package com.pet.dao;

import java.util.List;

import com.pet.entity.Orders;

public interface OrdersDao {
  
    int save(Orders record);//添加
   

    List<Orders> getPage(int pageNum, int pageSize);//分页查询
    List<Orders> findByMap(String oders_no);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    List<Orders> findMyOrders(int uid);
}
   
