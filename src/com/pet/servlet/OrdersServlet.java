package com.pet.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Orders;
import com.pet.entity.Product;
import com.pet.entity.User;
import com.pet.service.OrdersService;
import com.pet.service.ProductService;
import com.pet.service.UserService;
import com.pet.service.impl.OrdersServiceImpl;
import com.pet.service.impl.ProductServiceImpl;
import com.pet.service.impl.UserServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理订单的请求
 */

public class OrdersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrdersService service=new OrdersServiceImpl();
	private UserService us=new UserServiceImpl();	
	private ProductService ps=new ProductServiceImpl();
      
	//分页查询用户订单信息信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Orders> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        for(Orders m:list) {
        	User user=us.findById(m.getUid());
        	Product product=ps.findById(m.getProduct_id());
        	m.setUser(user);
        	m.setProduct(product);
        	
        }
        request.setAttribute("ordersList",list); //绑定参数
        int nums=service.queryOrdersCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/orders/orders_list.jsp").forward(request,response); //页面转发
    }
	
	
	//下单
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加   	     
      int product_id=WebUtils.parseInt(request.getParameter("product_id"),0);
       User user=(User) request.getSession().getAttribute("user");
       Product p=ps.findById(product_id);
       request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
       if(user!=null) {
    	   Orders orders=new Orders();
   		orders.setOrders_no(new WebUtils().getRno());
   		orders.setProduct_id(product_id);
   		orders.setTotal_price(p.getPrice());
   		orders.setQuantity(1);
   		orders.setUid(user.getId());
   		ps.updateStock(product_id);
    	   try {
               service.addOrders(orders);
           }catch(Exception e) {};
           PrintWriter out = response.getWriter();			
			out.write("<script>");
			out.write("");
			out.write("alert('下单成功');location.href='IndexServlet?action=toPersonInfo'");
			out.write("</script>");
			out.close();	
       }else {
    	   PrintWriter out = response.getWriter();			
			out.write("<script>");
			/*out.write("");*/
			out.write("alert('请先登录');location.href='LoginServlet?action=loginOut'");
			out.write("</script>");
			out.close();	
       }
       
             
    }

    
    //删除用户订单信息信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteOrders(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/OrdersServlet?action=list"); //重定向防止重复提交哦
        }
      
    }
    
    
  //删除用户订单信息信息
    protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteOrders(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toPersonInfo"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Orders> list=service.findOrdersByMap(name);
        for(Orders m:list) {
        	User user=us.findById(m.getUid());
        	Product product=ps.findById(m.getProduct_id());
        	m.setUser(user);
        	m.setProduct(product);
        	
        }
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/orders/list_orders.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/orders/list_orders.jsp").forward(request, response);
        }
    }


    
  
	

}
