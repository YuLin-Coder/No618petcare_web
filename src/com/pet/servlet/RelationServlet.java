package com.pet.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Relation;
import com.pet.service.RelationService;
import com.pet.service.impl.RelationServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理用户联系的请求
 */

public class RelationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private RelationService service=new RelationServiceImpl();
      
	//分页查询用户联系信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Relation> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("relationList",list); //绑定参数
        int nums=service.queryRelationCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/relation/relation_list.jsp").forward(request,response); //页面转发
    }
	

	//添加用户联系
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加   	     
        String name=request.getParameter("name");    
        String email=request.getParameter("email");    
        String phone=request.getParameter("phone");   
        String note=request.getParameter("note");              
        try {
            service.addRelation(new Relation(null,name,email,phone,note));
        }catch(Exception e) {};//提交后跳转到首页
       response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toIndex");//重定向防止重复提交       
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Relation relation=service.findById(id);
         request.setAttribute("relation",relation);      
         request.getRequestDispatcher("/WEB-INF/relation/edit_relation.jsp").forward(request,response);
    }

   
    //编辑用户联系信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改   		
    	 String name=request.getParameter("name");    
         String email=request.getParameter("email");    
         String phone=request.getParameter("phone");   
         String note=request.getParameter("note");    
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        try {
            service.updateRelation(new Relation(id,name,email,phone,note)) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/RelationServlet?action=list");//重定向防止重复提交



    }
    //删除用户联系信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteRelation(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/RelationServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Relation> list=service.findRelationByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/relation/list_relation.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/relation/list_relation.jsp").forward(request, response);
        }
    }

    
  //跳转到添加用户联系
    protected void toAddRelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/relation/add_relation.jsp").forward(request,response);
    }
	

}
