package com.pet.service;

import java.util.List;

import com.pet.entity.News;
//业务层萌宠资讯
public interface NewsService {
  
    int addNews(News record);//添加
    News findById(Integer id);//根据id查询当前类信息
    int updateNews(News record);//修改
    List<News> getPage(int pageNum, int pageSize);//分页查询
    List<News> findAllNews();//查询所有萌宠资讯信息
    List<News> findNewsByMap(String name);//条件查询
    int queryNewsCount();//统计数量
    int deleteNews(Integer id);//根据id数量
}
   
