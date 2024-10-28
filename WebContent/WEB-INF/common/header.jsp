<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE HTML>
<html class="no-js" lang="en-US">
<head>
<!-- Basic Page Needs
  ================================================== -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS
  ================================================== -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"><!-- Bootstrap -->
<link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"><!-- Bootstrap Theme -->
<link href="css/style.css" rel="stylesheet" type="text/css"><!-- Style Css -->
<link href="vendor/magnific/magnific-popup.css" rel="stylesheet" type="text/css"><!-- Magnific Popup -->
<link href="vendor/owl-carousel/css/owl.carousel.css" rel="stylesheet" type="text/css"><!-- Owl Carousel -->
<link href="vendor/owl-carousel/css/owl.theme.css" rel="stylesheet" type="text/css"><!-- Owl Carousel Theme -->
<!-- Color Style -->
<link href="colors/color1.css" rel="stylesheet" type="text/css">
<link href="css/custom.css" rel="stylesheet" type="text/css"><!-- CUSTOM STYLESHEET FOR STYLING -->
<!-- SCRIPTS
  ================================================== -->
<script src="js/modernizr.js"></script><!-- Modernizr -->
</head>
<body class="home">
<div class="body">
	<!-- 头部 -->
    <header class="topbar">
    	<!-- 顶部 -->
        <div class="container">
            <div class="header-info-col">
                <i class="fa fa-phone"></i>
                <strong>0512-57995109 </strong>
            </div>
            <div class="header-info-col">
                <i class="fa fa-envelope-o"></i>
                <strong><a href="Cindy@kindjob.cn" >Cindy@kindjob.cn</a></strong>
            </div>
            <div class="header-info-col">
                <i class="fa fa-map-marker"></i>
                <strong>地址：北京市中关村宠物乐园</strong>
            </div>
             <div class="header-info-col">
                <c:if test="${empty user }">
                <strong><a href="IndexServlet?action=toLogin">登录</a></strong>&emsp;
                <strong><a href="UserServlet?action=toRegiste">注册</a></strong>
                </c:if>
                 <c:if test="${not empty user }">
                <strong>欢迎用户：${user.nickname }登录本网站！</strong>
               <strong><a href="IndexServlet?action=toPersonInfo">个人中心</a></strong>
               <strong><a href="LoginServlet?action=loginOut">退出登录</a></strong>
                </c:if>
            </div>
        </div>
    </header>
	<!-- 导航栏 -->
    <header class="site-header-wrapper">
        <div class="site-header">
            <div class="container">
                <div class="site-logo">
                    <!-- <a href="index.html" title="Obsequy" class="default-logo"></a> -->
                    <h3>宠物养护网站</h3>
                </div>
                <a href="#" id="menu-toggle">
                    <i class="fa fa-bars"></i>
                </a>
                <nav class="main-navigation pull-right">
							<ul class="dd-menu sf-menu">
								<li class="active">
									<a href="IndexServlet?action=toIndex" title="首页"><span>首页</span></a>
								</li>
								<li>
									<a href="IndexServlet?action=tokinds" title="宠物信息"><span>宠物信息</span></a>
								</li>
								<li>
									<a href="IndexServlet?action=toProduct" title="宠物用品"><span>宠物用品</span></a>
								</li>
								<li>
									<a href="IndexServlet?action=toNews" title="萌宠资讯"><span>萌宠资讯</span></a>
								</li>
								
								<li>
									<a href="MessagesServlet?action=toAddMessages" title="用户留言"><span>用户留言</span></a>
								</li>
								<li>
									<a href="IndexServlet?action=toAbout" title="关于我们"><span>关于我们</span></a>
								</li>
								<li>
									<a href="IndexServlet?action=toContact" title="联系我们"><span>联系我们</span> <img src="images/flower-e1476975452944.png" alt=""></a>
								</li>
							</ul>
						</nav>
            </div>
        </div>
    </header>