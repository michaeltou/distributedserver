/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {





    $("#createSchoolBtnForSchoolList").click(function () {

        $.ajax({
            type: "GET",
            url: "/xiaobao/createSchool",
            success: function (data) {
                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3 = data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4 = data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");
                $('#mainContents').append(data4);
            }
        });
    });

    $(".updateSchoolLinkClass").on('click', function () {
        var href = $(this).attr('href');


        /**  这是第二种加载页面方式 **/
        $.ajax({
            type: "GET",
            url: href,
            success: function (data) {

                $('#mainContents').empty();
                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                var data2 = data.replace(/\<script src=\"js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                var data3 = data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                var data4 = data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");

                $('#mainContents').append(data4);


            }
        });

        //阻止跳转
        return false;
    });

    $(".deleteSchoolLinkClass").on('click', function () {

        var href = $(this).attr('href');
        var school_id = $(this).attr('school_id');
        var institution_code = $(this).attr('institution_code');
        var school_name = $(this).attr('school_name');
        $("#school_id").val(school_id);
        $("#institution_code").val(institution_code);
        $("#school_name").val(school_name);

        $('#myDeleteModal').modal('show');
        return false;

    });

    $("#deleteSchoolBtn").click(function () {


        var school_id = $("#school_id").val();
        var institution_code = $("#institution_code").val();
        var school_name = $("#school_name").val();


        var url = "/px/deleteSchool";
        $.ajax({
            type: "post",
            url: url,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: $("#school_id").val(),
                institution_code: $("#institution_code").val(),
                school_name: $("#school_name").val()
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
        $("#xiaoquguanli").click();
    })


    $("#searchBtnForSchoolListPage").click(function () {

        var school_name = $("#query_param_school_name").val();
        $.ajax({
            url: "/querySchoolByNameWithLike",
            type: "GET",
            data: {school_name: school_name},
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
                    $.each(data.data, function (id, school) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td >" + school.school_name + "</td>");
                        var $td2 = $("<td >" + school.type + "</td>");
                        var $td3 = $("<td >" + school.principal_name + "</td>");
                        var $td4 = $("<td >" + school.principal_sfz_code + "</td>");
                        var $td5 = $("<td >" + school.phone + "</td>");
                        var $td6 = $("<td >" + school.address + "</td>");

                        var $td7 = $("   <td><a id='deleteSchoolLink'  class='deleteSchoolLinkClass' href='#' school_name='" + school.school_name +
                            "'  institution_code = '" + school.institution_code + "'  school_id = '" + school.id + "'   >删除</a>" +
                            " &nbsp;&nbsp; " +
                            "<a id='updateSchoolLink'   class='updateSchoolLinkClass'  " +
                            " href='/xiaobao/updateSchool?institution_code=" +
                            school.institution_code + "&school_name=" +
                            school.school_name + "  '>编辑</a> </td>");

                        $tr.append($td1);
                        $tr.append($td2);
                        $tr.append($td3);
                        $tr.append($td4);
                        $tr.append($td5);
                        $tr.append($td6);
                        $tr.append($td7);

                        $tr.appendTo($("#mytablebody"));


                    });//each

                    $(".deleteSchoolLinkClass").on('click', function () {

                        var href = $(this).attr('href');

                        var school_id = $(this).attr('school_id');
                        var institution_code = $(this).attr('institution_code');
                        var school_name = $(this).attr('school_name');
                        $("#school_id").val(school_id);
                        $("#institution_code").val(institution_code);
                        $("#school_name").val(school_name);

                        $('#myDeleteModal').modal('show');
                        return false;

                    });

                    $(".updateSchoolLinkClass").on('click', function () {
                        var href = $(this).attr('href');


                        /**  这是第二种加载页面方式 **/
                        $.ajax({
                            type: "GET",
                            url: href,
                            success: function (data) {

                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3 = data2.replace(/\<script src=\"js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4 = data3.replace(/\<link rel=\"stylesheet\" href=\"css\/bootstrap.css\"\/\>/, "");

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

