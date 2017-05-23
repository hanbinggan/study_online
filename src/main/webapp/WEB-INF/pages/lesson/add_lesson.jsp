<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/21
  Time: 下午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="../left_bar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">课程管理</h1>

    <h3 class="sub-header">增加课程</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="lesson"
                   action="/lesson/add">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">课程名</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">描述</label>
                <div class="col-sm-5">
                    <form:input path="description" type="text" class="form-control" id="description"/>
                </div>
            </div>

            <div class="form-group">
                <label for="studyStarScore" class="col-sm-2 control-label">学习之星分数</label>
                <div class="col-sm-5">
                    <form:input path="studyStarScore" type="text" class="form-control" id="studyStarScore"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">增加课程</button>
                </div>
            </div>
        </form:form>
    </div>


    <div class="table-responsive">

    </div>
</div>
</div>
<jsp:include page="../footer.jsp"/>

