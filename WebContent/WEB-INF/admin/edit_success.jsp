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


<main>
    <div class="main">

        

        <h1>修改成功！</h1>
 			<a class="btn btn-info btn-sm" href="AdminServlet?action=query&id=${admin.id }">返回查看</a>


    </div>
</main>




<script>
$(function(){
	$("#update").click( function() {
		 var username = $("#username").val();
		 var password = $("#password").val();
		 var nickname = $("#nickname").val();
		 if(!username) {
	            $("#msg").html("用户名不允许为空");
	            $("#name").focus(); // 聚焦
	            return false;
	        }
		 if(!password) {
	            $("#msg").html("密码不允许为空");
	            $("#password").focus(); // 聚焦
	            return false;
	        }
		 if(!nickname) {
	            $("#msg").html("昵称不允许为空");
	            $("#nickname").focus(); // 聚焦
	            return false;
	        }
		      
		   
		 
	});
	
	

  
})


</script>
</body>

</html>
