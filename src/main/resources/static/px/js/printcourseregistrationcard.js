$(function () {
    $(".btnPrint").click(function () {
        $(this).parents(".classPermit").children(".printDataDiv").printArea();
    });

    $("#back").click(function () {
        window.location.href = "StudentDetail.html";
    });
});