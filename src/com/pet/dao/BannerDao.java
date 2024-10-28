package com.pet.dao;

import java.util.List;

import com.pet.entity.Banner;
//首页轮播图
public interface BannerDao {
  
    int save(Banner record);//添加
    Banner query(Integer id);//根据id查询当前类信息
    int update(Banner record);//修改
    List<Banner> getPage(int pageNum, int pageSize);//分页查询
    List<Banner> findAll();//查询所有
    List<Banner> findByMap(String name);//条件查询
    int queryCount();//统计轮播图数量
    int delete(Integer id);//根据id数量
}
   
