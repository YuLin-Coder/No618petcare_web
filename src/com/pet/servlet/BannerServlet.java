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
import com.pet.entity.Banner;
import com.pet.service.BannerService;
import com.pet.service.impl.BannerServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理的请求
 */

public class BannerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BannerService service=new BannerServiceImpl();
      
	//分页查询轮播图信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Banner> list=service.getPage(pageNum,pageSize);
        //携带参数到页面
        request.setAttribute("bannerList",list); //绑定参数
        int nums=service.queryBannerCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/banner/banner_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加轮播图
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
	  		//String savepath= this.getServletContext().getRealPath("/upload");//Tomcat上传路径
	  		String savepath=WebUtils.getRealPath();//物理路径
	  		try {
	  			su.save(savepath);
	  			/* for (int i = 0; i < su.getFiles().getCount(); i++) {//批量上传保存
	  				File　file = su.getFiles().getFile(i);
	  	        	　　if (file.isMissing()) continue;
	  	        	　　file.saveAs(savepath + file.getFileName());
	  	        	}*/
	  		} catch (SmartUploadException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}		
	  		Request req1 = su.getRequest();		
     
        String url=req1.getParameter("url");    
        String note=req1.getParameter("note");  
       
        	
        if(service.queryBannerCount()>6) {
        	   request.setAttribute("msg","最大数量为6!");      
               request.getRequestDispatcher("/WEB-INF/banner/add_banner.jsp").forward(request,response);
        }
       
        try {
            service.addBanner(new Banner(null,fname,url,note));
        }catch(Exception e) {};
       response.sendRedirect(request.getContextPath()+"/BannerServlet?action=list");//重定向防止重复提交       
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Banner banner=service.findById(id);
         request.setAttribute("banner",banner);      
         request.getRequestDispatcher("/WEB-INF/banner/edit_banner.jsp").forward(request,response);
    }

   
    //编辑轮播图信息
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
  		String savepath="D:\\Program Files\\eclipse_workspace\\patcare_web\\WebContent\\upload\\";
  		try {
  			
  			su.save(savepath);
  		} catch (SmartUploadException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}		
  		Request req1 = su.getRequest();		
  		String url=req1.getParameter("url");    
        String note=req1.getParameter("note");   
        String tp=req1.getParameter("photo");   
       Banner banner=new Banner();
       banner.setId(Integer.parseInt(req1.getParameter("id")));
       banner.setNote(note);
       banner.setUrl(url);
       if(f.isMissing()) {//如果没有上传就还用原来的图片
    	   System.out.print("没有上传任何文件"+fname);
    	   banner.setPhoto(tp);
       }else {
    	   banner.setPhoto(fname);
       }
        try {
            service.updateBanner(banner) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/BannerServlet?action=list");//重定向防止重复提交



    }
    //删除轮播图信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deleteBanner(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/BannerServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Banner> list=service.findBannerByMap(name);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/banner/list_banner.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/banner/list_banner.jsp").forward(request, response);
        }
    }
    //查询所有的轮播图
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Banner> list=service.findAllBanner();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("bannerList" ,list);
            request.getRequestDispatcher("/WEB-INF/banner/webiste.jsp").forward(request, response);
        }
    }

    
  //跳转到添加轮播图
    protected void toAddBanner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/banner/add_banner.jsp").forward(request,response);
    }
	

}
