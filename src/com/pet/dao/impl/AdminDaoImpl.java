package com.pet.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.pet.dao.AdminDao;
import com.pet.entity.Admin;
import com.pet.utils.C3p0Utils;


public class AdminDaoImpl implements AdminDao{

	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

	
	//根据用户名和密码查询
	public Admin queryByUserNameAndPwd(String username, String pwd) {
		 try {
	            return runner.query("select * from admin where username=? and pwd=?", new BeanHandler<Admin>(Admin.class),username,pwd);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}
	
  //修改管理员信息
	public int update(Admin record) {
		try {//执行更改
            runner.update("update admin set username=?,pwd=?,nickname=? where id=?",
            		record.getUsername(),record.getPwd(),record.getNickname(),record.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
        return 1;
	}


	
	public Admin query(Integer id) {
		// 根据id查询管理员信息
		 try {
	            return runner.query("select * from admin where id=?", new BeanHandler<Admin>(Admin.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	
}
