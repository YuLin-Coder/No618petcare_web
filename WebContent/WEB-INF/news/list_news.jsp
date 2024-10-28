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
                     <a class="btn btn-success float-right" href="NewsServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
   
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
               
                     <th scope="col">标题</th>
                      <th scope="col">封面</th>
                       <th scope="col">内容</th>
                    <th scope="col">编辑者</th>
                  <th scope="col">发布日期</th>
                      <th scope="col">操作</th>
                    
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="n">
			                <tr>
			               
			                     <td>${n.title}</td>
			                     <td><img src="upload/${n.photo}" style="width:150px;height:90px;"/></td>
			                    <td>${n.content}</td>
			                           <td>${n.editor}</td>    
			                            <td>${n.fbsj}</td>    
		                    <td>
		                   
 							<a class="btn btn-info btn-sm" href="NewsServlet?action=query&id=${p.id }">修改</a>
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
        location.href="${pageContext.request.contextPath}/NewsServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
