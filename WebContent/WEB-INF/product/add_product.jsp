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
            <h5>新增宠物用品</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="ProductServlet?action=add"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                            
                <div class="form-group">
                            <label>名称：</label>
                            <input type="text" name="name" id="name" value="" placeholder="比如狗食盆子" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div>         
                   <div class="form-group">
                            <label>预览：</label>
                             <img src="images/upload.png" id="preview_img" width="90px" height="100px" alt="">
                    </div>  
                     <div class="form-group">
                     <label>上传图片：</label>
                           <div class="field">
						<input type="file" id="photo" name="resPath"
							 class="uploadBtn"  accept=".jpg,.png,.gif" /><br> 
							 <small  id="msg1" style="color:red"></small>
					</div>
                        </div>
                        
                        <div class="form-group">
                            <label>价格：</label>
                            <input type="text" name="price" id="price" value="" placeholder="比如20" class="form-control">                          
                            <small  id="msg2" style="color:red"></small>
                        </div>
                        
                        
                          <div class="form-group">
                            <label>库存：</label>
                            <input type="number" name="stock" id="stock" value="100" placeholder="100" class="form-control">                          
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
		 var stock = $("#stock").val(); 
		 var price = $("#price").val();
		 if(!name) {
	            $("#msg").html("请上传宠物用品名称");
	            $("#name").focus(); // 聚焦
	            return false;
	        }
		   if(!photo) {
	            $("#msg1").html("请上传宠物用品图片");
	            $("#photo").focus(); // 聚焦
	            return false;
	        }
		 
		    if(!price) {
	            $("#msg2").html("请输入宠物用品价格！");
	            $("#price").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!stock) {
	            $("#msg2").html("请输入宠物用品库存！");
	            $("#stock").focus(); // 聚焦
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
