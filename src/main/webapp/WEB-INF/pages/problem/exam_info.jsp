<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/29
  Time: 下午2:39
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
    <h1 class="page-header">学习记录</h1>
    <h3 class="sub-header"><a href="/lesson/exam?id=${lesson.id}">${lesson.name}</a>--考试详情
    </h3>
    <div class="row placeholders">
        <form class="form-horizontal" method="post"
              action="/lesson/exam/update">
            <input name="lessonId" type="hidden" value="${exam.lessonId}"/>
            <input name="id" type="hidden" value="${exam.id}"/>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">考试名称</label>
                <div class="col-sm-5">
                    <input name="name" type="text" class="form-control" id="name" value="${exam.name}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="start_time" class="col-sm-2 control-label">考试开始时间</label>
                <div class="col-sm-5">
                    <input name="startTime" class="form-control" type="text" id="start_time"
                           value="<fmt:formatDate value="${exam.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                </div>
            </div>

            <div class="form-group">
                <label for="end_time" class="col-sm-2 control-label">考试结束时间</label>
                <div class="col-sm-5">
                    <input name="endTime" class="form-control" type="text" id="end_time"
                           value="<fmt:formatDate value="${exam.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">修改考试</button>
                </div>
            </div>
        </form>
    </div>
    <h3 class="sub-header">题目列表
        <button type="button" class="btn btn-primary pull-right"
                onclick="location.href='<%=path%>/lesson/problem/add?id=${exam.id}&type=exam';">增加题目
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
                    <td>
                        <a href="<%=path%>/lesson/problem/delete?id=${problem.id}&object_id=${exam.id}&url=exam/info">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

