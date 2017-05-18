<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>
<jsp:include page="left_bar.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">学生管理</h1>
    <h3 class="sub-header">增加学生</h3>

    <div class="row placeholders">

        <form:form class="form-inline" method="post" modelAttribute="studentForm" action="/manage/student/add">
            <div class="form-group">
                <label for="email">邮箱:</label>
                <form:input path="email" type="email" class="form-control" id="email"/>
            </div>
            <div class="form-group">
                <label for="name">姓名:</label>
                <form:input path="name" type="text" class="form-control" id="name"/>
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <form:input path="password" type="password" class="form-control" id="password"/>
            </div>
            <button type="submit" class="btn btn-default">增加</button>
        </form:form>
    </div>

    <h3 class="sub-header">学生列表</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td><fmt:formatDate value="${student.createTime}"/></td>
                    <td><a href="<%=path%>/manage/student/update?id=${student.id}">修改</a>／<a
                            href="<%=path%>/manage/student/delete?id=${student.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
<jsp:include page="../footer.jsp"/>

