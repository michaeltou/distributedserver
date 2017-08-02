/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    //updateAll();
    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;

    $("#title").focusout(function () {

        if ($("#title").val().length < 2) {
            $("#title").next().text("通知标题小于2个字符，不合法!");
            $("#title").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#title").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

    $("#school").focusout(function () {

        if ($("#school option:selected").val() == undefined ||
            $("#school option:selected").val().length == 0) {
            $("#school").next().text("请选择通知校区!");
            $("#school").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#school").next().css("display", "none");
            b_validate_result2 = true;
        }


    });

    $("#preview").focusout(function () {

        if ($("#preview").val().length < 2) {
            $("#preview").next().text("通知内容小于2个字符，不合法!");
            $("#preview").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#preview").next().css("display", "none");
            b_validate_result3 = true;
        }


    });

    $("#save").click(function () {

        $("#title").focus();
        $("#preview").focus();
        $("#type").focus();

        b_validate_result = b_validate_result1 & b_validate_result2& b_validate_result3;
        if (!b_validate_result) {
            return;
        }


        var url = "/insertSchoolNotice";
        var istop = $("#isTop").is(":checked")?1:0;
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                notice_type: $("#type option:selected").val(),
                notice_title: $("#title").val(),
                notice_content: $("#preview").val(),
                notice_school: $("#school option:selected").val(),
                is_top:istop,
                publisher:"",

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
            url: "/xiaobao/createSchoolNotice",
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
        $("#schoolNoticeguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#schoolNoticeguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#schoolNoticeguanli").click();
    });







});

function updateAll() {
    var arrVar = [], sVar, sJSInit, sInit;
    var textareaID = "elem1";
    var editor = $('textarea[name=preview]')[0].editor;
   /* if (editor) editor.getSource();*/
    $('textarea[name=preview]').attr('id', textareaID).xheditor(false);
    sJSInit = "$('#" + textareaID + "').xheditor(" + (sVar ? '{' + sVar + '}' : '') + ');';
    if ($('#editorMode').val() == 1) {
        sInit = ' class="xheditor' + (sVar ? ' {' + sVar + '}' : '') + '"';
        sInit = sInit.replace(/(.+?xheditor)(.+?)tools:'(simple|mini)',?(.+?)/i, '$1-$3$2$4');
    }
    else sInit = sJSInit;
    $('link[id^=xheCSS]').remove();
    try {
        eval(sJSInit);
    } catch (e) {
    }
    $('#source').val(sInit);
}

