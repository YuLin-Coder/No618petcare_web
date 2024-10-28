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
              <a class="btn btn-success float-right" href="BannerServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
         

   
       
   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">轮播图图片</th>
                      <th scope="col">跳转网址</th>
                       <th scope="col">备注</th>
                   
                   
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="b">
			                <tr>
			               
			                     <td><img src="upload/${b.photo}" style="width:300px;height:140px;"/></td>
			                     <td>${b.url}</td>
			                    <td>${b.note}</td>
			                            
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="BannerServlet?action=query&id=${b.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del_banner(this,'${b.id }')" href="javascript:;">删除</a>
			                   
			                    </td>
			                  
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
         
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
<script type="text/javascript">
function del_banner(obj,id){
	 //用户安全提示
    if(confirm("您确定要删除该条记录吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/BannerServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
