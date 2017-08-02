/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    // initialize with defaults
    $(".myfile").fileinput({
        //上传的地址
        uploadUrl:"/uploadFile",
        uploadAsync : true, //默认异步上传
        showUpload : true, //是否显示上传按钮,跟随文本框的那个
        showRemove : true, //显示移除按钮,跟随文本框的那个
        layoutTemplates:{actionDelete:""},//将预览框里面的删除按钮去除.
        showCaption : true,//是否显示标题,就是那个文本框
        showPreview : true, //是否显示预览,不写默认为true
        dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount : 3, //表示允许同时上传的最大文件个数
        enctype : 'multipart/form-data',
        validateInitialCount : true,
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
        allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
        allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
        language : 'zh'
    })
    //异步上传返回结果处理
    $('.myfile').on('fileerror', function(event, data, msg) {
        console.log("fileerror");
        console.log(data);
    });


    var oldValue= "";
    //异步上传返回结果处理
    $(".myfile").on("fileuploaded", function(event, data, previewId, index) {

        if(oldValue == "" ){
            oldValue = "";

        }else{
            var tempValue = $("#url2").val()
            oldValue = tempValue + ",";
        }

        var newvalue = oldValue+data.response.url;
        $("#url2").val(newvalue);

        if ($("#url2").val().length < 2) {
            $("#url2").next().text("没有上传文件，无法进行保存!");
            $("#url2").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#url2").next().css("display", "none");
            b_validate_result2 = true;
        }

    });

    //未上传时的删除
    $('.myfile').on('fileremoved', function(event, id, index) {
        console.log('fileremoved ，id = ' + id + ', index = ' + index);
        alert('id = ' + id + ', index = ' + index);
    });

    //上传后删除
    $('.myfile').on('filesuccessremove', function(event, id) {
        alert("id="+id);

    });

    $('.myfile').on('filecleared', function(event) {
       // alert("filecleared,clear url2");
        $("input[name='url2']").val("");
    });

    $('.myfile').on('fileclear', function(event) {
        //alert("fileclear");
    });




    //同步上传错误处理
    $('.myfile').on('filebatchuploaderror', function(event, data, msg) {
        console.log("filebatchuploaderror");
        console.log(data);
    });

    //同步上传返回结果处理
    $(".myfile").on("filebatchuploadsuccess",
        function(event, data, previewId, index) {
            console.log("filebatchuploadsuccess");
            console.log(data);
        });

    //上传前
    $('.myfile').on('filepreupload', function(event, data, previewId, index) {
        console.log("filepreupload");
    });

    var b_validate_result = true;
    var b_validate_result1 = true;
    var b_validate_result2 = true;

    $("#banji_name").focusout(function () {

        if ($("#banji_name").val() == null || $("#banji_name").val().length < 2) {
            $("#banji_name").next().text("班级名称 不合法!");
            $("#banji_name").next().css({"display": "block", "color": "red"});
            b_validate_result1 = false;
        } else {
            $("#banji_name").next().css("display", "none");
            b_validate_result1 = true;
        }


    });

   /* $("#myfile").change(function () {

        if ($("#url2").val().length < 2) {
            $("#url2").next().text("没有上传文件，无法进行保存!");
            $("#url2").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#url2").next().css("display", "none");
            b_validate_result2 = true;
        }


    });*/




    $("#save").click(function () {

        if ($("#url2").val().length < 2) {
            $("#url2").next().text("没有上传文件，无法进行保存!");
            $("#url2").next().css({"display": "block", "color": "red"});
            b_validate_result2 = false;
        } else {
            $("#url2").next().css("display", "none");
            b_validate_result2 = true;
        }


        $("#banji_name").focus();



        b_validate_result = b_validate_result1&&b_validate_result2;
        if (!b_validate_result) {
            return;
        }

        var url = "/insertUserPictures";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                banji_name: $("#banji_name").val(),
                url2: $("#url2").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    //清空表格数据

                    //显示
                    $("#successLabel").show();

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


    $("#backToListBtn").click(function () {
        $("#zuopingshangchuan").click();

    });

    $("#formBackBtn").click(function () {
        $("#zuopingshangchuan").click();

    });



});

