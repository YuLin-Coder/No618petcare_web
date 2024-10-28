<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

 <jsp:include page="/WEB-INF/common/header.jsp"/>
    <!-- 幻灯片-->
   	<div class="">
   		<img src="images/Z.jpg"/>  		
   	</div>
    <!-- 联系我们-->
  	<div class="main" role="main">
    	<div id="content" class="content full">
            <!-- start container -->
            <div class="container padding-tb60">
                <div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2 style="font-weight: 400;"><span>——</span>主营用品<span>——</span></h2>
                    </div>              
                <div class="clearfix"></div>
                <div class="woocommerce">
                    <ul class="products">
                      <c:forEach items="${productList }" var="p">
                        <li class="product">
                            <a href="#" title="" class="woocommerce-LoopProduct-link">
                                <span class="onsale">热卖!</span>
                                <img src="upload/${p.photo }" alt="">
                                <h3>${p.name }</h3>
                                <span class="price">
                                    <ins>
                                        <span>￥<span>${p.price} </span>     库存:${p.stock} </span>
                                          
                                    </ins>
                                    
                                </span>
                             
                            </a>
                            <a href="OrdersServlet?action=add&product_id=${p.id }" title="" class="button product_type_simple">在线预订</a>	
                        </li>
                        </c:forEach>
                    </ul>
                </div>
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
