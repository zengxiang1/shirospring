<%--
  Created by IntelliJ IDEA.
  User: zeng
  Date: 2017/11/3
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
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
    <table id="userTable" table-layout:fixed align="center"></table>
</body>

<script type="text/javascript">
    $("#userTable").bootstrapTable({
        url: '${pageContext.request.contextPath}/resource/user/getAllUser',
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
                field: 'realName',
                title: '用户姓名',
                width: '10%',
                align: 'center'
            }, {
                field: 'phoneNumber',
                title: "联系电话",
                width: '10%',
                align: 'center'
            },{
                field: 'address',
                title: "联系地址",
                width: '40%',
                align: 'center'
            },{
                field: 'registerTime',
                title: "注册日期",
                width: '20%',
                align: 'center'
            }, {
                field:'#',
                title:'操作',
                width: '20%',
                align: 'center',
                formatter:function (value, row, index) {
                    var del = '<a href="javascript:void(0);" class="col-sm-8" style="color: red" onclick="onDeleteClick('+ row.id + ',' + value + ')">删除</a>';
                    var change = '<a href="javascript:void(0);" class="col-sm-4" onclick="onChangeClick('+ row.id +')">修改</a>';
                    return del+"&nbsp&nbsp&nbsp&nbsp"+change;
                }
            }
        ]
    })
</script>

<script type="text/javascript">
    function onDeleteClick(id,value) {

        var row=$.map($("#userTable").bootstrapTable('getSelections'),function(row){
            return row ;
        });
        console.log(JSON.stringify(row));

        $.ajax({
            url:"${pageContext.request.contextPath}/resource/user/deleteUserInfo",
            method:'POST',
            dataType:'JSON',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(row),
            success:function (result) {
                if (0 == result.code){
                    console.log(result.code)
                    $('#userTable').bootstrapTable('refresh', {silent: true})
                    $('#userTable').bootstrapTable('removeAll','');
                }
            }
        });
    }
    
</script>
</html>
