/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    // initialize with defaults
 //   $("#input-id").fileinput();

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
    //异步上传返回结果处理
    $(".myfile").on("fileuploaded", function(event, data, previewId, index) {
        console.log("fileuploaded");
        var ref = $(this).attr("data-ref");
        var oldValue= "";
        if( $("input[name='" + ref + "']").val() == null ||$("input[name='" + ref + "']").val().length==0 ){
            oldValue = "";
        }else{
            oldValue = $("input[name='" + ref + "']").val()+",";
        }
        $("input[name='" + ref + "']").val(oldValue+data.response.url);

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
        alert("filecleared,clear url2");
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

    //////////////////////////////////////////////

    $("#createObjectBtnInList").click(function () {
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



    $(".deleteObjectLinkClass").on('click', function () {

        //获取点击链接自定义属性的值
        var href = $(this).attr('href');
        var id = $(this).attr('id');
        var banji_name = $(this).attr('banji_name');

        //将自定义属性的值赋值给modal
        $("#id").val(id);
        $("#banji_name").val(banji_name);

        //显示属性框.
        $('#myDeleteModal').modal('show');
        return false;

    });

    $(".updateObjectLinkClass").on('click', function () {
        var href = $(this).attr('href');

        $.ajax({
            type: "GET",
            url: href,
            success: function (data) {

                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");

                $('#mainContents').append(data4);


            }
        });

        //阻止跳转
        return false;
    });

    $("#deleteObjectBtnInModal").click(function () {

        var url = "/deleteClassRecord";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val(),
                banji_name: $("#banji_name").val()

            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $('#myDeleteModal').modal('hide');
                    //$("#xiaoquguanli").click();
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

    $('#myDeleteModal').on('hidden.bs.modal', function () {
        // 执行一些动作...
        $("#createClassRecordMenu").click();
    })


    $("#searchBtn").click(function () {

        var query_param_banji_name = $("#query_param_banji_name").val();
        $.ajax({
            url: "/queryClassRecordListByBanjiNameWithBanjiNameLike",
            type: "GET",
            data: {banji_name: query_param_banji_name},
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空当前表格
                    //   document.getElementById("mytablebody").innerHTML = '';

                    //清空当前表格
                    $("#mytablebody").empty();

                    //动态构建表格数据.
                    $.each(data.data, function (id, classRecordMain) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + classRecordMain.banji_name + "</td>");
                        var $td2 = $("<td >" + classRecordMain.xiaoqu_name + "</td>");
                        var $td3 = $("<td >" + classRecordMain.shangke_start_date + "</td>");
                        var $td4 = $("<td >" + classRecordMain.shangke_end_date + "</td>");
                        var $td5 = $("<td >" + classRecordMain.jiaoshi_keshi + "</td>");
                        var $td6 = $("<td >" + classRecordMain.teacher_name + "</td>");
                        var $td7 = $("<td >" + classRecordMain.shangke_content + "</td>");
                        var $td8 = $("<td >" + classRecordMain.shangke_note + "</td>");


                        var $td9 = $("   <td><a    class='deleteObjectLinkClass' href='#' banji_name='" + classRecordMain.banji_name +
                             "' id='" + classRecordMain.id  +　"'   >删除</a>" +
                            " &nbsp;&nbsp; " +
                            "<a  class='updateObjectLinkClass'  " +
                            " href='/xiaobao/updateClassRecord?id=" +
                            classRecordMain.id + "&banji_name=" +
                            classRecordMain.banji_name +  "  '>编辑</a> </td>");

                        $tr.append($td1);
                        $tr.append($td2);
                        $tr.append($td3);
                        $tr.append($td4);
                        $tr.append($td5);
                        $tr.append($td6);
                        $tr.append($td7);
                        $tr.append($td8);
                        $tr.append($td9);

                        $tr.appendTo($("#mytablebody"));


                    });//each


                    $(".deleteObjectLinkClass").on('click', function () {

                        //获取点击链接自定义属性的值
                        var href = $(this).attr('href');
                        var id = $(this).attr('id');
                        var banji_name = $(this).attr('banji_name');

                        //将自定义属性的值赋值给modal
                        $("#id").val(id);
                        $("#banji_name").val(banji_name);

                        //显示属性框.
                        $('#myDeleteModal').modal('show');
                        return false;

                    });

                    $(".updateObjectLinkClass").on('click', function () {
                        var href = $(this).attr('href');

                        $.ajax({
                            type: "GET",
                            url: href,
                            success: function (data) {

                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");

                                $('#mainContents').append(data4);


                            }
                        });

                        //阻止跳转
                        return false;
                    });

                }
                else {
                    alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });//ajax
    });

});

