<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

 <jsp:include page="/WEB-INF/common/header.jsp"/>
    <!-- 幻灯片-->
    <div class="hero-slider heroflex flexslider" data-autoplay="yes" data-pagination="no" data-arrows="yes" data-style="slide">
    	<ul class="slides">
    	<c:forEach items="${bannerList }" var="b">
            <li style="background-image:url(upload/${b.photo});">
            </li>
            <!-- <li style="background-image:url(images/bg_slide3.jpg);">
            </li> -->
            </c:forEach>
        </ul>
    </div>
    <div class="secondary-bg cta">
        <div class="container">
            <a href="IndexServlet?action=toContact"  class="btn btn-default btn-transparent btn-rounded pull-right">联系我们</a>
            <h3 class="white-text margin-0">我们的宠物服务更涵盖了宠物的衣食住行医疗等方面。</h3>
        </div>
    </div>
	<!--主体 -->
  	<div class="main" role="main">
        <!-- 服务 -->
    	<div id="content" class="content full">
            <div class="container">
                <div class="row">
            		<div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2><span>——</span>我们的服务<span>——</span></h2>
                        <p>美好的陪伴来自温暖的生命</p>
                    </div>
                    <img src="images/gou.png" alt="">
            		<div class="spacer-50"></div>
                </div>
            </div>
            <!-- 萌宠品种 -->
            <div class="parallax parallax1 padding-tb75" style="background:url(images/b1.jpg);">
                <div class="container">
                    <div class="row no-gutters secondary-bg">
                        <div class="col-md-3">
                            <div class="padding-all27">
                                <p class="white-text">
                                动物是人类的朋友。在这里，每一个热爱宠物的人<br>不但能找到他们想要的，而且能得到比他们想要的更多。</p>
                                <a href="IndexServlet?action=tokinds" title="" class="btn-all">所有品种 <i class="vc_btn3-icon fa fa-chevron-right"></i> </a>
                            </div>
                        </div>
                        <div class="col-md-9 bg-white">
                            <div class="carousel-area">
                            	<div class="carousel-wrapper-outer">
                                    <h2>萌宠展示</h2>
                                    <!-- 萌宠展示 -->
                                    <div class="carousel-wrapper">
                                        <div class="row">
                                            <ul class="owl-carousel carousel-fw" data-columns="3" data-autoplay="" data-pagination="no" data-arrows="yes" data-single-item="no" data-items-desktop="3" data-items-desktop-small="3" data-items-tablet="2" data-items-mobile="1">
                                                <c:forEach items="${petList }" var="p">
                                                <li class="item">
                                                    <div class="grid-item obituary-grid-item obituary-carousel-item format-standard">
                                                        <a href="IndexServlet?action=tokinds" class="media-block"><img src="upload/${p.photo }" alt=""></a>
                                                        <div class="grid-item-content">
                                                            <h3>${p.name }</h3>
                                                            <hr class="sm">
                                                            <span class="meta-data">${p.characters} </span>
                                                        </div>
                                                    </div>
                                                </li>
                                                </c:forEach>
                                                <!-- <li class="item">
                                                    <div class="grid-item obituary-grid-item obituary-carousel-item format-standard">
                                                        <a href="kinds.html" class="media-block"><img src="images/img5-350x500.jpg" alt=""></a>
                                                        <div class="grid-item-content">
                                                            <h3>金毛犬 </h3>
                                                            <hr class="sm">
                                                            <span class="meta-data">热情友善  自信且不怕生</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="item">
                                                    <div class="grid-item obituary-grid-item obituary-carousel-item format-standard">
                                                        <a href="kinds.html" class="media-block"><img src="images/depositphotos_125040540_original-350x500.jpg" alt=""></a>
                                                        <div class="grid-item-content">
                                                            <h3>萨摩耶 </h3>
                                                            <hr class="sm">
                                                            <span class="meta-data">乖巧可爱  微笑天使</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="item">
                                                    <div class="grid-item obituary-grid-item obituary-carousel-item format-standard">
                                                        <a href="kinds.html" class="media-block"><img src="images/Depositphotos_6699049_original-350x500.jpg" alt=""></a>
                                                        <div class="grid-item-content">
                                                            <h3>布偶猫</h3>
                                                            <hr class="sm">
                                                            <span class="meta-data">温顺好静  对人友善</span>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="item">
                                                    <div class="grid-item obituary-grid-item obituary-carousel-item format-standard">
                                                        <a href="kinds.html" class="media-block"><img src="images/Depositphotos_67927599_original-350x500.jpg" alt=""></a>
                                                        <div class="grid-item-content">
                                                            <h3>短毛猫</h3>
                                                            <hr class="sm">
                                                            <span class="meta-data">生性聪明  性格温顺</span>
                                                        </div>
                                                    </div>
                                                </li> -->
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 我们的保障 -->
            <div class="container">
                <div class="spacer-70"></div>
                <div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2><span>——</span>我们的保障<span>——</span></h2>
                    </div>
                <div class="spacer-35"></div>
                <div class="row">
                    <div class="col-md-6 col-sm-4">
                        <div class="icon-box ibox-center ibox-secondary ibox-outline ibox-effect ibox-plain">
                            <div class="ibox-icon">
                                <i class="fa fa-microphone"></i>
                            </div>
                            <h3>设备先进</h3>
                            <p>设施完备，设备先进，为他们提供了最大化的日常生活便利。</p>
                        </div>
                    </div>
                   <!--  <div class="col-md-4 col-sm-4">
                        <div class="icon-box ibox-center ibox-secondary ibox-outline ibox-effect ibox-plain">
                            <div class="ibox-icon">
                                <i class="fa fa-gavel"></i>
                            </div>
                            <h3>专业团队</h3>
                            <p>拥有多位教学经验丰富的A级宠物美容老师和注册宠物兽医师任教</p>
                        </div>
                    </div> -->
                    <div class="col-md-6 col-sm-4">
                        <div class="icon-box ibox-center ibox-secondary ibox-outline ibox-effect ibox-plain">
                            <div class="ibox-icon">
                                <i class="fa fa-anchor"></i>
                            </div>
                            <h3>优质宠物用品</h3>
                            <p>涉及囊括了、洗护用品、用品用具、窝包服饰、宠物玩具、美容工具等 </p>
                        </div>
                    </div>
                </div>
                <div class="spacer-35"></div>
            </div>
            <!--  宠物之恋 -->
            <div class="banner parallax parallax2" style="background-image:url(images/b2.jpg);">
            	<div class="accent-overlay"></div>
            	<div class="banner-caption text-align-center">

                    <div class="container">
                       	<h2 style="font-weight: 100;">宠物之恋，在于关爱，让你的爱宠享受家的感觉</h2>
                    </div>
                </div>
            </div>
            <!--  我们的团队 -->
            <div class="gray-bg">
                <div class="container">
                  
                   <!--  <div class="carousel-wrapper" style="margin-top: 70px;">
                       
                    </div> -->
                    <!-- 萌宠资讯-->
                    <div class="spacer-50">
                        <img src="images/zhua.png">
                        <h2><span>——</span>萌宠资讯<span>——</span></h2>
                        <p>从分享你我的养宠心情到爱宠人之间的经验交流</p>
                    </div>
                    <div class="spacer-35"></div>
                    <div class="our-services">
                        <div class="carousel-wrapper padding-tb0">
                            <div class="row">
                                <ul class="owl-carousel carousel-fw" data-columns="2" data-autoplay="5000" data-pagination="yes" data-arrows="no" data-single-item="no" data-items-desktop="2" data-items-desktop-small="2" data-items-tablet="2" data-items-mobile="1">
                                <c:forEach items="${newsList }" var="n">                                   
                                    <li class="item">
                                        <div class="grid-item post-grid-item post-carousel-item format-standard">
                                            <a href="#" class="media-box">
                                               <!--  <img src="images/img17-600x400.jpg" > -->
                                            <img src="upload/${n.photo }" >
                                            </a>
                                            <div class="grid-item-content">
                                                <div class="grid-post-date">
                                                
                                                    <span class="post-date"><fmt:formatDate value="${n.fbsj}" pattern="MM"/></span>
                                                    <span class="post-month">-<fmt:formatDate value="${n.fbsj}" pattern="dd"/></span>
                                                </div>
                                                <div class="grid-item-content-in">
                                                    <h3 class="post-title">
                                                        <a href="blog - show.html">${n.title }</a>
                                                    </h3>
                                                    <a href="NewsServlet?action=detail&id=${n.id }">查看详情</a>
<%--                                                     <p style="text-overflow: ellipsis;white-space:nowrap;overflow:hidden;">${n.content }</p>
 --%>                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    </c:forEach>
                                   <!--  <li class="item">
                                        <div class="grid-item post-grid-item post-carousel-item format-standard">
                                            <a href="blog - show.html" class="media-box">
                                                <img src="images/new.jpg" >
                                            </a>
                                            <div class="grid-item-content">
                                                <div class="grid-post-date">
                                                    <span class="post-date">08</span>
                                                    <span class="post-month">Nov</span>
                                                </div>
                                                <div class="grid-item-content-in">
                                                    <h3 class="post-title">
                                                        <a href="#">如何给猫咪驱虫</a>
                                                    </h3>
                                                    <p>猫咪定期驱虫，是保障猫咪身体健康的一个重要的环节。尤其是刚进家的流浪猫...</p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="grid-item post-grid-item post-carousel-item format-standard">
                                            <a href="blog - show.html" class="media-box">
                                                <img src="images/new1.jpg" >
                                            </a>
                                            <div class="grid-item-content">
                                                <div class="grid-post-date">
                                                    <span class="post-date">08</span>
                                                    <span class="post-month">Nov</span>
                                                </div>
                                                <div class="grid-item-content-in">
                                                    <h3 class="post-title">
                                                        <a href="#">如何通过牙齿推断猫咪的年龄</a>
                                                    </h3>
                                                    <p>猫咪的年龄，主要以犬牙齿的生长情况、齿峰及牙齿的磨损程度、外形、颜色等综合判定...</p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="grid-item post-grid-item post-carousel-item format-standard">
                                            <a href="blog - show.html" class="media-box">
                                                <img src="images/img17-600x400.jpg" >
                                            </a>
                                            <div class="grid-item-content">
                                                <div class="grid-post-date">
                                                    <span class="post-date">08</span>
                                                    <span class="post-month">Nov</span>
                                                </div>
                                                <div class="grid-item-content-in">
                                                    <h3 class="post-title">
                                                        <a href="#">如何通过牙齿推断猫咪的年龄</a>
                                                    </h3>
                                                    <p>猫咪的年龄，主要以犬牙齿的生长情况、齿峰及牙齿的磨损程度、外形、颜色等综合判定...</p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="grid-item post-grid-item post-carousel-item format-standard">
                                            <a href="blog - show.html" class="media-box">
                                                <img src="images/img17-600x400.jpg" >
                                            </a>
                                            <div class="grid-item-content">
                                                <div class="grid-post-date">
                                                    <span class="post-date">08</span>
                                                    <span class="post-month">Nov</span>
                                                </div>
                                                <div class="grid-item-content-in">
                                                    <h3 class="post-title">
                                                        <a href="#">如何通过牙齿推断猫咪的年龄</a>
                                                    </h3>
                                                    <p>猫咪的年龄，主要以犬牙齿的生长情况、齿峰及牙齿的磨损程度、外形、颜色等综合判定...</p>
                                                </div>
                                            </div>
                                        </div>
                                    </li> -->
                                </ul>
                            </div>
                        </div>
                        <div class="spacer-60"></div>
                    </div>
                </div>
            </div>
            <!-- 朋友 -->
            <div class="secondary-bg cta clearfix ">
                <div class="container">
                    <div class="pic">
                        <img src="images/dog.png" alt="">
                    </div>
                    <div class="cont">
                        <h3 class="white-text margin-0">动物是人类的朋友</h3>
                        <p>从分享你我的养宠心情到爱宠人之间的经验交流，从网上购物到在线医疗，宠物生活中涉及的方方面面，都在不断努力将它们做到最好。在这里，每一个热爱宠物的人，不但能找到他们想要的，而且能得到比他们想要的更多。</p>
                        <a href="about.html" title="Shop Flowers Now" class="btn btn-default btn-transparent btn-rounded pull-right">了解更多</a>
                    </div>
                    <div class="friend">
                        <img alt="" src="images/dog2.png">
                        <a href="about.html" title="" class="btn-all">了解更多 <i class="vc_btn3-icon fa fa-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 尾部 -->
    <jsp:include page="/WEB-INF/common/footer.jsp"/>
    <!-- 回到顶部 -->
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
<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights" id="links20210126">
	Collect from <a href="http://www.cssmoban.com/"  title="网站模板">模板之家</a>
	<a href="https://www.chazidian.com/"  title="查字典">查字典</a>
</div>
</body>
</html>
