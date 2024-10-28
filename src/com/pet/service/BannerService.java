package com.pet.service;

import java.util.List;

import com.pet.entity.Banner;
//业务层轮播图接口
public interface BannerService {
  
    int addBanner(Banner record);//添加
    Banner findById(Integer id);//根据id查询当前类信息
    int updateBanner(Banner record);//修改
    List<Banner> getPage(int pageNum, int pageSize);//分页查询
    List<Banner> findAllBanner();//查询所有分类
    List<Banner> findBannerByMap(String name);//条件查询
    int queryBannerCount();//统计数量
    int deleteBanner(Integer id);//根据id数量
}
   
