$(function () {

    $('#NewStudent').click(function () {
        $('.selectStudent').dialog("option", "title", "新生报名").dialog('open');

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

  // 学员选择dialog
    $('.selectStudent').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 670,
        height: 500,
        title: '选择课程',
        buttons: {
            '选择': function () {
                if ($lastSelectedStudent) {
                    $(this).dialog('close');

                    /*var tdArr = $lastSelectedStudent.children();
                    $("#studentNameText").val(tdArr.eq(0).html());
                    $("#studentPhoneText").val(tdArr.eq(1).html());

                    if(tdArr.eq(3).html() ==="男"){
                        //alert(tdArr.eq(3).html());
                       //
                       $("input[name='sex']").eq(1).click();
                       $("input[name='sex']").eq(1).attr("checked", "checked");
                       $("input[name='sex']").eq(0).removeAttr("checked");
                    }
                    else {
                        //
                       $("input[name='sex']").eq(0).click();
                       $("input[name='sex']").eq(0).attr("checked", "checked");
                       $("input[name='sex']").eq(1).removeAttr("checked");
                    }

                    $("#studentIDText").val(tdArr.eq(2).html());
                    $("#motherPhoneText").val(tdArr.eq(4).html());
                    $("#residenceText").val(tdArr.eq(5).html());

                    $("#studentNameText").attr("disabled",true);
                    $("#studentPhoneText").attr("disabled",true);
                    $("#studentIDText").attr("disabled",true);
                    $("#motherPhoneText").attr("disabled",true);
                    $("#residenceText").attr("disabled",true);
                    $("input[name='sex']").attr("disabled",true);
                    $('.AddStudent').dialog("option", "title", "选择学员").dialog('open')*/;
                    window.location.href = "StudentSignUpRenew.html";
                } else {
                    alert("请选择学员");
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

function setRadioChecked(id, value) {
    document.getElementById(id).checked = value;
}
