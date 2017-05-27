<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/27
  Time: 下午2:47
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
    <%--<h1 class="page-header">我的课程</h1>--%>
    <h3 class="sub-header">${lesson.name}--章节列表</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>章节</th>
                <th>描述</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lesson_chapter}" var="lessonChapter">
                <tr>
                    <td>${lessonChapter.id}</td>
                    <td><a href="<%=path%>/student/lesson/content?id=${lessonChapter.id}">${lessonChapter.name}</a></td>
                    <td>${lessonChapter.description}</td>
                    <td><fmt:formatDate value="${lessonChapter.createTime}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

