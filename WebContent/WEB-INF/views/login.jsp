<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
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
<div class="login">
    <form action="LoginServlet?action=login" method="post">
        <h2>宠物养护网站</h2>
        <div class="form-group">
            <label>用户名</label>
            <input type="text" name="username" id="username" class="form-control form-control-lg">
        </div>
       <span style="color:red;" id="msg">${msg}</span>
        <div class="form-group">
            <label>密码</label>
            <input type="password" name="pwd" id="pwd" class="form-control form-control-lg" id="pwd">
        </div>
          <span style="color:red;" id="msg2"></span>
         
         <div class="form-group form-check">
           <input type="radio" class="form-check-input" name="type" value="1" id="exampleCheck2" checked>
            <label class="form-check-label" for="exampleCheck2">用户</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" class="form-check-input" name="type" value="2" id="exampleCheck1" >
            <label class="form-check-label" for="exampleCheck1">管理员</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
            
        </div> 

        <button type="submit" id="login" class="btn btn-primary btn-lg  btn-block">
    
            立即登录
        </button>
          <button type="button" onclick="location.href='UserServlet?action=toRegiste'" class="btn btn-info btn-lg  btn-block">
    
            去注册
        </button>
        <div class="form-group form-check">
            
            <a class="form-check-label" href="IndexServlet?action=toIndex">返回首页</a>
        </div>
    </form>
</div>

<p style="position: fixed;bottom: 0;text-align: center; width: 100%;">
    <a href="http://www.ymkz.top"></a>
</p>
<script src="static/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#login").click( function() {
	    var username = $("#username").val().trim(); // trim()去除空格
	    var pwd = $("#pwd").val().trim();
	   
	    if(!username) {
	        $("#msg").html("用户名不能为空！");
	       /*  $("#username").focus(); // 聚焦 */
	        return false;
	    } 
        if($("#username").focus()){
        	 $("#msg").html("");
        }; // 聚焦
	  
	     if(!pwd) {
	            $("#msg2").html("密码不能为空！");
	            $("#pwd").focus(); // 聚焦
	            return false;
	   } else {
	            $("#msg2").html("");
	     }
	 
	});
})


</script>

</body>
</html>
