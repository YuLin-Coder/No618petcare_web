package com.pet.service.impl;

import java.util.List;

import com.pet.dao.UserDao;
import com.pet.dao.impl.UserDaoImpl;
import com.pet.entity.User;
import com.pet.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao=new UserDaoImpl();

	public int addUser(User record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateUser(User record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<User> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<User> findUserByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryUserCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public User login(String username, String pwd) {
		// TODO Auto-generated method stub
		return dao.queryByUserNameAndPwd(username, pwd);
	}

	@Override
	public boolean existUser(String username) {
		// TODO Auto-generated method stub
		 if(dao.queryByUsername(username)==null){
	            return false;//表示不可以用
	        }
	        return true;//表示可以用
	}
	

	

	
}
