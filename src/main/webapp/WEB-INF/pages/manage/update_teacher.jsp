<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String path = request.getContextPath();%>

<jsp:include page="../header.jsp"/>
<jsp:include page="left_bar.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">老师管理</h1>
    <h3 class="sub-header">修改老师</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="teacher"
                   action="/manage/teacher/update">
            <form:input path="id" type="hidden" class="form-control" id="id" value="${teacher.id}"/>

            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-5">
                    <form:input path="email" type="text" class="form-control" id="email"
                                value="${teacher.email}" readonly="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"
                                value="${teacher.name}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-5">
                    <form:input path="password" type="password" class="form-control" id="password"
                                value="${teacher.password}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">修改</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</div>
<jsp:include page="../footer.jsp"/>
