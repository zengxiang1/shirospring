<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Matrix Admin</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
<button class="btn-primary">增加</button>
<table id="roleTable">

</table>


</body>

<script type="text/javascript">
  $("#roleTable").bootstrapTable({
    url: '${pageContext.request.contextPath}/resource/role/list',
    sortable:true,
    sidePagination:'client',
    height:500,
    pagination:true,
    showRefresh:true,
    idField:'id',
    pageSize:10,
    columns: [{
      checkbox: true
      },
      {
        field: 'id',
        title: '角色ID'
      }, {
        field: 'roleName',
        title: "角色名称"
      }, {
        field:'#',
        title:'操作',
        formatter:function (value, row, index) {
          var d = '<a href="javascript:void(0);" class="btn-danger" onclick="onDeleteClick('+ row.id + ',' + value + ')">删除</a>'
          return d;
        }
      }
    ]
  })
</script>
<script>
    function onDeleteClick(id,value) {
      $.ajax({
        url:"${pageContext.request.contextPath}/resource/role/delete",
        method:'POST',
        dataType:'JSON',
        contentType:'application/json',
        data:JSON.stringify([{id:id}]),
        success:function (result) {
          if (0 == result.code){
            console.log(result.code)
            $('#roleTable').bootstrapTable('refresh', {silent: true})
            $('#roleTable').bootstrapTable('removeAll','');
          }
        }
      });
    }
</script>
</html>
