<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     　　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>

 <jsp:include page="/WEB-INF/common/form_header.jsp"/>
<body>
<style>
th,tr,td{    border: 1px solid #ced4da;}
</style>

<main>
    <div class="main">
        <div class="search">
            <form class="form-inline float-left" action="PetServlet?action=findByMap" method="post">
                <div class="form-group">
                    <input type="text" name="name" value="" class="form-control" placeholder="根据宠物名称查询">
                </div>
              
                
                <button type="submit" class="btn btn-primary"><i class="iconfont"></i>搜索</button>
            </form>

   
            <a class="btn btn-primary float-right" href="PetServlet?action=toAddPet"><i class="iconfont"></i>添加宠物信息</a>
   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">宠物名称</th>
                      <th scope="col">宠物种类</th>
                       <th scope="col">图片</th>
                     <th scope="col">特征</th>
                    <th scope="col">简介</th>
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${petList }" var="p">
			                <tr>
			               
			                     <td>${p.name}</td>
			                    <td>${p.category.cname}</td>
			                    <td><img src="upload/${p.photo}" style="width:100px;height:60px;"/></td>
			                    <td>${p.characters}</td>
			                 <td style=" 
             font-size:12px;">${p.detail}</td>     
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="PetServlet?action=query&id=${p.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del(this,'${p.id }')" href="javascript:;">删除</a>
			                   
			                    </td>
			                  
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
                   <div class="page">
            <span class="total float-left page-link">共${tp }条</span>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=1">&lt;&lt;</a></li>
                             
                 <c:if test="${cp>1}">
                  <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=${cp-1}">上一页</a></li>
                            
                        </c:if>
                        <%--        循环显示页码--%>
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                            <%--            判断是否是当前页--%>
                            <c:if test="${cp==e}">
                            <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=${e}">${e}</a></li>
                              
                            </c:if>
                            <c:if test="${cp!=e}">
                        <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=${e}">${e}</a></li>
                                                        
                            </c:if>

                        </c:forEach>

                        <%--        判断是否有下一页--%>
                        <c:if test="${cp<tp}">
                         <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=${cp+1}">下一页</a></li>                        
                        </c:if>
             
                <li class="page-item"><a class="page-link" href="PetServlet?action=list&p=${tp}">&gt;&gt;</a></li>
            </ul>
        </div>
        </div>

 
    </div>
</main>





<script type="text/javascript">
function del(obj,id){
	 //用户安全提示
    if(confirm("您确定要删除该条记录吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/PetServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
