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




    $("#save").click(function () {



        $("#kc_category_name").focus();
        $("#save").focus();
        $("#kc_category_name").focus();


        b_validate_result = b_validate_result1;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertKeChengCategory";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                kc_category_name: $("#kc_category_name").val()
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
            url: "/xiaobao/createKeChengCategory",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });
    });




    $("#backToListBtn").click(function () {
        $("#kechengleibieguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#kechengleibieguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#kechengleibieguanli").click();

    });








});

