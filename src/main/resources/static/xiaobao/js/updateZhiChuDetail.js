/**
 * Created by Huangqijun on 2017/7/20.
 */


$(document).ready(function () {

    $("#handingSchoolName").val($("#handingSchoolName").attr("value"));
    $("#zhiChuDaLeiName").val($("#zhiChuDaLeiName").attr("value"));
    $("#zhiChuAccountName").val($("#zhiChuAccountName").attr("value"));
    function initialXiaoLeiList() {
        $.ajax({
            url: "/queryZCXiaoLeiListByDaLeiName",
            async: false,           //同步
            type: "GET",
            data: {daLeiName: $("#zhiChuDaLeiName option:selected").val()},
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空下拉列表框
                    $("#zhiChuXiaoLeiName").empty();

                    //动态构建表格数据.
                    $.each(data.data, function (id, zhiChuXiaoLei) {
                        var $option = $("<option ></option>");
                        $option.val(zhiChuXiaoLei.name);
                        $option.html(zhiChuXiaoLei.name);

                        $option.appendTo($("#zhiChuXiaoLeiName"));


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
    }
    initialXiaoLeiList();

    $("#zhiChuXiaoLeiName").val($("#zhiChuXiaoLeiName").attr("value"));
    $('#handingDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });



    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;
    var b_validate_result5 = true;
    var b_validate_result6 = true;

    $("#zhiChuDaLeiName").change(function () {
        initialXiaoLeiList();
    });

    $("#handingSchoolName").focusout(function () {

        if ($("#handingSchoolName option:selected").val() == undefined ||
            $("#handingSchoolName option:selected").val().length == 0) {
            $("#handingSchoolName").next().text("请选择校区!");
            $("#handingSchoolName").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#handingSchoolName").next().css("display", "none");
            b_validate_result1 = true;
        }
    });

    $("#handingDate").focusout(function () {

        if ($("#handingDate").val().length == 0) {
            $("#handingDate").next().text("请选择经办日期!");
            $("#handingDate").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#handingDate").next().css("display", "none");
            b_validate_result2 = true;
        }
    });

    $("#zhiChuDaLeiName").focusout(function () {

        if ($("#zhiChuDaLeiName option:selected").val() == undefined ||
            $("#zhiChuDaLeiName option:selected").val().length == 0) {
            $("#zhiChuDaLeiName").next().text("请选择支出大类!");
            $("#zhiChuDaLeiName").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#zhiChuDaLeiName").next().css("display", "none");
            b_validate_result3 = true;
        }


    });

    $("#zhiChuXiaoLeiName").focusout(function () {

        if ($("#zhiChuXiaoLeiName option:selected").val() == undefined ||
            $("#zhiChuXiaoLeiName option:selected").val().length == 0) {
            $("#zhiChuXiaoLeiName").next().text("请选择支出小类!");
            $("#zhiChuXiaoLeiName").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#zhiChuXiaoLeiName").next().css("display", "none");
            b_validate_result4 = true;
        }


    });

    $("#zhiChuAccountName").focusout(function () {

        if ($("#zhiChuAccountName option:selected").val() == undefined ||
            $("#zhiChuAccountName option:selected").val().length == 0) {
            $("#zhiChuAccountName").next().text("请选择支出账户!");
            $("#zhiChuAccountName").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#zhiChuAccountName").next().css("display", "none");
            b_validate_result5 = true;
        }

    });


    $("#amount").focusout(function () {

        var numReg = /^\+?[1-9][0-9]*$/i;
        if ( !numReg.test($("#amount").val()) ) {
            $("#amount").next().text("非数字,不合法!");
            $("#amount").next().css({"display": "block", "color": "red"});
            b_validate_result6 = false;
        } else {
            $("#amount").next().css("display", "none");
            b_validate_result6 = true;
        }


    });





    $("#update").click(function () {

        $("#handingSchoolName").focus();

        if($("#handingDate").val().length == 0){
            $("#handingDate").focus();
            b_validate_result2 = false;
        }else {
            b_validate_result2 = true;
        }

        $("#zhiChuDaLeiName").focus();

        $("#zhiChuXiaoLeiName").focus();

        $("#zhiChuAccountName").focus();

        $("#amount").focus();

        $("#note").focus();


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4 & b_validate_result5 & b_validate_result6 ;
        if (!b_validate_result) {
            return;
        }

        var url = "/updateShouZhiDetail";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id:$("#id").val(),
                handingSchool: $("#handingSchoolName option:selected").val(),
                handingDate: $("#handingDate").val()+" 00:00:00",
                shou_zhi_da_lei: $("#zhiChuDaLeiName option:selected").val(),
                shou_zhi_xiao_lei: $("#zhiChuXiaoLeiName option:selected").val(),
                accountName: $("#zhiChuAccountName option:selected").val(),
                amount: $("#amount").val(),
                note: $("#note").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $("#myform1")[0].reset();
                    $("#myform2")[0].reset();
                    $("#successLabel").show();
                    $("#backBtn").show();
                    $("#submitAreaDiv").empty();
                    $("#formdiv1").empty();
                    $("#formdiv2").empty();
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
        $("#shouZhiDetailguanli").click();

    });

    $("#classroomguanlibread").click(function () {
        $("#shouZhiDetailguanli").click();

    });

    $("#backBtn").click(function () {
        $("#shouZhiDetailguanli").click();

    });



});

