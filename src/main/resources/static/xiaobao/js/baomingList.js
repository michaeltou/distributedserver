/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {


    $("#createObjectBtnInList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createBaoMing",
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

        //将自定义属性的值赋值给modal
        $("#id").val(id);


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

        var url = "/deleteBaoMing";
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
        $("#baomingguanli").click();
    })


    $("#searchBtn").click(function () {

        var query_param_baoMing_student_name = $("#query_param_baoMing_student_name").val();
        $.ajax({
            url: "/queryBaoMingListByNameWithLike",
            type: "GET",
            data: {name: query_param_baoMing_student_name},
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
                    $.each(data.data, function (id, baoMing) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + baoMing.name + "</td>");
                        var $td2 = $("<td >" + baoMing.sfzCode + "</td>");
                        var $td3 = $("<td >" + baoMing.banji_name + "</td>");
                        var $td4 = $("<td >" + baoMing.chargeFee + "</td>");
                        var $td5 = $("<td >" + baoMing.chageFeeNote + "</td>");
                        var $td6 = $("<td >" + baoMing.jiaocai_zafei_chargeFee + "</td>");
                        var $td7 = $("<td >" + baoMing.jiaocai_zafei_note + "</td>");
                        var $td8 = $("<td >" + baoMing.totalChargeFee + "</td>");



                        var $td9 = $("   <td><a    class='deleteObjectLinkClass' href='#' "  +
                             "  id='" + baoMing.id  + "'   >删除</a>" +
                            " &nbsp;&nbsp; " +
                            "<a  class='updateObjectLinkClass'  " +
                            " href='/xiaobao/updateBaoMing?id=" +
                            baoMing.id + "'>编辑</a> </td>");

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

                        //将自定义属性的值赋值给modal
                        $("#id").val(id);


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

