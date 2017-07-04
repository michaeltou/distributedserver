$(function () {

    //自定义函数
    //=============================================
    $.extend({
        calculateTotalMoney: function () {
            var receivableMoney = 0;

            var teachingMaterialRows = $("#teachingMaterialDiv").find("tbody tr");

            for (var j = 0; j < teachingMaterialRows.length; j++) {
                var teachingMaterialMoney = teachingMaterialRows.eq(j).children().eq(4).html();
                teachingMaterialMoney = parseInt(teachingMaterialMoney);
                if (isNaN(teachingMaterialMoney)) {
                    teachingMaterialMoney = 0;
                }
                receivableMoney += teachingMaterialMoney;
            }

            $("#receivableMoneyText").text(receivableMoney);

        }
    });


    $.extend({
        calculateReceivedMoney: function () {
            var cash = $("#cashText").val();
            cash = parseInt(cash);
            if (isNaN(cash)) {
                cash = 0;
            }

            var transferAccountsMoney = $("#transferAccountsMoneyText").val();
            transferAccountsMoney = parseInt(transferAccountsMoney);
            if (isNaN(transferAccountsMoney)) {
                transferAccountsMoney = 0;
            }

            $("#netReceiptsMoneyText").text(transferAccountsMoney + cash);

        }
    });
    //=============================================


    //=============================================
    $.calculateReceivedMoney();

    $("body").on('click', "#teachingMaterialDiv", function () {

        //alert("change");
        $.calculateTotalMoney();

    });


    $("body").on('click', ".deleteButton", function () {
        if (window.confirm('确定要删除吗？')) {
            if ($(this).parents("#teachingMaterialDiv").length > 0) {
                DeleteData($(this).get(0));
                $.calculateTotalMoney();
                return true;
            }
        } else {
            //alert("取消");
            return false;
        }
    });


    //教材杂费dialog
    $('.addTeachingMaterial').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 600,
        height: 400,
        title: '教材杂费一览',
        buttons: {
            '保存': function () {
                if ($(this).find("#authorifyselect").children('option:selected').length === 0) {
                    alert("请至少选择一种教材或杂费。");
                    return false;
                }
                var trs = $("#teachingMaterialDiv").find("tbody").children();
                for (var j = 0; j < trs.length; j++) {
                    var teachingMaterialType = trs.eq(j).children().eq(1).html();
                    var teachingMaterialName = trs.eq(j).children().eq(2).html();
                    var deleteFlag = true;
                    for (var i = 0; i < $("#authorifyselect").children('option:selected').length; i++) {
                        if (teachingMaterialType == $("#authorifyselect").children('option:selected').eq(i).attr("data-section") &&
                            teachingMaterialName == $("#authorifyselect").children('option:selected').eq(i).html()) {
                            deleteFlag = false;
                            continue;
                        }
                    }
                    if (deleteFlag) {
                        trs.eq(j).remove();
                        //$.calculateTotalMoney(trs.eq(j));
                    }
                }

                for (var i = 0; i < $("#authorifyselect").children('option:selected').length; i++) {

                    var teachingMaterialType = $("#authorifyselect").children('option:selected').eq(i).attr("data-section");
                    var teachingMaterialName = $("#authorifyselect").children('option:selected').eq(i).html();
                    var existFlag = false;

                    for (var j = 0; j < trs.length; j++) {
                        if (trs.eq(j).children().eq(1).html() == teachingMaterialType &&
                            trs.eq(j).children().eq(2).html() == teachingMaterialName) {
                            existFlag = true;
                        }
                    }
                    if (existFlag) {
                        continue;
                    }
                    var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                    tr.append($("<td></td>").html(teachingMaterialType));
                    tr.append($("<td></td>").html(teachingMaterialName));
                    tr.append($("<td></td>").html('200'));
                    tr.append($("<td></td>").html('<div class="gw_num"><em class="jian">-</em> <input type="text" value="1" class="num"/> <em class="add">+</em></div>'));
                    tr.append($("<td></td>").html("200"));
                    tr.append($("<td style='text-align: center;'></td>").html('<input type="button" name="deleteButton" value="删除" class="deleteButton">'));
                    tr.appendTo($("#teachingMaterialDiv").find("tbody"));
                }
                $.calculateTotalMoney();
                $(this).dialog('close');
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });

    var $teachingMaterialBtnTr;
    $("#addTeachingMaterial").click(function () {
        var html = '<select id="authorifyselect" multiple="multiple">' +
            '<option  value="1" data-section="教材"  selected>电脑</option>' +
            '<option  value="2" data-section="教材"  selected>钢琴</option>' +
            '<option  value="3" data-section="教材"  selected>跳舞鞋</option>' +
            '<option  value="6" data-section="杂费">手续费</option>' +
            '<option  value="7" data-section="杂费">场地费</option>' +
            '</select>';
        $("#authorityBody").empty().append(html);
        $("#authorifyselect").treeMultiselect({searchable: false, hideSidePanel: false});
        $teachingMaterialBtnTr = $(this).parent().parent();
        $('.addTeachingMaterial').dialog("option", "title", "教材杂费一览").dialog('open');
    });



    $("#Save").click(function () {
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
        window.location.href = "PrinntFeeVoucher.html";
    });

    $("#Cancel").click(function () {
        window.location.href = "StudentDetail.html";
    });

    //加的效果
    $("body").on('click', ".add", function () {
        var price = $(this).parent().parent().parent().children('td:eq(2)').html();
        price = parseInt(price);
        var n = $(this).prev().val();
        var num = parseInt(n) + 1;
        if (num == 0) {
            return;
        }
        $(this).prev().val(num);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(4)').text(totalPrice);
    });
    //减的效果
    $("body").on('click', ".jian", function () {
        var price = $(this).parent().parent().parent().children('td:eq(2)').html();
        price = parseInt(price);
        var n = $(this).next().val();
        var num = parseInt(n) - 1;
        if (num == 0) {
            return
        }
        $(this).next().val(num);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(4)').text(totalPrice);
    });

    $("body").on("change",".num",function () {
        var price = $(this).parent().parent().parent().children('td:eq(2)').html();
        price = parseInt(price);
        var n = $(this).val();
        var num = parseInt(n);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(4)').text(totalPrice);
        $.calculateTotalMoney();
    });

    $("body").on("change",".classHourNum",function () {
        $.calculateTotalMoney();
    });

    //输入现金变更事件
    $('#cashText').change(function () {
        $.calculateReceivedMoney();
    });

    //输入转账变更事件
    $('#transferAccountsMoneyText').change(function () {
        $.calculateReceivedMoney();
    });
});

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;
    byId("employeeNameText").value = (tr.cells[0]).innerHTML;
    byId("employeePhoneText").value = (tr.cells[1]).innerHTML;
    var all_options = document.getElementById("schoolTypeText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[2]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }

        if (tr.cells[3].innerHTML == "女") {
            byId("female").click();
        } else {
            byId("male").click();
        }
    }
    byId("employeeAgeText").value = (tr.cells[4]).innerHTML;
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
