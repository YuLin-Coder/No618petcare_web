package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.CategoryDao;
import com.pet.entity.Category;
import com.pet.utils.C3p0Utils;


public class CategoryDaoImpl implements CategoryDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Category> getPage(int pageNum, int pageSize) {
        String sql="select * from category limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Category> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Category>(Category.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询宠物分类
    public List<Category> findByMap(String name) {
        String sql="select * from category where 1=1 ";
        List<Category> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and cname like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Category>(Category.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计宠物分类数量
    public int queryCount() {
        String sql="select count(*) from category";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除宠物分类信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from category where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Category record) {
		 try {
	            //添加宠物分类信息
	            runner.update("insert into category(cname,note) values (?,?)",
	                  record.getCname(),record.getNote());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Category query(Integer id) {
		// TODO
		 try {//返回根据id查询的宠物分类信息的信息
	            return runner.query("select * from category where id=?", new BeanHandler<Category>(Category.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Category record) {
		
		 try {//执行修改宠物分类信息
	            runner.update("update category set cname=?,note=? where id=?",
	            		record.getCname(),record.getNote(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<Category> findAll() {
		// TODO查询有的分类西悉尼
		  String sql="select * from category ";	        
	        List<Category> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Category>(Category.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
