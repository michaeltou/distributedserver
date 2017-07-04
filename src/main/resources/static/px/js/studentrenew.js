$(function () {

    //自定义函数
    //=============================================
    $.extend({
        calculateTotalMoney: function () {
            var receivableMoney = 0;
            var selectedcourses = $(".selectedcourse");
            for (var i = 0; i < selectedcourses.length; i++) {
                var totalMoney = selectedcourses.eq(i).find(".recordList tbody tr td").eq(2).html();
                totalMoney = parseInt(totalMoney);
                if (isNaN(totalMoney)) {
                    totalMoney = 0;
                }

                var tag='元/期';
                if(selectedcourses.eq(i).find(".recordList tbody tr td").eq(2).html().indexOf(tag) ==-1){
                    var totalMoneyUnit = selectedcourses.eq(i).find(".classHourNum").val();
                    totalMoneyUnit = parseInt(totalMoneyUnit);

                    if (isNaN(totalMoneyUnit)) {
                        totalMoneyUnit = 0;
                    }
                    totalMoney = totalMoney * totalMoneyUnit;
                }


                var teachingMaterialMoney1 = selectedcourses.eq(i).find(".recordList tbody tr td").eq(7).html();
                teachingMaterialMoney1 = parseInt(teachingMaterialMoney1);
                if (isNaN(teachingMaterialMoney1)) {
                    teachingMaterialMoney1 = 0;
                }

                var teachingMaterialMoney2 = selectedcourses.eq(i).find(".recordList tbody tr td").eq(8).html();
                teachingMaterialMoney2 = parseInt(teachingMaterialMoney2);
                if (isNaN(teachingMaterialMoney2)) {
                    teachingMaterialMoney2 = 0;
                }

                var discountMoney = selectedcourses.eq(i).find(".recordList tbody tr td").eq(5).html();
                discountMoney = parseInt(discountMoney);
                if (isNaN(discountMoney)) {
                    discountMoney = 0;
                }

                var teachingMaterialRows = selectedcourses.eq(i).find("#teachingMaterialDiv tbody tr");

                for (var j = 0; j < teachingMaterialRows.length; j++) {
                    var teachingMaterialMoney = teachingMaterialRows.eq(j).children().eq(5).html();
                    teachingMaterialMoney = parseInt(teachingMaterialMoney);
                    if (isNaN(teachingMaterialMoney)) {
                        teachingMaterialMoney = 0;
                    }
                    if (teachingMaterialRows.eq(j).children().eq(0).children().attr("checked") === "checked") {
                        totalMoney += teachingMaterialMoney;
                    }
                }

                totalMoney = totalMoney + teachingMaterialMoney1 + teachingMaterialMoney2 - discountMoney;
                receivableMoney += totalMoney;
                totalMoney += "元";
                selectedcourses.eq(i).find(".recordList tbody tr td").eq(9).html(totalMoney);

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
    $("input[name='sex']").eq(0).attr("checked", "checked");
    $("input[name='sex']").eq(0).click();

    $('input[type=radio]').button();
    $('input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });


    //课程选择dialog
    $('#accordingCourse').click(function () {
        $('.selectCourse').dialog("option", "title", "课程选择").dialog('open');
    });

    //班级选择dialog
    $('#accordingClasses').click(function () {
        $('.selectClasses').dialog("option", "title", "班级选择").dialog('open');
    });

    //输入现金变更事件
    $('#cashText').change(function () {
        $.calculateReceivedMoney();
    });

    //输入转账变更事件
    $('#transferAccountsMoneyText').change(function () {
        $.calculateReceivedMoney();
    });

    // 教材杂费选择dialog
    var $teachingMaterialBtnTr;
    $("body").on('click', ".teachingMaterialButton", function () {
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

    $("body").on('click', ".placementButton", function () {
        $('.selectClasses').dialog("option", "title", "班级选择").dialog('open');
    });

    //优惠按钮点击
    var $dicountBtnClickTr;
    $("body").on('click', ".discountButton", function () {
        //alert(($(this).parent().parent().children()).eq(1).html());
        $("#receivableMoneyTextForDialog").text(($(this).parent().parent().children()).get(1).innerHTML);
        $("#discountMoneyTextForDialog").text("0.00");
        $("#discountPercentDiv").hide();
        $("#discountMoneyDiv").hide();
        $dicountBtnClickTr = $(this).parent().parent();
        $('.discountSelect').dialog("option", "title", "优惠设定").dialog('open');
    });

    var $lastSelectedCourse;
    $(".selectCourse .yunmo tr").click(function () {
        if ($lastSelectedCourse) {
            var trSeq = $lastSelectedCourse.parent().find("tr").index($lastSelectedCourse);
            if (trSeq % 2 == 0) {
                $lastSelectedCourse.css("background-color", "white");
            } else {
                $lastSelectedCourse.css("background-color", "#ecf0f1");
            }
        }
        $(this).css("background-color", "#00CCFF");
        $lastSelectedCourse = $(this);
    });

    var $lastSelectedStudent;
    $(".selectStudent .yunmo tr").click(function () {
        if ($lastSelectedStudent) {
            var trSeq = $lastSelectedStudent.parent().find("tr").index($lastSelectedStudent);
            if (trSeq % 2 == 0) {
                $lastSelectedStudent.css("background-color", "white");
            } else {
                $lastSelectedStudent.css("background-color", "#ecf0f1");
            }
        }
        $(this).css("background-color", "#00CCFF");
        $lastSelectedStudent = $(this);
    });

    $("body").on('click', "#teachingMaterialUse", function () {
        if ($(this).attr("checked") === undefined) {
            ($(this).attr("checked", true));
        }
        else {
            ($(this).attr("checked", false));
        }
        $.calculateTotalMoney();
    });

    $("body").on('click', "#teachingMaterialDiv", function () {

        //alert("change");
        $.calculateTotalMoney();

    });

    $("#discountTypeText").change(function () {

        if ($("#discountTypeText").children('option:selected').val() === "原价") {
            $("#discountMoneyTextForDialog").text("0.00");
            $("#discountPercentDiv").hide();
            $("#discountMoneyDiv").hide();
        } else if ($("#discountTypeText").children('option:selected').val() === "打折") {
            $("#discountPercentDiv").show();
            $("#discountMoneyDiv").hide();
            var discountMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney);
        } else if ($("#discountTypeText").children('option:selected').val() === "优惠") {
            $("#discountPercentDiv").hide();
            $("#discountMoneyDiv").show();
            $("#discountMoneyTextForDialog").text("0");
        } else if ($("#discountTypeText").children('option:selected').val() === "先优惠后打折") {
            $("#discountPercentDiv").show();
            $("#discountMoneyDiv").show();
            $("#discountMoney").val("0");
            var discountMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney);

        } else if ($("#discountTypeText").children('option:selected').val() === "先打折后优惠") {
            $("#discountPercentDiv").show();
            $("#discountMoneyDiv").show();
            $("#discountMoney").val("0");
            var discountMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney);
        }
    });

    $("#discountMoney").change(function () {
        var discountMoney = 0;
        if (!isNaN(parseInt($("#discountMoney").val()))) {
            discountMoney = parseInt($("#discountMoney").val())
        }
        var totalMoney = parseInt($("#receivableMoneyTextForDialog").text());

        if ($("#discountTypeText").children('option:selected').val() === "优惠") {
            $("#discountMoneyTextForDialog").text(discountMoney);
        } else if ($("#discountTypeText").children('option:selected').val() === "先优惠后打折") {
            totalMoney -= discountMoney;
            var discountPercentMoney = totalMoney * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney + discountPercentMoney);
        } else if ($("#discountTypeText").children('option:selected').val() === "先打折后优惠") {
            var discountPercentMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney + discountPercentMoney);
        }
    });

    $("#discountPercent").change(function () {
        var discountMoney = 0;
        if (!isNaN(parseInt($("#discountMoney").val()))) {
            discountMoney = parseInt($("#discountMoney").val())
        }
        var totalMoney = parseInt($("#receivableMoneyTextForDialog").text());
        if ($("#discountTypeText").children('option:selected').val() === "打折") {
            $("#discountPercentDiv").show();
            $("#discountMoneyDiv").hide();
            var discountMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney);
        } else if ($("#discountTypeText").children('option:selected').val() === "先优惠后打折") {
            totalMoney -= discountMoney;
            var discountPercentMoney = totalMoney * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney + discountPercentMoney);
        } else if ($("#discountTypeText").children('option:selected').val() === "先打折后优惠") {
            var discountPercentMoney = parseInt($("#receivableMoneyTextForDialog").text()) * ((100 - parseInt($("#discountPercent").children('option:selected').val())) / 100);
            $("#discountMoneyTextForDialog").text(discountMoney + discountPercentMoney);
        }
    });

    $("#imageselect").click(function () {
        $("input[type='file']").click();
    });


    $("body").on('click', ".deleteButton", function () {
        if (window.confirm('确定要删除吗？')) {
            if ($(this).parents("#teachingMaterialDiv").length > 0) {
                DeleteData($(this).get(0));
                $.calculateTotalMoney();
                return true;
            }
            if ($(this).parents(".selectedcourses").children(".selectedcourse").length > 0) {
                $(this).parents(".selectedcourse").remove();
                $.calculateTotalMoney();
                return true;
            } else {
                DeleteData($(this).get(0));
            }
        } else {
            //alert("取消");
            return false;
        }
    });

    $("body").on('click', ".editButton", function () {
        EditData($(this).get(0));
        $('.AddEmplyee').dialog("option", "title", "编辑社员").dialog('open');
    });

    $("body").on('click', ".detailButton", function () {
        window.location.href = "StudentDetail.html";
    });


    // 课程选择dialog
    $('.selectCourse').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 670,
        height: 500,
        title: '选择课程',
        buttons: {
            '选择': function () {
                if ($lastSelectedCourse) {
                    $(this).dialog('close');
                    var tdArr = $lastSelectedCourse.children();
                    var selectedCourseArr = $(".selectedcourse").length;
                    for (var i = 0; i < $(".selectedcourse").length; i++) {
                        if ($(".selectedcourse").eq(i).find("tbody tr td").eq(0).html() === tdArr.eq(0).html()) {
                            alert("不能添加同一门课程");
                            return false;
                        }
                    }
                    var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                    tr.append($("<td></td>").html(tdArr.eq(0).html()));
                    tr.append($("<td></td>").html("未分班"));
                    tr.append($("<td></td>").html(tdArr.eq(2).html()));
                    tr.append($("<td style='text-align: center;'></td>").html('<div><div><input type="text" value="" class="classHourNum"/></div><div class="ClassHourUnit">课时</div></div>'));
                    tr.append($("<td style='text-align:center;'></td>").html('<button type="button" class="discountButton icon iconfont icon-discount">优惠</button>'));
                    tr.append($("<td></td>").html("0"));
                    tr.append($("<td style='text-align:center;'></td>").html('<button type="button" class="teachingMaterialButton icon iconfont icon-add">新增</button>'));
                    tr.append($("<td></td>").html("0"));
                    tr.append($("<td></td>").html("0"));
                    tr.append($("<td></td>").html(tdArr.eq(2).html()));
                    tr.append($("<td style='text-align:center;'></td>").html('<button type="button" class="placementButton icon iconfont icon-office">分班</button><button class="deleteButton icon iconfont icon-delete">删除</button>'));

                    var trDetail = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                    trDetail.append($("<td></td>").html('<input value="" name="teachingMaterialUse"  type="checkbox" id = "teachingMaterialUse">'));
                    trDetail.append($("<td></td>").html("教材"));
                    trDetail.append($("<td></td>").html("教材"));
                    trDetail.append($("<td></td>").html("200"));
                    trDetail.append($("<td></td>").html('<div class="gw_num"><em class="jian">-</em> <input type="text" value="1" class="num"/> <em class="add">+</em></div>'));
                    trDetail.append($("<td></td>").html("130"));
                    trDetail.append($("<td style='text-align:center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button>'));

                    var htmlcourse1 = '<div class = "selectedcourse" style = "padding-top:10px;">' +
                        '<div style="clear:both;"></div>' +
                        '<div style="width:5%; height:20px; padding-top:2px; margin-top:10px; margin-bottom:1px;background-color:#9FF;">' +
                        '<label class ="courseDetailInfoTitle" style="font-size:14px; margin-left:2px;">课程</label>' +
                        '</div>' +
                        '<div class="recordList">' +
                        '<table class="yunmo">' +
                        '<thead>' +
                        '<tr>' +
                        '<th style="width:10%">课程名称</th>' +
                        '<th style="width:10%">班级名称</th>' +
                        '<th style="width:10%">学费</th>' +
                        '<th style="width:10%">数量</th>' +
                        '<th style="width:8%">优惠</th>' +
                        '<th style="width:8%">优惠金额</th>' +
                        '<th style="width:8%">新增教材杂费</th>' +
                        '<th style="width:9%">教材</th>' +
                        '<th style="width:8%">杂费</th>' +
                        '<th style="width:9%">合计</th>' +
                        '<th style="width:10%;min-width: 150px;text-align: center;">操作</th>' +
                        '</tr>' +
                        '</thead>' +
                        '<tbody>' +
                        '<tr>' +
                        tr.html() +
                        '</tr>' +
                        '</tbody>' +
                        '</table>' +
                        '</div>' +
                        '<div style="clear:both;"></div>' +
                        '<div class="recordList"  id = "teachingMaterialDiv" style = "padding-top:10px;">' +
                        '<table class="yunmo" style = "width:60%">' +
                        '<thead>' +
                        '<tr>' +
                        '<th style="width:10%">领用</th>' +
                        '<th style="width:10%">类别</th>' +
                        '<th style="width:12%">教材杂费名</th>' +
                        '<th style="width:10%">价格</th>' +
                        '<th style="width:10%">数量</th>' +
                        '<th style="width:10%">合计</th>' +
                        '<th style="width:15%;min-width: 80px;text-align: center;">操作</th>' +
                        '</tr>' +
                        '</thead>' +
                        '<tbody>' +
                        '<tr>' +
                        trDetail.html() +
                        '</tr>' +
                        '</tbody>' +
                        '</table>' +
                        '</div>' +
                        '</div>';
                    $(".selectedcourses").html($(".selectedcourses").html() + htmlcourse1);
                } else {
                    alert("请选择课程");
                    return false;
                }
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

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
                var trs = $teachingMaterialBtnTr.parents(".selectedcourse").find("#teachingMaterialDiv").find("tbody").children();
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
                        $.calculateTotalMoney(trs.eq(j));
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
                    tr.append($("<td></td>").html('<input value="" name="teachingMaterialUse"  type="checkbox" id = "teachingMaterialUse">'));
                    tr.append($("<td></td>").html(teachingMaterialType));
                    tr.append($("<td></td>").html(teachingMaterialName));
                    //tr.append($("<td></td>").html('<div class="gw_price"> <input type="text" value="1" class="price"/> </div>'));
                    tr.append($("<td></td>").html('200'));
                    tr.append($("<td></td>").html('<div class="gw_num"><em class="jian">-</em> <input type="text" value="1" class="num"/> <em class="add">+</em></div>'));
                    tr.append($("<td></td>").html("200"));
                    tr.append($("<td style='text-align: center;'></td>").html('<input type="button" name="deleteButton" value="删除" class="deleteButton">'));
                    tr.appendTo($teachingMaterialBtnTr.parents(".selectedcourse").find("#teachingMaterialDiv").find("tbody"));
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

    // 班级选择dialog
    $('.selectClasses').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 770,
        height: 500,
        title: '选择班级',
        buttons: {
            '选择': function () {

            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });

    //优惠设定
    $('.discountSelect').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 600,
        height: 250,
        title: '优惠设定',
        buttons: {
            '保存': function () {
                var totalMoney = 0;
                var discountMoney = 0;
                if (!isNaN(parseInt($("#discountMoneyTextForDialog").text()))) {
                    discountMoney = parseInt($("#discountMoneyTextForDialog").text());
                }
                if (!isNaN(parseInt($dicountBtnClickTr.children().eq(1).html()))) {
                    totalMoney += parseInt($dicountBtnClickTr.children().eq(1).html());
                }
                if (!isNaN(parseInt($dicountBtnClickTr.children().eq(5).html()))) {
                    totalMoney += parseInt($dicountBtnClickTr.children().eq(5).html());
                }
                if (!isNaN(parseInt($dicountBtnClickTr.children().eq(6).html()))) {
                    totalMoney += parseInt($dicountBtnClickTr.children().eq(6).html());
                }
                totalMoney -= discountMoney;
                $dicountBtnClickTr.children().eq(3).html(discountMoney);
                $dicountBtnClickTr.children().eq(7).html(totalMoney);
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


    $("#Save").click(function () {
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
        window.location.href = "StudentSignUp.html";
    });

    $("#Cancel").click(function () {
        window.location.href = "StudentSignUp.html";
    });

    //加的效果
    $("body").on('click', ".add", function () {
        //var price = $(this).parent().parent().parent().children('td:eq(3)').find(".price").val();
        var price = $(this).parent().parent().parent().children('td:eq(3)').html();
        price = parseInt(price);
        var n = $(this).prev().val();
        var num = parseInt(n) + 1;
        if (num == 0) {
            return;
        }
        $(this).prev().val(num);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(5)').text(totalPrice);
    });
    //减的效果
    $("body").on('click', ".jian", function () {
        //var price = $(this).parent().parent().parent().children('td:eq(3)').find(".price").val()
        var price = $(this).parent().parent().parent().children('td:eq(3)').html();
        price = parseInt(price);
        var n = $(this).next().val();
        var num = parseInt(n) - 1;
        if (num == 0) {
            return
        }
        $(this).next().val(num);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(5)').text(totalPrice);
    });

    $("body").on("change",".num",function () {
        var price = $(this).parent().parent().parent().children('td:eq(3)').html();
        price = parseInt(price);
        var n = $(this).val();
        var num = parseInt(n);
        var totalPrice = num * price;
        totalPrice += "元";
        $(this).parent().parent().parent().children('td:eq(5)').text(totalPrice);
        $.calculateTotalMoney();
    });

    $("body").on("change",".classHourNum",function () {
        $.calculateTotalMoney();
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
    var object = byId("schoolTypeText");
    object.selectedIndex = -1;

    object = byId("employeeMarriedText");
    object.selectedIndex = -1;

    object = byId("politicalStatusText");
    object.selectedIndex = -1;

    object = byId("educationText");
    object.selectedIndex = -1;

    object = byId("laborRelationsText");
    object.selectedIndex = -1;

    object = byId("personnelStatusText");
    object.selectedIndex = -1;

    object = byId("laborContractText");
    object.selectedIndex = -1;

    object = byId("socialSecurityText");
    object.selectedIndex = -1;
}

function setRadioChecked(id, value) {
    document.getElementById(id).checked = value;
}

var filechange = function (event) {
    var files = event.target.files, file;
    if (files && files.length > 0) {
        // 获取目前上传的文件
        file = files[0];// 文件大小校验的动作
        if (file.size > 1024 * 1024 * 2) {
            alert('图片大小不能超过 2MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file);
        //用attr将img的src属性改成获得的url
        $("#employeeImage").attr("src", imgURL);
        $("#employeeImageHref").attr("href", imgURL);
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);
    }
};