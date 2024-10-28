<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
                        <img src="images/zhua.png">
                        <h2 style="font-weight: 400;"><span>——</span>联系我们<span>——</span></h2>
                    </div> 
                <div class="contact clearfix">  
	                <div class="map">
	                	<iframe src="IndexServlet?action=toDitu" style="width: 100%; height: 450px;"></iframe>
	                </div>
	              <!--   <form method="post" action="RelationServlet?action=add" class="left_form"> -->
	               <form method="post" action="#" class="left_form">
						    	<!-- <div>
							    	<span><label>您的姓名</label></span>
							    	<span><input name="name" type="text" class="textbox"></span>
							    </div>
							    <div>
							    	<span><label>您的邮箱</label></span>
							    	<span><input name="email" type="text" class="textbox"></span>
							    </div>
							    <div>
							     	<span><label>联系电话</label></span>
							    	<span><input name="phone" type="text" class="textbox"></span>
							    </div>
							    <div>					    	
							    	<span><label>其他要求</label></span>
							    	<span><textarea name="note"> </textarea></span>
							    </div>
							   <div>
							   		<span><input type="submit" value="提交" class="myButton"></span>
							  </div>
							</div> -->
							<div>
							    	<span><label>店长</label></span>
							    	<span><input name="name" readonly value="沈航蓉" type="text" class="textbox"></span>
							    </div>
							    <div>
							    	<span><label>邮箱</label></span>
							    	<span><input name="email" readonly value="1728608455@qq.com"type="text" class="textbox"></span>
							    </div>
							    <div>
							     	<span><label>联系电话</label></span>
							    	<span><input name="phone" readonly value="0512-57995109" type="text" class="textbox"></span>
							    </div>
							    <div>					    	
							    	<span><label>店铺地址</label></span>
							    	<span><textarea name="note" readonly>北京市中关村宠物乐园 </textarea></span>
							    </div>
							   <div>
							   	<!-- 	<span><input type="submit" value="提交" class="myButton"></span> -->
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
    