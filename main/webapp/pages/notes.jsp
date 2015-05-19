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
    <title>Заметки</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand glyphicon glyphicon-home" href="/index"></a>
                <a class="navbar-brand" href="/notes">Заметки</a>
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
                <c:if test="${not empty notes}">
                    <c:forEach items="${notes}" var="note">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    ${note.title}
                                    <p style="float: right;">${note.lastModified.toLocaleString()}</p>
                                </h3>
                            </div>
                            <div class="panel-body">
                                ${note.content}
                                <br/>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty pages}">
                    <div class="row" style="text-align: center">
                        <ul class="pagination pagination-lg">
                            <c:forEach items="${pages}" var="page">
                                <li  <c:if test='${page.pageNo eq currentPage}'>class=active</c:if> >
                                    <a href="/notes?amount=${page.amount}&skip=${page.skip}&pageNo=${page.pageNo}">
                                        ${page.pageNo}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $('#notes-link').addClass('active');
            $('#notes-link').children().css('color', 'white');
        })
    </script>
    <script src="/resources/js/clock.js"></script>
</body>
</html>
