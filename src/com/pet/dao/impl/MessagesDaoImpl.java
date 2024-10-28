package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.MessagesDao;
import com.pet.entity.Messages;
import com.pet.utils.C3p0Utils;


public class MessagesDaoImpl implements MessagesDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Messages> getPage(int pageNum, int pageSize) {
        String sql="select * from messages limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Messages> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Messages>(Messages.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询用户信息
    public List<Messages> findByMap(String name) {
        String sql="select * from messages where 1=1 ";
        List<Messages> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and content like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Messages>(Messages.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计宠物分类数量
    public int queryCount() {
        String sql="select count(*) from messages";
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
            runner.update("delete from messages where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Messages record) {
		 try {
	            //添加用户信息
	            runner.update("insert into messages(content,uid,create_time) values (?,?,now())",
	                  record.getContent(),record.getUid());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Messages query(Integer id) {
		// TODO
		 try {//返回根据id查询的用户信息的信息
	            return runner.query("select * from messages where id=?", new BeanHandler<Messages>(Messages.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Messages record) {
		
		 try {//执行修改用户信息
	            runner.update("update messages set content=? where id=?",
	            		record.getContent(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}

	public List<Messages> findAll() {
		// TODO查询有的用户信息
		  String sql="select * from messages ";	        
	        List<Messages> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Messages>(Messages.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public List<Messages> findMyMessages(int uid) {
		   String sql="select * from messages where uid=?";
	 
	        List<Messages> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Messages>(Messages.class),uid);//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
		
	}





	
    
   
	
}
