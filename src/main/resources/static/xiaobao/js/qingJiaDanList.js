/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {
    $("body").unbind("click");//

    var arrRows = $("#mytablebody tr");
    for(var i = 0;i < arrRows.length;i++){
        if(arrRows.eq(i).children().eq(6).html() == 0){
            arrRows.eq(i).children().eq(6).html("未确认");
            arrRows.eq(i).children().eq(7).children().eq(2).html("确认");
            arrRows.eq(i).children().eq(7).children().eq(2).attr("class","conformObjectLinkClass");
        }else {
            arrRows.eq(i).children().eq(6).html("已确认");
            arrRows.eq(i).children().eq(7).children().eq(1).html("取消确认");
            arrRows.eq(i).children().eq(7).children().eq(1).attr("class","conformCancelObjectLinkClass");
        }

    }
    $("#createObjectBtnInList").click(function () {
        /*$.ajax({
            type: "GET",
            url: "/xiaobao/createSRDaLei",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });*/
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
        var url = "/deleteQingJiaDan";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val(),
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
        $("#studentqingjiaguanli").click();
    })

    //确认
    $("body").on('click', ".conformObjectLinkClass",  function () {
        $tra = $(this);
        //获取点击链接自定义属性的值
        var id = $(this).attr('id');

        var url = "/updateQingJiaDanStatus";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: id,
                status:1
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $tra.html("取消确认");
                    $tra.parents("tr").children().eq(6).html("已确认");
                    $tra.attr("class","conformCancelObjectLinkClass");
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

    //取消确认
    $("body").on('click', ".conformCancelObjectLinkClass",  function () {

        $tra = $(this);
        //获取点击链接自定义属性的值
        var id = $(this).attr('id');

        var url = "/updateQingJiaDanStatus";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: id,
                status:0
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $tra.html("确认");
                    $tra.parents("tr").children().eq(6).html("未确认");
                    $tra.attr("class","conformObjectLinkClass");
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


});

