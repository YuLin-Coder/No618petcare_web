<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

 <jsp:include page="/WEB-INF/common/header.jsp"/>
    <!-- 幻灯片-->
   	<div class="">
   		<img src="images/ban6.jpg"/>  		
   	</div>
    <!-- 萌宠资讯-->
  	<div class="main" role="main">
    	<div id="content" class="content full">
            <div class="container padding-tb60" >
            	<div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2 style="font-weight: 400;"><span>——</span>萌宠资讯<span>——</span></h2>
                    </div>              
                <div class="row"  style="margin-top: 50px;">
                    <div class="col-md-9 content-block news">
                     <c:forEach items="${newsList }" var="n">
                        <div class="post-list-item">
                            <!-- start row -->
                            <div class="row">
                                <div class="col-md-4 col-sm-4 format-standard">
                                    <a href="NewsServlet?action=detail&id=${n.id }" class="media-box grid-featured-img">
                                        <img src="upload/${n.photo }" >
                                    </a>
                                </div>
                                <div class="col-md-8 col-sm-8">
                                    <h3><a href="blog - show.html">${n.title }</a></h3>
                                    <div class="meta-data grid-item-meta">
                                        <div>
                                            <i class="fa fa-calendar"></i>
                                            ${n.fbsj }
                                        </div>
                                        <div>
                                            <i class="fa fa-pencil"></i>
                                            <a>${n.editor }</a>
                                        </div>
                                    </div>
                                    <div class="grid-item-excerpt">
                                        <p>${fn:substring(n.content,127,379)}..</p>
                                    </div>
                                    <a href="NewsServlet?action=detail&id=${n.id }" title="Read more" class="btn btn-primary btn-secondary">阅读更多</a>
                                </div>
                            </div>
                            <!-- end row -->
                        </div>
                        </c:forEach>
                              
                    </div>
                </div>
                <!-- end row -->
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
