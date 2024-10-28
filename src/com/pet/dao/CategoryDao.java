package com.pet.dao;

import java.util.List;

import com.pet.entity.Category;
//宠物类别
public interface CategoryDao {
  
    int save(Category record);//添加
    Category query(Integer id);//根据id查询当前类信息
    int update(Category record);//修改
    List<Category> getPage(int pageNum, int pageSize);//分页查询
    List<Category> findAll();//查询所有
    List<Category> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
