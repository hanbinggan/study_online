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
    <h3 class="sub-header">课程章节详情</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="lesson_chapter"
                   action="/lesson/chapter/update">
            <form:input path="lessonId" type="hidden"/>
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">id</label>
                <div class="col-sm-5">
                    <form:input path="id" type="text" class="form-control" id="id"
                                readonly="true" value="${id}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">课程章节名</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"
                                value="${name}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">章节描述</label>
                <div class="col-sm-5">
                    <form:input path="description" type="text" class="form-control" id="description"
                                value="${description}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="orderNumber" class="col-sm-2 control-label">排序</label>
                <div class="col-sm-5">
                    <form:input path="orderNumber" type="text" class="form-control" id="orderNumber"
                                value="${orderNumber}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">修改</button>
                </div>
            </div>
        </form:form>
    </div>
    <h3 class="sub-header">内容列表
        <button type="button" class="btn btn-primary pull-right"
                onclick="location.href='<%=path%>/lesson/content/add?id=${lesson_chapter.id}';">增加章节内容
        </button>
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程内容名</th>
                <th>学习之星分数</th>
                <th>排序</th>
                <th>文件名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lessonContents}" var="lessonContent">
                <tr>
                    <td>${lessonContent.id}</td>
                    <td><a href="<%=path%>/lesson/content/info?id=${lessonContent.id}">${lessonContent.name}</a></td>
                    <td>${lessonContent.studyStarScore}</td>
                    <td>${lessonContent.orderNumber}</td>
                    <td>${lessonContent.orderNumber}</td>
                    <td><fmt:formatDate value="${lessonContent.createTime}"/></td>
                    <td><a href="<%=path%>/lesson/content/delete?id=${lessonContent.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
