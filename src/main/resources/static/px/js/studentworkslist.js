$(function () {

    $("#uploadPictures").hide();

    $('#selectStudentBtn').click(function () {
        $('.selectStudent').dialog("option", "title", "选择学员").dialog('open');

    });
    
    $("#uploadPictures").click(function () {
        window.location.href = "UploadWorks.html";
    });

    $(".albumListDiv").on("click",".backgroundbutton",function () {
        alert("作品展示画面跳转");
    });

// 学员选择dialog
    $('.selectStudent').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 670,
        height: 500,
        title: '选择学员',
        buttons: {
            '选择': function () {
                if ($lastSelectedStudent) {
                    $(this).dialog('close');

                    /*var tdArr = $lastSelectedStudent.children();

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
                     $('.AddStudent').dialog("option", "title", "选择学员").dialog('open')*/

                    var tdArr = $lastSelectedStudent.children();
                    var studentName = tdArr.eq(0).html();
                    $(".block-title-cpt").html(studentName + "的作品");
                    for (var i = 0; i < 10; i++) {
                        $albumDiv = $('<div class="albumDiv"></div>');
                        $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
                        $imgbutton = $('<button class="backgroundbutton"></button>');
                        $nameSpan = $('<span></span>');
                        $nameSpan.html("美术课程");

                        $albumPanelDiv.append($imgbutton);
                        $albumPanelDiv.append(($nameSpan));
                        $albumDiv.append($albumPanelDiv);
                        $(".albumListDiv").append($albumDiv);
                    }
                    $("#uploadPictures").show();

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
});





