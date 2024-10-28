package com.pet.service;

import java.util.List;

import com.pet.entity.Admin;
import com.pet.entity.User;
//业务层用户
public interface UserService {
    int addUser(User record);//添加
    User findById(Integer id);//根据id查询当前类信息
    int updateUser(User record);//修改
    List<User> getPage(int pageNum, int pageSize);//分页查询
    List<User> findAllUser();//查询所有用户信息
    List<User> findUserByMap(String name);//条件查询
    int queryUserCount();//统计数量
    int deleteUser(Integer id);//根据id数量
    public User login(String username, String pwd);//根据用户名和密码来登录
    boolean existUser(String username);
    
}
   
