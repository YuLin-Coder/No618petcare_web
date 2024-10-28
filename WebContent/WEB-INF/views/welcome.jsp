<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



 <jsp:include page="/WEB-INF/common/form_header.jsp"/>

<body>

<script>
console.log(config);
$(function() {
    $('#version').html(config.version);
});

</script>
<style>

    .main {
        overflow-y: auto;
    }

    .info .card {
        min-height: 330px;
    }

    .user .card {
        min-height: 500px;
    }

    .card h5 {
        margin-bottom: 20px;
    }

    .main ul li {
        margin-bottom: 3px;
    }
</style>
<main>
    <div class="main pt-5 pb-5">

        <div class="jumbotron bg-white pt-1 pb-1 mb-0">
            <h1 class="display-4">欢迎来到宠物养护网站</h1>
           <p class="lead">基于JSP+Servlet开发的宠物养护网站</p>
        </div>

        <hr class="my-4">
        <div class="info">
            <div class="row">


                <div class="col-4">


                    <div class="card">
                        <div class="card-body">
                            <h5>项目说明</h5>
                            <ul>
                                <li>宠物养护网站目的是为宣传宠物的相关信息，呼吁人们爱护动物，分为前台网站和后台管理，后台可以发布一些内容、比如
                            重要的功能模块有轮播图管理、宠物种类管理、宠物信息管理、萌宠资讯管理、用户联系管理、宠物用品管理等功能模块，实现了前端和后台的交互功能</li>
                              
                            </ul>
                        </div>
                    </div>


                </div>
                <div class="col-4">

                    <div class="card">
                        <div class="card-body">
                            <h5>开发环境和技术介绍</h5>
                            <ul>
                                <li>开发环境：JDK1.8、windows10/11</li>
                                <li>开发工具：Eclipse、Naicat12</li>
                                 <li>数&nbsp;据&nbsp;库：MySQL5.7</li>
                                  <li>服&nbsp;务&nbsp;器：Tomcat9.0</li>
                                 <li>前端技术：BootStrap、HTML、CSS、JS、JQuery</li>
                                 <li>后端技术：JSP、Servlet</li>
                                  <li>开发语言：Java</li>                             
                                <li>当前版本：V2.0</li>
                                <li>开发作者：逍遥游制作</li>
                               
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-4">

                    <div class="card">
                        <div class="card-body">
                            <h5> 项目说明书</h5>
                            <ul>
                                <li>项目前台访问路径：http://localhost:8080/petcare_web/</li>
                                <li>开发周期：一个月</li>
                            
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>


     

    </div>

</main>


<script src="static/admin/js/update.js" ></script>
</body>

</html>
