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
       
           <a class="btn btn-success float-right" href="MessagesServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>

   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                   <th scope="col">留言内容</th>
                  
                       <th scope="col">留言人</th>
                   
                
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${messagesList }" var="m">
			                <tr>		               
			                     <td>${m.content}</td>
			                  
			                    <td>${m.user.nickname}</td>
			                            
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="MessagesServlet?action=query&id=${m.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del(this,'${m.id }')" href="javascript:;">删除</a>
			                   
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
        location.href="${pageContext.request.contextPath}/MessagesServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
