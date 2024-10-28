package com.pet.service;

import java.util.List;

import com.pet.entity.Category;
//业务层宠物类别
public interface CategoryService {
  
    int addCategory(Category record);//添加
    Category findById(Integer id);//根据id查询当前类信息
    int updateCategory(Category record);//修改
    List<Category> getPage(int pageNum, int pageSize);//分页查询
    List<Category> findAllCategory();//查询所有宠物类别
    List<Category> findCategoryByMap(String name);//条件查询
    int queryCategoryCount();//统计数量
    int deleteCategory(Integer id);//根据id数量
}
   
