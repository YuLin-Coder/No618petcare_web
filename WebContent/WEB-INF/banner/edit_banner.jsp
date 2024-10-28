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
                    <form action="BannerServlet?action=update"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                                 <input type="hidden" name="id" value="${banner.id }" />
                                   <input type="hidden" name="photo" value="${banner.photo }" />
                        <div class="form-group">
                            <label>预览：</label>
                             <img src="upload/${banner.photo }" id="preview_img" width="200px" height="70px" alt="">
                    </div>  
                     <div class="form-group">
                     <label>选择轮播图：</label>
                           <div class="field">
						<input type="file" id="photo" name="resPath"
							 class="uploadBtn"  accept=".jpg,.png,.gif" /><br> 
							 <small  id="msg" style="color:red"></small>
					</div>
                        
                        <div class="form-group">
                            <label>跳转网址：</label>
                            <input type="text" name="url" id="url" value="${banner.url }" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                        </div>
                        
                     
                         
                           <div class="form-group">
                            <label>备&emsp;&emsp;注：</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control">${banner.note }</textarea>
                             
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



<script src="static/admin/js/update.js" ></script>
<script>
$(function(){
	$("#update").click( function() {
		 var photo = $("#photo").val();
		    var url = $("#url").val();
		
		  /*  if(!photo) {
	            $("#msg").html("请上传轮播图");
	            $("#photo").focus(); // 聚焦
	            return false;
	        } */
		 
		    if(!url) {
	            $("#msg1").html("跳转网址不能为空！");
	            $("#url").focus(); // 聚焦
	            return false;
	        }
		  
		   
		 
	});
})


</script>
</body>

</html>
