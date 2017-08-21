<%-- 
    Document   : MemberManager
    Created on : Jul 29, 2017, 9:28:15 PM
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
        <title>Member Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <form id="memberForm">
                        <legend id="leg-add">Add New Member</legend>
                        <legend id="leg-update">Update Member Detail</legend>
                        <legend id="leg-remove">Remove Member</legend>
                        <div class="form-group">
                            <input type="text" name="userName" placeholder="User Name" class="form-control" id="userName">
                        </div>
                        <div class="form-group">
                            <input type="text" name="password" placeholder="Password" class="form-control" id="password">
                        </div>
                        <div class="form-group">
                            <input type="text" name="mobile" placeholder="Mobile Number" class="form-control" id="mobile">
                        </div>
                        <div class="form-group txt-right">
                            <label class="control-label">New Member</label>
                            <input type="radio" name="operation" value="New Member" checked="checked" class=""/>
                            &nbsp;&nbsp;
                            <label class="control-label">Update Member</label>
                            <input type="radio" name="operation" value="Update Member" class=""/>
                            &nbsp;&nbsp;
                            <label class="control-label">Remove Member</label>
                            <input type="radio" name="operation" value="Remove Member" class=""/>
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
                            <th class="txt-cntr">Mobile</th>
                            <th class="txt-cntr">Manage</th>
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
        <script src="js/MemberJS.js" type="text/javascript"></script>
    </body>
</html>
