<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
 <jsp:include page="/WEB-INF/common/header.jsp"/>
    <!DOCTYPE HTML>

    <!-- 幻灯片-->
   	  	<div class="">
   		<!-- <img src="images/ban4.jpg"/>  		 -->
   	</div>
    <!-- 商品-->
  	<div class="main" role="main">
    	<div id="content" class="content full">
            <!-- start container -->
                       

         <div class="container padding-tb60">
              
                <div class="contact clearfix"> 
               <br>
      <h3>我的订单信息</h3>      
        
<table class="table table-striped">
    <thead>
      <tr>
        <th>订单编号</th>
        <th>商品名称</th>
        <th>商品图片</th>
         <th>商品单价</th>
         <th>下单数量</th>
         <th>下单人</th>       
          <th>总金额</th>
            <th>下单时间</th>
               <th>操作</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ordersList }" var="row">
      <tr>
          <td>${row.orders_no}</td>
			                        <td>${row.product.name}</td>
			                     <td><img src="upload/${row.product.photo}" style="width:100px;height:80px;"/></td>
			                      <td>${row.product.price}</td>
			                      <td>${row.quantity}</td>
			                      <td>${row.user.nickname}</td>
			                    <td>${row.total_price}</td>
			                       <td><fmt:formatDate value="${row.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>      
		                    <td>			                        <a class="btn btn-danger btn-sm"  href="OrdersServlet?action=delete2&id=${row.id }">删除</a>
		                    </td>
		                   
      </tr>
        </c:forEach>
    </tbody>
 
</table>
                 
	  
      
	       
                
            </div> 
            
                            <div class="contact clearfix"> 
                
             <br>
      <h3>我的留言信息</h3>

                 
	                 <table class="table table-striped">
    <thead>
      <tr>
        <th>留言人</th>
        <th>留言内容</th>
        <th>留言时间</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${messagesList }" var="row">
      <tr>
        <td>${row.user.nickname }</td>
        <td>${row.content }</td>
        <td><fmt:formatDate value="${row.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        <td>			                        <a class="btn btn-danger btn-sm"  href="MessagesServlet?action=delete2&id=${row.id }">删除</a>
		                    </td>
      </tr>
        </c:forEach>
    </tbody>
</table>
      
	       
                
            </div> 
            <!-- end container -->
        </div>
    </div>
    <!-- 尾部 -->
    <jsp:include page="/WEB-INF/common/footer.jsp"/>
  	<a id="back-to-top"><i class="fa fa-arrow-up"></i></a> 
</div>
<script src="js/jquery-2.2.3.min.js"></script> <!-- Jquery Library Call -->
<script src="vendor/magnific/jquery.magnific-popup.min.js"></script> <!-- Maginific Popup Plugin -->
<script src="js/ui-plugins.js"></script> <!-- UI Plugins -->
<script src="js/helper-plugins.js"></script> <!-- Helper Plugins -->
<script src="vendor/owl-carousel/js/owl.carousel.min.js"></script> <!-- Owl Carousel -->
<script src="js/bootstrap.js"></script> <!-- UI -->
<script src="js/init.js"></script> <!-- All Scripts -->
<script src="vendor/flexslider/js/jquery.flexslider.js"></script> <!-- FlexSlider -->
<!--<script src="js/jquery.mb.YTPlayer.js"></script>-->
</body>
</html>
    