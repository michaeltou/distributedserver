$(function () {

    $('#calendar').fullCalendar({
        header: {
            left: 'today prev,next ',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
        },
        buttonText: {
            prev: '<',
            next: '>'
        },

        defaultDate: new Date(),
        minTime: "06:00:00",
        maxTime: "23:00:00",
        buttonIcons: false, // show the prev/next text
        weekNumbers: false,
        //weekMode:'variable', //设定无效???
        defaultView: 'agendaWeek', ////初始化时的默认视图，month、agendaWeek、agendaDay
        allDaySlot: false, //agenda视图下是否显示all-day
        allDayText: '全天', //agenda视图下all-day的显示文本
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        eventStartEditable: false,
        eventLimit: true, // 设置为true时，如果数据过多超过日历格子显示的高度时，多出去的数据不会将格子挤开，而是显示为 +...more ，点击后才会完整显示所有的数据
        defaultEventMinutes: 120, //非all-day时，如果没有指定结束时间，默认执行120分钟

        slotMinutes: 30, //agenda视图下两个相邻时间之间的间隔
        ignoreTimezone: true,
        //businessHours: true, //区分工作时间
        selectable: false,
        selectHelper: true,
        select: function (start, end) {

        },
        //timeFormat: 'h:mm',
        //axisFormat:'H:mm',
        timezone: 'local',
        locale: "zh-cn",
        events: [
            {
                title: "美术一班...",
                start: '2017-07-12 10:30:00',
                end: '2017-07-12 12:30:00',
                className: "美术一班",
                teacherName: "张老师",
                helpTeacherName: "小王",
                classRoomName: "东区一教室",
                mainSubject: "美术",
            },
            {
                title: "美术二班...",
                start: '2017-07-13 10:30:00',
                end: '2017-07-13 12:30:00',
                className: "美术二班",
                teacherName: "李老师",
                helpTeacherName: "小赵",
                classRoomName: "东区二教室",
                mainSubject: "音乐",
            },
            {
                title: "美术三班...",
                start: '2017-07-14 10:30:00',
                end: '2017-07-14 12:30:00',
                className: "美术三班",
                teacherName: "王老师",
                helpTeacherName: "小李",
                classRoomName: "东区三教室",
                mainSubject: "语文",
            },
        ],
        eventRender: function (event, element, view) {
            /* qtip鼠标移动悬浮文案
             * 使用qtip 更丰富内容展示 http://qtip2.com/demos
             */

            var qtipHtml = $("<div></div>");

            qtipHtml.append("开始：" + event.start.format("YYYY-MM-DD HH:mm") + "<br/>")
                .append(function () {
                    if (event.end) {
                        return ("结束：" + event.end.format("YYYY-MM-DD HH:mm") + "<br/>")
                    } else {
                        return ("结束：" + event.start.format("YYYY-MM-DD HH:mm") + "<br/>")
                    }
                })
                .append("班级：" + event.className + "<br/>")
                .append("教师：" + event.teacherName + "<br/>")
                .append("助教：" + event.helpTeacherName + "<br/>")
                .append("教室：" + event.classRoomName + "<br/>")
                .append("主题：" + event.mainSubject);
            element.qtip({
                content: qtipHtml,
                style: {
                    classes: "qtip-my-schedule",
                    tip: {
                        corner: false
                    }
                },
                position: {
                    // target: 'mouse',
                    at: "bottom left"
                }
            });
        },
    });

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
    $(".ordersDetailListDiv").hide();
    $(".coursesDetailListDiv").show();
    $(".classScheduleListDiv").hide();
    $(".classRecordListDiv").hide();

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(3))){
            $(".ordersDetailListDiv").show();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(this).addClass("selected");
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").show();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").show();
            $(".classRecordListDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(2))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").show();
        };
    });

    // [上课记录] =>[编辑]
    $(".classRecordListDiv").on('click', ".editButton", function () {
        window.location.href = "RememberClassDetail.html";
    });

    // [课程] =>[打印听课证]
    $(".coursesDetailListDiv").on('click', ".printClassCardBtn", function () {
        window.location.href = "PrintCourseRegistrationCard.html";
    });

    // [课程] =>[续费]
    $(".coursesDetailListDiv").on('click', ".renewBtn", function () {
        window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[买教材]
    $(".coursesDetailListDiv").on('click', ".buyTextbooksBtn", function () {
        window.location.href = "BuyTeachingMaterial.html";
    });

    // [课程] =>[转班]
    $(".coursesDetailListDiv").on('click', ".classTransferBtn", function () {
        //window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[停课]
    $(".coursesDetailListDiv").on('click', ".suspendClassesBtn", function () {
        //window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[退费]
    $(".coursesDetailListDiv").on('click', ".refundBtn", function () {
        window.location.href = "StudentRefund.html";
    });

    // [课程] =>[结课]
    $(".coursesDetailListDiv").on('click', ".endClassesBtn", function () {
        $('.endClass').dialog("option", "title", "结课确认").dialog('open');
    });

    // [课程] =>[分班]
    $(".coursesDetailListDiv").on('click', ".placementClassesBtn", function () {
        $('.selectClasses').dialog("option", "title", "班级选择").dialog('open');
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


    $(".ordersDetailListDiv").on('click', ".printButton", function () {
        window.location.href = "PrinntFeeVoucher.html";
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

    // 结课dialog
    $('.endClass').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 500,
        height: 300,
        title: '结课确认',
        buttons: {
            '确认': function () {
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

});

function padZero(num, n) {
    if ((num + "").length >= n) {
        return num;
    }
    return padZero("0" + num, n);
}


