/**
 * Created by Huangqijun on 2017/7/4.
 */


$(document).ready(function () {

    $("body").unbind("click");//

    $("#createObjectBtnInList").click(function () {
        $.ajax({
            type: "GET",
            url: "/xiaobao/createGongZiTiao",
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

        $("#month").val($(this).parents("tr").children().eq(0).html());

        //显示属性框.
        $('#myDeleteModal').modal('show');
        return false;

    });

    $("#deleteObjectBtnInModal").click(function () {
        $.ajax({
            type: "get",
            url: "/deleteGongZiTiaoByMonth",
            data: {
                month: $("#month").val(),
            },
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
        $("#gongzitiaoguanli").click();
    })

    $("body").on('click', ".detailObjectLinkClass" ,function () {

        $("#month").val($(this).parents("tr").children().eq(0).html());

        $.ajax({
            type: "GET",
            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
            data: {
                month: $("#month").val(),
            },
/*            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)*/
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
});

