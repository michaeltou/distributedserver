/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    $("#createObjectBtnInList").click(function () {
        $.ajax({
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
        });
    });



    $(".deleteObjectLinkClass").on('click', function () {
        //获取点击链接自定义属性的值
        var href = $(this).attr('href');
        var id = $(this).attr('id');
        var name = $(this).attr('name');


        //将自定义属性的值赋值给modal
        $("#id").val(id);
        $("#name").val(name);

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
        var url = "/deleteSRDaLei";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val(),
                name: $("#name").val()
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
        $("#shouRuDaLeiguanli").click();
    })


    $("#searchBtn").click(function () {
        var query_param_shouRuDaLei_name = $("#query_param_shouRuDaLei_name").val();
        $.ajax({
            url: "/querySRDaLeiByNameWithLike",
            type: "GET",
            data: {name: query_param_shouRuDaLei_name},
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
                    $.each(data.data, function (id, shouRuDaLei) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + shouRuDaLei.name + "</td>");
                        var $td2 = ('<td><a class="deleteObjectLinkClass" href="#" th:attr="name=${shouRuDaLei.name},id=${shouRuDaLei.id}" >删除</a></td>');

                        $tr.append($td1);
                        $tr.append($td2);
                        $tr.appendTo($("#mytablebody"));


                    });//each

                    $(".deleteObjectLinkClass").on('click', function () {

                        //获取点击链接自定义属性的值
                        var href = $(this).attr('href');
                        var id = $(this).attr('id');
                        var name = $(this).attr('name');


                        //将自定义属性的值赋值给modal
                        $("#id").val(id);
                        $("#name").val(name);


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

