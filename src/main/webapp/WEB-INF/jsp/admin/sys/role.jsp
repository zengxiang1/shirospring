<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Matrix Admin</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/matrix-style.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
<div id="toolbar">
    <a href="javascript:void(0);" class="btn btn-primary btn-lg" onclick="popAddWindow()"><i class="fa fa-plus"></i>新增</a>
    <a href="javascript:void(0);" class="btn btn-danger btn-lg" onclick="batchDelete()"><i class="fa fa-plus"></i>删除</a>
</div>
<table id="roleTable">


</table>

<div id="addWindow" class="modal fade " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-header">
            <span>新增角色</span><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        </div>
        <div class="modal-content">
            <div class="widget-content nopadding form-horizontal" style="margin-top: 5px;" >
                    <div class="control-group">
                        <label class="control-label">角色名称 :</label>
                        <div class="controls">
                            <input type="text"  placeholder="First name" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">拥有资源 :</label>
                        <div class="controls">
                            <input type="text"  placeholder="Last name" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">上级</label>
                        <div class="controls" >
                            <select style="border-radius: 10px;">
                                <option>管理员</option>
                                <option>部长</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Company info :</label>
                        <div class="controls">
                            <input type="text"  placeholder="Company name" />
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-success">保存</button>
                    </div>
            </div>
        </div>
    </div>
</div>


</body>
<style>
    input{
        min-height: 30px;
    }
</style>

<script type="text/javascript">
  $("#roleTable").bootstrapTable({
    url: '${pageContext.request.contextPath}/resource/role/list',
    sortable:true,
      toolbar:'#toolbar',
    sidePagination:'client',
    height:500,
    pagination:true,
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
    function batchDelete(){
        var rows=$.map($("#roleTable").bootstrapTable('getSelections'),function(row){
            return row ;
        });
        $.ajax({
            url:"${pageContext.request.contextPath}/resource/role/delete",
            method:'POST',
            dataType:'JSON',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(rows),
            success:function (result) {
                if (0 == result.code){
                    console.log(result.code)
                    $('#userTable').bootstrapTable('refresh', {silent: true})
                    $('#userTable').bootstrapTable('removeAll','');
                }
            }
        });
    }
    function popAddWindow(){
        $("#addWindow").modal('show')
    }
</script>
</html>
