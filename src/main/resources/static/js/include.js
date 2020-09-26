$(function () {
    $.get("main-sidebar.html",function (data) {
        $("#main-sidebar").html(data);
    });
});