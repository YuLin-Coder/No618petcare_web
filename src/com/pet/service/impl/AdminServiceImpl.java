package com.pet.service.impl;

import com.pet.dao.AdminDao;
import com.pet.dao.impl.AdminDaoImpl;
import com.pet.entity.Admin;
import com.pet.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDao dao=new AdminDaoImpl();

	public Admin login(String username, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByUserNameAndPwd(username, pwd);
	}

	public int updateAdmin(Admin record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public Admin findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

}
