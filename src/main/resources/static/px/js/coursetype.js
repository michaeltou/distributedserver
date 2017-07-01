$(function () {

    $('#newCourseType').click(function () {
        $('.addCourseType').dialog("option", "title", "新建课程类别").dialog('open');
    });


    $("body").on('click', ".deleteButton", function () {

        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });

    $("body").on('click', ".editButton", function () {
        EditData($(this).get(0));
        $('.addCourseType').dialog("option", "title", "编辑社员").dialog('open');
    });


    $('.addCourseType').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 500,
        height: 200,
        title: '新建课程类别',
        buttons: {
            '保存': function () {
                if ($("#courseTypeCodeText").val() == "") {
                    alert("类别编号不能为空。");
                    $("#courseTypeCodeText").focus();
                    return;
                } else if ($("#courseTypeNameText").val() == "") {
                    alert("类别名称不能为空。");
                    $("#courseTypeNameText").focus();
                    return;
                }
                //$(this).submit();
                $(this).dialog('close');
                $.ajax({
                    url: "/insertKeChengCategory",
                    type: "POST",
                    data: JSON.stringify({
                        kc_category_name: $("#courseTypeNameText").val(),
                        institution_code: $("#courseTypeCodeText").val()
                    }),
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if (data.success) {
                            alert("课程类别更新成功");
                            window.location.href = "/px/serachKeChengCategory";
                        }
                        else {
                            window.alert("课程类别更新失败");
                        }
                    }
                });
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });


    $("#search").click(function () {

        var institution_code = "tm";
        var courseName = $("#courseTypeNameForSearchText").val();
        $.ajax({
            url: "/px/queryKeChengCategoryListByNameWithLike",
            type: "POST",
            data: JSON.stringify({institution_code: institution_code, kc_category_name: courseName}),
            contentType: "application/json; charset=utf-8",

            success: function (data, textStatus) {


                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空当前表格
                    document.getElementById("data_body").innerHTML = '';

                    //动态构建表格数据.
                    $.each(data.data, function (id, keChengCategory) {
                        var $tr = $("<tr ></tr>");
                        var $td1 = $("<td ></td>");
                        var $td2 = $("<td style='text-align: center;' ></td>");
                        var $td3 = $("<td style='text-align: center;'>  <button class='deleteButton icon iconfont icon-delete'>删除</button> </td>");
                        $tr.append($td1.clone().text(keChengCategory.id));
                        $tr.append($td2.clone().text(keChengCategory.kc_category_name));
                        $tr.append($td3.clone());
                        $tr.appendTo($("#data_body"));
                    });

                }
                else {
                    window.alert("课程类别更新失败");
                }
            }
        });
    });
});

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;
    byId("courseTypeCodeText").value = (tr.cells[0]).innerHTML;
    byId("courseTypeNameText").value = (tr.cells[1]).innerHTML;
}

function DeleteData(delRow) {
    //var table = delRow.parentNode.parentNode.parentNode;
    //table.removeChild(delRow.parentNode.parentNode);
    var tr = delRow.parentNode.parentNode;
    var courseID = (tr.cells[0]).innerText;
    var courseName = (tr.cells[1]).innerText;
    var institution_code = "tm";//(tr.cells[0]).innerText;
    $.ajax({
        url: "/deleteChengCategory",
        type: "POST",
        data: JSON.stringify({id: courseID, kc_category_name: courseName, institution_code: institution_code}),
        contentType: "application/json; charset=utf-8",
        success: function (data, textStatus) {
            if (data.success) {
                alert("课程类别删除成功");
                window.location.href = "/px/serachKeChengCategory";
            }
            else {
                window.alert("课程类别删除失败");
            }
        }
    });
}

function byId(id) {
    return document.getElementById(id);
}

function load() {

}    