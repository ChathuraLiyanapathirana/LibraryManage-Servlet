/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('input').on('change', function () {
    if ($('input[name=operation]:checked').val() == "Update Member") {
        $("#leg-update").show(100);
        $("#leg-add").hide(100);
        $("#leg-remove").hide(100);
        $('#userName').prop('readonly', true);
        $('#password').prop('readonly', false);
        $('#mobile').prop('readonly', false);
    }
    if ($('input[name=operation]:checked').val() == "Remove Member") {
        $("#leg-update").hide(100);
        $("#leg-add").hide(100);
        $("#leg-remove").show(100);
        $('#userName').prop('readonly', false);
        $('#password').prop('readonly', true);
        $('#mobile').prop('readonly', true);
    }
    if ($('input[name=operation]:checked').val() == "New Member") {
        $("#leg-update").hide(100);
        $("#leg-add").show(100);
        $("#leg-remove").hide(100);
        $('#userName').prop('readonly', false);
        $('#password').prop('readonly', false);
        $('#mobile').prop('readonly', false);
    }
});

$("#btnProcess").click(function () {
    if ($('input[name=operation]:checked').val() == "New Member") {
        var ajaxConfigure = {
            type: "POST",
            url: "MemberController",
            async: true,
            data: $("#memberForm").serialize()
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    if (response.toString() == "true") {
                        swal("Success!", "New Member Added Successfully!", "success");
                        getAllData();
                    }
                    if (response.toString() == "") {
                        swal("Error!", "Operation Not Successfull!", "error")
                    }
                })
                .fail(function (response) {
                    console.log(response);
                });
    }
    if ($('input[name=operation]:checked').val() == "Update Member") {
        var queryString = "userName=" + encodeURIComponent($("#userName").val()) + "&" + "password=" + encodeURIComponent($("#password").val()) + "&" + "mobile=" + encodeURIComponent($("#mobile").val());
        var ajaxConfigure = {
            type: "PUT",
            url: "MemberController?" + queryString,
            async: true,
            data: ""
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    console.log(response);
                    if (response.toString() == "true") {
                        swal("Success!", "New Member Updated Successfully!", "success");
                        getAllData();
                    }
                    if (response.toString() == "") {
                        swal("Error!", "Operation Not Successfull!", "error");
                    }
                })
                .fail(function (response) {
                    getAllData();
                });
    }

    if ($('input[name=operation]:checked').val() == "Remove Member") {
        var queryString = "userName=" + encodeURIComponent($("#userName").val());
        var ajaxConfigure = {
            type: "DELETE",
            url: "MemberController?" + queryString,
            async: true,
            data: ""
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    if (response.toString() == "true") {
                        swal("Success!", "New Member Updated Successfully!", "success");
                        getAllData();
                    }
                    if (response.toString() == "") {
                        swal("Error!", "Operation Not Successfull!", "error")
                    }
                })
                .fail(function (response) {
                    console.log(response);
                });
    }
    $("#userName").val("");
    $("#password").val("");
    $("#mobile").val("");
});

getAllData();

function getAllData() {
    var ajaxConfigure = {
        type: "GET",
        url: "MemberController",
        async: true,
        data: ""
    };
    $.ajax(ajaxConfigure)
            .done(function (response) {
                $("#table tbody").empty();
                var html;
                for (var i = 0; i < response.length; i++) {
                    html += "<tr><td class='txt-cntr'>" + response[i].userName + "</td><td class='txt-cntr'>" + response[i].mobile + "</td><td class='tbl-row txt-cntr'><a>Edit</a></td></tr>";
                }
                $("#table tbody").append(html);
            })
            .fail(function (response) {
                console.log(response);
            });
}
$('#table tbody').on('click', 'td.tbl-row', function () {
    var rowData = $(this).parent().children(":lt(2)").map(function () {
        return $(this).text();
    });
    for (var i = 0; i < 1; i++) {
        console.log(rowData[i]);
        console.log(rowData[i + 1]);
        $("#userName").val(rowData[i]);
        $("#mobile").val(rowData[i + 1]);
    }
});
