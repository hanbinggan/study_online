<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/29
  Time: 下午6:59
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
    <h3 class="sub-header"><a href="/student/lesson/exercise?id=${exercise.chapterId}">
        ${exercise.name}</a>--章节练习
    </h3>
    <h3 class="sub-header">题目列表</h3>

    <form class="form-horizontal" method="post" action="/student/lesson/problem/answer/${exercise.id}/exercise">
        <c:forEach items="${problem_list}" var="problem">
            <div id="sub-header">
                <div class="form-group">
                    <label for="content_${problem.id}" class="col-sm-2 control-label">第${problem.orderNumber}题.</label>
                    <div class="col-sm-5">
                        <textarea class="form-control" rows="5"
                                  id="content_${problem.id}" readonly>${problem.content}</textarea>
                    </div>
                </div>
            </div>
            <div id="sub-header">
                <div class="form-group">
                    <label for="content_${problem.id}" class="col-sm-2 control-label">答案</label>
                    <div class="col-sm-5">
                        <textarea class="form-control" rows="1"
                                  id="content_${problem.id}" name="answer_list"></textarea>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-9">
                <button type="submit" class="btn btn-default">提交练习</button>
            </div>
        </div>
    </form>
    <jsp:include page="../footer.jsp"/>


