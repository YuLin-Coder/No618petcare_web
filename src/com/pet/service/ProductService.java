package com.pet.service;

import java.util.List;

import com.pet.entity.Product;
//业务层宠物用品
public interface ProductService {
  
    int addProduct(Product record);//添加
    Product findById(Integer id);//根据id查询当前类信息
    int updateProduct(Product record);//修改
    List<Product> getPage(int pageNum, int pageSize);//分页查询
    List<Product> findAllProduct();//查询所有宠物用品
    List<Product> findProductByMap(String name);//条件查询
    int queryProductCount();//统计数量
    int deleteProduct(Integer id);//根据id数量
    
    int updateStock(int product_id);//修改数量
}
   
