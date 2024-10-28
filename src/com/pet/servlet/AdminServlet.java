package com.pet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Admin;
import com.pet.service.AdminService;
import com.pet.service.impl.AdminServiceImpl;
import com.pet.utils.WebUtils;

/**
 * 处理管理员的业务
 */

public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service=new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //查看个人信息
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询个人信息
    	int id=WebUtils.parseInt(request.getParameter("id"),0);
        Admin admin=service.findById(id);
        request.setAttribute("admin",admin);
        System.out.println(admin);
        request.getRequestDispatcher("/WEB-INF/admin/edit_admin.jsp").forward(request,response);
    }
    
    //管理员修改
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String username=request.getParameter("username");      
        String pwd=request.getParameter("pwd");      
        String nickname=request.getParameter("nickname");
        Admin  admin=new Admin();
        admin.setId(id);
        admin.setNickname(nickname);
        admin.setUsername(username);
        admin.setPwd(pwd);
        int b=service.updateAdmin(admin);
        if(b==1) {
        	 Admin record=service.findById(id);
             request.setAttribute("admin",record);
             System.out.println(admin);
             request.getRequestDispatcher("/WEB-INF/admin/edit_success.jsp").forward(request,response);
        }
       
    }
    



}
