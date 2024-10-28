package com.pet.dao;

import java.util.List;

import com.pet.entity.User;
//用户接口
public interface UserDao {
  
    int save(User record);//添加
    User query(Integer id);//根据id查询当前类信息
    User queryByUsername(String  username);//根据id查询用户名
    int update(User record);//修改
    List<User> getPage(int pageNum, int pageSize);//分页查询
    List<User> findAll();//查询所有
    List<User> findByMap(String name);//条件查询
    int queryCount();//统计数量
    int delete(Integer id);//根据id数量
    public User queryByUserNameAndPwd(String username, String pwd);//根据用户的用户名和密码来登录
}
   
