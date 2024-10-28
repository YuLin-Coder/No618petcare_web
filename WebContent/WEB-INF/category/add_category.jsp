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
            <h5>新增宠物种类</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="CategoryServlet?action=add"    method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                            
                <div class="form-group">
                            <label>种类名称：</label>
                            <input type="text" name="cname" id="cname" value="" placeholder="比如犬类" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div>         
                   
                        
                        <div class="form-group">
                            <label>种类说明：</label>
                              <textarea type="text" name="note" id="note" rows="5" class="form-control"></textarea>                 
                            <small  id="msg1" style="color:red"></small>
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
		 var cname = $("#cname").val();
		
		 if(!cname) {
	            $("#msg").html("宠物种类名称不允许为空");
	            $("#cname").focus(); // 聚焦
	            return false;
	        }
		   
		   
		 
	});
	
	

  
})


</script>
</body>

</html>
