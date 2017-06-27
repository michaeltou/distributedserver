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
                //-----------------------------
                var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                tr.append($("<td></td>").html($("#courseTypeCodeText").val()));
                tr.append($("<td style='text-align:center;'></td>").html($("#courseTypeNameText").val()));
                tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button><button class="editButton icon iconfont icon-edit">编辑</button>'));
                tr.appendTo($("tbody"));

                //------------------------------
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
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

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
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

function byId(id) {
    return document.getElementById(id);
}

function load() {

}    