/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;


    $("#username").focusout(function () {
        if ($("#username").val().length < 2) {
            $("#username").next().text("请输入正确的用户名");
            $("#username").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#username").next().css("display", "none");
            b_validate_result1 = true;
        }
    });

    $("#password").focusout(function () {
        if ($("#password").val().length < 2) {
            $("#password").next().text("请输入正确的密码");
            $("#password").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#password").next().css("display", "none");
            b_validate_result2 = true;
        }
    });



    $("#login").click(function () {



        $("#username").focus();
        $("#password").focus();
        $("#username").focus();



        b_validate_result = b_validate_result1 & b_validate_result2 ;
        if (!b_validate_result) {
            return;
        }

        var url = "/processLogin";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                username: $("#username").val(),
                password: $("#password").val()


            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#loginResult").css("display:block");

                    window.location.href = "/";

                }
                else {
                    $("#loginResult").text("登录失败,用户名或密码不正确！");
                    $("#loginResult").css({"display": "block", "color": "red"});

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
            url: "/xiaobao/createBaoMing",
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
        $("#baomingguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#baomingguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#baomingguanli").click();

    });








});

