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

    $("#school_name").focusout(function () {

        if ($("#school_name").val().length < 2) {
            $("#school_name").next().text("校区名称小于2个字符，不合法!");
            $("#school_name").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#school_name").next().css("display", "none");
            b_validate_result2 = true;
        }


    });

    $("#capacity").focusout(function () {



        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#capacity").val()) ) {
            $("#capacity").next().text("非数字,不合法!");
            $("#capacity").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#capacity").next().css("display", "none");
            b_validate_result3 = true;
        }


    });
    $("#address").focusout(function () {

        if ($("#address").val().length < 2) {
            $("#address").next().text("地址信息小于2个字符，不够详细!");
            $("#address").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#address").next().css("display", "none");
            b_validate_result4 = true;
        }


    });
    $("#note").focusout(function () {

        if ($("#note").val().length < 2) {
            $("#note").next().text("备注信息小于2个字符，不合法!");
            $("#note").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#note").next().css("display", "none");
            b_validate_result5 = true;
        }


    });




    $("#save").click(function () {



        $("#name").focus();
        $("#school_name").focus();
        $("#capacity").focus();
        $("#address").focus();
        $("#note").focus();
        $("#name").focus();



        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4 &b_validate_result5;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertClassroom";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                name: $("#name").val(),
                school_name: $("#school_name").val(),
                capacity: $("#capacity").val(),
                address: $("#address").val(),
                note: $("#note").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
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


    $("#createAgainBtn").click(function () {

        $.ajax({
            type: "GET",
            url: "/xiaobao/createClassroom",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });
    });




    $("#backToListBtn").click(function () {
        $("#classroomguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#classroomguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#classroomguanli").click();

    });








});

