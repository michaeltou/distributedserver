/**
 * Created by Huangqijun on 2017/7/19.
 */


$(document).ready(function () {
    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    $("#oldPassword").focusout(function () {

        $.ajax({
            url: "/queryUserPasswordByUserNameAndPasswordForAccountSetting",
            type: "GET",
            data: {
                password: $("#oldPassword").val()
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    $("#oldPassword").next().css("display", "none");
                    b_validate_result1 = true;
                }
                else {
                    $("#oldPassword").next().text("密码错误.");
                    $("#oldPassword").next().css({"display": "block", "color": "red"});
                    b_validate_result1 = false;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });//ajax

    });

    $("#newPassword").focusout(function () {

        if ($("#newPassword").val().length < 6) {
            $("#newPassword").next().text("密码长度不能小于6位!");
            $("#newPassword").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#newPassword").next().css("display", "none");
            b_validate_result2 = true;
        }
    });

    $("#confirmNewPassword").focusout(function () {

        if ($("#newPassword").val() !=  $("#confirmNewPassword").val()) {
            $("#confirmNewPassword").next().text("两次输入的密码不一致!");
            $("#confirmNewPassword").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#confirmNewPassword").next().css("display", "none");
            b_validate_result3 = true;
        }
    });

    $("#save").click(function () {

        $("#oldPassword").focus();
        $("#newPassword").focus();
        $("#confirmNewPassword").focus();
        $("#oldPassword").focus();

        b_validate_result = b_validate_result1 && b_validate_result2 && b_validate_result3;
        if (!b_validate_result) {
            return;
        }

        var url = "/updatePassword";
        $.ajax({
            type: "get",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: {
                oldPassword:$("#oldPassword").val(),
                newPassword:$("#newPassword").val()

            },
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv").empty();

                }
                else {
                    $("#failLabel").css("display:block");
                    //  alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });


    });

    $("#backToListBtn").click(function () {
        $("#zhanghuguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#zhanghuguanli").click();

    });

});

