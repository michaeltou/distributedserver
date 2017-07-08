$(function () {

    $("#allGroup").click();
    $('input[type=radio]').button();
    $('input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });

    $("#studentSelectBtn").hide();
    $("#courseSelectBtn").hide();
    $("#classSelectBtn").hide();
    $(".remarks").hide();

    $('#studentSelectBtn').click(function () {
        $('.selectStudent').dialog("option", "title", "选择学员").dialog('open');

    });

    $('#courseSelectBtn').click(function () {
        $('.selectCourse').dialog("option", "title", "选择课程").dialog('open');
    });

    $('#classSelectBtn').click(function () {
        $('.selectClasses').dialog("option", "title", "选择班级").dialog('open');
    });


    $("#allGroup").click(function () {
        $("#studentSelectBtn").hide();
        $("#courseSelectBtn").hide();
        $("#classSelectBtn").hide();
        $(".remarks").hide();

        $(".albumListDiv").empty();
        $albumDiv = $('<div class="albumDiv"></div>');
        $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
        $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
        $nameSpan = $('<span></span>');
        $nameSpan.html("全部作品");

        $albumPanelDiv.append($imgbutton);
        $albumPanelDiv.append(($nameSpan));
        $albumDiv.append($albumPanelDiv);

        $(".albumListDiv").append($albumDiv);
    });

    $("#schoolGroup").click(function () {
        $("#studentSelectBtn").hide();
        $("#courseSelectBtn").hide();
        $("#classSelectBtn").hide();
        $(".remarks").hide();

        $(".albumListDiv").empty();
        for (var i = 0; i < 10; i++) {
            $albumDiv = $('<div class="albumDiv"></div>');
            $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
            $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
            $nameSpan = $('<span></span>');
            $nameSpan.html("校区" + (i + 1));

            $albumPanelDiv.append($imgbutton);
            $albumPanelDiv.append(($nameSpan));
            $albumDiv.append($albumPanelDiv);

            $(".albumListDiv").append($albumDiv);
        }
    });

    $("#classGroup").click(function () {
        $("#studentSelectBtn").hide();
        $("#courseSelectBtn").hide();
        $("#classSelectBtn").show();
        $(".remarks").hide();

        $(".albumListDiv").empty();
        for (var i = 0; i < 10; i++) {
            $albumDiv = $('<div class="albumDiv"></div>');
            $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
            $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
            $nameSpan = $('<span></span>');
            $nameSpan.html("班级" + (i + 1));

            $albumPanelDiv.append($imgbutton);
            $albumPanelDiv.append(($nameSpan));
            $albumDiv.append($albumPanelDiv);

            $(".albumListDiv").append($albumDiv);
        }
    });

    $("#courseGroup").click(function () {
        $("#studentSelectBtn").hide();
        $("#courseSelectBtn").show();
        $("#classSelectBtn").hide();
        $(".remarks").hide();

        $(".albumListDiv").empty();
        for (var i = 0; i < 10; i++) {
            $albumDiv = $('<div class="albumDiv"></div>');
            $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
            $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
            $nameSpan = $('<span></span>');
            $nameSpan.html("课程" + (i + 1));

            $albumPanelDiv.append($imgbutton);
            $albumPanelDiv.append(($nameSpan));
            $albumDiv.append($albumPanelDiv);

            $(".albumListDiv").append($albumDiv);
        }
    });

    $("#studentAllGroup").click(function () {
        $("#studentSelectBtn").show();
        $("#courseSelectBtn").hide();
        $("#classSelectBtn").hide();
        $(".remarks").hide();

        $(".albumListDiv").empty();
        for (var i = 0; i < 10; i++) {
            $albumDiv = $('<div class="albumDiv"></div>');
            $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
            $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
            $nameSpan = $('<span></span>');
            $nameSpan.html("学员" + (i + 1));

            $albumPanelDiv.append($imgbutton);
            $albumPanelDiv.append(($nameSpan));
            $albumDiv.append($albumPanelDiv);

            $(".albumListDiv").append($albumDiv);
        }
    });

    $("#studentSingleGroup").click(function () {
        $("#studentSelectBtn").show();
        $("#courseSelectBtn").hide();
        $("#classSelectBtn").hide();
        $(".remarks").show();

        $(".albumListDiv").empty();

    });


    $(".albumListDiv").on("click", ".backgroundimg", function () {
        //alert("作品展示画面跳转");
        window.location.href = "ShowWorks.html";
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

                    var tdArr = $lastSelectedStudent.children();
                    var studentName = tdArr.eq(0).html();
                    $(".block-title-cpt").html(studentName + "的作品");
                    $(".albumListDiv").empty();
                    if ($("#studentAllGroup").is(":checked")) {
                        $albumDiv = $('<div class="albumDiv"></div>');
                        $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
                        $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
                        $nameSpan = $('<span></span>');
                        $nameSpan.html(studentName);

                        $albumPanelDiv.append($imgbutton);
                        $albumPanelDiv.append(($nameSpan));
                        $albumDiv.append($albumPanelDiv);
                        $(".albumListDiv").append($albumDiv);
                    } else if ($("#studentSingleGroup").is(":checked")) {
                        for (var i = 0; i < 10; i++) {
                            $albumDiv = $('<div class="albumDiv"></div>');
                            $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
                            $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
                            $nameSpan = $('<span></span>');
                            $nameSpan.html("课程" + (i + 1));

                            $albumPanelDiv.append($imgbutton);
                            $albumPanelDiv.append(($nameSpan));
                            $albumDiv.append($albumPanelDiv);
                            $(".albumListDiv").append($albumDiv);
                        }
                    }
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
                if ($lastSelectedClass) {
                    $(this).dialog('close');
                    var tdArr = $lastSelectedClass.children();

                    $(".albumListDiv").empty();
                    $albumDiv = $('<div class="albumDiv"></div>');
                    $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
                    $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
                    $nameSpan = $('<span></span>');
                    $nameSpan.html(tdArr.eq(0).html());

                    $albumPanelDiv.append($imgbutton);
                    $albumPanelDiv.append(($nameSpan));
                    $albumDiv.append($albumPanelDiv);
                    $(".albumListDiv").append($albumDiv);
                } else {
                    alert("请选择班级");
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

    var $lastSelectedClass;
    $(".selectClasses .yunmo tr").click(function () {
        if ($lastSelectedClass) {
            var trSeq = $lastSelectedClass.parent().find("tr").index($lastSelectedClass);
            if (trSeq % 2 == 0) {
                $lastSelectedClass.css("background-color", "white");
            } else {
                $lastSelectedClass.css("background-color", "#ecf0f1");
            }
        }
        $(this).css("background-color", "#00CCFF");
        $lastSelectedClass = $(this);
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

                    $(".albumListDiv").empty();
                    $albumDiv = $('<div class="albumDiv"></div>');
                    $albumPanelDiv = $('<div class="albumPanelDiv"></div>');
                    $imgbutton = $('<img src="image/albumcover.jpg" class="backgroundimg"></img>');
                    $nameSpan = $('<span></span>');
                    $nameSpan.html(tdArr.eq(0).html());

                    $albumPanelDiv.append($imgbutton);
                    $albumPanelDiv.append(($nameSpan));
                    $albumDiv.append($albumPanelDiv);
                    $(".albumListDiv").append($albumDiv);
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
});





