package com.pet.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.pet.dao.PetDao;
import com.pet.entity.Pet;
import com.pet.utils.C3p0Utils;

//宠物信息Dao类
public class PetDaoImpl implements PetDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    


  
    //分页查询
    public List<Pet> getPage(int pageNum, int pageSize) {
        String sql="select * from pet limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Pet> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Pet>(Pet.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //模糊查询宠物信息
    public List<Pet> findByMap(String name) {
        String sql="select * from pet where 1=1 ";
        List<Pet> list=null;
      
        List<String> list1 = new ArrayList<String>();
        if (name != "") {
          
            sql += " and name like  ? ";
        
            list1.add("%" + name + "%");
        }
      
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Pet>(Pet.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
    //统计宠物信息数量
    public int queryCount() {
        String sql="select count(*) from pet";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   //删除宠物信息信息
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from pet where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }

	


	public int save(Pet record) {
		 try {
	            //添加宠物信息
	            runner.update("insert into pet(name,c_id,photo,characters,detail,fbrq) values (?,?,?,?,?,now())",
	            		record.getName(),record.getC_id(),record.getPhoto(),record.getCharacters(),record.getDetail());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return 1;
	}


	public Pet query(Integer id) {
		// TODO
		 try {//返回根据id查询的宠物信息信息的信息
	            return runner.query("select * from pet where id=?", new BeanHandler<Pet>(Pet.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}


	public int update(Pet record) {
		
		 try {//执行修改宠物信息
	            runner.update("update pet set  name=?,c_id=?,photo=?,characters=?, detail=? where id=?",
	            		record.getName(),record.getC_id(),record.getPhoto(),record.getCharacters(),record.getDetail(),record.getId());
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//抛出运行异常
	        }
	        return 1;
	}



	public List<Pet> findAll() {
		// 查询所有宠物信息
		  String sql="select * from pet ";	        
	        List<Pet> list=null;
	        try {
	            list= runner.query(sql, new BeanListHandler<Pet>(Pet.class));//添加实体类的适配器进行类的反射
	            return list;
	        } catch (SQLException e) {//捕获异常
	            throw new RuntimeException(e);//抛出运行异常
	        }
	}





	
    
   
	
}
