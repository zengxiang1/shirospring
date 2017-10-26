<%--
  Created by IntelliJ IDEA.
  User: xiang zeng
  Date: 2017/10/26
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <h1><a href="dashboard.html">信息管理系统平台</a></h1>
</div>

<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" >
            <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                <i class="fa fa-user"></i>&nbsp;
                <span class="text">欢迎你，admin</span>&nbsp;
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#"><i class="fa fa-user"></i> 个人资料</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="fa fa-check"></i> 我的任务</a></li>
                <li class="divider"></li>
                <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-key"></i> 退出系统</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages">
            <a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle">
                <i class="fa fa-envelope"></i>&nbsp;
                <span class="text">我的消息</span>&nbsp;
                <span class="label label-important">4</span>&nbsp;
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="fa fa-plus"></i> 新消息</a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="fa fa-envelope"></i> 收件箱</a></li>
                <li class="divider"></li>
                <li><a class="sOutbox" title="" href="#"><i class="fa fa-arrow-up"></i> 发件箱</a></li>
                <li class="divider"></li>
                <li><a class="sTrash" title="" href="#"><i class="fa fa-trash"></i> 回收站</a></li>
            </ul>
        </li>
        <li class=""><a title="" href="#"><i class="fa fa-cog"></i> <span class="text">&nbsp;设置</span></a></li>
        <li class=""><a title="" href="${pageContext.request.contextPath}/logout"><i class="fa fa-power-off"></i> <span class="text">&nbsp;退出系统</span></a></li>
    </ul>
</div>


<div id="search">
    <input type="text" placeholder="搜索..."/>
    <button type="submit" class="tip-bottom" title="Search"><i class="fa fa-search fa-white"></i></button>
</div>
