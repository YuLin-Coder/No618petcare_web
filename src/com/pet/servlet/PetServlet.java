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
import com.pet.entity.Pet;
import com.pet.service.CategoryService;
import com.pet.service.PetService;
import com.pet.service.impl.CategoryServiceImpl;
import com.pet.service.impl.PetServiceImpl;
import com.pet.utils.WebUtils;

/**
 *处理宠物信息的请求
 */

public class PetServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PetService service=new PetServiceImpl();
	private CategoryService cs=new CategoryServiceImpl();
      
	//分页查询宠物信息信息
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p=request.getParameter("p");//接收页码   
        int pageSize=5;//每页显示5条
        int pageNum=1; //默认第一页
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //调用分页查询
        List<Pet> list=service.getPage(pageNum,pageSize);
        for(Pet pet:list) {
        	Category category=cs.findById(pet.getC_id());
        	pet.setCategory(category);
        }
        //携带参数到页面
        request.setAttribute("petList",list); //绑定参数
        int nums=service.queryPetCount(); //查询总数
        //计算总页数
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //当前页
        request.setAttribute("tp",totalPage); //总页数

        //条件 值1：值2
        request.getRequestDispatcher("/WEB-INF/pet/pet_list.jsp").forward(request,response); //页面转发
    }
	
	
	//添加宠物信息
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
        int c_id=Integer.parseInt(req1.getParameter("c_id"));  
        String characters=req1.getParameter("characters");    
        String detail=req1.getParameter("detail");    
        try {
            service.addPet(new Pet(null,name,c_id,fname,characters,detail,null));
        }catch(Exception e) {};
       response.sendRedirect(request.getContextPath()+"/PetServlet?action=list");//重定向防止重复提交       
    }

    	//根据id查询
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Pet pet=service.findById(id);
         request.setAttribute("pet",pet);      
         List<Category> list=cs.findAllCategory();
         request.setAttribute("categoryList" ,list);
         request.getRequestDispatcher("/WEB-INF/pet/edit_pet.jsp").forward(request,response);
    }

   
    //编辑宠物信息信息
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
       int c_id=Integer.parseInt(req1.getParameter("c_id"));  
       String characters=req1.getParameter("characters");    
       String detail=req1.getParameter("detail"); 
  		
        String photo=req1.getParameter("photo");   
       
        Pet pet=new Pet();
       pet.setId(Integer.parseInt(req1.getParameter("id")));
       pet.setName(name);
       pet.setC_id(c_id);
       pet.setCharacters(characters);
       pet.setDetail(detail);
       if(f.isMissing()) {//如果没有上传就还用原来的图片
    	   System.out.print("没有上传任何文件"+fname);
    	   pet.setPhoto(photo);
       }else {
    	   pet.setPhoto(fname);
       }
        try {
            service.updatePet(pet) ;
        }catch(Exception e) {};
        response.sendRedirect(request.getContextPath()+"/PetServlet?action=list");//重定向防止重复提交
    }
    //删除宠物信息信息
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//根据id删除
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int b=service.deletePet(id);
        if(b==1) {
        	  response.sendRedirect(request.getContextPath()+"/PetServlet?action=list"); //重定向防止重复提交哦
        }
      
    }

    //根据名称查询
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询  
        String name=request.getParameter("name");
        List<Pet> list=service.findPetByMap(name);
        for(Pet pet:list) {
        	Category category=cs.findById(pet.getC_id());
        	pet.setCategory(category);
        }
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"无此信息");
            request.getRequestDispatcher("/WEB-INF/pet/list_pet.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/pet/list_pet.jsp").forward(request, response);
        }
    }
    //查询所有的宠物信息
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//条件查询      
        List<Pet> list=service.findAllPet();
        if(null == list || list.size() ==0 ){
             request.getRequestDispatcher("/WEB-INF/client/website.jsp").forward(request, response);
        }else {      
            request.setAttribute("petList" ,list);
            request.getRequestDispatcher("/WEB-INF/pet/webiste.jsp").forward(request, response);
        }
    }

    
  //跳转到添加宠物信息
    protected void toAddPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面      
    	List<Category> list=cs.findAllCategory();
    	request.setAttribute("categoryList" ,list);
    	request.getRequestDispatcher("/WEB-INF/pet/add_pet.jsp").forward(request,response);
    }
	

}
