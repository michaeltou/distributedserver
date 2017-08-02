/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {



    $('#start_ban_ji_date').datetimepicker({
        format: 'yyyy-mm-dd',
        minView:'month',
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

    $("#kecheng_name").focusout(function () {

        if ($("#kecheng_name").val().length < 2) {
            $("#kecheng_name").next().text("课程名称小于2个字符，不合法!");
            $("#kecheng_name").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#kecheng_name").next().css("display", "none");
            b_validate_result3 = true;
        }

    });

    $("#pre_recruit_cnt").focusout(function () {

        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#pre_recruit_cnt").val()) ) {
            $("#pre_recruit_cnt").next().text("非数字,不合法!");
            $("#pre_recruit_cnt").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#pre_recruit_cnt").next().css("display", "none");
            b_validate_result4 = true;
        }


    });



    $("#start_ban_ji_date").change(function () {
        var telReg = /^(\d{4})\-(\d{2})\-(\d{2})$/;
        if ( !telReg.test($("#start_ban_ji_date").val()) ) {
            $("#start_ban_ji_date").next().text("时间格式有误!正确时间格式为yyyy-mm-dd");
            $("#start_ban_ji_date").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#start_ban_ji_date").next().css("display", "none");
            b_validate_result5 = true;
        }


    });



    $("#student_consume_keshi").focusout(function () {

        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#student_consume_keshi").val()) ) {
            $("#student_consume_keshi").next().text("非数字,不合法!");
            $("#student_consume_keshi").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#student_consume_keshi").next().css("display", "none");
            b_validate_result6 = true;
        }
    });


    $("#teacher_consume_keshi").focusout(function () {

        var telReg = /^\+?[1-9][0-9]*$/i;
        if ( !telReg.test($("#teacher_consume_keshi").val()) ) {
            $("#teacher_consume_keshi").next().text("非数字,不合法!");
            $("#teacher_consume_keshi").next().css({"display": "block", "color": "red"});
            b_validate_result7 = false;
        } else {
            $("#teacher_consume_keshi").next().css("display", "none");
            b_validate_result7 = true;
        }

    });



    $("#save").click(function () {

        $("#banji_name").focus();
        $("#school_name").focus();
        $("#kecheng_name").focus();
        $("#pre_recruit_cnt").focus();
        $("#start_ban_ji_date").change();
        $("#student_consume_keshi").focus();
        $("#teacher_consume_keshi").focus(); 
        $("#banji_name").focus();


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4
            &b_validate_result5&b_validate_result6&b_validate_result7;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertBanJi";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                banji_name: $("#banji_name").val(),
                school_name: $("#school_name").val(),
                kecheng_name: $("#kecheng_name").val(),
                pre_recruit_cnt: $("#pre_recruit_cnt").val(),
                start_ban_ji_date: !$("#start_ban_ji_date").val()?null:$("#start_ban_ji_date").val()+" 00:00:00",
                student_consume_keshi: $("#student_consume_keshi").val(),
                teacher_consume_keshi: $("#teacher_consume_keshi").val(),
                teacher: $("#teacher").val(),
                teacherSFZCode: $("#teacherSFZCode").val(),
                note: $("#note").val()

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
            url: "/xiaobao/createBanJi",
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
        $("#banjiguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#banjiguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#banjiguanli").click();

    });








});

