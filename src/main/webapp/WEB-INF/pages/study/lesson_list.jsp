<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/26
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String path = request.getContextPath();%>
<jsp:include page="../header.jsp"/>

<jsp:include page="../left_bar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">课程管理</h1>

    <h3 class="sub-header">课程列表
        <button type="button" class="btn btn-primary pull-right"
                onclick="location.href='<%=path%>/lesson/add';">增加课程
        </button>
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程</th>
                <th>老师</th>
                <th>描述</th>
                <th>创建时间</th>
                <th>操作</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lessonList}" var="lesson">
                <tr>
                    <td>${lesson.id}</td>
                    <td><a href="<%=path%>/lesson/info?id=${lesson.id}">${lesson.name}</a></td>
                    <td>老师名字</td>
                    <td>${lesson.description}</td>
                    <td><fmt:formatDate value="${lesson.createTime}"/></td>
                    <td><a href="#">申请加入</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="../footer.jsp"/>
