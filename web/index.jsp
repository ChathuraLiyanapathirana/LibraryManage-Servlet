<%-- 
    Document   : index
    Created on : Jul 29, 2017, 7:34:07 PM
    Author     : chathura buddhika
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
        <title>Well Come Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="jumbotron txt-cntr">
                <h1>WelCome Back To Easy Library</h1>
                <%
                    Date d = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    String nowDate = dateFormat.format(d);
                %>
                <h2><%= nowDate%></h2>
                <%
                %>
            </div>
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <div class="form-group">
                    <a role="button" class="btn btn-warning width-fix" href="MemberManager.jsp">Member Management</a>
                </div>
                <div class="form-group">
                    <a role="button" class="btn btn-info width-fix" href="BookManager.jsp">Book Management</a>
                </div>
                <div class="form-group">
                    <a role="button" class="btn btn-info width-fix">Transaction Management</a>
                </div>
            </div>
            <div class="col-lg-2"></div>
        </div>
    </body>
</html>
