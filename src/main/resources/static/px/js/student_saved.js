$(function () {
    $(".btnPrint").click(function () {
        //$(".printDataDiv").printArea();
        if ($(this).parents(".feeVoucher").length > 0) {
            $(this).parents(".feeVoucher").children(".printDataDiv").printArea();
        } else if ($(this).parents(".classPermit").length > 0) {
            $(this).parents(".classPermit").children(".printDataDiv").printArea();
        }
    });

    $("#back").click(function () {
        //alert("");
        window.location.href = "/px/defaultStudentSerach";
    });
});