<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/27
  Time: 下午12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="../left_bar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">学生管理</h1>

    <h3 class="sub-header">进行中
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>学生</th>
                <th>学习之星分数</th>
                <th>加入时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applied_lesson}" var="lesson">
                <tr>
                    <td>${lesson.studentName}</td>
                    <td>10</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
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
                <th>学生</th>
                <th>加入时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applying_lesson}" var="lesson">
                <tr>
                    <td>${lesson.studentName}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                    <td><a href="/lesson/join?lesson_id=${lesson.lessonId}&student_id=${lesson.studentId}">同意加入课程</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="../footer.jsp"/>

