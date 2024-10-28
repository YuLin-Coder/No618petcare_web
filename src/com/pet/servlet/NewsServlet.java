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
import com.pet.entity.Category;
import com.pet.entity.News;
import com.pet.service.CategoryService;
import com.pet.service.NewsService;
import com.pet.service.impl.CategoryServiceImpl;
import com.pet.service.impl.NewsServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理萌宠资讯的请求
 */

public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private NewsService service=new NewsServiceImpl();
	private CategoryService cs=new CategoryServiceImpl();
	//分页查询萌宠资讯信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p=request.getParameter("p");//接收页码   
        int pageSize=2;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<News> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("newsList",list); //绑定参数
        int nums=service.queryNewsCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/news/news_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加萌宠资讯
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
     
        String title=req1.getParameter("title");    
        String content=req1.getParameter("content");  
        String editor=req1.getParameter("editor");      
     System.out.println(title+content+editor);
     News news=new News();
   
     news.setContent(content);
     news.setTitle(title);
     news.setEditor(editor);
     service.addNews(news);
        /*try {
            service.addNews(new News(null,title,content,fname,null,editor));
        }catch(Exception e) {};*/
       response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//重定向防止重复提交       
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         News news=service.findById(id);
         request.setAttribute("news",news);      
         request.getRequestDispatcher("/WEB-INF/news/edit_news.jsp").forward(request,response);
    }
     //查看萌宠咨询资讯详情
     protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         News news=service.findById(id);
         request.setAttribute("news",news);      
         List<Category> list=cs.findAllCategory();  
         request.setAttribute("categoryList",list); //宠物品种
         request.getRequestDispatcher("/WEB-INF/index/detail.jsp").forward(request,response);
    }


   
    //编辑萌宠资讯信息
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
  		String title=req1.getParameter("title");    
        String content=req1.getParameter("content");   
        String photo=req1.getParameter("photo");   
        String editor=req1.getParameter("editor");   
         News news=new News();
       news.setId(Integer.parseInt(req1.getParameter("id")));
       news.setContent(content);
       news.setTitle(title);
       news.setEditor(editor);
       if(f.isMissing()) {//如果没有上传就还用原来的图片
    	   System.out.print("没有上传任何文件"+fname);
    	   news.setPhoto(photo);
       }else {
    	   news.setPhoto(fname);
       }
        try {
            service.updateNews(news) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//重定向防止重复提交
    }
    //删除萌宠资讯信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteNews(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<News> list=service.findNewsByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
        }
    }
    //查询所有的萌宠资讯
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<News> list=service.findAllNews();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("newsList" ,list);
            request.getRequestDispatcher("/WEB-INF/news/webiste.jsp").forward(request, response);
        }
    }

    
  //跳转到添加萌宠资讯
    protected void toAddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/news/add_news.jsp").forward(request,response);
    }
	

}
