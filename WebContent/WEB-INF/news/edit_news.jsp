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
            <h5>修改萌宠资讯</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="NewsServlet?action=update"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                             <input type="hidden" name="id" value="${news.id }" />
                                   <input type="hidden" name="photo" value="${news.photo }" /> <!--如果不选择图片，就把源地址传递过去--> 
                <div class="form-group">
                            <label>标题：</label>
                            <input type="text" name="title" id="title" value="${news.title }" placeholder="请输入标题" class="form-control">                          
                            <small  id="msg" style="color:red"></small>
                  </div>         
                   <div class="form-group">
                            <label>预览：</label>
                             <img src="upload/${news.title }" id="preview_img" width="200px" height="70px" alt="">
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
                            <!-- <label>编辑者：</label> -->
                            <script id="container" name="content" type="text/plain">${news.content}</script>
                        </div>
                        
                        
                        <div class="form-group">
                            <label>编辑者：</label>
                            <input type="text" name="editor" id="editor" value="${news.editor }" placeholder="请输入编辑者" class="form-control">                          
                            <small  id="msg2" style="color:red"></small>
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

 <script src="<%=path%>/js/jquery-1.9.1.min.js"></script> 
 <script src="<%=path%>/js/ueditor/ueditor.config.js"></script>
    <script src="<%=path%>/js/ueditor/ueditor.all.min.js"></script>
    <script src="<%=path%>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
       <script type="text/javascript">
       var ue = UE.getEditor('container',{
    	   initialFrameWidth:1000,
    	//   initialFrameHeight:400,
       });
   </script> 


<script>
$(function(){
	$("#update").click( function() {
		 var title = $("#title").val();
		 var photo = $("#photo").val();
		 var editor = $("#editor").val();
		 if(!title) {
	            $("#msg").html("请上传标题");
	            $("#title").focus(); // 聚焦
	            return false;
	        }
		   if(!photo) {
	            $("#msg1").html("请上传资讯封面");
	            $("#photo").focus(); // 聚焦
	            return false;
	        }
		 
		    if(!editor) {
	            $("#msg2").html("请输入编辑者！");
	            $("#editor").focus(); // 聚焦
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
