$(function () {

    //自定义函数
    //=============================================
    $.extend({
        calculateTotalMoney: function () {
            var receivableMoney = 0;

            var refundAmount = $("#refundAmountText").val();
            refundAmount = parseInt(refundAmount);
            if(isNaN(refundAmount)){
                refundAmount = 0;
            }
            receivableMoney += refundAmount;

            var serviceChargeAmount = $("#serviceChargeAmountText").val();
            serviceChargeAmount = parseInt(serviceChargeAmount);
            if(isNaN(serviceChargeAmount)){
                serviceChargeAmount = 0;
            }
            receivableMoney -= serviceChargeAmount;

            var penaltyAmount = $("#penaltyAmountText").val();
            penaltyAmount = parseInt(penaltyAmount);
            if(isNaN(penaltyAmount)){
                penaltyAmount = 0;
            }

            receivableMoney -= penaltyAmount;
            $("#receivableMoneyText").text(-receivableMoney);

        }
    });


    $.extend({
        calculateReceivedMoney: function () {
            var receivedAmount = 0;
            var cash = $("#cashText").val();
            cash = parseInt(cash);
            if (isNaN(cash)) {
                cash = 0;
            }
            receivedAmount += cash;

            var transferAccountsMoney = $("#transferAccountsMoneyText").val();
            transferAccountsMoney = parseInt(transferAccountsMoney);
            if (isNaN(transferAccountsMoney)) {
                transferAccountsMoney = 0;
            }
            receivedAmount += transferAccountsMoney;
            $("#netReceiptsMoneyText").text(-receivedAmount);

        }
    });
    //=============================================


    //=============================================
    $.calculateReceivedMoney();

    $(".remark1").hide();

    $("#allRefund").attr("checked", "checked");
    $("#allRefund").click();
    $('input[type=radio]').button();
    $('input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });

    if($("#rechargeModeText").text() === "按课时"){
        $("#rechargeStandardText").text("XXX元/课时");
        $("#totalCourseCountTitle").text("总计课时:");
        $("#totalCourseCountText").text("XX课时");
        $("#surplusClassesTitle").text("剩余课时:");
        $("#surplusClassesText").text("XX课时");
    } else if($("#rechargeModeText").text() === "按时间"){
        $("#rechargeStandardText").text("XXX元/天");
        $("#totalCourseCountTitle").text("总计天数:");
        $("#totalCourseCountText").text("XX天");
        $("#surplusClassesTitle").text("剩余天数:");
        $("#surplusClassesText").text("XX天");
    } else if($("#rechargeModeText").text() === "按期"){
        $("#rechargeStandardText").text("XXX元/期");
        $("#totalCourseCountTitle").text("总计课时:");
        $("#totalCourseCountText").text("XX课时");
        $("#surplusClassesTitle").text("剩余课时:");
        $("#surplusClassesText").text("XX课时");
    }

    $("#allRefund").click(function () {
        $(".remark1").hide();
        $("#partRefund").prop("checked" ,false);
        $("#partRefund").removeAttr("checked");
        $("#allRefund").attr("checked", "checked");
        $("#refundAmountText").val("");
        $("#serviceChargeAmountText").val("");
        $("#penaltyAmountText").val("");
    });

    $("#partRefund").click(function () {
        $(".remark1").show();
        $("#allRefund").prop("checked" ,false);
        $("#allRefund").removeAttr("checked");
        $("#partRefund").attr("checked", "checked");
        $("#refundAmountText").val("");
        $("#serviceChargeAmountText").val("");
        $("#penaltyAmountText").val("");
    });

    $("#Save").click(function () {
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
        window.location.href = "PrinntFeeVoucher.html";
    });

    $("#Cancel").click(function () {
        window.location.href = "StudentDetail.html";
    });

    //退费金额变更事件
    $('#refundAmountText').change(function () {
        $.calculateTotalMoney();
    });

    //手续费变更事件
    $('#serviceChargeAmountText').change(function () {
        $.calculateTotalMoney();
    });

    //违约金变更事件
    $('#penaltyAmountText').change(function () {
        $.calculateTotalMoney();
    });

    //输入现金变更事件
    $('#cashText').change(function () {
        $.calculateReceivedMoney();
    });

    //输入转账变更事件
    $('#transferAccountsMoneyText').change(function () {
        $.calculateReceivedMoney();
    });
});

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;
    byId("employeeNameText").value = (tr.cells[0]).innerHTML;
    byId("employeePhoneText").value = (tr.cells[1]).innerHTML;
    var all_options = document.getElementById("schoolTypeText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[2]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }

        if (tr.cells[3].innerHTML == "女") {
            byId("female").click();
        } else {
            byId("male").click();
        }
    }
    byId("employeeAgeText").value = (tr.cells[4]).innerHTML;
}

function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

function byId(id) {
    return document.getElementById(id);
}

function load() {

}
