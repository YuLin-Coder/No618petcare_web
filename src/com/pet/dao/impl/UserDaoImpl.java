package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.UserDao;
import com.pet.entity.Admin;
import com.pet.entity.User;
import com.pet.utils.C3p0Utils;


public class UserDaoImpl implements UserDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<User> getPage(int pageNum, int pageSize) {
        String sql="select * from user limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<User> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<User>(User.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询用户信息
    public List<User> findByMap(String name) {
        String sql="select * from user where 1=1 ";
        List<User> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and nickname like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<User>(User.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计宠物分类数量
    public int queryCount() {
        String sql="select count(*) from user";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除用户信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from user where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(User record) {
		 try {
	            //添加用户信息
	            runner.update("insert into user(username,pwd,sex,nickname,registeTime) values (?,?,?,?,now())",
	                  record.getUsername(),record.getPwd(),record.getSex(),record.getNickname());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public User query(Integer id) {
		// TODO
		 try {//返回根据id查询的用户信息的信息
	            return runner.query("select * from user where id=?", new BeanHandler<User>(User.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(User record) {
		
		 try {//执行修改用户信息
	            runner.update("update user set username=?,pwd=?,sex=?,nickname=? where id=?",
	            		   record.getUsername(),record.getPwd(),record.getSex(),record.getNickname(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<User> findAll() {
		// TODO查询有的用户信息
		  String sql="select * from user ";	        
	        List<User> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<User>(User.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public User queryByUserNameAndPwd(String username, String pwd) {
		// TODO Auto-generated method stub
		 try {
	            return runner.query("select * from user where username=? and pwd=?", new BeanHandler<User>(User.class),username,pwd);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public User queryByUsername(String username) {
		// TODO Auto-generated method stub
		try {//返回根据id查询的用户信息的信息
            return runner.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}





	
    
   
	
}
