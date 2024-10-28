<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>宠物养护网站后台</title>
    <link rel="icon" href="static/favicon.ico">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/admin/css/login.css">
    <script src="static/js/vue.min.js"></script>
  
    <script src="static/bootstrap/js/bootstrap.bundle.js"></script>
</head>
<body>
<div class="login" style="height:600px;">
    <form action="UserServlet?action=registe" method="post" >
        <h2>用户注册</h2>
        <div class="form-group">
            <label>用户名：</label>
            <input type="text" name="username" id="username" value="${username }" class="form-control form-control-lg">
        </div>
       <span style="color:red;" id="msg">${msg}</span>
        <div class="form-group">
            <label>密码：</label>
            <input type="password" name="pwd" id="pwd" class="form-control form-control-lg" id="pwd">
        </div>
          <span style="color:red;" id="msg1"></span>
           <div class="form-group">
                            <label>性别：</label>
                          <select name="sex" class="form-control  form-control-lg">
                   
                                <option value="男" <c:if test="${user.sex=='男' }">selected</c:if>>男</option>  
                                 
                                <option value="女" <c:if test="${user.sex=='女' }">selected</c:if>>女</option>                                    
                            </select>
                           
                   </div> 
          <div class="form-group">
            <label>昵称：</label>
            <input type="text" name="nickname" id="nickname" class="form-control form-control-lg">
        </div>
       <span style="color:red;" id="msg2"></span>
      

        <button type="submit" id="login" class="btn btn-primary btn-lg  btn-block">
    
            立即注册
        </button>
          <button type="button" onclick="location.href='LoginServlet?action=loginOut'" class="btn btn-info btn-lg  btn-block">
    
            返回登录
        </button>
        
    </form>
</div>

<p style="position: fixed;bottom: 0;text-align: center; width: 100%;">
    
</p>
<script src="static/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#login").click( function() {
	    var username = $("#username").val().trim(); // trim()去除空格
	    var pwd = $("#pwd").val().trim();
	    var nickname = $("#nickname").val().trim();
	    if(!username) {
	        $("#msg").html("用户名不能为空！");
	         $("#username").focus(); 
	        return false;
	    } 
     
	     if(!pwd) {
	            $("#msg1").html("密码不能为空！");
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
