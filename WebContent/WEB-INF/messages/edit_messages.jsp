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
            <h5>编辑留言信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="MessagesServlet?action=update"    method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                          <input type="hidden" name="id" value="${messages.id }" />
                            
              
                        
                        <div class="form-group">
                            <label>留言内蓉：</label>
                               <textarea type="text" name="content" id="content" rows="5" class="form-control">${messages.content}</textarea>
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
		 var content = $("#content").val();
		
		 if(!content) {
	            $("#msg1").html("留言内容不允许为空");
	            $("#content").focus(); // 聚焦
	            return false;
	        }
		   
		   
		 
	});
	
	

  
})


</script>
</body>

</html>
