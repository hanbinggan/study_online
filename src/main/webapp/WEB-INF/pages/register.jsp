<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: songqiaolin
  Date: 2017/4/19
  Time: 下午2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/favicon.ico">

    <title>注册</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/assets/js/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <form class="form-signin" action="/register" method="post">
        <h2 class="form-signin-heading">注册</h2>
        <label for="name" class="sr-only">名字</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="名字" required autofocus>
        <label for="email" class="sr-only">邮箱</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="邮箱">
        <label for="password" class="sr-only">密码</label>
        <input type="text" id="password" name="password" class="form-control" placeholder="密码" required>
        <label>
            <br/>
        </label>
        <label class="radio-inline">
            <input type="radio" name="role" value="student" checked>学生
        </label>
        <label class="radio-inline">
            <input type="radio" name="role" value="teacher">老师
        </label>
        <label>
            <br/>
        </label>
        <c:if test="${not empty warning}">
            <div class="alert alert-warning">
                <strong>Warning!</strong> ${warning}
            </div>
        </c:if>
        <label class="pull-right">
            <a href="#">登录</a>
        </label>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>

    </form>
</div> <!-- /container -->
</body>
</html>
