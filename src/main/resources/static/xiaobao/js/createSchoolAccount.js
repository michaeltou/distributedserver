/**
 * Created by Huangqijun on 2017/7/17.
 */


$(document).ready(function () {

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;

    $("#accountName").focusout(function () {

        if ($("#accountName").val().length < 2) {
            $("#accountName").next().text("账户名称小于2个字符，不合法!");
            $("#accountName").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#accountName").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

    $("#accountCode").focusout(function () {

        if ($("#accountCode").val().length < 2) {
            $("#accountCode").next().text("账户小于2个字符，不合法!");
            $("#accountCode").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#accountCode").next().css("display", "none");
            b_validate_result2 = true;
        }

    });


    $("#bank").focusout(function () {

        if ($("#bank").val().length < 2) {
            $("#bank").next().text("开户行小于2个字符，不合法!");
            $("#bank").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#bank").next().css("display", "none");
            b_validate_result3 = true;
        }
    });

    $("#save").click(function () {

        $("#accountName").focus();
        $("#accountCode").focus();
        $("#bank").focus();
        $("#accountName").focus();

        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 ;
        if (!b_validate_result) {
            return;
        }

        var status = "";
        if($("input[type='radio']").eq(0).is(":checked")){
            status = $("input[type='radio']").eq(0).val();
        }else {
            status = $("input[type='radio']").eq(1).val();
        }

        var url = "/insertSchoolAccount";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                accountName: $("#accountName").val(),
                accountCode: $("#accountCode").val(),
                bank: $("#bank").val(),
                status: status
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
            url: "/xiaobao/createSchoolAccount",
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
        $("#schoolAccountguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#schoolAccountguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#schoolAccountguanli").click();

    });








});

