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
   		<img src="images/ban3.jpg"/>  		
   	</div>
    <!-- 联系我们-->
  	<div class="main" role="main">
    	<div id="content" class="content full">
            <!-- start container -->
            <div class="container padding-tb60">
                <div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2 style="font-weight: 400;"><span>——</span>爱宠品种<span>——</span></h2>
                    </div>              
                <div class="warp clearfix">
                <c:forEach items="${petList }" var="p">
	                <div class="kinds clearfix">
	                <c:if test="${p.id%2!=0 }"><!-- 如果判断id为奇数，则图片显示在左侧，反之，显示在右侧 -->
	                	<div class="left-img">
	                		<img src="upload/${p.photo }"/>
	                	</div>
	                </c:if>
	                <c:if test="${p.id%2==0 }"><!--  -->
	                	<div class="left-img y">
	                		<img src="upload/${p.photo }"/>
	                	</div>
	                </c:if>
	                	<div class="right-words r">
	                		<h3>${p.name }<span></span></h4>
	                		<p>${p.characters }</p>
	                		<hr />
	                		<p>${p.detail }</p>
	                	</div>                	             	
	                </div>
	                </c:forEach>
	                
                </div>
                <div class="spacer-50"></div>
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
  