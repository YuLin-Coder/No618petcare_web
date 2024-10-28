package com.pet.service;

import com.pet.entity.Admin;

//管理员业务层
public interface AdminService {
    public Admin login(String username, String pwd);//根据管理员用户名和密码来登录
    public int updateAdmin(Admin record);//修改管理员信息
    public Admin findById(Integer id);//根据id查询管理员信息
}
