<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/27
  Time: 下午2:48
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
    <%--<h1 class="page-header">课程管理</h1>--%>
    <%--<h3 class="sub-header">课程章节详情</h3>--%>
    <h3 class="sub-header">${lesson_chapter.name}--内容列表
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>课程内容名</th>
                <th>学习之星分数</th>
                <th>创建时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lesson_content}" var="lessonContent">
                <tr>
                    <td>${lessonContent.id}</td>
                    <td><a href="<%=path%>/student/lesson/content/info?id=${lessonContent.id}">${lessonContent.name}</a></td>
                    <td>${lessonContent.studyStarScore}</td>
                    <td><fmt:formatDate value="${lessonContent.createTime}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
