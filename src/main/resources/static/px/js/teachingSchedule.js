$(function () {

    $.extend({
        addNewSchedule: function () {
            var classDate = $("#classDatePeriodStart").val();
            var classStartTime = padZero($("#classTimeStartHourText option:selected").val(), 2) + ":" + padZero($("#classTimeStartMinText option:selected").val(), 2);
            var classEndTime = padZero($("#classTimeEndHourText option:selected").val(), 2) + ":" + padZero($("#classTimeEndMinText option:selected").val(), 2);
            var teacherName = $("#teachingTeacherText option:selected").val();
            var classRoomName = $("#teachingClassroomText option:selected").val();
            var className = $("#classNameText option:selected").val();
            var mainSubject = $("#mainSubjectText").val();
            var title =
                "班级:" + className + "\r\n" +
                "教师:" + teacherName + "\r\n" +
                "教室:" + classRoomName + "\r\n" +
                "上课主题:" + mainSubject;
            var eventData;
            eventData = {
                //id:"12345",
                title: title,
                start: classDate + " " + classStartTime,
                end: classDate + " " + classEndTime,
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
        editable: true,
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
                title: 'All Day Event',
                start: '2017-05-01'
            },
            {
                title: 'Long Event',
                start: '2017-05-07',
                end: '2017-05-10'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2017-05-09T16:00:00'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2017-05-16T16:00:00'
            },
            {
                title: 'Conference',
                start: '2017-05-11',
                end: '2017-05-13'
            },
            {
                title: 'Meeting',
                start: '2017-05-12T10:30:00',
                end: '2017-05-12T12:30:00'
            },
            {
                title: 'Lunch',
                start: '2017-05-12T12:00:00'
            },
            {
                title: 'Meeting',
                start: '2017-05-12T14:30:00'
            },
            {
                title: 'Happy Hour',
                start: '2017-05-12T17:30:00'
            },
            {
                title: 'Dinner',
                start: '2017-05-12T20:00:00'
            },
            {
                title: 'Birthday Party',
                start: '2017-05-13T07:00:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2017-05-28'
            }
        ],
        dayClick: function (date, allDay, jsEvent, view) {

            /*  获取当前日历中全部的任务,返回的是json数组.
             var arr = $('#calendar').fullCalendar('clientEvents');
             */
            var time = moment(date);
            var startTime = time.format("YYYY-MM-DD");
            $("#classDatePeriodStart").val(startTime);
            $(".ui-dialog-buttonset").children().eq(0).hide();
            $('.AddClassesTimes').dialog("option", "title", "新增上课时间").dialog('open');

        },
        eventClick: function (calEvent, jsEvent, view) {
            if ((calEvent.title + "").length > 0) {

                var arrs = calEvent.title.split("\r\n");
                var className = "";
                var teacherName = "";
                var classRoomName = "";
                var mainSubject = "";
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


                if (arrs.length == 4) {
                    className = (arrs[0].split(":"))[1];
                    teacherName = (arrs[1].split(":"))[1];
                    classRoomName = (arrs[2].split(":"))[1];
                    mainSubject = (arrs[3].split(":"))[1];
                }
                $("#classNameText").val(className);
                $("#classNameText").find("option[text=className]").attr("selected", true);
                $("#teachingTeacherText").val(teacherName);
                $("#teachingTeacherText").find("option[text=teacherName]").attr("selected", true);
                $("#teachingClassroomText").val(classRoomName);
                $("#teachingClassroomText").find("option[text=classRoomName]").attr("selected", true);
                $("#mainSubjectText").val(mainSubject);

                $("#operationType").val("1");
                $calEvent = calEvent;
                $(".ui-dialog-buttonset").children().eq(0).show();
                $('.AddClassesTimes').dialog("option", "title", "编辑上课时间").dialog('open');

            }
        },

        eventMouseover: function (calEvent, jsEvent, view) {

            if (calEvent.title != undefined) {
                /*var startDateTime = new Date(calEvent.start);
                var endDateTime = new Date(calEvent.end);
                var year = startDateTime.getFullYear();
                var month = startDateTime.getMonth() + 1;
                var day = startDateTime.getDate();

                var classStartHour = padZero(startDateTime.getHours(), 2);
                var classStartMin = padZero(startDateTime.getMinutes(), 2);
                var classEndHour = padZero(endDateTime.getHours(), 2);
                var classEndMin = padZero(endDateTime.getMinutes(), 2);
                var classStartDateTime = year + "-" + padZero(month, 2) + "-" + padZero(day, 2) +" "+classStartHour +":"+classStartMin;
                var classEndDateTime = year + "-" + padZero(month, 2) + "-" + padZero(day, 2) +" "+classEndHour +":"+classEndMin;*/

                var startDateTime = moment(calEvent.start);
                var endDateTime = moment(calEvent.end);
                var classStartDateTime = startDateTime.format("YYYY-MM-DD HH:mm");
                var classEndDateTime = endDateTime.format("YYYY-MM-DD HH:mm");
                var title =
                    "开始:"+ classStartDateTime+"\r\n"+
                    "结束:"+ classEndDateTime+"\r\n"+
                    calEvent.title;
                $(this).attr('title', title);
                $(this).css('font-weight', 'normal');
                /*$(this).tooltip({
                 //$(this).css("color",'red');
                 effect: 'toggle',
                 cancelDefault: true

                 });*/


               /* var x=10;
                var y=20;
                var tooltip="<div id='tooltip'>"+title+"</div>";   //创建DIV元素
                $("#link").append(tooltip);  //追加到文档中
                $("#tooltip").css({"top": (jsEvent.pageY+y) + "px","left": (jsEvent.pageX+x) + "px"}).show(); //设置X  Y坐标， 并且显示*/

            }
        },
        /*eventMouseout: function (calEvent, jsEvent, view) {
            $("#tooltip").remove();    //移除
        },*/
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
});

function padZero(num, n) {
    if ((num + "").length >= n) {
        return num;
    }
    return padZero("0" + num, n);
}

