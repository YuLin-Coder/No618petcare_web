package com.pet.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;



public class WebUtils {

	public static  <T> T copyParamToBean(Map value, T bean){//使用泛型来减少request.getParameter的重复代码，优化开发
		try {

			System.out.println("注入之前"+bean);
			BeanUtils.populate(bean,value);
			System.out.println("注入之后"+bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int parseInt(String sid,int defalultvalue) {//把String类型的id转化Integer类型的
		  try {
	            return Integer.parseInt(sid);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return defalultvalue;
	}
	
	public static String getRealPath() {
		return "D:\\Program Files\\eclipse_workspace\\petcare_web\\WebContent\\upload\\";
	}
	
	public  String getRno() {//生成订单号
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	      String newDate=sdf.format(new Date());
	      String result="";
	      Random random=new Random();
	      for(int i=0;i<3;i++){
	          result+=random.nextInt(10);
	      }
	      return newDate+result;
	    
	}
	


}
