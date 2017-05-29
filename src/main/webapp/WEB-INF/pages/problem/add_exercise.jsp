<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/28
  Time: 下午3:42
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
    <h3 class="sub-header">增加章节练习</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="exercise"
                   action="/lesson/chapter/exercise/add">
            <form:input path="chapterId" type="hidden"/>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">课程章节名</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"
                                value="${name}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">增加练习</button>
                </div>
            </div>
        </form:form>
    </div>
<jsp:include page="../footer.jsp"/>


