/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;
    var b_validate_result5 = true;
    var b_validate_result6 = true;


    $("#school_name").focusout(function () {

        if ($("#school_name").val().length < 4) {
            $("#school_name").next().text("学校名称小于4个字符，不合法!");
            $("#school_name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#school_name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });



    $("#type").focusout(function () {
        if ($("#type").val().length < 2) {
            $("#type").next().text("校区类型不合法");
            $("#type").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#type").next().css("display", "none");
            b_validate_result2 = true;
        }

    });


    $("#principal_name").focusout(function () {
        if ($("#principal_name").val().length < 2) {
            $("#principal_name").next().text("校长姓名不合法");
            $("#principal_name").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#principal_name").next().css("display", "none");
            b_validate_result3 = true;
        }

    });



    $("#principal_sfz_code").focusout(function () {

        var telReg = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
        if (!telReg.test($("#principal_sfz_code").val())) {
            $("#principal_sfz_code").next().text("身份证号码不正确");
            $("#principal_sfz_code").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#principal_sfz_code").next().css("display", "none");
            b_validate_result4 = true;
        }

    });


    $("#phone").focusout(function () {
        if ($("#phone").val().length < 5) {
            $("#phone").next().text("电话号码不正确");
            $("#phone").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#phone").next().css("display", "none");
            b_validate_result5 = true;
        }

    });



    $("#address").focusout(function () {
        if ($("#address").val().length < 3) {
            $("#address").next().text("地址信息不够详细");
            $("#address").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#address").next().css("display", "none");
            b_validate_result6 = true;
        }

    });





    $("#save").click(function () {

        $("#school_name").focus();
        $("#type").focus();
        $("#principal_name").focus();
        $("#principal_sfz_code").focus();
        $("#phone").focus();
        $("#address").focus();
        $("#school_name").focus();

        b_validate_result = b_validate_result1 && b_validate_result2 && b_validate_result3
            && b_validate_result4 && b_validate_result5 && b_validate_result6;
        if (!b_validate_result) {
            return;
        }

        var url = "/px/insertSchool";
        $.ajax({
            type: "post",
            async: false,
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                school_name: $("#school_name").val(),
                type: $("#type").val(),
                principal_name: $("#principal_name").val(),
                principal_sfz_code: $("#principal_sfz_code").val(),
                phone: $("#phone").val(),
                address: $("#address").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $('#myModal').modal('hide')
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


});

