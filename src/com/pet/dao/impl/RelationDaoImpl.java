package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.RelationDao;
import com.pet.entity.Relation;
import com.pet.utils.C3p0Utils;

//用户联系Dao类
public class RelationDaoImpl implements RelationDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Relation> getPage(int pageNum, int pageSize) {
        String sql="select * from user_relation limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Relation> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Relation>(Relation.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询用户联系
    public List<Relation> findByMap(String name) {
        String sql="select * from user_relation where 1=1 ";
        List<Relation> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and name like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Relation>(Relation.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计用户联系数量
    public int queryCount() {
        String sql="select count(*) from user_relation";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除用户联系信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from user_relation where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Relation record) {
		 try {
	            //添加用户联系
	            runner.update("insert into user_relation(name,email,phone,note) values (?,?,?,?)",
	            		record.getName(),record.getEmail(),record.getPhone(),record.getNote());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Relation query(Integer id) {
		// TODO
		 try {//返回根据id查询的用户联系信息的信息
	            return runner.query("select * from user_relation where id=?", new BeanHandler<Relation>(Relation.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Relation record) {
		
		 try {//执行修改用户联系
	            runner.update("update user_relation set  name=?,email=?,phone=?,note=? where id=?",
	            		record.getName(),record.getEmail(),record.getPhone(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<Relation> findAll() {
		// 查询所有用户联系
		  String sql="select * from user_relation ";	        
	        List<Relation> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Relation>(Relation.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
