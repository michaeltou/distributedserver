/**
 * Created by Huangqijun on 2017/7/17.
 */


$(document).ready(function () {

    $("body").unbind("click");//

    $("#createObjectBtnInList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createSchoolAccount",
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
        var href = $(this).attr('href');
        var id = $(this).attr('id');
        var name = $(this).attr('accountName');
        //将自定义属性的值赋值给modal
        $("#id").val(id);
        $("#name").val(name);

        //显示属性框.
        $('#myDeleteModal').modal('show');
        return false;

    });

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

    $("#deleteObjectBtnInModal").click(function () {

        var url = "/deleteSchoolAccount";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#id").val(),
                accountName: $("#name").val()
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
        $("#schoolAccountguanli").click();
    })


    $("#searchBtn").click(function () {

        var query_param_account_name = $("#query_param_account_name").val();
        $.ajax({
            url: "/querySchoolAccountByNameWithLike",
            type: "GET",
            data: {name: query_param_account_name},
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
                    $.each(data.data, function (id, schoolAccount) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + schoolAccount.accountName + "</td>");
                        var $td2 = $("<td >" + schoolAccount.accountCode + "</td>");
                        var $td3 = $("<td >" + schoolAccount.bank + "</td>");
                        var $td4 = $("<td >" + schoolAccount.status + "</td>");
                        var $td5 = $("   <td><a    class='deleteObjectLinkClass' href='#' accountName='" + schoolAccount.accountName +
                             "' id='" + schoolAccount.id +"'>删除</a>" +
                            " &nbsp;&nbsp; " +
                            "<a  class='updateObjectLinkClass'  " +
                            " href='/xiaobao/updateSchoolAccount?id=" +
                            schoolAccount.id + "&accountName=" +
                            schoolAccount.accountName + "'>编辑</a> </td>");

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

