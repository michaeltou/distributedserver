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

    $(".studentsDetailListDiv").show();
    $(".classScheduleListDiv").hide();
    $(".classRecordListDiv").hide();
    $(".homeworkListDiv").hide();
    $(".pointTableDiv").hide();
    $(".studentsInfoDiv").hide();

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            $(".studentsDetailListDiv").show();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").show();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(2))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").show();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(3))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").show();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(4))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").show();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(5))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").show();
        }
    });

    $(".classRecordListDiv").on('click', ".editButton", function () {
        window.location.href = "RememberClassDetail.html";
    });

    $(".classRecordListDiv").on('click', ".deleteButton", function () {
        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });

    $(".studentsDetailListDiv").on('click', ".printClassCardBtn", function () {
        //window.location.href = "PrintCourseRegistrationCard.html";
    });
    $(".ordersDetailListDiv").on('click', ".printButton", function () {
        //window.location.href = "PrinntFeeVoucher.html";
    });

    $(".btnPrint").click(function () {
        if ($(this).parents(".pointTableDiv").length > 0) {
            $(this).parents(".pointTableDiv").children(".printDataDiv").printArea();
        } else if ($(this).parents(".studentsInfoDiv").length > 0) {
            $(this).parents(".studentsInfoDiv").children(".printDataDiv").printArea();
        }
    });

    $("#rememberClassBtn").click(function (){

        window.location.href = "RememberClassDetail.html";
    });



});


function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

function padZero(num, n) {
    if ((num + "").length >= n) {
        return num;
    }
    return padZero("0" + num, n);
}

