<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/28
  Time: 下午3:44
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
    <h3 class="sub-header"><a href="/lesson/chapter/exercise?id=${lesson_chapter.id}">
    ${lesson_chapter.name}</a>--章节练习详情
    </h3>
    <div class="row placeholders">
        <form:form class="form-horizontal" method="post" modelAttribute="exercise"
                   action="/lesson/chapter/exercise/update">
            <form:input path="chapterId" type="hidden"/>
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">id</label>
                <div class="col-sm-5">
                    <form:input path="id" type="text" class="form-control" id="id"
                                readonly="true" value="${id}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">练习名称</label>
                <div class="col-sm-5">
                    <form:input path="name" type="text" class="form-control" id="name"
                                value="${name}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">修改练习</button>
                </div>
            </div>
        </form:form>
    </div>
    <h3 class="sub-header">题目列表
        <button type="button" class="btn btn-primary pull-right"
                onclick="location.href='<%=path%>/lesson/problem/add?id=${exercise.id}&type=exercise';">增加题目
        </button>
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id</th>
                <th>题目</th>
                <th>答案</th>
                <th>排序</th>
                <th>分值</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${problem_list}" var="problem">
                <tr>
                    <td><a href="<%=path%>/lesson/problem/info?id=${problem.id}">${problem.id}</a></td>
                    <td>${problem.content}</td>
                    <td>${problem.answer}</td>
                    <td>${problem.orderNumber}</td>
                    <td>${problem.score}</td>
                    <td><a href="<%=path%>/lesson/problem/delete?id=${problem.id}&exercise_id=${exercise.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

