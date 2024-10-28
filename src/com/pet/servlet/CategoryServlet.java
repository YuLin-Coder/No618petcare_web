package com.pet.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Category;
import com.pet.service.CategoryService;
import com.pet.service.impl.CategoryServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理宠物种类的请求
 */

public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service=new CategoryServiceImpl();
      
	//分页查询宠物种类信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Category> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("categoryList",list); //绑定参数
        int nums=service.queryCategoryCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/category/category_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加宠物种类
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加   	     
        String cname=request.getParameter("cname");    
        String note=request.getParameter("note");              
        try {
            service.addCategory(new Category(null,cname,note));
        }catch(Exception e) {};
       response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=list");//重定向防止重复提交       
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Category category=service.findById(id);
         request.setAttribute("category",category);      
         request.getRequestDispatcher("/WEB-INF/category/edit_category.jsp").forward(request,response);
    }

   
    //编辑宠物种类信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改   		
  		String cname=request.getParameter("cname");    
        String note=request.getParameter("note");   
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        Category category=new Category();
        category.setId(id);
        category.setNote(note);
        category.setCname(cname);     
        try {
            service.updateCategory(category) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=list");//重定向防止重复提交



    }
    //删除宠物种类信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteCategory(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/CategoryServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Category> list=service.findCategoryByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/category/list_category.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/category/list_category.jsp").forward(request, response);
        }
    }
 /*   
    //查询所有的宠物种类
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Category> list=service.findAllCategory();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("categoryList" ,list);
            request.getRequestDispatcher("/WEB-INF/category/webiste.jsp").forward(request, response);
        }
    }*/

    
  //跳转到添加宠物种类
    protected void toAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/category/add_category.jsp").forward(request,response);
    }
	

}
