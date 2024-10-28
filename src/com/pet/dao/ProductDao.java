package com.pet.dao;

import java.util.List;

import com.pet.entity.Product;
//宠物用品
public interface ProductDao {
  
    int save(Product record);//添加
    Product query(Integer id);//根据id查询当前类信息
    int update(Product record);//修改
    List<Product> getPage(int pageNum, int pageSize);//分页查询
    List<Product> findAll();//查询所有
    List<Product> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    int updateStock(int product_id);//修改数量
}
   
