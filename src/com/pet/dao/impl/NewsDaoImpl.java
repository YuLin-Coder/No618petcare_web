package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.NewsDao;
import com.pet.entity.News;
import com.pet.utils.C3p0Utils;

//萌宠资讯Dao类
public class NewsDaoImpl implements NewsDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<News> getPage(int pageNum, int pageSize) {
        String sql="select * from news limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<News> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<News>(News.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询萌宠资讯
    public List<News> findByMap(String name) {
        String sql="select * from news where 1=1 ";
        List<News> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and title like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<News>(News.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计萌宠资讯数量
    public int queryCount() {
        String sql="select count(*) from news";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除萌宠资讯信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from news where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(News record) {
		 try {
	            //添加萌宠资讯信息
	            runner.update("insert into news(title,photo,content,editor,fbsj) values (?,?,?,?,now())",
	            		record.getTitle(),record.getPhoto(),record.getContent(),record.getEditor());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public News query(Integer id) {
		// TODO
		 try {//返回根据id查询的萌宠资讯信息的信息
	            return runner.query("select * from news where id=?", new BeanHandler<News>(News.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(News record) {
		
		 try {//执行修改萌宠资讯
	            runner.update("update news set  title=?,photo=?,content=?, editor=? where id=?",
	            		record.getTitle(),record.getPhoto(),record.getContent(),record.getEditor(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<News> findAll() {
		// 查询所有萌宠资讯
		  String sql="select * from news ";	        
	        List<News> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<News>(News.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
