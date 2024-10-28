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
            <h5>编辑用户联系信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="RelationServlet?action=update"    method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                          <input type="hidden" name="id" value="${relation.id }" />
                            
                <div class="form-group">
                            <label>客户名称：</label>
                            <input type="text" name="name" id="name" value="${relation.name }" placeholder="请输入客户名称" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div> 
                   <div class="form-group">
                            <label>邮&emsp;箱：</label>
                            <input type="text" name="email" id="email" value="${relation.email }" placeholder="请输入邮箱" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                  </div>  
                  
                       <div class="form-group">
                            <label>联系方式：</label>
                            <input type="text" name="phone" id="phone" value="${relation.phone }" placeholder="请输入联系方式" class="form-control">                          
                            <small  id="msg2" style="color:red"></small>
                  </div>            
                   
                        
                        <div class="form-group">
                            <label>其他要求：</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control">${relation.note}</textarea>
                       
                        </div>
                        
         

                      
        <div class="submit-box">
            <button type="submit" id="update" class="btn btn-primary">确定提交</button>
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
	$("#update").click( function() {
		 var name = $("#name").val();
		 var email = $("#email").val();
		 var phone = $("#phone").val();
		 if(!name) {
	            $("#msg").html("客户名称不允许为空");
	            $("#name").focus(); // 聚焦
	            return false;
	        }
		 if(!email) {
	            $("#msg").html("邮箱不允许为空");
	            $("#email").focus(); // 聚焦
	            return false;
	        }
		 if(!phone) {
	            $("#msg").html("联系方式不允许为空");
	            $("#phone").focus(); // 聚焦
	            return false;
	        }
		      
		   
		 
	});
	
	

  
})


</script>
</body>

</html>
