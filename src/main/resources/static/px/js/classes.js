$(function () {


    $('.AddClasses input[type=radio]').button();
    $('.AddClasses input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });

    $('#NewClasses').click(function () {
        $editClassDataTr = null;
        $('.AddClasses').dialog("option", "title", "新建班级").dialog('open');
    });

    $('#NewClassesTime').click(function () {
        $('.AddClassesTimes').dialog("option", "title", "新增上课时间").dialog('open');
    });

    $('#addCourse').click(function () {
        if ($('#schoolDistrictText option:selected').val() == undefined ||
            $('#schoolDistrictText option:selected').val() == "") {
            alert("请先选择校区");
            $('#schoolDistrictText').focus();
            return false;
        }

        $('.selectCourse').dialog("option", "title", "选择课程" + "(" + $('#schoolDistrictText option:selected').val() + ")").dialog('open');
    });

    $("#imageselect").click(function () {
        $("input[type='file']").click();
    });

    $("#authoritySettingText").change(function () {
        $.accessDataChanged();
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

    $("body").on('click', ".editTimesButton", function () {
        EditTimesData($(this).get(0));
        $('.AddClassesTimes').dialog("option", "title", "编辑上课时间").dialog('open');
    });

    $("body").on('click', ".detailButton", function () {
        window.location.href = "ClassDetail.html";
    });

    var $editClassDataTr;
    $("body").on('click', ".editButton", function () {
        EditData($(this).get(0));
        $editClassDataTr = $(this).parent().parent();
        $('.AddClasses').dialog("option", "title", "编辑班级").dialog('open');
    });

    $('.AddClasses').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 1270,
        height: 600,
        title: '新建班级',
        buttons: {
            '保存': function () {
                if ($('#schoolDistrictText option:selected').val() == undefined ||
                    $('#schoolDistrictText option:selected').val() == "") {
                    alert("请选择校区。");
                    $('#schoolDistrictText').focus();
                    return false;
                }
                if ($("#courseText").val() == "") {
                    alert("请选择课程。");
                    $("#courseText").focus();
                    return;
                }
                if ($("#classesNameText").val() == "") {
                    alert("班级名称不能为空。");
                    $("#classesNameText").focus();
                    return;
                }
                if ($("#studentUsedUnitText").val() == "") {
                    alert("学生消耗课时不能为空。");
                    $("#studentUsedUnitText").focus();
                    return;
                }
                if ($("#teacherGettedText").val() == "") {
                    alert("老师获得课时不能为空。");
                    $("#teacherGettedText").focus();
                    return;
                }
                if ($("#planStuNumText").val() == "") {
                    alert("请输入预招人数。");
                    $("#planStuNumText").focus();
                    return;
                }

                $(this).dialog('close');
                if ($editClassDataTr) {
                    $editClassDataTr.children("td").eq(0).html($('#classesNameText').val());
                    $editClassDataTr.children("td").eq(1).html($('#planStuNumText').val());
                    $editClassDataTr.children("td").eq(2).html($('#courseText').val());
                    $editClassDataTr.children("td").eq(3).html($("#schoolDistrictText").children('option:selected').val());
                    $editClassDataTr.children("td").eq(4).html($("#managerTeachertText").children('option:selected').val());
                    if ($("input[type='radio'][name='classStartDateStatus']:checked").val() == "未定") {
                        $editClassDataTr.children("td").eq(5).html($("input[type='radio'][name='classStartDateStatus']:checked").val());
                    } else {
                        $editClassDataTr.children("td").eq(5).html($("#classStartDate").val());
                    }
                    //$editClassDataTr.children("td").eq(6).html($("#classStartDate").val());
                    $editClassDataTr.children("td").eq(7).html($("input[type='radio'][name='recruitStuStatus']:checked").val());

                } else {
                    //-----------------------------
                    var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                    tr.append($("<td></td>").html($('#classesNameText').val()));
                    tr.append($("<td></td>").html($("#planStuNumText").val()));
                    tr.append($("<td></td>").html($("#courseText").val()));
                    tr.append($("<td></td>").html($("#schoolDistrictText").children('option:selected').val()));
                    tr.append($("<td></td>").html($("#managerTeachertText").children('option:selected').val()));
                    if ($("input[type='radio'][name='classStartDateStatus']:checked").val() == "未定") {
                        tr.append($("<td></td>").html($("input[type='radio'][name='classStartDateStatus']:checked").val()));
                    } else {
                        tr.append($("<td></td>").html($("#classStartDate").val()));
                    }

                    tr.append($("<td></td>").html("XXXXXXXX"));
                    tr.append($("<td></td>").html($("input[type='radio'][name='recruitStuStatus']:checked").val()));
                    tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button> <button class="editButton icon iconfont icon-edit">编辑</button> <button class="editButton icon iconfont icon-edit">节课</button>'));
                    tr.appendTo($("#classesList tbody"));
                    //------------------------------
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

    // 上课时间dialog
    $('.AddClassesTimes').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 600,
        height: 330,
        title: '新建上课时间',
        buttons: {
            '保存': function () {
                if ($("#teachingTeacherText").val() == "" || $("#teachingTeacherText").val() == undefined) {
                    alert("请选择任课老师。");
                    $("#teachingTeacherText").focus();
                    return false;
                }
                if ($("#teachingClassroomText").val() == "" || $("#teachingTeacherText").val() == undefined) {
                    alert("请选择上课教室。");
                    $("#teachingClassroomText").focus();
                    return false;
                }

                var repeatSetting = "";
                var classDatePeriod = $("#classDatePeriodStart").val() + "~" + $("#classDatePeriodEnd").val();
                var classTimePeriod = $("#classTimeStartHourText").val() + ":" + $("#classTimeStartMinText").val() + "~" + $("#classTimeEndHourText").val() + ":" + $("#classTimeEndMinText").val();
                if ($("input[name='classesWeekAll']").get(0).checked) {
                    repeatSetting = "周一~周日";
                }
                else {
                    if ($("input[name='classesWeek']").get(0).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周一";
                    }
                    if ($("input[name='classesWeek']").get(1).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周二";
                    }
                    if ($("input[name='classesWeek']").get(2).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周三";
                    }
                    if ($("input[name='classesWeek']").get(3).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周四";
                    }
                    if ($("input[name='classesWeek']").get(4).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周五";
                    }
                    if ($("input[name='classesWeek']").get(5).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周六";
                    }
                    if ($("input[name='classesWeek']").get(6).checked) {
                        if (repeatSetting != "") {
                            repeatSetting += "/";
                        }
                        repeatSetting += "周日";
                    }
                }

                if (repeatSetting == "") {
                    alert("请选择周几上课。");
                    return false;
                }
                //$(this).submit();
                $(this).dialog('close');
                //-----------------------------
                var tr = $("<tr></tr>").attr("bgcolor", "#FFFFFF");
                tr.append($("<td></td>").html(classDatePeriod));
                tr.append($("<td></td>").html(repeatSetting));
                tr.append($("<td></td>").html(classTimePeriod));
                tr.append($("<td></td>").html($("#teachingTeacherText").val()));
                tr.append($("<td></td>").html($("#teachingHelpTeacherText").val()));
                tr.append($("<td></td>").html($("#teachingClassroomText").val()));
                tr.append($("<td></td>").html($("#mainSubjectText").val()));
                tr.append($("<td style='text-align: center;'></td>").html('<button class="deleteButton icon iconfont icon-delete">删除</button> <button type="button" class="editTimesButton icon iconfont icon-edit" >编辑</button>'));
                tr.appendTo($("#classesTimeList tbody"));

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
                if ($lastClickTr) {
                    $(this).dialog('close');
                    var tdArr = $lastClickTr.children();
                    $("#courseText").val(tdArr.eq(0).html());
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

    $("#classesWeekAll").click(function () {
        if ($("#classesWeekAll").get(0).checked) {
            WeekAllClick(true);
        } else {
            WeekAllClick(false);
        }
    });

    $("input[name='classesWeek']").click(function () {
        WeekOtherClick();
    });

    $("#undecided").click(function () {
        $("#classStartDate").hide();
        $("#planStuNumDiv").css("padding-left", "195px");
        //$("#undecided").eq(0).attr("checked","checked");
        //$("#decided").eq(0).removeAttr("checked");
        //$("#undecided").eq(0).click();
        setRadioChecked("undecided", true);
        setRadioChecked("decided", false);
    });

    $("#decided").click(function () {
        $("#classStartDate").show();
        $("#planStuNumDiv").css("padding-left", "50px");
        //$("#decided").eq(0).attr("checked","checked");
        //$("#undecided").eq(0).removeAttr("checked");
        //$("#decided").eq(0).click();
        setRadioChecked("undecided", false);
        setRadioChecked("decided", true);
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

    var $lastClickTr;
    $(".selectCourse .yunmo tr").click(function () {
        if ($lastClickTr) {
            var trSeq = $lastClickTr.parent().find("tr").index($lastClickTr);
            if (trSeq % 2 == 0) {
                $lastClickTr.css("background-color", "white");
            } else {
                $lastClickTr.css("background-color", "#ecf0f1");
            }
        }
        $(this).css("background-color", "#00CCFF");
        $lastClickTr = $(this);
    });
});

function WeekAllClick(flag) {
    var fir = document.getElementsByName("classesWeek");
    for (var i = 0; i < fir.length; i++) {
        fir[i].checked = flag;
    }
}

function WeekOtherClick() {
    var allSelectedFlag = true;
    var fir = document.getElementsByName("classesWeek");
    for (var i = 0; i < fir.length; i++) {
        if (fir[i].checked == false) {
            allSelectedFlag = false;
            break;
        }
    }
    document.getElementById("classesWeekAll").checked = allSelectedFlag;
}

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;

    var all_options = byId("schoolDistrictText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[3]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }

    byId("courseText").value = (tr.cells[2]).innerHTML;
    byId("classesNameText").value = (tr.cells[0]).innerHTML;
    byId("planStuNumText").value = (tr.cells[1]).innerHTML;

    all_options = byId("managerTeachertText").options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == (tr.cells[4]).innerHTML)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }

    if ((tr.cells[5]).innerHTML == "未定") {
        byId("undecided").checked = true;
        byId("decided").checked = false;
        byId("undecided").click();
        byId("classStartDate").style.visibility = "hidden";
    } else {
        byId("undecided").checked = false;
        byId("decided").checked = true;
        byId("decided").click();
        byId("classStartDate").value = (tr.cells[5]).innerHTML;
        byId("classStartDate").style.visibility = "visible";
    }

    if ((tr.cells[7]).innerHTML == "招生") {
        byId("recruitStuStarting").checked = true;
        byId("recruitStuStarting").click();
        byId("recruitStuStop").checked = false;

    } else {
        byId("recruitStuStop").checked = true;
        byId("recruitStuStop").click();
        byId("recruitStuStarting").checked = false;
    }
}

function EditTimesData(editRow) {
    var tr = editRow.parentNode.parentNode;
    var classDatePeriod = (tr.cells[0]).innerHTML;
    var datePeriods = classDatePeriod.split("~");
    if (datePeriods.length == 2) {
        byId("classDatePeriodStart").value = datePeriods[0];
        byId("classDatePeriodEnd").value = datePeriods[1];
    }
    var repeatSetting = (tr.cells[1]).innerHTML;
    if (repeatSetting == "周一~周日") {
        WeekAllClick(true);
    }
    else {
        var repeats = repeatSetting.split("/");
        document.getElementById("classesWeek1").checked = contains(repeats, "周一");
        document.getElementById("classesWeek2").checked = contains(repeats, "周二");
        document.getElementById("classesWeek3").checked = contains(repeats, "周三");
        document.getElementById("classesWeek4").checked = contains(repeats, "周四");
        document.getElementById("classesWeek5").checked = contains(repeats, "周五");
        document.getElementById("classesWeek6").checked = contains(repeats, "周六");
        document.getElementById("classesWeek7").checked = contains(repeats, "周日");
    }

    var classTimesPeriod = (tr.cells[2]).innerHTML;
    var classTimesSE = classTimesPeriod.split("~");
    if (classTimesSE.length == 2) {
        var classTimesStart = classTimesSE[0].split(":");
        if (classTimesStart.length == 2) {
            setSelectedValue("classTimeStartHourText", classTimesStart[0]);
            setSelectedValue("classTimeStartMinText", classTimesStart[1]);
        }
        var classTimesEnd = classTimesSE[1].split(":");
        if (classTimesEnd.length == 2) {
            setSelectedValue("classTimeEndHourText", classTimesEnd[0]);
            setSelectedValue("classTimeEndMinText", classTimesEnd[1]);
        }
    }

    setSelectedValue("teachingTeacherText", (tr.cells[3]).innerHTML);
    setSelectedValue("teachingHelpTeacherText", (tr.cells[4]).innerHTML);
    setSelectedValue("teachingClassroomText", (tr.cells[5]).innerHTML);
    byId("mainSubjectText").value = (tr.cells[6]).innerHTML;

}

function setSelectedValue(id, value) {
    var all_options = document.getElementById(id).options;
    for (i = 0; i < all_options.length; i++) {
        if (all_options[i].value == value)  // 根据option标签的ID来进行断  测试的代码这里是两个等号
        {
            all_options[i].selected = true;
        }
    }
}

function setRadioChecked(id, value) {
    document.getElementById(id).checked = value;
}

function contains(arr, obj) {
    var i = arr.length;
    while (i--) {
        if (arr[i] === obj) {
            return true;
        }
    }
    return false;
}


function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

function byId(id) {
    return document.getElementById(id);
}

function load() {
    var object = byId("schoolDistrictText");
    object.selectedIndex = -1;

    object = byId("teacherForSearchText");
    object.selectedIndex = -1;

    object = byId("courseForSearchText");
    object.selectedIndex = -1;

    object = byId("recruitStudentsStatsuForSearchText");
    object.selectedIndex = -1;

    object = byId("classroomText");
    object.selectedIndex = -1;

    object = byId("managerTeachertText");
    object.selectedIndex = -1;

    object = byId("managerHelpTeachertText");
    object.selectedIndex = -1;


}    