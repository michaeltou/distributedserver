$(function () {

    //自定义函数
    //=============================================
    $.extend({
        chargingModeChanged: function () {
            $("#tuitionStandardUnit").empty();
            if ($("#chargingModeText").children('option:selected').val() == "1") {
                $("#tuitionStandardUnit").append("<option value='1' selected>元/课时</option>");
                $(".classHourDiv").hide();
            }
            else if ($("#chargingModeText").children('option:selected').val() == "2") {
                $("#tuitionStandardUnit").append("<option value='2' selected>元/天 </option>");
                $("#tuitionStandardUnit").append("<option value='3' >元/月 </option>");
                $("#tuitionStandardUnit").append("<option value='4' >元/季</option>");
                $("#tuitionStandardUnit").append("<option value='5' >元/年</option>");
                $(".classHourDiv").hide();
            } else if ($("#chargingModeText").children('option:selected').val() == "3") {
                $("#tuitionStandardUnit").append("<option value='6' selected>元/期 </option>");
                $(".classHourDiv").show();
            }
        }
    });

    //=============================================

    $.chargingModeChanged();

    $("input[name='classType']").eq(0).attr("checked", "checked");
    $("input[name='classType']").eq(0).click();

    $("input[name='courseStatus']").eq(0).attr("checked", "checked");
    $("input[name='courseStatus']").eq(0).click();

    $('.addCourse input[type=radio]').button();
    $('.addCourse input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });

    $('#newCourse').click(function () {
        $('.addCourse').dialog("option", "title", "新建课程").dialog('open');
    });

    $("#chargingModeText").change(function () {
        $.chargingModeChanged();
    });

    $('#newTeachingMaterial').click(function () {
        var html = '<select id="authorifyselect" multiple="multiple">' +
            '<option  value="1" data-section="教材"  selected>电脑</option>' +
            '<option  value="2" data-section="教材"  selected>钢琴</option>' +
            '<option  value="3" data-section="教材"  selected>跳舞鞋</option>' +
            '<option  value="6" data-section="杂费">手续费</option>' +
            '<option  value="7" data-section="杂费">场地费</option>' +
            '</select>';
        $("#authorityBody").empty().append(html);
        $("#authorifyselect").treeMultiselect({searchable: false, hideSidePanel: false});
        $('.addTeachingMaterial').dialog("option", "title", "教材杂费一览").dialog('open');
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
        $('.addCourse').dialog("option", "title", "编辑课程").dialog('open');
    });

    $("body").on('click', ".detailButton", function () {
        //EditData($(this).get(0));
        window.location.href = "CourseDetail.html";
    });


    $('.addCourse').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 870,
        height: 640,
        title: '新建课程',
        buttons: {
            '保存': function () {
                /*
                 if($("#employeeNameText").val() == ""){
                 alert("姓名不能为空。");
                 $("#employeeNameText").focus();
                 return;
                 }else if($("#employeePhoneText").val() == ""){
                 alert("手机号码不能为空。");
                 $("#employeePhoneText").focus();
                 return;
                 }else if($("#employeeAgeText").val() == ""){
                 alert("年龄不能为空。");
                 $("#employeeAgeText").focus();
                 return;
                 }else if($("#schoolTypeText").children('option:selected').val() == undefined){
                 alert("所属校区不能为空。");
                 $("#schoolTypeText").focus();
                 return;
                 }
                 */
                //$(this).submit();
                $(this).dialog('close');
                //-----------------------------
                var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td></td>").html("22222"));
                tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button> <button class="editButton icon iconfont icon-edit">编辑</button>'));
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
                    for (var i = 0; i < $(this).find("#authorifyselect").children('option:selected').length; i++) {
                        if (teachingMaterialType == $(this).find("#authorifyselect").children('option:selected').eq(i).attr("data-section") &&
                            teachingMaterialName == $(this).find("#authorifyselect").children('option:selected').eq(i).html()) {
                            deleteFlag = false;
                            continue;
                        }
                    }
                    if (deleteFlag) {
                        trs.eq(j).remove();
                    }
                }

                for (var i = 0; i < $(this).find("#authorifyselect").children('option:selected').length; i++) {
                    var teachingMaterialType = $(this).find("#authorifyselect").children('option:selected').eq(i).attr("data-section");
                    var teachingMaterialName = $(this).find("#authorifyselect").children('option:selected').eq(i).html();
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
                    tr.append($("<td></td>").html(teachingMaterialName));
                    tr.append($("<td></td>").html(teachingMaterialType));
                    tr.append($("<td></td>").html('<div class="gw_num"><em class="jian">-</em> <input type="text" value="1" class="num"/> <em class="add">+</em></div>'));
                    tr.append($("<td></td>").html("200"));
                    tr.append($("<td></td>").html("200"));
                    tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button>'));
                    tr.appendTo($("#teachingMaterialDiv").find("tbody"));
                }
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


    $("#search").click(function () {
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
    });

    //加的效果
    $("body").on('click', ".add", function () {
        var price = $(this).parent().parent().parent().children('td:eq(3)').text();
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
        var price = $(this).parent().parent().parent().children('td:eq(3)').text();
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
    var object = byId("courseTypeText");
    object.selectedIndex = -1;

    object = byId("courseTimeText");
    object.selectedIndex = -1;

    object = byId("chargingModeText");
    object.selectedIndex = 0;
}    
