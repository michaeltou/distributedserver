/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    // initialize with defaults
    $(".myfile").fileinput({
        //上传的地址
        uploadUrl: "/uploadFile",
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮,跟随文本框的那个
        showRemove: true, //显示移除按钮,跟随文本框的那个
        layoutTemplates: {actionDelete: ""},//将预览框里面的删除按钮去除.
        showCaption: true,//是否显示标题,就是那个文本框
        showPreview: true, //是否显示预览,不写默认为true
        dropZoneEnabled: false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 3, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        allowedFileTypes: ['image'],//配置允许文件上传的类型
        allowedPreviewTypes: ['image'],//配置所有的被预览文件类型
        allowedPreviewMimeTypes: ['jpg', 'png', 'gif'],//控制被预览的所有mime类型
        language: 'zh'
    })
    //异步上传返回结果处理
    $('.myfile').on('fileerror', function (event, data, msg) {
        console.log("fileerror");
        console.log(data);
    });


    //异步上传返回结果处理
    $(".myfile").on("fileuploaded", function (event, data, previewId, index) {

        var oldvalue = $("#urlxx2").val()  ;
        var newvalue = data.response.url;
       // alert("oldvalue:" + oldvalue);
       // alert("newvalue:"+data.response.url);
        $("#urlxx2").val(oldvalue +","+newvalue);
       // alert("final:" + $("#urlxx2").val());

        if ($("#urlxx2").val().length < 2) {
            $("#urlxx2").next().text("没有上传文件，无法进行保存!");
            $("#urlxx2").next().css({"display": "block", "color": "red"});
            b_validate_result10 = false;
        } else {
            $("#urlxx2").next().css("display", "none");
            b_validate_result10 = true;
        }

    });

    //未上传时的删除
    $('.myfile').on('fileremoved', function (event, id, index) {
        console.log('fileremoved ，id = ' + id + ', index = ' + index);
        alert('id = ' + id + ', index = ' + index);
    });

    //上传后删除
    $('.myfile').on('filesuccessremove', function (event, id) {
        alert("id=" + id);

    });

    $('.myfile').on('filecleared', function (event) {
        // alert("filecleared,clear urlxx2");
        $("input[name='urlxx2']").val("");
    });

    $('.myfile').on('fileclear', function (event) {
        //alert("fileclear");
    });


    //同步上传错误处理
    $('.myfile').on('filebatchuploaderror', function (event, data, msg) {
        console.log("filebatchuploaderror");
        console.log(data);
    });

    //同步上传返回结果处理
    $(".myfile").on("filebatchuploadsuccess",
        function (event, data, previewId, index) {
            console.log("filebatchuploadsuccess");
            console.log(data);
        });

    //上传前
    $('.myfile').on('filepreupload', function (event, data, previewId, index) {
        console.log("filepreupload");
    });


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

    $("#shangke_start_date").change(function () {


        var telReg = /^(\d{4})\-(\d{2})\-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;
        if (!telReg.test($("#shangke_start_date").val())) {

            $("#shangke_start_date").next().text("时间格式有误!正确时间格式为yyyy-mm-dd hh:ii:ss");
            $("#shangke_start_date").next().css({"display": "block", "color": "red"});
            b_validate_result3 = false;
        } else {
            $("#shangke_start_date").next().css("display", "none");
            b_validate_result3 = true;
        }


    });


    $("#shangke_end_date").change(function () {
        var telReg = /^(\d{4})\-(\d{2})\-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;
        if (!telReg.test($("#shangke_end_date").val())) {
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
        if (!telReg.test($("#jiaoshi_keshi").val())) {
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


    $("#createBtn").click(function () {

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
        $("#banji_name").focus();



        if ($("#urlxx2").val().length < 2) {
            $("#urlxx2").next().text("没有上传文件，无法进行保存!");
            $("#urlxx2").next().css({"display": "block", "color": "red"});
            b_validate_result10 = false;
        } else {
            $("#urlxx2").next().css("display", "none");
            b_validate_result10 = true;
        }


        b_validate_result = b_validate_result1 & b_validate_result2 & b_validate_result3 & b_validate_result4
            & b_validate_result5 & b_validate_result6 & b_validate_result7 & b_validate_result8 & b_validate_result9 & b_validate_result10;
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
                shangke_pic_list: $("#urlxx2").val() //上传的图片列表.
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {

                    //清空表格数据

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
            url: "/xiaobao/createClassRecord",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3 = data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4 = data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
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

