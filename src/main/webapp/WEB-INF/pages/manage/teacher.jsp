<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="left_bar.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">老师管理</h1>
    <h3 class="sub-header">增加老师</h3>

    <div class="row placeholders">

        <form:form class="form-inline" method="post" modelAttribute="teacherForm" action="/manage/teacher/add">
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

    <h3 class="sub-header">老师列表</h3>
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
            <c:forEach items="${teacherList}" var="teacher">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.email}</td>
                    <td><fmt:formatDate value="${teacher.createTime}"/></td>
                    <td><a href="<%=path%>/manage/teacher/update?id=${teacher.id}">修改</a>／<a
                            href="<%=path%>/manage/teacher/delete?id=${teacher.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
<jsp:include page="../footer.jsp"/>
