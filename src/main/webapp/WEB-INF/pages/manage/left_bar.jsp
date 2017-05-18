<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/5/18
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <%--<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>--%>
                <li><a href="<%=path%>/manage/student/">学生设置</a></li>
                <li><a href="<%=path%>/manage/teacher/">老师设置</a></li>
                <li><a href="#"></a></li>
            </ul>
        </div>