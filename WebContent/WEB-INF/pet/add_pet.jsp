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
            <h5>新增宠物信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="PetServlet?action=add"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                            
                <div class="form-group">
                            <label>宠物名称：</label>
                            <input type="text" name="name" id="name" value="" placeholder="比如拉布拉多" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div>        
                  
                  
                    <div class="form-group">
                            <label>宠物种类</label>
                          <select name="c_id" class="form-control">
                   <c:forEach items="${ categoryList}" var="c">
                                <option value="${c.id }" selected>${c.cname }</option>  
                 </c:forEach>                                                         
                            </select>
                           
                   </div> 
                   <div class="form-group">
                            <label>预览：</label>
                             <img src="images/upload.png" id="preview_img" width="80px" height="120px" alt="">
                    </div>  
                     <div class="form-group">
                     <label>上传宠物图片：</label>
                           <div class="field">
						<input type="file" id="photo" name="resPath"
							 class="uploadBtn"  accept=".jpg,.png,.gif" /><br> 
							 <small  id="msg1" style="color:red"></small>
					</div>
                        </div>
                        
                           <div class="form-group">
                            <label>宠物特征：</label>
                           <textarea type="text" name="characters" id="characters" rows="5" class="form-control"></textarea>                 
                        
                            <small  id="msg2" style="color:red"></small>
                        </div>
                        
                        <div class="form-group">
                            <label>宠物简介：</label>
                                <textarea type="text" name="detail" id="detail" rows="5" class="form-control"></textarea>                           
                            <small  id="msg3" style="color:red"></small>
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
		 var name = $("#name").val();
		 var photo = $("#photo").val();
		 var characters = $("#characters").val();
		 var detail = $("#detail").val();
		 if(!name) {
	            $("#msg").html("请上传宠物名称");
	            $("#name").focus(); // 聚焦
	            return false;
	        }
		   if(!photo) {
	            $("#msg1").html("请上传宠物图片");
	            $("#photo").focus(); // 聚焦
	            return false;
	        }
		 
		    if(!characters) {
	            $("#msg2").html("请输入宠物特征！");
	            $("#characters").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!detail) {
	            $("#msg2").html("请输入宠物简介！");
	            $("#detail").focus(); // 聚焦
	            return false;
	        }
		  
		   
		 
	});
	
	
	 $("#photo").change(function () {
		    //创建blob对象，浏览器将文件放入内存中，并生成标识
		    var img_src = URL.createObjectURL($(this)[0].files[0]);
		    //给img标检的src赋值
		    document.getElementById("preview_img").src=img_src;
		    //URL.revokeObjectURL(img_src);// 手动 回收，
		});
	 
  
})


</script>
</body>

</html>
