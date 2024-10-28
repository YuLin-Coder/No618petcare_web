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
            <h5>编辑用户信息信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="UserServlet?action=update"    method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                          <input type="hidden" name="id" value="${user.id }" />
                            
                <div class="form-group">
                            <label>用户名：</label>
                            <input type="text" name="username" id="username" value="${user.username }" placeholder="昵称" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div>         
                  <div class="form-group">
                            <label>密码：</label>
                            <input type="password" name="pwd" id="pwd" value="${user.pwd }" placeholder="密码" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                  </div>         
                      <div class="form-group">
                            <label>性别</label>
                          <select name="sex" class="form-control">
                   
                                <option value="男" <c:if test="${user.sex=='男' }">selected</c:if>>男</option>  
                                 
                                <option value="女" <c:if test="${user.sex=='女' }">selected</c:if>>女</option>                                    
                            </select>
                           
                   </div> 
                       <div class="form-group">
                            <label>昵称：</label>
                            <input type="text" name="nickname" id="nickname" value="${user.nickname }" placeholder="昵称" class="form-control">                          
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
		 var pwd = $("#pwd").val();
		 var nickname = $("#nickname").val();
		 if(!username) {
	            $("#msg").html("用户名不允许为空");
	            $("#username").focus(); // 聚焦
	            return false;
	        }
		 if(!pwd) {
	            $("#msg1").html("密码不允许为空");
	            $("#pwd").focus(); // 聚焦
	            return false;
	        }
		 if(!nickname) {
	            $("#msg2").html("昵称不允许为空");
	            $("#nickname").focus(); // 聚焦
	            return false;
	        }
		   
		   
		 
	});
	
	

  
})


</script>
</body>

</html>
