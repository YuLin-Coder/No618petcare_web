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

        <div class="title-box">
            <h5>编辑我的信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="AdminServlet?action=update"    method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                          <input type="hidden" name="id" value="${admin.id }" />
                            
                <div class="form-group">
                            <label>用户名：</label>
                            <input type="text" name="username" id="username" value="${admin.username }" placeholder="请输入用户名" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div> 
                   <div class="form-group">
                            <label>密&emsp;码：</label>
                            <input type="text" name="pwd" id="pwd" value="${admin.pwd }" placeholder="请输入密码" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                  </div>  
                  
                       <div class="form-group">
                            <label>昵&emsp;称：</label>
                            <input type="text" name="nickname" id="nickname" value="${admin.nickname }" placeholder="请输入昵称" class="form-control">                          
                            <small  id="msg2" style="color:red"></small>
                  </div>            
                   
                       
                        
         

                      
        <div class="submit-box">
            <button type="submit" id="add" class="btn btn-primary">确定提交</button>
            <button type="button" onclick="window.history.back()" class="btn btn-outline-secondary">取消</button>
        </div>

                    </form>
                </div>
            </div>

        </div>


    </div>
</main>




<script>
$(function(){
	$("#add").click( function() {
		 var username = $("#username").val();
		 var password = $("#password").val();
		 var nickname = $("#nickname").val();
		 if(!username) {
	            $("#msg").html("用户名不允许为空");
	            $("#name").focus(); // 聚焦
	            return false;
	        }
		 if(!pwd) {
	            $("#msg").html("密码不允许为空");
	            $("#pwd").focus(); // 聚焦
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
