/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {
    var val = $("#keChengCategory").attr("value")
    $("#keChengCategory").val(val);

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;

    $("#keChengCategory").focusout(function () {

        if ($("#keChengCategory option:selected").val().length == 0) {
            $("#keChengCategory").next().text("请选择所属课程!");
            $("#keChengCategory").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#keChengCategory").next().css("display", "none");
            b_validate_result1 = true;
        }

    });

    $("#jinJia").focusout(function () {

        var numReg = /^\+?[1-9][0-9]*$/i;
        if ( !numReg.test($("#jinJia").val()) ) {
            $("#jinJia").next().text("非数字,不合法!");
            $("#jinJia").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#capacity").next().css("display", "none");
            b_validate_result2 = true;
        }


    });

    $("#shouJia").focusout(function () {

        var numReg = /^\+?[1-9][0-9]*$/i;
        if ( !numReg.test($("#shouJia").val()) ) {
            $("#shouJia").next().text("非数字,不合法!");
            $("#shouJia").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#capacity").next().css("display", "none");
            b_validate_result3 = true;
        }
    });




    $("#update").click(function () {

        $("#keChengCategory").focus();
        $("#jinJia").focus();
        $("#shouJia").focus();
 
        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 ;
        if (!b_validate_result) {

            return;
        }

        var url = "/updateJiaoCaiZaFei";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#jiaoCaiZaFei_id").val(),
                name: $("#name").val(),
                kecheng_category: $("#keChengCategory option:selected").val(),
                jin_jia: $("#jinJia").val(),
                shou_jia: $("#shouJia").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $("#myform")[0].reset();
                    $("#successLabel").show();
                    $("#backBtn").show();
                    $("#submitAreaDiv").empty();
                    $("#formdiv").empty();
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
        $("#jiaoCaiZaFeiGuanLi").click();

    });

    $("#classroomguanlibread").click(function () {
        $("#jiaoCaiZaFeiGuanLi").click();

    });

    $("#backBtn").click(function () {
        $("#jiaoCaiZaFeiGuanLi").click();

    });



});

