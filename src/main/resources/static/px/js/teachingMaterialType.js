$(function () {

    $('#newTeachingMaterialType').click(function () {
        $('.addTeachingMaterialType').dialog("option", "title", "新建教材").dialog('open');
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
        $('.addTeachingMaterialType').dialog("option", "title", "编辑教材").dialog('open');
    });


    $('.addTeachingMaterialType').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 450,
        height: 300,
        title: '新建教材',
        buttons: {
            '保存': function () {
                if ($("#teachingMaterialNameText").val() === "") {
                    alert("教材名称不能为空。");
                    $("#teachingMaterialNameText").focus();
                    return;
                } else if ($("#teachingMaterialBuyPriceText").val() === "") {
                    alert("教材进价不能为空。");
                    $("#teachingMaterialBuyPriceText").focus();
                    return;
                } else if ($("#teachingMaterialSalePriceText").val() === "") {
                    alert("教材售价不能为空。");
                    $("#teachingMaterialSalePriceText").focus();
                    return;
                } else if ($("#courseTypeText").children('option:selected').val() === "") {
                    alert("请选择课程类别。");
                    $("#courseTypeText").focus();
                    return;
                }
                //$(this).submit();
                $(this).dialog('close');
                //-----------------------------
                var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                tr.append($("<td></td>").html($("#teachingMaterialNameText").val()));
                tr.append($("<td></td>").html($("#courseTypeText").children('option:selected').val()));
                tr.append($("<td ></td>").html($("#teachingMaterialBuyPriceText").val()));
                tr.append($("<td ></td>").html($("#teachingMaterialSalePriceText").val()));
                tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button> <button class="editButton icon iconfont icon-edit" >编辑</button>'));
                tr.appendTo($("tbody"));

                //------------------------------
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            //$(".ui-dialog-titlebar-close", $(this).parent()).hide();
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
    byId("teachingMaterialNameText").value = (tr.cells[0]).innerHTML;
    var all_options = document.getElementById("courseTypeText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[1]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }
    byId("teachingMaterialBuyPriceText").value = (tr.cells[2]).innerHTML;
    byId("teachingMaterialSalePriceText").value = (tr.cells[3]).innerHTML;
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