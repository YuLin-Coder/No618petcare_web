package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.ProductDao;
import com.pet.entity.Product;
import com.pet.utils.C3p0Utils;

//宠物用品Dao类
public class ProductDaoImpl implements ProductDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Product> getPage(int pageNum, int pageSize) {
        String sql="select * from product limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Product> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Product>(Product.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询宠物用品
    public List<Product> findByMap(String name) {
        String sql="select * from product where 1=1 ";
        List<Product> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and name like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Product>(Product.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计宠物用品数量
    public int queryCount() {
        String sql="select count(*) from product";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除宠物用品信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from product where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Product record) {
		 try {
	            //添加宠物用品
	            runner.update("insert into product(name,price,photo,stock) values (?,?,?,?)",
	            		record.getName(),record.getPrice(),record.getPhoto(),record.getStock());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Product query(Integer id) {
		// TODO
		 try {//返回根据id查询的宠物用品信息的信息
	            return runner.query("select * from product where id=?", new BeanHandler<Product>(Product.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Product record) {
		
		 try {//执行修改宠物用品
	            runner.update("update product set  name=?,price=?,photo=?,stock=? where id=?",
	            		record.getName(),record.getPrice(),record.getPhoto(),record.getStock(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<Product> findAll() {
		// 查询所有宠物用品
		  String sql="select * from product ";	        
	        List<Product> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Product>(Product.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	@Override
	public int updateStock(int product_id) {
		// TODO Auto-generated method stub
		
		 try {//执行修改宠物用品
	            runner.update("update product set stock=stock-1 where id=?",
	            		product_id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}





	
    
   
	
}
