/**
 * Created by Huangqijun on 2017/7/19.
 */


$(document).ready(function () {

    $("body").unbind("click");//

    var arrRows = $("#mytablebody tr");
    for(var i = 0;i < arrRows.length;i++){
        if(arrRows.eq(i).children().eq(2).html() == 1){
            arrRows.eq(i).children().eq(2).html("收入");
        }else {
            arrRows.eq(i).children().eq(2).html("支出");
        }
        if(arrRows.eq(i).children().eq(10).html() == 0){
            arrRows.eq(i).children().eq(10).html("未到账");
            arrRows.eq(i).children().eq(11).children().eq(2).html("确认");
            arrRows.eq(i).children().eq(11).children().eq(2).attr("class","conformObjectLinkClass");
        }else {
            arrRows.eq(i).children().eq(10).html("已到账");
            arrRows.eq(i).children().eq(11).children().eq(2).html("取消确认");
            arrRows.eq(i).children().eq(11).children().eq(2).attr("class","conformCancelObjectLinkClass");
        }

    }

    $("#createObjectBtn1InList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createShouRuDetail",
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

    $("#createObjectBtn2InList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createZhiChuDetail",
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



    $("body").on('click', ".deleteObjectLinkClass" ,function () {

        //获取点击链接自定义属性的值
        var id = $(this).attr('id');

        //将自定义属性的值赋值给modal
        $("#id").val(id);

        //显示属性框.
        $('#myDeleteModal').modal('show');
        return false;

    });

    $("#deleteObjectBtnInModal").click(function () {

        var url = "/deleteShouZhiDetail";
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
        $("#shouZhiDetailguanli").click();
    })

    $("body").on('click', ".updateObjectLinkClass",  function () {
        var url = $(this).attr('href');
        $.ajax({
            type: "GET",
            url: url,
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

    //确认
    $("body").on('click', ".conformObjectLinkClass",  function () {
        $tra = $(this);
        //获取点击链接自定义属性的值
        var id = $(this).attr('id');

        var url = "/updateShouZhiDetailStatus";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: id,
                amountStatus:1
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $tra.html("取消确认");
                    $tra.parents("tr").children().eq(10).html("已到账");
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

        var url = "/updateShouZhiDetailStatus";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: id,
                amountStatus:0
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $tra.html("确认");
                    $tra.parents("tr").children().eq(10).html("未到账");
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




    $("#searchBtn").click(function () {

        var query_param_type = $("#query_param_type option:selected").val();
        $.ajax({
            url: "/queryShouZhiDetailListByType",
            type: "GET",
            data: {type: query_param_type},
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
                    $.each(data.data, function (id, shoouZhiDetail) {
                        var typeStr = shoouZhiDetail.type == 1? "收入":"支出";
                        var statusStr = shoouZhiDetail.amountStatus == 0? "未到账":"已到账";
                        var className = shoouZhiDetail.amountStatus == 0? "conformObjectLinkClass":"conformCancelObjectLinkClass";
                        var buttonName = shoouZhiDetail.amountStatus == 0? "确认":"取消确认";
                        var dateStr = shoouZhiDetail.handingDate.substring(0,10);
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + shoouZhiDetail.accountName + "</td>");
                        var $td2 = $("<td >" + shoouZhiDetail.orderNo + "</td>");
                        var $td3 = $("<td >" + typeStr + "</td>");
                        var $td4 = $("<td >" + shoouZhiDetail.shou_zhi_da_lei + "</td>");
                        var $td5 = $("<td >" + shoouZhiDetail.shou_zhi_xiao_lei + "</td>");
                        var $td6 = $("<td >" + shoouZhiDetail.amount + "</td>");
                        var $td7 = $("<td >" + shoouZhiDetail.handingSchool + "</td>");
                        var $td8 = $("<td >" + shoouZhiDetail.handingPerson + "</td>");
                        var $td9 = $("<td >" + dateStr + "</td>");
                        var $td10 = $("<td >" + shoouZhiDetail.studentName + "</td>");
                        var $td11 = $("<td >" + statusStr + "</td>");
                        var $td12 = $("<td><a class='deleteObjectLinkClass' href='#'" +
                             "' id='" + shoouZhiDetail.id +"'>删除</a>" +
                            " &nbsp;&nbsp; " +
                            "<a  class='updateObjectLinkClass'  " +
                            " href='/xiaobao/updateShouZhiDetail?id=" + shoouZhiDetail.id  + "'>编辑</a>"+
                            " &nbsp;&nbsp; " +
                            "<a  class='"+className+"'  href = '#'" +
                            " id= '" + shoouZhiDetail.id  + "'>"+buttonName+"</a></td>");

                        $tr.append($td1);
                        $tr.append($td2);
                        $tr.append($td3);
                        $tr.append($td4);
                        $tr.append($td5);
                        $tr.append($td6);
                        $tr.append($td7);
                        $tr.append($td8);
                        $tr.append($td9);
                        $tr.append($td10);
                        $tr.append($td11);
                        $tr.append($td12);

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

