/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;


    $("#name").focusout(function () {
        if ($("#name").val().length < 2) {
            $("#name").next().text("教室名称小于2个字符，不合法!");
            $("#name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#name").next().css("display", "none");
            b_validate_result1 = true;
        }
    });


    var telReg = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
    if (!telReg.test($("#sfzCode").val())) {
        $("#sfzCode").next().text("身份证号码不正确");
        $("#sfzCode").next().css({"display": "block", "color": "red"});
        b_validate_result2 = false;
    } else {
        $("#sfzCode").next().css("display", "none");
        b_validate_result2 = true;
    }

    $("#banji_name").focusout(function () {

        if ($("#banji_name").val().length < 2) {
            $("#banji_name").next().text("班级名称小于2个字符，不合法!");
            $("#banji_name").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#banji_name").next().css("display", "none");
            b_validate_result3 = true;
        }
    });


    $("#chargeFee").focusout(function () {
        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#chargeFee").val()) ) {
            $("#chargeFee").next().text("非数字,不合法!");
            $("#chargeFee").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#chargeFee").next().css("display", "none");
            b_validate_result4 = true;
        }


    });




    $("#update").click(function () {

        $("#name").focus();
        $("#sfzCode").focus();
        $("#banji_name").focus();
        $("#chargeFee").focus();
        $("#name").focus();



        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4 ;
        if (!b_validate_result) {
            return;
        }

        var url = "/updateBaoMing";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val(),
                name: $("#name").val(),
                sfzCode: $("#sfzCode").val(),
                banji_name: $("#banji_name").val(),
                chargeFee: $("#chargeFee").val(),
                chageFeeNote: $("#chageFeeNote").val(),
                jiaocai_zafei_chargeFee: $("#jiaocai_zafei_chargeFee").val(),
                jiaocai_zafei_note: $("#jiaocai_zafei_note").val(),
                totalChargeFee: $("#totalChargeFee").val()

            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $("#myform")[0].reset();
                    $("#myform")[1].reset();

                    $("#successLabel").show();
                    $("#backBtn").show();
                    $("#submitAreaDiv").empty();

                    $("#formdiv").empty();
                    $("#formdiv2").empty();
                }
                else {
                    alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });


    });

    $("#formBackBtn").click(function () {
        $("#baomingguanli").click();

    });

    $("#classroomguanlibread").click(function () {
        $("#baomingguanli").click();

    });

    $("#backBtn").click(function () {
        $("#baomingguanli").click();

    });



});

