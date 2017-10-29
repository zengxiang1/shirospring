<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<jsp:include page="common/header.jsp"/>
<body>
    <jsp:include page="common/top.jsp"/>
    
    <jsp:include page="common/menu.jsp"/>

    <div id="content">
        <div id="content-header">
          <div id="breadcrumb"> 
            <a href="index.html" title="回首页" class="tip-bottom"><i class="fa fa-home"></i> 系统</a>
            <a href="#" class="tip-bottom"> 首页</a>
        </div>
        </div>
        <!--End-breadcrumbs-->
        <iframe src="${pageContext.request.contextPath}/static/welcome.html" id="iframe-main" frameborder='0' style="width:100%;"></iframe>
    </div>
    <!--end-main-container-part-->

</body>
<jsp:include page="common/bottom.jsp"/>
</html>
