package com.pet.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.User;
import com.pet.service.UserService;
import com.pet.service.impl.UserServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理用户信息的请求
 */

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
      
	//分页查询用户信息信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<User> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("userList",list); //绑定参数
        int nums=service.queryUserCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/user/user_list.jsp").forward(request,response); //页面转发
    }
/*	this.id = id;
	this.username = username;
	this.pwd = pwd;
	this.sex = sex;
	this.nickname = nickname;
	this.registeTime = registeTime;*/
	
	//注册
    protected void registe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加   	     
        String username=request.getParameter("username");   
        String pwd=request.getParameter("pwd");  
        String sex=request.getParameter("sex");              
        String nickname=request.getParameter("nickname");  
        
        try {
        	if(service.existUser(username)){
                request.setAttribute("msg","用户名已经注册");
                request.setAttribute("username",username);          
                request.getRequestDispatcher("/WEB-INF/views/registe.jsp").forward(request,response);
            }else {
            	service.addUser(new User(null,username,pwd,sex,nickname,null));
            	//response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toIndex");//重定向防止重复提交      
            	 PrintWriter out = response.getWriter();			
        			out.write("<script>");
        			/*out.write("");*/
        			out.write("alert('registe success');location.href='IndexServlet?action=toIndex'");
        			out.write("</script>");
        			out.close();	
            }
    		
            
        }catch(Exception e) {};
        
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         User user=service.findById(id);
         request.setAttribute("user",user);      
         request.getRequestDispatcher("/WEB-INF/user/edit_user.jsp").forward(request,response);
    }

   
    //编辑用户信息信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改   		
    	String username=request.getParameter("username");   
        String pwd=request.getParameter("pwd");  
        String sex=request.getParameter("sex");              
        String nickname=request.getParameter("nickname");       
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setNickname(nickname);
         
        try {
            service.updateUser(user) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/UserServlet?action=list");//重定向防止重复提交



    }
    //删除用户信息信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteUser(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/UserServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<User> list=service.findUserByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/user/list_user.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/user/list_user.jsp").forward(request, response);
        }
    }
 
    
  //注册
    protected void toRegiste(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/views/registe.jsp").forward(request,response);
    }
	

}
