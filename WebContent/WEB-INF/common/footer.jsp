<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
 <footer class="footer">
    	<div class="site-footer">
        	<div class="container">
                <div class="row">
                    <!-- 关于-->
                    <div class="col-md-3 bot footer_widget">
                        <h5>关于我们</h5>
                        <div class="footer-logo margin-20">
                            <a href="IndexServlet?action=toIndex" title="Obsequy">宠物用品养护网站</a>
                        </div>
                        <p>让天下宠物得到人间关爱<br>是XX始终不变的企业愿景<br>这就是XX步步领先的秘诀所在</p>
                    </div>
                    <!-- 服务 -->
                    <div class="col-md-3 bot footer_widget">
                        <h5>我们的服务</h5>
                        <div class="menu-services">
                            <ul>
                                <li><a href="IndexServlet?action=tokinds" title="Burial Services">宠物品种</a></li>
                                <li><a href="IndexServlet?action=toNews" title="Catering Services">萌宠资讯</a></li>
                                <li><a href="IndexServlet?action=toProduct" title="Celebrating a Life">宠物用品</a></li>
                                    <li><a href="MessagesServlet?action=toAddMessages" title="Celebrating a Life">用户留言</a></li>
                                <li><a href="IndexServlet?action=toContact" title="Funeral Services">联系我们</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- 品种 -->
                    <div class="col-md-3 bot footer_widget">
                        <h5>萌宠品种</h5>
                        <div class="recent-post">
                            <ul>
                            <c:forEach items="${categoryList }" var="c">
                                <li>
                                   <!--  <div class="recent-post-imgb">
                                        <a href="kinds.html" title="recent post"><img src="images/kinds (2).jpg" ></a>
                                    </div> -->
                                    <div class="recent-post-txtb">
                                        <h6><a href="IndexServlet?action=tokinds" title="Why you should plan ahead">${c.cname }</a></h6>
<!--                                         <span>聪明敏捷  开朗不常吠</span>
 -->                                    </div>
                                </li>
                                </c:forEach>
                             
                            </ul>
                        </div>
                        <div class="spacer-30"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部 -->
    	<div class="site-footer-bottom">
        	<div class="container">
            	<div class="row">
                	<div class="col-md-6 col-sm-6">
                    	<p>XXX. XXX.</p>
                    </div>
                	<div class="col-md-6 col-sm-6">
                    	<div class="social-icons-colored pull-right">
                        	<ul>
                            	<li class="facebook"><a href="#" title="facebook"><i class="fa fa-facebook"></i></a></li>
                            	<li class="twitter"><a href="#" title="twitter"><i class="fa fa-twitter"></i></a></li>
                            	<li class="youtube"><a href="#" title="youtube"><i class="fa fa-youtube"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>