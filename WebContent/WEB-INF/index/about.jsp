<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
  <jsp:include page="/WEB-INF/common/header.jsp"/>
    <!-- 幻灯片-->
   	<div class="ban">
   		<img src="images/ban2.jpg"/>  		
   	</div>

  	<div class="main" role="main">
    	<div id="content" class="content full padding-tb60">
            <!-- start container -->
        	<div class="container">
        		<div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2 style="font-weight: 400;"><span>——</span>关于我们<span>——</span></h2>
                    </div> 
                <div class="spacer-50"></div>
                <!-- start row -->
                <div class="row">
                    <div class="col-md-6 col-sm-6">
                        <img style="width:100%" src="images/ab.jpg" alt="">
                        <div class="spacer-35"></div>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <p>“让天下宠物得到人间关爱”是XX始终不变的企业愿景。对生命的关爱，带来对宠物需求的全新发现和产品开发的独特视角，也是XX追求消费者价值最大化的动力之源。这就是XX步步领先的秘诀所在。因为国际品牌的影响，目前市场上的宠物食品几乎都在强调营养和功能，大大小小的品牌象跟风似地产品按犬种、年龄段进行细分。而XX却在纷繁芜杂的现象背后发现了众多宠物主人对于犬猫粮“美味”的需求——他们疼爱自己的宠物，担心每天吃一样的干粮太单调</p>
                        <p>XX吸收全球业界的先进经验，不断强化自身的研发实力，以多名动物营养硕士和兽医为核心，建立了亚洲最大的宠物食品研发中心，制定了适口性、营养全面提升的每年计划。</p>
                    </div>
                </div>
                <!-- end row -->
                <div class="spacer-40"></div>
            </div>
            <!-- end container -->
            <!-- start counters -->
           
            <!-- 客户评价 -->
            <div class="parallax parallax1 padding-tb75" style="background-image:url(images/img32.jpg);">
                <!-- start container -->
                <div class="container">
                    <!-- start row -->
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="our-services">
                                <!-- start carousel -->
                                <div class="carousel-wrapper">
                                    <div class="row">
                                        <ul class="owl-carousel carousel-fw" data-columns="1" data-autoplay="5000" data-pagination="yes" data-arrows="no" data-single-item="no" data-items-desktop="1" data-items-desktop-small="1" data-items-tablet="1" data-items-mobile="1">
                                            <li class="item">
                                                <div class="grid-item testimonial-grid-item testimonial-carousel-item format-standard">
                                                    <div class="testimonial-outer">
                                                        <div class="testimonial-image">
                                                            <img src="images/img20.jpg" alt="">
                                                        </div>
                                                        <div class="testimonial-inner">
                                                            让天下宠物得到人间关爱”是XX始终不变的企业愿景。对生命的关爱，带来对宠物需求的全新发现和产品开发的独特视角，也是XX追求消费者价值最大化的动力之源。这就是XX步步领先的秘诀所在。
                                                            <div class="spacer-20"></div>
                                                            <hr class="sm">
                                                            <h4>罗莱才</h4>
                                                            <span class="meta-data">店长</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="item">
                                                <div class="grid-item testimonial-grid-item testimonial-carousel-item format-standard">
                                                    <div class="testimonial-outer">
                                                        <div class="testimonial-image">
                                                            <img src="images/img21.jpg" alt="">
                                                        </div>
                                                        <div class="testimonial-inner">
                                                            凭借阵容强大的专家团队、媲美港台的医疗设备、遵循规范、严谨的作业流程，每年为几十万只宠物提供高品质的服务。服务范围涵盖：宠物医疗保健。
                                                            <div class="spacer-20"></div>
                                                            <hr class="sm">
                                                            <h4>李羡慕</h4>
                                                            <span class="meta-data">主治医师</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                            <li class="item">
                                                <div class="grid-item testimonial-grid-item testimonial-carousel-item format-standard">
                                                    <div class="testimonial-outer">
                                                        <div class="testimonial-image">
                                                            <img src="images/img20.jpg" alt="">
                                                        </div>
                                                        <div class="testimonial-inner">
                                                            拥有一批高学历、临床经验丰富的宠物医师，其中硕士35人、博士2人，执业兽医师328人。建有完善的宠物内科、心血管科皮肤科等领域综合实力领跑全国。
                                                            <div class="spacer-20"></div>
                                                            <hr class="sm">
                                                            <h4>千金方</h4>
                                                            <span class="meta-data">VIP会员</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>                                                     
                                        </ul>
                                    </div>
                                </div>
                                <!-- end carousel -->
                            </div>
                        </div>
                    </div>
                    <!-- end row -->
                </div>
                <!-- end container -->
            </div>
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
  