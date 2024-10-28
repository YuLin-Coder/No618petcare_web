package com.pet.service;

import java.util.List;

import com.pet.entity.Messages;
//业务层留言信息
public interface MessagesService {
    int addMessages(Messages record);//添加
    Messages findById(Integer id);//根据id查询当前类信息
    int updateMessages(Messages record);//修改
    List<Messages> getPage(int pageNum, int pageSize);//分页查询
    List<Messages> findAllMessages();//查询所有用户信息
    List<Messages> findMessagesByMap(String name);//条件查询
    int queryMessagesCount();//统计数量
    int deleteMessages(Integer id);//根据id数量
    List<Messages> findMyMessages(int uid);//查询我的留言
}
   
