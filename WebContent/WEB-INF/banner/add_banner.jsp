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
            <h5>新增轮播图</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="BannerServlet?action=add"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                   <div class="form-group">
                            <label>预览：</label>
                             <img src="images/upload.png" id="preview_img" width="200px" height="70px" alt="">
                    </div>  
                     <div class="form-group">
                     <label>选择轮播图：</label>
                           <div class="field">
						<input type="file" id="photo" name="resPath"
							 class="uploadBtn"  accept=".jpg,.png,.gif" /><br> 
							 <small  id="msg" style="color:red"></small>
					</div>
                        </div>
                        
                        <div class="form-group">
                            <label>跳转网址：</label>
                            <input type="text" name="url" id="url" value="" placeholder="比如http://www.baidu.com" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                        </div>
                        
                     
                         
                           <div class="form-group">
                            <label>备&emsp;&emsp;注：</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control"></textarea>
                             
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
		 var photo = $("#photo").val();
		    var url = $("#url").val();
		
		   if(!photo) {
	            $("#msg").html("请上传轮播图");
	            $("#photo").focus(); // 聚焦
	            return false;
	        }
		 
		    if(!url) {
	            $("#msg1").html("跳转网址不能为空！");
	            $("#url").focus(); // 聚焦
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
