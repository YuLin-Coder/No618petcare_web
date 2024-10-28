package com.pet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Admin;
import com.pet.entity.User;
import com.pet.service.AdminService;
import com.pet.service.UserService;
import com.pet.service.impl.AdminServiceImpl;
import com.pet.service.impl.UserServiceImpl;


/**
 * 处理管理员的相关业务
 */

public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();   
  private UserService us=new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//管理员登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理登录
        String username = request.getParameter("username").trim();
        String pwd = request.getParameter("pwd").trim();
		Admin admin=as.login(username,pwd);
		System.out.println(username+pwd+admin);
		
        int type=Integer.parseInt(request.getParameter("type").trim());
	       switch (type) {
	       case 1:
				User user=us.login(username,pwd);
				System.out.println(username+pwd+"type=1"+user);
				if(user==null){
					  request.setAttribute("msg","用户名或者或者密码错误"); //绑定参数
					  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
				}else {
					request.getSession().setAttribute("user", user);		
					request.getSession().setAttribute("type", "1");				
			        response.sendRedirect(request.getContextPath()+"/IndexServlet?action=toIndex"); //重定向防止重复提交哦	
				}
				break;
	     
			case 2:
				if(admin==null){
					request.setAttribute("msg","用户名或者密码错误"); //绑定参数
					request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
					}else {
					request.getSession().setAttribute("admin", admin);		
					
					request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);					
					}
		
				break;
        

	       }
				
	       
    }
    
 
    //注销登录
    protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.getSession().invalidate();   	
    	request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	
}
