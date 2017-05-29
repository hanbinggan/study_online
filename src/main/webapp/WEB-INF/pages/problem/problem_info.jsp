<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/28
  Time: 下午3:55
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
    <h1 class="page-header">课程管理</h1>
    <h3 class="sub-header"><a href="/lesson/chapter/exercise/info?id=${exercise.id}">${exercise.name}</a> --修改题库</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="problem"
                   action="/lesson/problem/update">
            <form:input path="type" type="hidden"/>
            <form:input path="objectId" type="hidden"/>
            <form:input path="id" type="hidden"/>
            <div class="form-group">
                <label for="content" class="col-sm-2 control-label">课程章节名</label>
                <div class="col-sm-5">
                    <form:textarea path="content" type="text" class="form-control" id="content" rows="7"/>
                </div>
            </div>
            <div class="form-group">
                <label for="answer" class="col-sm-2 control-label">答案</label>
                <div class="col-sm-5">
                    <form:textarea path="answer" type="text" class="form-control" id="answer" rows="4"/>
                </div>
            </div>

            <div class="form-group">
                <label for="score" class="col-sm-2 control-label">分数</label>
                <div class="col-sm-5">
                    <form:input path="score" type="text" class="form-control" id="score"/>
                </div>
            </div>

            <div class="form-group">
                <label for="orderNumber" class="col-sm-2 control-label">排序</label>
                <div class="col-sm-5">
                    <form:input path="orderNumber" type="text" class="form-control" id="orderNumber"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">更改题目</button>
                </div>
            </div>
        </form:form>
    </div>
    <jsp:include page="../footer.jsp"/>


