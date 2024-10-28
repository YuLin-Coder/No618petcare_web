package com.pet.dao;

import com.pet.entity.Admin;


public interface AdminDao {
    public Admin queryByUserNameAndPwd(String username, String pwd);//根据管理员用户名和密码来登录
    public int update(Admin record);//修改管理员信息
    public Admin query(Integer id);//根据id查询管理员信息
}
