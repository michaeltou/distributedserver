/**
 * Created by Hangqijun on 2017/7/20.
 */


$(document).ready(function () {

    $('#qingJiaStartDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    $('#qingJiaEndDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    var nowDate = new Date();
    var result=nowDate.getFullYear()+'-'+(nowDate.getMonth()+1)+'-'+nowDate.getDate() ;//
    $('#qingJiaStartDate').val(result);
    $('#qingJiaEndDate').val(result);


    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;
    var b_validate_result3 = true;
    var b_validate_result4 = true;
    var b_validate_result5 = true;


    $("#qingJiaRenName").focusout(function () {

        if ($("#qingJiaRenName option:selected").val() == undefined ||
            $("#qingJiaRenName option:selected").val().length == 0) {
            $("#qingJiaRenName").next().text("请选择请假人!");
            $("#qingJiaRenName").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#qingJiaRenName").next().css("display", "none");
            b_validate_result1 = true;
        }
    });

    $("#qingJiaLeiXing").focusout(function () {

        if ($("#qingJiaLeiXing option:selected").val() == undefined ||
            $("#qingJiaLeiXing option:selected").val().length == 0) {
            $("#qingJiaLeiXing").next().text("请选择请假类型!");
            $("#qingJiaLeiXing").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#qingJiaLeiXing").next().css("display", "none");
            b_validate_result2 = true;
        }
    });

    $("#qingJiaStartDate").focusout(function () {

        if ($("#qingJiaStartDate").val() == undefined ||
            $("#qingJiaStartDate").val().length == 0) {
            $("#qingJiaStartDate").next().text("请选择请假开始日期!");
            $("#qingJiaStartDate").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#qingJiaStartDate").next().css("display", "none");
            b_validate_result3 = true;
        }
    });

    $("#qingJiaEndDate").focusout(function () {

        if ($("#qingJiaEndDate").val() == undefined ||
            $("#qingJiaEndDate").val().length == 0) {
            $("#qingJiaEndDate").next().text("请选择请假结束日期!");
            $("#qingJiaEndDate").next().css({"display": "block", "color": "red"});
            b_validate_result4 = false;
        } else {
            $("#qingJiaEndDate").next().css("display", "none");
            b_validate_result4 = true;
        }


    });

    $("#qingJiaFangShi").focusout(function () {

        if ($("#qingJiaFangShi option:selected").val() == undefined ||
            $("#qingJiaFangShi option:selected").val().length == 0) {
            $("#qingJiaFangShi").next().text("请选择请假方式!");
            $("#qingJiaFangShi").next().css({"display": "block", "color": "red"});
            b_validate_result5 = false;
        } else {
            $("#qingJiaFangShi").next().css("display", "none");
            b_validate_result5 = true;
        }
    });


    $("#save").click(function () {

        $("#qingJiaRenName").focus();

        /*if($("#qingJiaStartDate").val().length == 0){
            b_validate_result2 = false;
        }else {
            b_validate_result2 = true;
        }

        if($("#qingJiaEndDate").val().length == 0){
            b_validate_result2 = false;
        }else {
            b_validate_result2 = true;
        }*/

        $("#qingJiaLeiXing").focus();

        $("#qingJiaFangShi").focus();


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4 & b_validate_result5 ;
        if (!b_validate_result) {
            return;
        }

        var idList = "";
        for(var i = 0; i< $(".classTimeDiv").length;i++){
            if($(".classTimeDiv").eq(i).children().is(":checked")){
                if(idList == ""){
                    idList+= $(".classTimeDiv").eq(i).children().attr("value");
                }else {
                    idList+=","+ $(".classTimeDiv").eq(i).children().attr("value");
                }
            }
        }

        var url = "/insertQingJiaDan";
        $.ajax({
            type: "get",
            url: url,
            data: {
                role:1,
                employeeType:$("#employeeType option:selected").val(),
                qingJiaDays:1,
                qingJiaRenSFZ: $("#qingJiaRenName option:selected").val(),
                qingJiaRenName: $("#qingJiaRenName option:selected").text(),
                qingJiaLeiXing: $("#qingJiaLeiXing option:selected").val(),
                qingJiaStartDate: $("#qingJiaStartDate").val()+" 00:00:00",
                qingJiaEndDate: $("#qingJiaEndDate").val()+" 23:59:59",
                qingJiaFangShi: $("#qingJiaFangShi option:selected").val(),
                note: $("#note").val(),
                idList:idList
            },
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据
                    $("#myform1")[0].reset();
                    $("#myform2")[0].reset();
                    $("#myform3")[0].reset();
                    //显示
                    $("#successLabel").show();
                    $("#createAgainBtn").show();
                    $("#backToListBtn").show();
                    //隐藏
                    $("#submitAreaDiv").empty();
                    $("#formdiv1").empty();
                    $("#formdiv2").empty();
                    $("#formdiv3").empty();

                }
                else {
                    $("#failLabel").css("display:block");
                    alert(data.errorMsg);
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
            url: "/xiaobao/createQingJiaDan",
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

    $("#qingJiaFangShi").change(function () {
        getClassesByGUIData();
    });

    $("#qingJiaRenName").change(function () {
        $(".classList").empty();
        getClassesByGUIData();
    });

    $("#qingJiaStartDate").change(function () {
        $(".classList").empty();
        getClassesByGUIData();
    });

    $("#qingJiaEndDate").change(function () {
        $(".classList").empty();
        getClassesByGUIData();
    });


    $("#employeeType").change(function () {

        $(".classList").empty();
        var selectedItem = $(this).find("option:selected").html();

        if (selectedItem == "教务老师") {
            $("#qingJiaFangShi").empty();
            var $option = $("<option></option>");
            $option.attr("value","按天");
            $option.html("按天");
            $("#qingJiaFangShi").append($option);
        }else {
            $("#qingJiaFangShi").empty();
            var $option1 = $("<option></option>");
            $option1.attr("value","按天");
            $option1.html("按天");

            var $option2 = $("<option></option>");
            $option2.attr("value","按班级");
            $option2.html("按班级");
            $("#qingJiaFangShi").append($option1);
            $("#qingJiaFangShi").append($option2);
        }
        $("#qingJiaFangShi").val("按天");
    });






    $("#backToListBtn").click(function () {
        $("#employeeqingjiaguanli").click();

    });

    $("#formBackBtn").click(function () {
        $("#employeeqingjiaguanli").click();

    });

    $("#backToListbreadLink").click(function () {
        $("#employeeqingjiaguanli").click();

    });








});

function getClassesByGUIData() {
    var selectedItem = $("#qingJiaFangShi").find("option:selected").html();
    if (selectedItem == "按天") {
        $(".classList").empty();
        return;
    }
    $.ajax({
        type: "get",
        url: "/queryBanjiPaikeItemForEmployeeQingJiaDan",
        data: {
            qingJiaRenSFZ: $("#qingJiaRenName option:selected").val(),
            qingJiaRenName: $("#qingJiaRenName option:selected").text(),
            qingJiaLeiXing: $("#qingJiaLeiXing option:selected").val(),
            qingJiaStartDate: $("#qingJiaStartDate").val()+" 00:00:00",
            qingJiaEndDate: $("#qingJiaEndDate").val()+" 23:59:59",
            qingJiaFangShi: $("#qingJiaFangShi option:selected").val(),
            note: $("#note").val()
        },
        dataType: "json",
        contentType: "application/json; charset=utf-8",//(可以)
        success: function (data, textStatus) {
            if (data.success) {
                $.each(data.data, function (id, item) {
                    var lblText = "["+item.banji_name+"]" + " ["+item.start+ "]-["+item.end+"]";
                    $div = $('<div class="classTimeDiv"></div>');
                    $chk = $('<input value="" name="classTimes" type="checkbox" class="classTimes">');
                    $chk.attr("value", item.id);
                    $lbl = $('<label></label>');
                    $lbl.html(lblText);
                    $div.append($chk);
                    $div.append($lbl);
                    $(".classList").append($div);

                });//each

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

}

