$(function () {

    $('#newExpenditureItems').click(function () {
        $('.addExpenditureItems').dialog("option", "title", "新建支出项目大类").dialog('open');
    });

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            window.location.href = "ExpenditureItems.html";
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            window.location.href = "SubExpenditureItems.html";
        }
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
        $('.addExpenditureItems').dialog("option", "title", "编辑支出项目大类").dialog('open');
    });


    $('.addExpenditureItems').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 450,
        height: 250,
        title: '新建支出项目大类',
        buttons: {
            '保存': function () {
                if ($("#expenditureItemNameText").val() === "") {
                    alert("支出项目名称不能为空。");
                    $("#expenditureItemNameText").focus();
                    return;
                } else if ($("#sortIDText").children('option:selected').val() === "") {
                    alert("请选择排序编号。");
                    $("#sortIDText").focus();
                    return;
                }else if ($("#expenditureItemsText").children('option:selected').val() === "") {
                    alert("请选择支出大类。");
                    $("#expenditureItemsText").focus();
                    return;
                }
                //$(this).submit();
                $(this).dialog('close');
                //-----------------------------
                var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                tr.append($("<td></td>").html($("#sortIDText").children('option:selected').val()));
                tr.append($("<td></td>").html($("#expenditureItemsText").children('option:selected').val()));
                tr.append($("<td></td>").html($("#expenditureItemNameText").val()));
                tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button>'));
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
    byId("expenditureItemNameText").value = (tr.cells[2]).innerHTML;
    var all_options = document.getElementById("sortIDText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[0]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }
    var all_options = document.getElementById("expenditureItemsText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[1]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }
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