/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    $.ajax({
        url: "/querySRDaLeiListByInstitution",
        type: "POST",
        data: "",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus) {
            if (data.success) {
                // alert(JSON.stringify(data)); 调试使用，请勿删除

                //清空当前表格
                //   document.getElementById("mytablebody").innerHTML = '';

                //清空下拉列表框
                $("#daLeiName").empty();

                //动态构建表格数据.
                $.each(data.data, function (id, shouRuDaLei) {
                    var $option = $("<option ></option>");
                    $option.val(shouRuDaLei.name);
                    $option.html(shouRuDaLei.name);

                    $option.appendTo($("#daLeiName"));


                });//each
            }
            else {
                alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("系统异常！");
        }
    });//ajax

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;

    $("#name").focusout(function () {

        if ($("#name").val().length < 2) {
            $("#name").next().text("收入小类名称小于2个字符，不合法!");
            $("#name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#name").next().css("display", "none");
            b_validate_result1 = true;
        }

    });

    $("#daLeiName").focusout(function () {

        if ($("#daLeiName option:selected").val().length == 0) {
            $("#daLeiName").next().text("请选择收入大类!");
            $("#daLeiName").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#daLeiName").next().css("display", "none");
            b_validate_result2 = true;
        }

    });


    $("#save").click(function () {

        $("#name").focus();
        $("#daLeiName").focus();

        b_validate_result = b_validate_result1 && b_validate_result2 ;

        if (!b_validate_result) {
            return;
        }

        var url = "/insertSRXiaoLei";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                name: $("#name").val(),
                daLeiName:$("#daLeiName option:selected").val()
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
            url: "/xiaobao/createSRXiaoLei",
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
        $("#shouRuXiaoLeiguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#shouRuXiaoLeiguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#shouRuXiaoLeiguanli").click();

    });








});

