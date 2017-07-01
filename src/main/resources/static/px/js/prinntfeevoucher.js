$(function () {
    $(".btnPrint").click(function () {
        $(this).parents(".feeVoucher").children(".printDataDiv").printArea();
    });

    $("#back").click(function () {
        window.location.href = "StudentDetail.html";
    });
});