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
   		<img src="images/ban4.jpg"/>  		
   	</div>
    <!-- 商品-->
  	<div class="main" role="main">
    	<div id="content" class="content full">
            <!-- start container -->
            <div class="container padding-tb60">
                <div class="spacer-50">
                        <!-- <img src="images/zhua.png"> -->
                        <h2 style="font-weight: 400;"><span>——</span>留言<span>——</span></h2>
                    </div> 
                <div class="contact clearfix">  
	             <div class="map">
	             <table class="table table-striped">
    <thead>
      <tr>
        <th>留言人</th>
        <th>留言内容</th>
        <th>留言时间</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${list }" var="row">
      <tr>
        <td>${row.user.nickname }</td>
        <td>${row.content }</td>
        <td><fmt:formatDate value="${row.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
      </tr>
        </c:forEach>
    </tbody>
</table>
	                <!-- 	<iframe src="IndexServlet?action=toDitu" style="width: 100%; height: 450px;"></iframe> -->
	                </div>  
	               
	              
	             
	                <form method="post" action="MessagesServlet?action=add" >
						    	
							    <div>					    	
							    	<span><label>留言内容</label></span>
							    	<span><textarea rows="10" name="content"> </textarea></span>
							    </div>
							   <div>
							   		<span><input type="submit" value="确定留言" class="myButton"></span>
							  </div>
							</div>
					    </form>

                  
	       
                
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
    