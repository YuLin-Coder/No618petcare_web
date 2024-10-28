package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.BannerDao;
import com.pet.entity.Banner;
import com.pet.utils.C3p0Utils;

//轮播图
public class BannerDaoImpl implements BannerDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Banner> getPage(int pageNum, int pageSize) {
        String sql="select * from banner limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Banner> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Banner>(Banner.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询轮播图信息
   
    public List<Banner> findByMap(String name) {
        String sql="select * from banner where 1=1 ";
        List<Banner> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and note like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Banner>(Banner.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计轮播图信息数量
    public int queryCount() {
        String sql="select count(*) from banner";
        try {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除轮播图信息信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from banner where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Banner record) {
		 try {
	            //添加轮播图信息信息
	            runner.update("insert into banner(photo,url,note) values (?,?,?)",
	                  record.getPhoto(),record.getUrl(),record.getNote());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Banner query(Integer id) {
		// TODO
		 try {//返回根据id查询的轮播图信息信息的信息
	            return runner.query("select * from banner where id=?", new BeanHandler<Banner>(Banner.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Banner record) {
		
		 try {//执行修改轮播图信息
	            runner.update("update banner set photo=?,note=?,url=? where id=?",
	            		record.getPhoto(),record.getNote(),record.getUrl(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<Banner> findAll() {
		// TODO Auto-generated method stub
		  String sql="select * from banner ";	        
	        List<Banner> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Banner>(Banner.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
