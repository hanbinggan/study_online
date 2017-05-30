<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/26
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="../left_bar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">我的课程</h1>

    <h3 class="sub-header">进行中
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程</th>
                <th>老师</th>
                <th>描述</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applied_lesson}" var="lesson">
                <tr>
                    <td>${lesson.id}</td>
                    <td><a href="<%=path%>/student/lesson/info?id=${lesson.id}">${lesson.name}</a></td>
                    <td>${lesson.teacherName}</td>
                    <td>${lesson.description}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                    <td><a href="/student/lesson/exam?id=${lesson.id}">参加考试</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h3 class="sub-header">申请中
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程</th>
                <th>老师</th>
                <th>描述</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applying_lesson}" var="lesson">
                <tr>
                    <td>${lesson.id}</td>
                    <td><a href="<%=path%>/lesson/info?id=${lesson.id}">${lesson.name}</a></td>
                    <td>${lesson.teacherName}</td>
                    <td>${lesson.description}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h3 class="sub-header">已结束
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程</th>
                <th>老师</th>
                <th>描述</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${finished_lesson}" var="lesson">
                <tr>
                    <td>${lesson.id}</td>
                    <td><a href="<%=path%>/lesson/info?id=${lesson.id}">${lesson.name}</a></td>
                    <td>${lesson.teacherName}</td>
                    <td>${lesson.description}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h3 class="sub-header">被驳回
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程</th>
                <th>老师</th>
                <th>描述</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reject_lesson}" var="lesson">
                <tr>
                    <td>${lesson.id}</td>
                    <td><a href="<%=path%>/lesson/info?id=${lesson.id}">${lesson.name}</a></td>
                    <td>${lesson.teacherName}</td>
                    <td>${lesson.description}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                    <td><a href="/student/lesson/apply?lesson_id=${lesson.id}">重新申请</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="../footer.jsp"/>
