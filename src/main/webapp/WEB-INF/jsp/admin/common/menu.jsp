<%--
  Created by IntelliJ IDEA.
  User: xiang zeng
  Date: 2017/10/26
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar" style="OVERFLOW-Y: auto; OVERFLOW-X:hidden;">
    <ul>
        <li class="submenu active">
            <a class="menu_a" link="${pageContext.request.contextPath}/static/welcome.html"><i class="fa fa-home"></i> <span class="menu1_name">系统资源管理</span></a>
        </li>
        <li class="submenu">
            <a href="#">
                <i class="fa fa-table"></i>
                <span class="menu1_name">表单</span>
                <span class="label label-important">3</span>
            </a>
            <ul>
                <li><a class="menu_a" link="form-common.html"><i class="fa fa-caret-right"></i>基本表单</a></li>
                <li><a class="menu_a" link="form-validation.html"><i class="fa fa-caret-right"></i>校验表单</a></li>
                <li><a class="menu_a" link="form-wizard.html"><i class="fa fa-caret-right"></i>密码修改样式表单</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#">
                <i class="fa fa-tv"></i>
                <span class="menu1_name">布局表格组件</span>
                <span class="label label-important">6</span>
            </a>
            <ul>
                <li><a class="menu_a" link="buttons.html"><i class="fa fa-caret-right"></i> 按钮 &amp; 图标</a></li>
                <li><a class="menu_a" link="grid.html"><i class="fa fa-caret-right"></i>页面布局</a></li>
                <li><a class="menu_a" link="tables.html"><i class="fa fa-caret-right"></i>表格</a></li>
                <li><a class="menu_a" link="widgets.html"><i class="fa fa-caret-right"></i>插件</a></li>
                <li><a class="menu_a" link="charts.html"><i class="fa fa-caret-right"></i>曲线图 &amp; 统计图</a></li>
                <li><a class="menu_a" link="interface.html"><i class="fa fa-caret-right"></i>元素</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#">
                <i class="fa fa-cog"></i>
                <span class="menu1_name">其他组件</span>
                <span class="label label-important">5</span>
            </a>
            <ul>
                <li><a class="menu_a" link="gallery.html"><i class="fa fa-caret-right"></i>图片墙</a></li>
                <li><a class="menu_a" link="calendar.html"><i class="fa fa-caret-right"></i>日历</a></li>
                <li><a class="menu_a" link="invoice.html"><i class="fa fa-caret-right"></i>清单示例</a></li>
                <li><a class="menu_a" link="chat.html"><i class="fa fa-caret-right"></i>聊天</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#">
                <i class="fa fa-file-o"></i>
                <span class="menu1_name">错误页面</span>
                <span class="label label-important">4</span>
            </a>
            <ul>
                <li><a href="error403.html"><i class="fa fa-caret-right"></i>Error 403</a></li>
                <li><a class="menu_a" link="error404.html"><i class="fa fa-caret-right"></i>Error 404</a></li>
                <li><a class="menu_a" link="error405.html"><i class="fa fa-caret-right"></i>Error 405</a></li>
                <li><a class="menu_a" link="error500.html"><i class="fa fa-caret-right"></i>Error 500</a></li>
            </ul>
        </li>
    </ul>
</div>