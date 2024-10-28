package com.pet.servlet;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.pet.entity.Product;
import com.pet.service.ProductService;
import com.pet.service.impl.ProductServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理宠物用品的请求
 */

public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service=new ProductServiceImpl();
      
	//分页查询宠物用品信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Product> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("productList",list); //绑定参数
        int nums=service.queryProductCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/product/product_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加宠物用品
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
    	  SmartUpload su= new SmartUpload();		
	  		//初使化
	  		su.initialize(this.getServletConfig(), request, response);		
	  		//上传过程
	  		try {
	  			su.upload();
	  		} catch (SmartUploadException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}		
	  		//获取上传的文件对象
	  		Files fs= su.getFiles();
	  		File f = fs.getFile(0);
	  		//获取上传的文件名称
	  		String fname = f.getFileName();		
	  		//String savepath= this.getServletContext().getRealPath("/upload");//上传路径
	  		String savepath=WebUtils.getRealPath();
	  		
	  		try {
	  			su.save(savepath);
	  		
	  		} catch (SmartUploadException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}		
	  		Request req1 = su.getRequest();		
     
        String name=req1.getParameter("name");    
        String price=req1.getParameter("price");  
        String stock=req1.getParameter("stock");  
        try {
            service.addProduct(new Product(null,name,Integer.parseInt(stock),Integer.parseInt(price),fname));
        }catch(Exception e) {};
       response.sendRedirect(request.getContextPath()+"/ProductServlet?action=list");//重定向防止重复提交       
    }



	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Product product=service.findById(id);
         request.setAttribute("product",product);      
         request.getRequestDispatcher("/WEB-INF/product/edit_product.jsp").forward(request,response);
    }

   
    //编辑宠物用品信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
    	SmartUpload su= new SmartUpload();		
  		//初使化
  		su.initialize(this.getServletConfig(), request, response);		
  		//上传过程
  		try {
  			su.upload();
  		} catch (SmartUploadException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}		
  		//获取上传的文件对象
  		Files fs= su.getFiles();
  		File f = fs.getFile(0);
  		//获取上传的文件名称
  		String fname = f.getFileName();		
  		//String savepath= this.getServletContext().getRealPath("/upload");//上传路径
		String savepath=WebUtils.getRealPath();
  		try {
  			
  			su.save(savepath);
  		} catch (SmartUploadException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}		
  		Request req1 = su.getRequest();		

        String name=req1.getParameter("name");    
        String price=req1.getParameter("price");
        String photo=req1.getParameter("photo");   
        String stock=req1.getParameter("stock");  
         Product product=new Product();
       product.setId(Integer.parseInt(req1.getParameter("id")));
       product.setName(name);
       product.setStock(Integer.parseInt(stock));
       product.setPrice(Integer.parseInt(price));      
       if(f.isMissing()) {//如果没有上传就还用原来的图片
    	   System.out.print("没有上传任何文件"+fname);
    	   product.setPhoto(photo);
       }else {
    	   product.setPhoto(fname);
       }
        try {
            service.updateProduct(product) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/ProductServlet?action=list");//重定向防止重复提交
    }
    //删除宠物用品信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteProduct(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/ProductServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Product> list=service.findProductByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/product/list_product.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/product/list_product.jsp").forward(request, response);
        }
    }
    //查询所有的宠物用品
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Product> list=service.findAllProduct();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("productList" ,list);
            request.getRequestDispatcher("/WEB-INF/product/webiste.jsp").forward(request, response);
        }
    }

    
  //跳转到添加宠物用品
    protected void toAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/product/add_product.jsp").forward(request,response);
    }
	

}
