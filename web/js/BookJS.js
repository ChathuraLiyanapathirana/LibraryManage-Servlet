/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('input').on('change', function () {
    if ($('input[name=operation]:checked').val() == "Update Book") {
        $("#leg-update").show(100);
        $("#leg-add").hide(100);
        $("#leg-remove").hide(100);
        $('#bookName').prop('readonly', true);
        $('#auther').prop('readonly', false);
        $('#isbn').prop('readonly', false);
    }
    if ($('input[name=operation]:checked').val() == "Remove Book") {
        $("#leg-update").hide(100);
        $("#leg-add").hide(100);
        $("#leg-remove").show(100);
        $('#bookName').prop('readonly', false);
        $('#auther').prop('readonly', true);
        $('#isbn').prop('readonly', true);
    }
    if ($('input[name=operation]:checked').val() == "New Book") {
        $("#leg-update").hide(100);
        $("#leg-add").show(100);
        $("#leg-remove").hide(100);
        $('#bookName').prop('readonly', false);
        $('#auther').prop('readonly', false);
        $('#isbn').prop('readonly', false);
    }
});

$("#btnProcess").click(function () {
    if ($('input[name=operation]:checked').val() == "New Book") {
        var ajaxConfigure = {
            type: "POST",
            url: "BookController",
            async: true,
            data: $("#bookForm").serialize()
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    if (response.toString() == "true") {
                        swal("Success!", "New Book Added Successfully!", "success");
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
    if ($('input[name=operation]:checked').val() == "Update Book") {
        var queryString = "bookName=" + encodeURIComponent($("#bookName").val()) + "&" + "auther=" + encodeURIComponent($("#auther").val()) + "&" + "isbn=" + encodeURIComponent($("#isbn").val());
        var ajaxConfigure = {
            type: "PUT",
            url: "BookController?" + queryString,
            async: true,
            data: ""
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    console.log(response);
                    if (response.toString() == "true") {
                        swal("Success!", "New Book Updated Successfully!", "success");
                        getAllData();
                    }
                    if (response.toString() == "") {
                        swal("Error!", "Operation Not Successfull!", "error");
                    }
                })
                .fail(function (response) {
                    swal("Success!", "New Book Updated Successfully!", "success");
                    getAllData();
                });
    }

    if ($('input[name=operation]:checked').val() == "Remove Book") {
        var queryString = "bookName=" + encodeURIComponent($("#bookName").val());
        var ajaxConfigure = {
            type: "DELETE",
            url: "BookController?" + queryString,
            async: true,
            data: ""
        };
        $.ajax(ajaxConfigure)
                .done(function (response) {
                    if (response.toString() == "true") {
                        swal("Success!", "New Book Updated Successfully!", "success");
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
    $("#bookName").val("");
    $("#auther").val("");
    $("#isbn").val("");
});

getAllData();

function getAllData() {
    var ajaxConfigure = {
        type: "GET",
        url: "BookController",
        async: true,
        data: ""
    };
    $.ajax(ajaxConfigure)
            .done(function (response) {
                $("#table tbody").empty();
                var html;
                for (var i = 0; i < response.length; i++) {
                    html += "<tr><td class='txt-cntr'>" + response[i].bookName + "</td><td class='txt-cntr'>" + response[i].auther + "</td><td class='txt-cntr'>" + response[i].isbn + "</td><td class='tbl-row txt-cntr'><a>Edit</a></td></tr>";
                }
                $("#table tbody").append(html);
            })
            .fail(function (response) {
                console.log(response);
            });
}
$('#table tbody').on('click', 'td.tbl-row', function () {
    var rowData = $(this).parent().children(":lt(3)").map(function () {
        return $(this).text();
    });
    for (var i = 0; i < 1; i++) {
        console.log(rowData[i]);
        console.log(rowData[i + 1]);
        $("#bookName").val(rowData[i]);
        $("#auther").val(rowData[i + 1]);
        $("#isbn").val(rowData[i + 2]);
    }
});

