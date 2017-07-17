/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {



    $('#shangke_start_date').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮

    });

    $('#shangke_end_date').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮
    });


    
    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;
    var b_validate_result5 = true;
    var b_validate_result6 = true;
    var b_validate_result7 = true;
    var b_validate_result8 = true;
    var b_validate_result9 = true;



    $("#banji_name").focusout(function () {

        if ($("#banji_name").val().length < 2) {
            $("#banji_name").next().text("班级名称小于2个字符，不合法!");
            $("#banji_name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#banji_name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

    $("#xiaoqu_name").focusout(function () {

        if ($("#xiaoqu_name").val().length < 2) {
            $("#xiaoqu_name").next().text("校区名称小于2个字符，不合法!");
            $("#xiaoqu_name").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#xiaoqu_name").next().css("display", "none");
            b_validate_result2 = true;
        }


    });

    $("#shangke_start_date").change(function () {


        var telReg = /(\d{4}-\d{2}-\d{2}\d{2}:\d{2}:\d{2})|(\d{2}-\d{2}\d{2}:\d{2}:\d{2})|(\d{2}:\d{2}:\d{2})/;
        if ( !telReg.test($("#shangke_start_date").val()) ) {

            $("#shangke_start_date").next().text("时间格式有误!正确时间格式为yyyy-mm-dd hh:ii:ss");
            $("#shangke_start_date").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#shangke_start_date").next().css("display", "none");
            b_validate_result3 = true;
        }


    });


    $("#shangke_end_date").change(function () {
        var telReg = /(\d{4}-\d{2}-\d{2}\d{2}:\d{2}:\d{2})|(\d{2}-\d{2}\d{2}:\d{2}:\d{2})|(\d{2}:\d{2}:\d{2})/;
        if ( !telReg.test($("#shangke_end_date").val()) ) {
            $("#shangke_end_date").next().text("时间格式有误!正确时间格式为yyyy-mm-dd hh:ii:ss");
            $("#shangke_end_date").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#shangke_end_date").next().css("display", "none");
            b_validate_result4 = true;
        }


    });
    $("#jiaoshi_keshi").focusout(function () {

        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#jiaoshi_keshi").val()) ) {
            $("#jiaoshi_keshi").next().text("非数字,不合法!");
            $("#jiaoshi_keshi").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#jiaoshi_keshi").next().css("display", "none");
            b_validate_result5 = true;
        }


    });

    $("#teacher_name").focusout(function () {

        if ($("#teacher_name").val().length < 2) {
            $("#teacher_name").next().text("教师姓名小于2个字符，不合法!");
            $("#teacher_name").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#teacher_name").next().css("display", "none");
            b_validate_result6 = true;
        }


    });

    $("#teacher_sfzCode").focusout(function () {

        if ($("#teacher_sfzCode").val().length < 2) {
            $("#teacher_sfzCode").next().text("身份证信息小于2个字符，不合法!");
            $("#teacher_sfzCode").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#teacher_sfzCode").next().css("display", "none");
            b_validate_result6 = true;
        }


    });
/*
    $("#assist_teacher_name").focusout(function () {
        if ($("#assist_teacher_name").val().length < 2) {
            $("#assist_teacher_name").next().text("助教姓名小于2个字符，不合法!");
            $("#assist_teacher_name").next().css({"display": "block", "color": "red"});
            b_validate_result7 = false;
        } else {
            $("#assist_teacher_name").next().css("display", "none");
            b_validate_result7 = true;
        }

    });

    $("#assist_teacher_sfzCode").focusout(function () {

        if ($("#assist_teacher_sfzCode").val().length < 2) {
            $("#assist_teacher_sfzCode").next().text("助教身份证信息小于2个字符，不合法!");
            $("#assist_teacher_sfzCode").next().css({"display": "block", "color": "red"});
            b_validate_result8 = false;
        } else {
            $("#assist_teacher_sfzCode").next().css("display", "none");
            b_validate_result8 = true;
        }


    });*/
    $("#shangke_content").focusout(function () {

        if ($("#shangke_content").val().length < 10) {
            $("#shangke_content").next().text("上课内容小于10个字符，不合法!");
            $("#shangke_content").next().css({"display": "block", "color": "red"});
            b_validate_result9 = false;
        } else {
            $("#shangke_content").next().css("display", "none");
            b_validate_result9 = true;
        }


    });





    $("#save").click(function () {

        $("#banji_name").focus();
        $("#xiaoqu_name").focus();
        $("#shangke_start_date").change();
        $("#shangke_end_date").change();
        $("#jiaoshi_keshi").focus();
        $("#teacher_name").focus();
        $("#teacher_sfzCode").focus();
        $("#assist_teacher_name").focus();
        $("#assist_teacher_sfzCode").focus();
        $("#shangke_content").focus();
        $("#shangke_note").focus();
        $("#shangke_pic_list").focus();
        $("#banji_name").focus();


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4
            &b_validate_result5&b_validate_result6&b_validate_result7&b_validate_result8&b_validate_result9;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertClassRecord";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                banji_name: $("#banji_name").val(),
                xiaoqu_name: $("#xiaoqu_name").val(),
                shangke_start_date: $("#shangke_start_date").val(),
                shangke_end_date: $("#shangke_end_date").val(),
                jiaoshi_keshi: $("#jiaoshi_keshi").val(),
                teacher_name: $("#teacher_name").val(),
                teacher_sfzCode: $("#teacher_sfzCode").val(),
                assist_teacher_name: $("#assist_teacher_name").val(),
                assist_teacher_sfzCode: $("#assist_teacher_sfzCode").val(),
                shangke_content: $("#shangke_content").val(),
                shangke_note: $("#shangke_note").val(),
                shangke_pic_list: $("#shangke_pic_list").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform")[0].reset();
                    $("#myform2")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv").empty();
                    $("#formdiv2").empty();

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
            url: "/xiaobao/createClassRecord",
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
        $("#createClassRecordMenu").click();

    });

    $("#formBackBtn").click(function () {
        $("#createClassRecordMenu").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#createClassRecordMenu").click();

    });








});

