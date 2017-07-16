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
    var b_validate_result7 = true;
    var b_validate_result8 = true;
    var b_validate_result9 = true;
    var b_validate_result10 = true;


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

    $("#shangke_start_date").focusout(function () {

        if ($("#shangke_start_date").val().length < 2) {
            $("#shangke_start_date").next().text("地址信息小于2个字符，不够详细!");
            $("#shangke_start_date").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#shangke_start_date").next().css("display", "none");
            b_validate_result3 = true;
        }


    });


    $("#shangke_end_date").focusout(function () {

        if ($("#shangke_end_date").val().length < 2) {
            $("#shangke_end_date").next().text("地址信息小于2个字符，不够详细!");
            $("#shangke_end_date").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#shangke_end_date").next().css("display", "none");
            b_validate_result4 = true;
        }


    });
    $("#jiaoshi_keshi").focusout(function () {

        if ($("#jiaoshi_keshi").val().length < 2) {
            $("#jiaoshi_keshi").next().text("备注信息小于2个字符，不合法!");
            $("#jiaoshi_keshi").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#jiaoshi_keshi").next().css("display", "none");
            b_validate_result5 = true;
        }


    });

    $("#teacher_name").focusout(function () {

        if ($("#teacher_name").val().length < 2) {
            $("#teacher_name").next().text("备注信息小于2个字符，不合法!");
            $("#teacher_name").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#teacher_name").next().css("display", "none");
            b_validate_result6 = true;
        }


    });

    $("#teacher_sfzCode").focusout(function () {

        if ($("#teacher_sfzCode").val().length < 2) {
            $("#teacher_sfzCode").next().text("备注信息小于2个字符，不合法!");
            $("#teacher_sfzCode").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#teacher_sfzCode").next().css("display", "none");
            b_validate_result6 = true;
        }


    });

    $("#assist_teacher_name").focusout(function () {

        if ($("#assist_teacher_name").val().length < 2) {
            $("#assist_teacher_name").next().text("备注信息小于2个字符，不合法!");
            $("#assist_teacher_name").next().css({"display": "block", "color": "red"});
            b_validate_result7 = false;
        } else {
            $("#assist_teacher_name").next().css("display", "none");
            b_validate_result7 = true;
        }


    });

    $("#assist_teacher_sfzCode").focusout(function () {

        if ($("#assist_teacher_sfzCode").val().length < 2) {
            $("#assist_teacher_sfzCode").next().text("备注信息小于2个字符，不合法!");
            $("#assist_teacher_sfzCode").next().css({"display": "block", "color": "red"});
            b_validate_result8 = false;
        } else {
            $("#assist_teacher_sfzCode").next().css("display", "none");
            b_validate_result8 = true;
        }


    });
    $("#shangke_content").focusout(function () {

        if ($("#shangke_content").val().length < 2) {
            $("#shangke_content").next().text("备注信息小于2个字符，不合法!");
            $("#shangke_content").next().css({"display": "block", "color": "red"});
            b_validate_result9 = false;
        } else {
            $("#shangke_content").next().css("display", "none");
            b_validate_result9 = true;
        }


    });

    $("#shangke_note").focusout(function () {

        if ($("#shangke_note").val().length < 2) {
            $("#shangke_note").next().text("备注信息小于2个字符，不合法!");
            $("#shangke_note").next().css({"display": "block", "color": "red"});
            b_validate_result10 = false;
        } else {
            $("#shangke_note").next().css("display", "none");
            b_validate_result10 = true;
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

                var data3= data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");
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

