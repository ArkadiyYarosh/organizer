<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css" type="text/css" media="all">
    <script src="/resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/stupidtable.js" type="text/javascript"></script>
    <title>Войти</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand glyphicon glyphicon-home" href="/index"></a>
                <a class="navbar-brand" href="/user">Вход в систему</a>
            </div>
            <div class="navbar-right">
                <a class="navbar-text" style="text-decoration: none;" id="clock"></a>
                <a class="navbar-brand" href="#">EDI</a>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row" style="padding-top: 65px">
            <div class="col-lg-offset-4 col-lg-4">
                <c:url value="/j_spring_security_check" var="loginUrl" />
                <form action="${loginUrl}" method="post">
                    <legend>Войти</legend>
                    <div class="form-group">
                        <label>Логин</label>
                        <input type="text" class="form-control" name="j_username">
                    </div>
                    <div class="form-group">
                        <label>Пароль</label>
                        <input type="password" class="form-control" name="j_password">
                    </div>
                    <button type="submit" class="btn btn-primary col-lg-6">Войти</button>
                    <a href="/register" class="btn btn-warning col-lg-6">
                        Регистрация
                    </a>
                </form>
            </div>
        </div>
    </div>

    <script src="/resources/js/clock.js"></script>
</body>
</html>
