<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/29
  Time: 下午2:05
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
    <h3 class="sub-header">增加考试</h3>
    <div class="row placeholders">
        <form class="form-horizontal" method="post"
                   action="/lesson/exam/add">
            <input name="lessonId" type="hidden" value="${lesson.id}"/>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">考试名称</label>
                <div class="col-sm-5">
                    <input name="name" type="text" class="form-control" id="name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="start_time" class="col-sm-2 control-label">考试开始时间</label>
                <div class="col-sm-5">
                    <input name="startTime" class="form-control" type="text" id="start_time" placeholder="2017-01-01 01:01:01"/>
                </div>
            </div>

            <div class="form-group">
                <label for="end_time" class="col-sm-2 control-label">考试结束时间</label>
                <div class="col-sm-5">
                    <input name="endTime" class="form-control" type="text" id="end_time" placeholder="2017-01-01 01:01:01"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">增加考试</button>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="../footer.jsp"/>


