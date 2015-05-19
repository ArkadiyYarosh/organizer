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
    <title>Категория</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand glyphicon glyphicon-home" href="/index"></a>
                <a class="navbar-brand" href="/index">Категории</a>
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
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('#category-link').addClass('active');
            $('#category-link').children().css('color', 'white');
        })
    </script>
    <script src="/resources/js/clock.js"></script>
</body>
</html>
