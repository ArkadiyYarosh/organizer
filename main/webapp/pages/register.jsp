<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css" type="text/css" media="all">
    <script src="/resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="/resources/js/stupidtable.js" type="text/javascript"></script>
    <title>Регистрация</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand glyphicon glyphicon-home" href="/index"></a>
                <a class="navbar-brand" href="/user">Регистрация</a>
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
                <form:form id="form" action="/register" method="post" modelAttribute="user">
                    <legend>
                        Регистрация
                    </legend>
                    <div class="form-group">
                        <label>Имя</label>
                        <form:input type="text" class="form-control" path="firstName"/>
                    </div>
                    <div class="form-group">
                        <label>Фамилия</label>
                        <form:input type="text" class="form-control" path="secondName"/>
                    </div>
                    <div class="form-group">
                        <label>Отчество</label>
                        <form:input type="text" class="form-control" path="lastName"/>
                    </div>
                    <div class="form-group">
                        <label>Логин</label>
                        <form:input type="text" class="form-control" path="login"/>
                    </div>
                    <div class="form-group">
                        <label>Пароль</label>
                        <form:input id="pass" type="password" class="form-control" path="Password"/>
                    </div>
                    <div class="form-group">
                        <label>Повторите пароль</label>
                        <input id="pass_rep" type="password" class="form-control"/>
                    </div>
                    <div class="form-group" id="errors">
                        <form:errors path="*" cssStyle="color: red;"/>
                    </div>
                    <button class="btn btn-primary col-lg-6" id="submit_user">Подтвердить</button>
                    <button type="reset" class="btn btn-warning col-lg-6">Сбросить</button>
                </form:form>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#submit_user').click(function (e) {
                e.preventDefault();

                if ($('#pass').val() === $('#pass_rep').val()) {
                    $('#form').submit();
                } else {
                    $('#errors').append('<span style="color:red;">Пароли не совпадают!</span>');
                }
            })

            setTimeout(updateTime, 1000);
        })
    </script>
    <script src="/resources/js/clock.js"></script>
</body>
</html>
