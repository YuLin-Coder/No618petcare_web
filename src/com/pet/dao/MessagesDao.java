package com.pet.dao;

import java.util.List;

import com.pet.entity.Messages;
//留言信息
public interface MessagesDao {
  
    int save(Messages record);//添加
    Messages query(Integer id);//根据id查询当前类信息
    int update(Messages record);//修改
    List<Messages> getPage(int pageNum, int pageSize);//分页查询
    List<Messages> findAll();//查询所有
    List<Messages> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    List<Messages> findMyMessages(int uid);//查询我的留言
}
   
