<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/28
  Time: 下午2:03
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
    <h1 class="page-header">课程管理
        <div class="pull-right btn-group" role="group">
            <button type="button" class="btn btn-info"
                    onclick="location.href='<%=path%>/study/record/top?id=${study.lessonId}'">
                学习之星排名
            </button>
        </div>
    </h1>
    <h3 class="sub-header">学习之星</h3>
    <div class="row placeholders">
        <form class="form-horizontal" method="post"
              action="/lesson/study_star/update">
            <input type="hidden" value="${study.lessonId}" name="lesson_id">
            <div class="form-group">
                <label for="study_score" class="col-sm-2 control-label">课程所占比例</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="study_score"
                           value="${study.precent}" name="study_score"/>
                </div>
            </div>
            <div class="form-group">
                <label for="exercise_score" class="col-sm-2 control-label">练习所占比例</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="exercise_score"
                           value="${exercise.precent}" name="exercise_score"/>
                </div>
            </div>
            <div class="form-group">
                <label for="exam_score" class="col-sm-2 control-label">考试所占比例</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="exam_score"
                           value="${exam.precent}" name="exam_score"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-9">
                    <button type="submit" class="btn btn-default">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="../footer.jsp"/>

