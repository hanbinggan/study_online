<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/18
  Time: 上午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <c:if test="${sessionScope.user['role'] eq 'teacher'}">
                    <li><a href="/lesson">课程 <span class="sr-only">(current)</span></a></li>
                </c:if>
                <c:if test="${sessionScope.user['role'] eq 'student'}">
                    <li><a href="/lesson/all">参加课程</a></li>
                    <li><a href="/student/lesson">课程管理</a></li>
                </c:if>
            </ul>
        </div>
    </div>
