<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/30
  Time: 下午7:44
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
    <h1 class="page-header">学习之星排名
        <button type="button" class="btn btn-primary pull-right"
                onclick="location.href='<%=path%>/lesson/study_star?id=${lesson.id}';">修改学习之星设置
        </button>
    </h1>

    <h3 class="sub-header">
    </h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>排名</th>
                <th>学生姓名</th>
                <th>得分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${student_list}" var="student">
                <tr>
                    <td>${student.order_number}</td>
                    <td><a href="<%=path%>/study/record?id=${student.student_id}&lesson_id=${lesson.id}">
                        ${student.name}</a>
                    </td>
                    <td>${student.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../footer.jsp"/>


