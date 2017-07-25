/**
 * Created by Huangqijun on 2017/7/25.
 */


$(document).ready(function () {

    $("body").unbind("click");//

    $('#startSendDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    $('#endSendDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });
    $("#createObjectBtnInList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createSMSNotice",
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



    $("body").on('click',".deleteObjectLinkClass", function () {
        //获取点击链接自定义属性的值
        var id = $(this).attr('id');


        //将自定义属性的值赋值给modal
        $("#id").val(id);

        //显示属性框.
        $('#myDeleteModal').modal('show');
        return false;

    });

    $("#deleteObjectBtnInModal").click(function () {
        var url = "/deleteSmsNotice";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val()
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
        $("#smsNoticeguanli").click();
    })


    $("#searchBtn").click(function () {
        var startSendDate = $("#startSendDate").val();
        var endSendDate = $("#endSendDate").val();
        $.ajax({
            url: "/querySmsNoticeListBySendDate",
            type: "GET",
            data: {
                startSendDate: startSendDate +" 00:00:00",
                endSendDate:endSendDate + " 23:59:59"
            },
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
                    $.each(data.data, function (id, smsNotice) {
                        var dateStr = smsNotice.send_date.substring(0,10);
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + smsNotice.title + "</td>");
                        var $td2 = $("<td >" + smsNotice.notify_object_name + "</td>");
                        var $td3 = $("<td >" + smsNotice.send_person + "</td>");
                        var $td4 = $("<td >" + dateStr + "</td>");
                        var $td5 = $("<td><a class='deleteObjectLinkClass' href='#'"  +
                            "' institution_code = '" + smsNotice.institution_code + "'  id = '" + smsNotice.id + "'>删除</a></td>");

                        $tr.append($td1);
                        $tr.append($td2);
                        $tr.append($td3);
                        $tr.append($td4);
                        $tr.append($td5);
                        $tr.appendTo($("#mytablebody"));


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
    });

});

