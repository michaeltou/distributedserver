$(function () {

    $.extend({
        addNewSchedule: function () {
            var classDate = $("#classDatePeriodStart").val();
            var classStartTime = padZero($("#classTimeStartHourText option:selected").val(), 2) + ":" + padZero($("#classTimeStartMinText option:selected").val(), 2);
            var classEndTime = padZero($("#classTimeEndHourText option:selected").val(), 2) + ":" + padZero($("#classTimeEndMinText option:selected").val(), 2);
            var teacherName = $("#teachingTeacherText option:selected").val();
            var helpTeacherName = $("#teachingHelpTeacherText option:selected").val();
            var classRoomName = $("#teachingClassroomText option:selected").val();
            var className = $("#classNameText option:selected").val();
            var mainSubject = $("#mainSubjectText").val();
            var eventData;
            eventData = {
                //id:"12345",
                title: className,
                start: classDate + " " + classStartTime,
                end: classDate + " " + classEndTime,
                className: className,
                teacherName: teacherName,
                helpTeacherName: helpTeacherName,
                classRoomName: classRoomName,
                mainSubject: mainSubject,
            };
            $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true

        }
    });
    var $calEvent;
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
        eventStartEditable:false,
        eventLimit: true, // 设置为true时，如果数据过多超过日历格子显示的高度时，多出去的数据不会将格子挤开，而是显示为 +...more ，点击后才会完整显示所有的数据
        defaultEventMinutes: 120, //非all-day时，如果没有指定结束时间，默认执行120分钟

        slotMinutes: 30, //agenda视图下两个相邻时间之间的间隔
        ignoreTimezone: true,
        //businessHours: true, //区分工作时间
        selectable: true,
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
        dayClick: function (date, allDay, jsEvent, view) {

            /*  获取当前日历中全部的任务,返回的是json数组.
             var arr = $('#calendar').fullCalendar('clientEvents');
             */

            var startTime = moment(date);
            var endTime = moment(new Date(Date.parse(startTime) + (60000 * 30)));
            var startDate = startTime.format("YYYY-MM-DD");
            var classStartHour = startTime.format("HH");
            var classStartMin = startTime.format("mm");
            var classEndHour = endTime.format("HH");
            var classEndMin = endTime.format("mm");

            $("#classDatePeriodStart").val(startDate);
            $("#classTimeStartHourText").val(classStartHour);
            $("#classTimeStartHourText").find("option[text=classStartHour]").attr("selected", true);
            $("#classTimeStartMinText").val(classStartMin);
            $("#classTimeStartMinText").find("option[text=classStartMin]").attr("selected", true);
            $("#classTimeEndHourText").val(classEndHour);
            $("#classTimeEndHourText").find("option[text=classEndHour]").attr("selected", true);
            $("#classTimeEndMinText").val(classEndMin);
            $("#classTimeEndMinText").find("option[text=classEndMin]").attr("selected", true);
            $(".ui-dialog-buttonset").children().eq(0).hide();
            $('.confirmDialog').dialog("option", "title", "确认").dialog('open');
        },
        eventClick: function (calEvent, jsEvent, view) {
            if ((calEvent.title + "").length > 0) {

                var className = calEvent.className;
                var teacherName = calEvent.teacherName;
                var helpTeacherName = calEvent.helpTeacherName;
                var classRoomName = calEvent.classRoomName;
                var mainSubject = calEvent.mainSubject;
                /*var startDateTime = new Date(calEvent.start);
                 var endDateTime = new Date(calEvent.end);
                 var year = startDateTime.getFullYear();
                 var month = startDateTime.getMonth() + 1;
                 var day = startDateTime.getDate();
                 var classDate = year + "-" + padZero(month, 2) + "-" + padZero(day, 2);
                 var classStartHour = padZero(startDateTime.getHours(), 2);
                 var classStartMin = padZero(startDateTime.getMinutes(), 2);
                 var classEndHour = padZero(endDateTime.getHours(), 2);
                 var classEndMin = padZero(endDateTime.getMinutes(), 2);*/

                var startDateTime = moment(calEvent.start);
                var endDateTime = moment(calEvent.end);
                var classDate = startDateTime.format("YYYY-MM-DD");
                var classStartHour = startDateTime.format("HH");
                var classStartMin = startDateTime.format("mm");
                var classEndHour = endDateTime.format("HH");
                var classEndMin = endDateTime.format("mm");

                $("#classDatePeriodStart").val(classDate);
                $("#classTimeStartHourText").val(classStartHour);
                $("#classTimeStartHourText").find("option[text=classStartHour]").attr("selected", true);
                $("#classTimeStartMinText").val(classStartMin);
                $("#classTimeStartMinText").find("option[text=classStartMin]").attr("selected", true);
                $("#classTimeEndHourText").val(classEndHour);
                $("#classTimeEndHourText").find("option[text=classEndHour]").attr("selected", true);
                $("#classTimeEndMinText").val(classEndMin);
                $("#classTimeEndMinText").find("option[text=classEndMin]").attr("selected", true);

                $("#classNameText").val(className);
                $("#classNameText").find("option[text=className]").attr("selected", true);
                $("#teachingTeacherText").val(teacherName);
                $("#teachingTeacherText").find("option[text=teacherName]").attr("selected", true);
                $("#teachingHelpTeacherText").val(helpTeacherName);
                $("#teachingHelpTeacherText").find("option[text=helpTeacherName]").attr("selected", true);
                $("#teachingClassroomText").val(classRoomName);
                $("#teachingClassroomText").find("option[text=classRoomName]").attr("selected", true);
                $("#mainSubjectText").val(mainSubject);

                $("#operationType").val("1");
                $calEvent = calEvent;
                $(".ui-dialog-buttonset").children().eq(0).show();
                $('.AddClassesTimes').dialog("option", "title", "编辑上课时间").dialog('open');

            }
        },

        eventRender: function (event, element, view) {
            /* qtip鼠标移动悬浮文案
             * 使用qtip 更丰富内容展示 http://qtip2.com/demos
             */
            if (event.title != undefined) {
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
            }

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
            '删除': function () {
                //删除当前日程
                $('#calendar').fullCalendar('removeEvents', function (event) {
                    return event == $calEvent;
                });
                $(this).dialog('close');
                $("#operationType").val("0");
            },
            '保存': function () {
                var classStartTime = padZero($("#classTimeStartHourText option:selected").val(), 2) + ":" + padZero($("#classTimeStartMinText option:selected").val(), 2);
                var classEndTime = padZero($("#classTimeEndHourText option:selected").val(), 2) + ":" + padZero($("#classTimeEndMinText option:selected").val(), 2);
                if ($("#classTimeStartHourText option:selected").val() > $("#classTimeEndHourText option:selected").val()) {
                    alert("上课结束时间必须大于上课开始时间.");
                    return false;
                } else if ($("#classTimeStartHourText option:selected").val() == $("#classTimeEndHourText option:selected").val()) {
                    if ($("#classTimeStartMinText option:selected").val() >= $("#classTimeEndMinText option:selected").val()) {
                        alert("上课结束时间必须大于上课开始时间.");
                        return false;
                    }
                }

                // $("#operationType").val() == 0 新建日程
                // $("#operationType").val() == 1 编辑日程
                // $("#operationType").val() == 2 删除日程
                if ($("#operationType").val() == "1") {
                    //删除当前日程
                    $('#calendar').fullCalendar('removeEvents', function (event) {
                        return event == $calEvent;
                    });
                    $.addNewSchedule();
                } else if ($("#operationType").val() == "0") {
                    $.addNewSchedule();
                }
                $(this).dialog('close');
                $("#operationType").val("0");
                $calEvent = "";
            },
            '取消': function () {
                $(this).dialog('close');
                $("#operationType").val("0");
                $calEvent = "";

            },
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });

    // 确认dialog
    $('.confirmDialog').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 300,
        height: 150,
        title: '确认',
        buttons: {
            '确定': function () {
                $(this).dialog('close');
                $('.AddClassesTimes').dialog("option", "title", "创建日程").dialog('open');
            },
            '取消': function () {
                $(this).dialog('close');
            },
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

Date.prototype.DateAdd = function(strInterval, Number) {
    var dtTmp = this;
    alert(dtTmp);
    switch (strInterval) {
        case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
}


