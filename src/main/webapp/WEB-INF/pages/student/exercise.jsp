<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/29
  Time: 下午6:45
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
    <h3 class="sub-header"><a href="/student/lesson/info?id=${lesson.id}">
        ${lesson.name}</a>--课程章节练习</h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="lesson_chapter"
                   action="">
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
                                value="${name}" readonly="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">章节描述</label>
                <div class="col-sm-5">
                    <form:input path="description" type="text" class="form-control" id="description"
                                value="${description}" readonly="true"/>
                </div>
            </div>
        </form:form>
    </div>
    <h3 class="sub-header">习题列表</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>名称</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${exercise_list}" var="exercise">
                <tr>
                    <td>${exercise.id}</td>
                    <td>${exercise.name}</td>
                    <td><fmt:formatDate value="${exercise.createTime}"/></td>
                    <td>
                        <c:if test="${exercise.chapterId eq -1}">
                            <a href="<%=path%>/student/lesson/problem/answer?id=${exercise.id}&type=exercise">查看回答</a>
                        </c:if>
                        <c:if test="${exercise.chapterId != -1}">
                            <a href="<%=path%>/student/lesson/exercise/join?id=${exercise.id}">参加测试</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

