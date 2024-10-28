package com.pet.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.entity.Messages;
import com.pet.entity.User;
import com.pet.service.MessagesService;
import com.pet.service.UserService;
import com.pet.service.impl.MessagesServiceImpl;
import com.pet.service.impl.UserServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理用户留言的请求
 */

public class MessagesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private MessagesService service=new MessagesServiceImpl();
	private UserService us=new UserServiceImpl();
      
	//分页查询用户留言信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Messages> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        for(Messages m:list) {
        	User user=us.findById(m.getUid());
        	m.setUser(user);
        	
        }
        request.setAttribute("messagesList",list); //绑定参数
        int nums=service.queryMessagesCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/messages/messages_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加用户留言
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加   	     
        String content=request.getParameter("content");    
       User user=(User) request.getSession().getAttribute("user");
       request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
       if(user!=null) {
    	   try {
               service.addMessages(new Messages(null,content,user.getId(),null));
           }catch(Exception e) {};
           PrintWriter out = response.getWriter();			
			out.write("<script>");
			/*out.write("");*/
			out.write("alert('留言成功');location.href='IndexServlet?action=toIndex'");
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

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Messages messages=service.findById(id);
         request.setAttribute("messages",messages);      
         request.getRequestDispatcher("/WEB-INF/messages/edit_messages.jsp").forward(request,response);
    }

   
    //编辑用户留言信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//更改   		
  		String content=request.getParameter("content");    
     
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        Messages messages=new Messages();
        messages.setId(id);
        messages.setContent(content);
   
        try {
            service.updateMessages(messages) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/MessagesServlet?action=list");//重定向防止重复提交



    }
    //删除用户留言信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteMessages(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/MessagesServlet?action=list"); //重定向防止重复提交哦
        }
      
    }
    //前台删除
    protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteMessages(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/MessagesServlet?action=toPersonInfo"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Messages> list=service.findMessagesByMap(name);
        for(Messages m:list) {
        	User user=us.findById(m.getUid());
        	m.setUser(user);
        	
        }
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/messages/list_messages.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/messages/list_messages.jsp").forward(request, response);
        }
    }


    
  //跳转到添加用户留言
    protected void toAddMessages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        
        List<Messages> list=service.findAllMessages();
        for(Messages m:list) {
        	User user=us.findById(m.getUid());
        	m.setUser(user);
        	
        }
        request.setAttribute("list" ,list);
        request.getRequestDispatcher("/WEB-INF/index/messages.jsp").forward(request,response);
    }
	

}
