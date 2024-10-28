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
                     <a class="btn btn-success float-right" href="ProductServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
  
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">宠物用品名称</th>
                      <th scope="col">图片</th>
                       <th scope="col">价格</th>
                   
                 <th scope="col">库存</th>
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="p">
			                <tr>
			               
			                     <td>${p.name}</td>
			                     <td><img src="upload/${p.photo}" style="width:100px;height:80px;"/></td>
			                    <td>${p.price}</td>
			                              <td>${p.stock}</td>
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="ProductServlet?action=query&id=${p.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del(this,'${p.id }')" href="javascript:;">删除</a>
			                   
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
        location.href="${pageContext.request.contextPath}/ProductServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
