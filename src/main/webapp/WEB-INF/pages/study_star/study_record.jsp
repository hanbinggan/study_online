<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/30
  Time: 下午12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="../left_bar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">学习之星记录
        <span class="pull-right" style="color: red; font-size: large;">总分： ${total_score}</span>

    </h1>

    <h3 class="sub-header">记录
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>时间</th>
                <th>操作</th>
                <th>得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lesson_record_list}" var="lesson_record">
                <tr>
                    <td><fmt:formatDate value="${lesson_record.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${lesson_record.type} <a href="<%=path%>${lesson_record.url}">${lesson_record.name}</a></td>
                    <td>${lesson_record.study_star_score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h3 class="sub-header">学习记录
        <span class="pull-right" style="color: red;">分数：${study_score}</span>
        <span class="pull-right" style="margin-right: 15px">权值：${study_precent}</span>
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>时间</th>
                <th>操作</th>
                <th>得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${study_record_list}" var="lesson_record">
                <tr>
                    <td><fmt:formatDate value="${lesson_record.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${lesson_record.type} <a href="<%=path%>${lesson_record.url}">${lesson_record.name}</a></td>
                    <td>${lesson_record.study_star_score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h3 class="sub-header">练习记录
        <span class="pull-right" style="color: red;">分数：${exercise_score}</span>
        <span class="pull-right" style="margin-right: 15px">权值：${exercise_precent}</span></h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>时间</th>
                <th>操作</th>
                <th>得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${exercise_record_list}" var="lesson_record">
                <tr>
                    <td><fmt:formatDate value="${lesson_record.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${lesson_record.type} <a href="<%=path%>${lesson_record.url}">${lesson_record.name}</a></td>
                    <td>${lesson_record.study_star_score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <h3 class="sub-header">考试记录
        <span class="pull-right" style="color: red;">分数：${exam_score}</span>
        <span class="pull-right" style="margin-right: 15px">权值：${exam_precent}</span></h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>时间</th>
                <th>操作</th>
                <th>得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${exam_record_list}" var="lesson_record">
                <tr>
                    <td><fmt:formatDate value="${lesson_record.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${lesson_record.type} <a href="<%=path%>${lesson_record.url}">${lesson_record.name}</a></td>
                    <td>${lesson_record.study_star_score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<jsp:include page="../footer.jsp"/>


