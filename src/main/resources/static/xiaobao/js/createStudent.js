/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    $('#birthday').datetimepicker({
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

    $("#name").focusout(function () {

        if ($("#name").val().length < 2) {
            $("#name").next().text("姓名小于2个字符，不合法!");
            $("#name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

    $("#phone").focusout(function () {

        if ($("#phone").val().length < 2) {
            $("#phone").next().text("电话不合法!");
            $("#phone").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#phone").next().css("display", "none");
            b_validate_result2 = true;
        }
    });

    $("#sfzCode").focusout(function () {
        var telReg = /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i;
        if (!telReg.test($("#sfzCode").val())) {
            $("#sfzCode").next().text("身份证号码不正确");
            $("#sfzCode").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#sfzCode").next().css("display", "none");
            b_validate_result3 = true;
        }

    });






    $("#save").click(function () {



        $("#name").focus();
        $("#sfzCode").focus();
        $("#phone").focus();
        $("#name").focus();



        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertStudent";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                name: $("#name").val(),
                sfzCode: $("#sfzCode").val(),
                phone: $("#phone").val(),
                gender: $("#gender").val(),
                birthday: !$("#birthday").val()?null:$("#birthday").val(),
                motherPhone: $("#motherPhone").val(),
                fatherPhone: $("#fatherPhone").val(),
                address: $("#address").val(),
                email: $("#email").val(),
                weixinhao: $("#weixinhao").val(),
                qq: $("#qq").val(),
                qudao_source: $("#qudao_source").val(),
                header_image_url: $("#header_image_url").val(),
                current_school_level: $("#current_school_level").val(),
                current_school_grade: $("#current_school_grade").val(),
                jiguan: $("#jiguan").val(),
                minzu: $("#minzu").val(),
                zheng_zhi_mian_miao: $("#zheng_zhi_mian_miao").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform")[0].reset();
                    $("#myform2")[0].reset();
                    $("#myform3")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv").empty();
                    $("#formdiv2").empty();
                    $("#formdiv3").empty();

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
            url: "/xiaobao/createStudent",
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
        $("#studentguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#studentguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#studentguanli").click();

    });


});
