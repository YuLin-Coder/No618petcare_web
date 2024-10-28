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
               <a class="btn btn-success float-right" href="OrdersServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
    
   
           
   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">订单编号</th>
                          <th scope="col">商品名称</th>
                           <th scope="col">商品图片</th>
                       <th scope="col">下单人</th>
                         
                     <th scope="col">总金额</th>
                 <th scope="col">下单时间</th>
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="o">
			                <tr>
			               
			                     <td>${o.orders_no}</td>
			                        <td>${o.product.name}</td>
			                     <td><img src="upload/${o.product.photo}" style="width:100px;height:80px;"/></td>
			                      <td>${o.user.nickname}</td>
			                    <td>${o.product.price}</td>
			                       <td><fmt:formatDate value="${o.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>      
		                    <td>
		                   
 							
			                        <a class="btn btn-danger btn-sm" onClick="del(this,'${o.id }')" href="javascript:;">删除</a>
			                   
			                    </td>
			                  
			                </tr>
			 </c:forEach>                     

                </tbody>
                
            </table>
     
        </div>

 
    </div>
</main>





<script type="text/javascript">
function del(obj,id){
	 //用户安全提示
    if(confirm("您确定要删除该条记录吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/OrdersServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
