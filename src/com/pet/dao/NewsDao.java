package com.pet.dao;

import java.util.List;

import com.pet.entity.News;
//萌宠资讯
public interface NewsDao {
  
    int save(News record);//添加
    News query(Integer id);//根据id查询当前类信息
    int update(News record);//修改
    List<News> getPage(int pageNum, int pageSize);//分页查询
    List<News> findAll();//查询所有
    List<News> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
}
   
