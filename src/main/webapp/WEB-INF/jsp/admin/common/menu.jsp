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
        <c:forEach items="${menuList}" var="menus" varStatus="i">
        <li class="submenu">
                <a href="#">
                    <i class="fa fa-table"></i>
                    <span class="menu1_name">${i.current.get(0).resourceName}</span>
                </a>
            <ul>
            <c:forEach items="${menus}" var="menu" begin="1" varStatus="status">
                <li><a class="menu_a" link="${pageContext.request.contextPath}${menu.resourcePath}"><i class="fa fa-caret-right"></i>${menu.resourceName}</a></li>
            </c:forEach>
            </ul>
        </li>
        </c:forEach>
    </ul>
</div>