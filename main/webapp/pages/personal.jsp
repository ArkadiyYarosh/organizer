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
    <title>Личная информация</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand glyphicon glyphicon-home" href="/index"></a>
                <a class="navbar-brand" href="/admin/users">Личная информация</a>
            </div>
            <div class="navbar-right">
                <a class="navbar-text" style="text-decoration: none;" id="clock"></a>
                <a class="navbar-brand" href="#">EDI</a>
                <a href="/j_spring_security_logout" class="navbar-brand glyphicon glyphicon-off" style="text-decoration: none;"></a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row" style="padding-top: 65px">
            <jsp:include page="templates/navigation.jsp"/>
            <div class="col-lg-offset-1 col-lg-8">
                <div class="list-group">
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">Имя</h4>
                        <p class="list-group-item-text">${user.firstName}</p>
                    </a>
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">Фамилия</h4>
                        <p class="list-group-item-text">${user.secondName}</p>
                    </a>
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">Отчество</h4>
                        <p class="list-group-item-text">${user.lastName}</p>
                    </a>
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">Логин</h4>
                        <p class="list-group-item-text">${user.login}</p>
                    </a>
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading">Пароль</h4>
                        <form action="/user/change-password" method="post">
                            <div class="form-group">
                                <label>Старый пароль (*)</label>
                                <input type="password" class="form-control" name="oldPass">
                            </div>
                            <div class="form-group">
                                <label>Новый пароль (*)</label>
                                <input type="password" class="form-control" name="newPass">
                            </div>
                            <div class="form-group">
                                <label>Подтверждение пароля (*)</label>
                                <input type="password" class="form-control" name="repPass">
                            </div>
                            <div class="form-group" id="errors">
                                <c:if test="${oldPass_error}">
                                    <h3 class="text-danger">
                                        Введеный неверный текущий пароль
                                    </h3>
                                </c:if>
                                <c:if test="${newPass_error}">
                                    <h3 class="text-danger">
                                        Новые пароли не совпадают
                                    </h3>
                                </c:if>
                                <c:if test="${success}">
                                    <h3 class="text-success">
                                        Пароль успешно изменен!
                                    </h3>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary col-lg-6"value="Подтвердить">
                                <input type="reset" class="btn btn-warning col-lg-6" value="Сбросить">
                            </div>
                            <div class="clearfix"></div>
                        </form>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('#person-link').addClass('active');
            $('#person-link').children().css('color', 'white');
        })
    </script>
    <script src="/resources/js/clock.js"></script>
</body>
</html>
