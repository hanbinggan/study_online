<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/23
  Time: 下午6:21
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
    <h3 class="sub-header">课程内容详情</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="lesson_content"
                   action="/lesson/content/update" enctype="multipart/form-data">
            <form:input path="lessonChapterId" type="hidden"/>
            <form:input path="id" type="hidden"/>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">课程内容名</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="orderNumber" class="col-sm-2 control-label">排序</label>
                <div class="col-sm-5">
                    <form:input path="orderNumber" type="text" class="form-control" id="orderNumber"/>
                </div>
            </div>

            <div class="form-group">
                <label for="studyStarScore" class="col-sm-2 control-label">学习之星分数</label>
                <div class="col-sm-5">
                    <form:input path="studyStarScore" type="text" class="form-control" id="studyStarScore"/>
                </div>
            </div>

            <div class="form-group">
                <label for="file" class="col-sm-2 control-label">文件</label>
                <div class="col-sm-5">
                    <div><br/></div>
                    <input type="file" name="file" class="form-control-file" id="file" aria-describedby="fileHelp"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">更新课程内容</button>
                </div>
            </div>
        </form:form>
    </div>
<jsp:include page="../footer.jsp"/>
