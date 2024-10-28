<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>宠物养护网站后台</title>
    <link rel="icon" href="./static/favicon.ico">
    <link rel="stylesheet" href="./static/bootstrap/css/bootstrap.min.css" >
    <link rel="stylesheet" href="./static/admin/css/index.css" >
    <script src="./static/js/vue.min.js"></script>
    <script src="./static/js/jquery-3.3.1.min.js" ></script>
    <script src="./static/bootstrap/js/bootstrap.bundle.js" ></script>
    <script src="./static/admin/js/script.js" ></script>
</head>
<body>

<div id="app" class="d-flex">

    <nav>
        <div class="logo">
            <h4>宠物养护网站后台</h4>
        </div>
        <ul class="menu">
         
       
             <li><a href="IndexServlet?action=welcome" target="main"><i class="iconfont mr-1">&#xe6a2;</i>首页</a> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>轮播图管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="BannerServlet?action=list" target="main">轮播图列表</a></li><li><a href="BannerServlet?action=toAddBanner" target="main">添加轮播图</a></li></ul> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>用户管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="UserServlet?action=list" target="main">用户列表</a></li></ul> </li> 
             
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>宠物种类管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="CategoryServlet?action=list" target="main">宠物种类列表</a></li><li><a href="CategoryServlet?action=toAddCategory" target="main">添加宠物种类</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>宠物信息管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="PetServlet?action=list" target="main">宠物信息列表</a></li><li><a href="PetServlet?action=toAddPet" target="main">添加宠物信息</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>宠物用品管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="ProductServlet?action=list" target="main">宠物用品列表</a></li><li><a href="ProductServlet?action=toAddProduct" target="main">添加宠物用品</a></li></ul> </li>
            <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>订单管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="OrdersServlet?action=list" target="main">订单列表</a></li></ul> </li>
             
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>萌宠资讯管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="NewsServlet?action=list" target="main">萌宠资讯列表</a></li><li><a href="NewsServlet?action=toAddNews" target="main">发布萌宠资讯</a></li></ul> </li>
<!--            <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>联系方式管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="RelationServlet?action=list" target="main">联系方式列表</a></li></ul> </li>
 -->             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>留言管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="MessagesServlet?action=list" target="main">留言列表</a></li><li></ul> </li> 
             
  
              <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6d4;</i>个人信息管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="AdminServlet?action=findMyInfo&id=${admin.id }" target="main">修改个人信息</a></li></ul> </li>
 	
 <li><a href="LoginServlet?action=loginOut"><i class="iconfont mr-1">&#xe68c;</i>退出登录</a> </li> 
        </ul>
    </nav>

    <main>
        <header>
            <a href="IndexServlet?action=toIndex" target="_blank">网站首页</a>



            <div class="dropdown float-right">


                <button class="btn  btn-sm  dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             
                  
                  
          
             	欢迎管理员：${admin.nickname }
            
                  
                </button>
  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
           
                    <a class="dropdown-item" href="LoginServlet?action=loginOut">退出登录</a>
                </div>

              
            </div>


           


        </header>

        <iframe src="IndexServlet?action=welcome" name="main"></iframe>
    </main>
</div>

</body>
</html>



