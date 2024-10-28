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
				<img src="images/ban6.jpg" />
			</div>
			<!-- 萌宠资讯-->
			<div class="main" role="main">
				<div id="content" class="content full">
					<div class="container padding-tb60">
						<div class="col-md-9 met-shownews-body">
							<div class="row">
								<div class="met-shownews-header">
									<h2>${news.title }</h2>
									<div class="info">
										<span><i style="padding-right: 10px;" class="fa fa-calendar"></i>${news.fbsj }</span>
										<span><i style="padding-right: 10px;" class="fa fa-pencil"></i>${news.editor }</span>
									</div>
								</div>
								<div class="met-editor lazyload ">
									<div class="words">
										<p>
										${news.content }
										</p>
									</div>
									<div class="center-block met_tools_code"></div>
								</div>
						<!-- 		<div class="met-shownews-footer">

									<ul class="pager pager-round">
										<li class="previous ">
											<a href="blog - show.html" >
												上一篇
												<span aria-hidden="true" class='hidden-xs'>：幼犬为什么容易得犬瘟和细小</span>
											</a>
										</li>
										<li class="next ">
											<a href="blog - show.html">
												下一篇
												<span aria-hidden="true" class='hidden-xs'>：如何通过牙齿推断猫咪的年龄</span>
											</a>
										</li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!-- end container -->
				</div>
			</div>
			<!-- 尾部 -->
      <jsp:include page="/WEB-INF/common/footer.jsp"/>
			<a id="back-to-top"><i class="fa fa-arrow-up"></i></a>
		</div>
		<script src="js/jquery-2.2.3.min.js"></script>
		<!-- Jquery Library Call -->
		<script src="vendor/magnific/jquery.magnific-popup.min.js"></script>
		<!-- Maginific Popup Plugin -->
		<script src="js/ui-plugins.js"></script>
		<!-- UI Plugins -->
		<script src="js/helper-plugins.js"></script>
		<!-- Helper Plugins -->
		<script src="vendor/owl-carousel/js/owl.carousel.min.js"></script>
		<!-- Owl Carousel -->
		<script src="js/bootstrap.js"></script>
		<!-- UI -->
		<script src="js/init.js"></script>
		<!-- All Scripts -->
		<script src="vendor/flexslider/js/jquery.flexslider.js"></script>
		<!-- FlexSlider -->
		<!--<script src="js/jquery.mb.YTPlayer.js"></script>-->
	</body>

</html>
 