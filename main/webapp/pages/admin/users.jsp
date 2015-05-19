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
    <title>Пользователи</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/admin/users">Управление пользователями</a>
            </div>
            <div class="navbar-right">
                <a class="navbar-text" style="text-decoration: none;" id="clock"></a>
                <a class="navbar-brand" href="#">EDI</a>
                <a href="/j_spring_security_logout" class="navbar-brand glyphicon glyphicon-off" style="text-decoration: none;"></a>
            </div>
        </div>
    </nav>
    <div>
        <div class="row" style="margin: 65px 0px 20px 0px;">
            <div class="col-lg-2">
                <form:form id="form" action="/admin/users" method="post" modelAttribute="user">
                    <legend>
                        Добавить пользователя
                    </legend>
                    <form:input id="userId" type="hidden" path="userId"/>
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
                    <div class="form-group">
                        <label>Права доступа</label>
                        <form:select class="form-control" path="rights">
                            <option value="1">Администратор</option>
                            <option value="2">Пользователь</option>
                            <option value="0">Забанен</option>
                        </form:select>
                    </div>
                    <div class="form-group" id="errors">
                        <form:errors path="*" cssStyle="color: red;"/>
                    </div>
                    <button class="btn btn-primary col-lg-6" id="submit_user">Подтвердить</button>
                    <button type="reset" class="btn btn-warning col-lg-6">Сбросить</button>
                </form:form>
            </div>
            <div class="col-lg-10">
                <table class="table table-striped table-hover" id="table">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th data-sort="int">
                                ID
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                            <th data-sort="string">
                                Имя
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                            <th data-sort="string">
                                Фамилия
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                            <th data-sort="string">
                                Отчество
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                            <th data-sort="string">
                                Логин
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                            <th data-sort="string">
                                Права
                                <a href="#" class="glyphicon glyphicon-sort" style="float: right; text-decoration: none;"/>
                            </th>
                        </tr>
                        <tr>
                            <form action="/admin/users" method="get" id="filter">
                                <td></td>
                                <td><a href="#" onclick="$('#filter').submit()" class="glyphicon glyphicon-refresh"></a> </td>
                                <td><input id="fil_userId" type="number" name="userId"></td>
                                <td><input id="fil_firstName" type="text" name="firstName"></td>
                                <td><input id="fil_secondName" type="text" name="secondName"></td>
                                <td><input id="fil_lastName" type="text" name="lastName"></td>
                                <td><input id="fil_login" type="text" name="login"></td>
                                <td>
                                    <select name="rights" id="fil_rights">
                                        <option value="-1">Все</option>
                                        <option value="1">Администратор</option>
                                        <option value="2">Пользователь</option>
                                        <option value="0">Забанен</option>
                                    </select>
                                </td>
                            </form>
                        </tr>
                    </thead>
                    <c:if test="${not empty users}">
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>
                                    <a href="/admin/users/${user.userId}.edit" class="glyphicon glyphicon-edit" style="text-decoration: none"></a>
                                </td>
                                <td><a href="/admin/users/${user.userId}.delete" class="glyphicon ${user.rights==0?'glyphicon-ok-circle':'glyphicon-ban-circle'}" style="text-decoration: none"></a></td>
                                <td>${user.userId}</td>
                                <td>${user.firstName}</td>
                                <td>${user.secondName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.login}</td>
                                <td>${user.rights==1?'Администратор':user.rights==2?'Пользователь':'Забанен'}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>

    <script>
        (function($) {
            $.QueryString = (function(a) {
                if (a == "") return {};
                var b = {};
                for (var i = 0; i < a.length; ++i)
                {
                    var p=a[i].split('=');
                    if (p.length != 2) continue;
                    b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
                }
                return b;
            })(window.location.search.substr(1).split('&'))
        })(jQuery);

        $(document).ready(function(){
            if($('#pass').val() && !$('#pass_rep').val()) {
                $('#pass_rep').val($('#pass').val());
            }

            if($.QueryString["userId"]) {
                $('#fil_userId').val($.QueryString["userId"]);
            }
            if($.QueryString["firstName"]) {
                $('#fil_firstName').val($.QueryString["firstName"]);
            }
            if($.QueryString["secondName"]) {
                $('#fil_secondName').val($.QueryString["secondName"]);
            }
            if($.QueryString["lastName"]) {
                $('#fil_lastName').val($.QueryString["lastName"]);
            }
            if($.QueryString["login"]) {
                $('#fil_userId').val($.QueryString["login"]);
            }
            if($.QueryString["rights"]) {
                $('#fil_rights').val($.QueryString["rights"]);
            }

            $('#table').stupidtable();

            $('#submit_user').click(function(e){
                e.preventDefault();

                if($('#pass').val() === $('#pass_rep').val()) {
                    $('#form').submit();
                } else {
                    $('#errors').append('<span style="color:red;">Пароли не совпадают!</span>');
                }
            })
            setTimeout(updateTime, 1000);
        })

        function updateTime() {
            var d = new Date();
            $('#clock').text(d.getHours()+':'+ d.getMinutes()+':'+((d.getSeconds()<10)?('0'+d.getSeconds()): d.getSeconds()));
            setTimeout(updateTime, 1000);
        }
    </script>
</body>
</html>
