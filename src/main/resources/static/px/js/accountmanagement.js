$(function () {

    $("input[name='accountStatus']").eq(0).attr("checked", "checked");
    $("input[name='accountStatus']").eq(0).click();
    $('.addAccount input[type=radio]').button();
    $('.addAccount input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });


    $('#newAccount').click(function () {
        $('.addAccount').dialog("option", "title", "新建账户").dialog('open');
    });

    $('#validStatus').click(function () {
        $("#validStatus").attr("checked", "checked");
        $("#invalidStatus").removeAttr("checked")
        $("#validStatus").click();
    });

    $('#invalidStatus').click(function () {
        $("#invalidStatus").attr("checked", "checked");
        $("#validStatus").removeAttr("checked")
        $("#invalidStatus").click();
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
        //EditData($(this).get(0));
        $('.addAccount').dialog("option", "title", "编辑账户").dialog('open');
    });


    $('.addAccount').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 600,
        height: 250,
        title: '新建账户',
        buttons: {
            '保存': function () {
                if ($("#accountNameText").val() == "") {
                    alert("账户名称不能为空。");
                    $("#accountNameText").focus();
                    return;
                }
                $(this).dialog('close');
                $.ajax({
                    url: "",
                    type: "POST",
                    data: "",
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if (data.success) {
                            alert("账户更新成功");
                            window.location.href = "/px/serachKeChengCategory";
                        }
                        else {
                            window.alert("账户更新失败");
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
                    //window.alert("课程类别更新失败");
                }
            }
        });
    });
});

function EditData(editRow) {
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