<%-- 
    Document   : BookManager
    Created on : Jul 29, 2017, 9:27:28 PM
    Author     : chathura buddhika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <title>Books Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <form id="bookForm">
                        <legend id="leg-add">Add New Book</legend>
                        <legend id="leg-update">Update Book Detail</legend>
                        <legend id="leg-remove">Remove Book</legend>
                        <div class="form-group">
                            <input type="text" name="bookName" placeholder="Book Name" class="form-control" id="bookName">
                        </div>
                        <div class="form-group">
                            <input type="text" name="auther" placeholder="Auther" class="form-control" id="auther">
                        </div>
                        <div class="form-group">
                            <input type="text" name="isbn" placeholder="ISBN Code" class="form-control" id="isbn">
                        </div>
                        <div class="form-group txt-right">
                            <label class="control-label">New Book</label>
                            <input type="radio" name="operation" value="New Book" checked="checked" class=""/>
                            &nbsp;&nbsp;
                            <label class="control-label">Update Book</label>
                            <input type="radio" name="operation" value="Update Book" class=""/>
                            &nbsp;&nbsp;
                            <label class="control-label">Remove Book</label>
                            <input type="radio" name="operation" value="Remove Book" class=""/>
                        </div>
                        <div class="form-group txt-right">
                            <button class="btn btn-success" type="button" id="btnProcess">Do Process</button>
                        </div>
                    </form>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <div class="row">
                <div class="col-lg-2 col-md-2"></div>
                <div class="col-lg-8 col-md-8">
                    <form>
                        <table class="table" id="table">
                            <thead id="tbl-header">
                            <th class="txt-cntr">Name</th>
                            <th class="txt-cntr">Auther</th>
                            <th class="txt-cntr">ISBN</th>
                            <th class="txt-cntr">EDIT</th>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="col-lg-2 col-md-2"></div>
            </div>
        </div>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/sweetalert.js" type="text/javascript"></script>
        <script src="js/BookJS.js" type="text/javascript"></script>
    </body>
</html>
