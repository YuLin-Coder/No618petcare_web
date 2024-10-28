package com.pet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;

import com.pet.entity.Banner;
import com.pet.entity.Category;
import com.pet.entity.Messages;
import com.pet.entity.News;
import com.pet.entity.Orders;
import com.pet.entity.Pet;
import com.pet.entity.Product;
import com.pet.entity.User;
import com.pet.service.AdminService;
import com.pet.service.BannerService;
import com.pet.service.CategoryService;
import com.pet.service.MessagesService;
import com.pet.service.NewsService;
import com.pet.service.OrdersService;
import com.pet.service.PetService;
import com.pet.service.ProductService;
import com.pet.service.UserService;
import com.pet.service.impl.AdminServiceImpl;
import com.pet.service.impl.BannerServiceImpl;
import com.pet.service.impl.CategoryServiceImpl;
import com.pet.service.impl.MessagesServiceImpl;
import com.pet.service.impl.NewsServiceImpl;
import com.pet.service.impl.OrdersServiceImpl;
import com.pet.service.impl.PetServiceImpl;
import com.pet.service.impl.ProductServiceImpl;
import com.pet.service.impl.UserServiceImpl;
import com.pet.utils.WebUtils;


/**
 * 处理网站的相关请求
 */

public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();   
	private BannerService bs=new BannerServiceImpl();
	private PetService ps=new PetServiceImpl();
	private CategoryService cs=new CategoryServiceImpl();
	private NewsService ns=new NewsServiceImpl();
	private ProductService service=new ProductServiceImpl();
	private MessagesService ms=new MessagesServiceImpl();
	private UserService us=new UserServiceImpl();
	private OrdersService os=new OrdersServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //网站首页
    protected void toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	List<Banner> list=bs.findAllBanner();      
        request.setAttribute("bannerList",list); //绑定轮播图
        List<Pet> list2=ps.findAllPet();   
        request.setAttribute("petList",list2); //宠物集合
        List<News> list3=ns.findAllNews();   
        request.setAttribute("newsList",list3); //萌宠咨询
        List<Category> list4=cs.findAllCategory();  
        request.setAttribute("categoryList",list4); //宠物品种
    	request.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(request,response);
	}
    //去宠物品种节目
    protected void tokinds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        List<Pet> list=ps.findAllPet();   
        request.setAttribute("petList",list); //宠物集合      
        List<Category> list4=cs.findAllCategory();  
        request.setAttribute("categoryList",list4); //宠物品种
    	request.getRequestDispatcher("/WEB-INF/index/kinds.jsp").forward(request,response);
	}
    //去宠物用品界面
    protected void toProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        List<Product> list=service.findAllProduct();
        request.setAttribute("productList",list); //宠物集合    
        List<Category> list4=cs.findAllCategory();  
        request.setAttribute("categoryList",list4); //宠物
    	request.getRequestDispatcher("/WEB-INF/index/product.jsp").forward(request,response);
	}
    //关于我们
    protected void toAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  
    	List<Category> list4=cs.findAllCategory();  
        request.setAttribute("categoryList",list4); //宠物品种
    	request.getRequestDispatcher("/WEB-INF/index/about.jsp").forward(request,response);
	}
    
    //萌宠资讯
    protected void toNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	 List<News> list3=ns.findAllNews();   
         request.setAttribute("newsList",list3); //萌宠咨询
         List<Category> list4=cs.findAllCategory();  
         request.setAttribute("categoryList",list4); //宠物品种
    	request.getRequestDispatcher("/WEB-INF/index/news.jsp").forward(request,response);
	}
    //个人中心
    protected void toPersonInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	  
          User user=(User) request.getSession().getAttribute("user");
        
          if(user!=null) {
        	  List<Orders> list=os.findMyOrders(user.getId());
              for(Orders m:list) {
              	User u=us.findById(m.getUid());
              	Product product=service.findById(m.getProduct_id());
              	m.setUser(u);
              	m.setProduct(product);
              	
              }
        	  List<Messages> list2=ms.findMyMessages(user.getId());
              //携带参数到页面
              for(Messages m:list2) {
              	User user2=us.findById(m.getUid());
              	m.setUser(user2);
              	
              }
              request.setAttribute("ordersList",list); //我的订单信息
              request.setAttribute("messagesList",list2); //我的订单信息
              request.getRequestDispatcher("/WEB-INF/index/person_info.jsp").forward(request,response);
          }else {
       	   PrintWriter out = response.getWriter();			
   			out.write("<script>");
   			/*out.write("");*/
   			out.write("alert('请先登录');location.href='LoginServlet?action=loginOut'");
   			out.write("</script>");
   			out.close();	
          }
          
	}
    
    
    
    //去联系我们
    protected void toContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	 List<Category> list4=cs.findAllCategory();  
         request.setAttribute("categoryList",list4); //宠物
    	request.getRequestDispatcher("/WEB-INF/index/contact.jsp").forward(request,response);
	}
    //去登陆后台
    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  	
    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
	}
    //寻找地图
    protected void toDitu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  	
    	request.getRequestDispatcher("/WEB-INF/index/ditu.jsp").forward(request,response);
	}

 
    //跳转到后台的欢迎界面
    protected void welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    	request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,response);
	}

	
}
