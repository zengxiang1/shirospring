<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Matrix Admin</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.css" />
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
<table id="roleTable">

</table>



</body>

<script type="text/javascript">
  $("#roleTable").bootstrapTable({
    url:'${pageContext.request.contextPath}/resource/role/list',
    onlyInfoPagination:true,
    columns:[{
        field:"id",
        title:"用户名"
      }
    ]
  })
</script>
</html>
