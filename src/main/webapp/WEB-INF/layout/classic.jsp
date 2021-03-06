<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html>
<html>
    <head>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="/redist/bootstrap-3.2.0-dist/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="/redist/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css">

        <script src="/redist/jquery/2.1.1/jquery-2.1.1.js"></script>

        
        <script type="text/javascript" src="/redist/jquery.validate/1.13.0/jquery.validate.min.js"></script>
        
        <!-- Latest compiled and minified JavaScript -->
        <script src="/redist/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body>

        <%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
        <tilesx:useAttribute name="current"/>


        <div class="container">

            <!-- Static navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href='<spring:url value="/" />'>Sebas JBA sample</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="${current=='index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <li class="${current=='listadoUsuarios' ? 'active' : ''}"><a href='<spring:url value="/users.html" />'>Usuarios</a></li>
                            </security:authorize>
                            <li class="${current=='register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'>Register</a></li>
                            <security:authorize access="!isAuthenticated()">
                                <li class="${current=='login' ? 'active' : ''}"><a href='<spring:url value="/login.html" />'>Login</a></li>
                            </security:authorize>
                            <security:authorize access="isAuthenticated()">
                                <li class="${current=='miCuenta' ? 'active' : ''}"><a href='<spring:url value="/account.html" />'>Mi cuenta</a></li>
                                <li><a href='<spring:url value="/logout" />'>Logout</a></li>
                            </security:authorize>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </div>

            <tiles:insertAttribute name="body" />

            <br><br>

            <center>
                <tiles:insertAttribute name="footer" />
            </center>
        </div>
    </body>
</html>