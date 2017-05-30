<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/29
  Time: 下午6:59
  To change this template use File | Settings | File Templates.
--%>
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
    <h3 class="sub-header"><a href="/student/lesson/${type}?id=${to_id}">
        ${name}</a>--答案
    </h3>
    <h3 class="sub-header">题目列表
    <div class="pull-right">总分：${total_score}<span style="color: red;margin-left: 10px"> 得分：${student_score}</span></div>
    </h3>

    <form class="form-horizontal" method="post" action="/student/lesson/problem/answer/${exercise.id}">
        <c:forEach items="${answer_list}" var="answer">
            <div id="sub-header">
                <div class="form-group">
                    <label class="col-sm-2 control-label">第${answer.order_number}题.</label>
                    <div class="col-sm-5">
                        <textarea class="form-control" rows="5"
                                   readonly>${answer.problem}
                        </textarea>
                    </div>
                </div>
            </div>
            <div id="sub-header">
                <div class="form-group">
                    <label class="col-sm-2 control-label">答案</label>
                    <div class="col-sm-5">
                        <textarea class="form-control" rows="1"
                                   name="answer_list" readonly>${answer.origin_answer}</textarea>
                    </div>
                </div>
            </div>
            <div id="sub-header">
                <div class="form-group">
                    <label class="col-sm-2 control-label">回答</label>
                    <div class="col-sm-5">
                        <textarea class="form-control" rows="1"
                                  name="answer_list" readonly>${answer.student_answer}</textarea>
                    </div>
                </div>
            </div>

            <div id="sub-header">
                <div class="form-group">
                    <label class="col-sm-2 control-label"></label>
                    <div class="col-sm-2">分值：${answer.score}</div>
                    <div class="col-sm-2" style="color: red;">得分：${answer.student_score}</div>
            </div>
        </c:forEach>
    </form>
    <jsp:include page="../footer.jsp"/>


