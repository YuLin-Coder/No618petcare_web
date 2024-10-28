package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.OrdersDao;
import com.pet.entity.Orders;
import com.pet.utils.C3p0Utils;


public class OrdersDaoImpl implements OrdersDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Orders> getPage(int pageNum, int pageSize) {
        String sql="select * from orders limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Orders> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Orders>(Orders.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询订单
    public List<Orders> findByMap(String name) {
        String sql="select * from orders where 1=1 ";
        List<Orders> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and orders_no like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Orders>(Orders.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计订单数量
    public int queryCount() {
        String sql="select count(*) from orders";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除订单信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from orders where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Orders record) {
		 try {
	            //添加订单信息
	            runner.update("insert into orders(orders_no,product_id,uid,total_price,quantity,create_time) values (?,?,?,?,?,now())",
	                  record.getOrders_no(),record.getProduct_id(),record.getUid(),record.getTotal_price(),record.getQuantity());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	


	@Override
	public List<Orders> findMyOrders(int uid) {
		// TODO Auto-generated method stub
		  String sql="select * from orders where uid=?";
	   
	        List<Orders> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Orders>(Orders.class),uid);//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
