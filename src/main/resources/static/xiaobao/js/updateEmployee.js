/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    $('#birthday').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: 'month',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮

    });


    $('#employ_start_date').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: 'month',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮

    });

    $('#employ_end_date').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: 'month',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true//显示今日按钮
    });


    $('#zhuanzheng_date').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: 'month',
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


$("#update").click(function () {


    $("#name").focus();
    $("#phone").focus();
    $("#sfzCode").focus();
    $("#name").focus();


    b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3;
    if (!b_validate_result) {

        return;
    }

    var url = "/updateEmployee";
    $.ajax({
        type: "post",
        url: url,
        /**     * 关键点：获取post请求的参数，有2个关键点：
         * 1、java接口需要加上@RequestBody这个注解.
         * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
         * */
        data: JSON.stringify({
            id: $("#id").val(),
            name: $("#name").val(),
            phone: $("#phone").val(),
            sfzCode: $("#sfzCode").val(),
            xiaoqu_name: $("#xiaoqu_name").val(),
            gender: $("#gender").val(),
            birthday: !$("#birthday").val() ? null : $("#birthday").val() + " 00:00:00",
            english_name: $("#english_name").val(),
            email: $("#email").val(),
            ji_guan: $("#ji_guan").val(),
            nationality: $("#nationality").val(),
            zhengzhi_mianmao: $("#zhengzhi_mianmao").val(),
            is_married: $("#is_married").val(),
            biye_yuanxiao: $("#biye_yuanxiao").val(),
            zhuanye: $("#zhuanye").val(),
            xueli: $("#xueli").val(),
            peixun_jingli: $("#peixun_jingli").val(),
            renshi_zhuangtai: $("#renshi_zhuangtai").val(),
            employ_start_date: !$("#employ_start_date").val() ? null : $("#employ_start_date").val() + " 00:00:00",
            employ_end_date: !$("#employ_end_date").val() ? null : $("#employ_end_date").val() + " 00:00:00",
            laodong_guanxi: $("#laodong_guanxi").val(),
            zhuanzheng_date: !$("#zhuanzheng_date").val() ? null : $("#zhuanzheng_date").val() + " 00:00:00",
            bank_card: $("#bank_card").val(),
            bank: $("#bank").val()
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
                $("#backBtn").show();


                //隐藏
                $("#submitAreaDiv").empty();
                $("#formdiv").empty();
                $("#formdiv2").empty();
                $("#formdiv3").empty();

            }
            else {
                alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("系统异常！");
        }
    });


});

$("#formBackBtn").click(function () {
    $("#employeeguanli").click();

});

$("#classroomguanlibread").click(function () {
    $("#employeeguanli").click();

});

$("#backBtn").click(function () {
    $("#employeeguanli").click();

});



