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
     
   
             <a class="btn btn-success float-right" href="UserServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
           
   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">用户名</th>
                  
                       <th scope="col">用户密码</th>
                    <th scope="col">性别</th>
                           <th scope="col">昵称</th>
                            <th scope="col">注册时间</th>
                
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="u">
			                <tr>		               
			                     <td>${u.username}</td>    
			                    <td>${u.pwd}</td>
			                      <td>${u.sex}</td>
			                    <td>${u.nickname}</td>
			                       <td>${u.registeTime}</td>
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="UserServlet?action=query&id=${u.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del(this,'${u.id }')" href="javascript:;">删除</a>
			                   
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
        location.href="${pageContext.request.contextPath}/UserServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
