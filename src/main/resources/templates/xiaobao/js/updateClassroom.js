/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    var b_validate_result = true;
    var b_validate_result1 = true;
    $("#kc_category_name").focusout(function () {

        if ($("#kc_category_name").val().length < 2) {
            $("#kc_category_name").next().text("学校名称小于2个字符，不合法!");
            $("#kc_category_name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#kc_category_name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });



    $("#update").click(function () {

        $("#kc_category_name").focus();
        $("#update").focus();
        $("#kc_category_name").focus();

        b_validate_result = b_validate_result1 ;
        if (!b_validate_result) {
            return;
        }

        var url = "/updateChengCategory";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#keChengCategory_id").val(),
                kc_category_name: $("#kc_category_name").val()
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
        $("#kechengleibieguanli").click();

    });

    $("#xiaoquguanlibread").click(function () {
        $("#kechengleibieguanli").click();

    });

    $("#backBtn").click(function () {
        $("#kechengleibieguanli").click();

    });



});

