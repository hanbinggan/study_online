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
    <h3 class="sub-header"><a href="/student/lesson/exam?id=${exam.lessonId}">
        ${exam.name}</a>--考试
    </h3>
    <h3 class="sub-header">题目列表
        <div class="pull-right">剩余时间：
            <span id="timer">0 天 0 时 0 分  0秒</span>
            <span style="margin-left: 10px"> 结束时间：</span>
            <span style="color: red;"><fmt:formatDate value="${exam.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
        </div>
    </h3>

    <form class="form-horizontal" method="post" action="/student/lesson/problem/answer/${exam.id}/exam" id="answer_form">
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
                <button type="submit" class="btn btn-default" id="submit_btn">提交考试</button>
            </div>
        </div>
    </form>
    <script>
        // Set the date we're counting down to
        var countDownDate = new Date('<fmt:formatDate value="${exam.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>').getTime();

        // Update the count down every 1 second
        var x = setInterval(function () {

            // Get todays date and time
            var now = new Date().getTime();

            // Find the distance between now an the count down date
            var distance = countDownDate - now;

            // Time calculations for days, hours, minutes and seconds
            var days = Math.floor(distance / (1000 * 60 * 60 * 24));
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            // Display the result in the element with id="demo"
            document.getElementById("timer").innerHTML = days + "天 " + hours + "时 "
                + minutes + "分 " + seconds + "秒 ";

            // If the count down is finished, write some text
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("submit_btn").click();
            }
        }, 1000);
    </script>
    <jsp:include page="../footer.jsp"/>


