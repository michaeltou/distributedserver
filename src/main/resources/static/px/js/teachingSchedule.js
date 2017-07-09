$(function () {

    $('#calendar').fullCalendar({
        header: {
            left: 'today prev,next ',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listMonth'
        },
        defaultDate: '2017-07-09',
        buttonIcons: false, // show the prev/next text
        weekNumbers: true,
        defaultView: 'agendaWeek', ////初始化时的默认视图，month、agendaWeek、agendaDay
        allDaySlot: false, //agenda视图下是否显示all-day
        allDayText: '全天', //agenda视图下all-day的显示文本
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        eventLimit: true, // 设置为true时，如果数据过多超过日历格子显示的高度时，多出去的数据不会将格子挤开，而是显示为 +...more ，点击后才会完整显示所有的数据
        defaultEventMinutes: 120, //非all-day时，如果没有指定结束时间，默认执行120分钟
        locale: "zh-cn",
        slotMinutes: 30, //agenda视图下两个相邻时间之间的间隔
        //businessHours: true, //区分工作时间
        selectable: true,
        selectHelper: true,
        select: function (start, end) {
            $('.AddClassesTimes').dialog("option", "title", "新增上课时间").dialog('open');
        },
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
        /*dayClick: function(date, allDay, jsEvent, view) {
            var selDate =$.fullCalendar.formatDate(date,'yyyy-MM-dd');
            alert(calEvent.title);
           /!* $.fancybox({
                /!*'type':'ajax',
                'href':'event.php?action=add&date='+selDate*!/
            });*!/
        },*/
        eventClick: function(calEvent, jsEvent, view) {
            alert(calEvent.title);
           /* $.fancybox({
                /!*'type':'ajax',
                'href':'event.php?action=edit&id='+calEvent.id*!/
            });*/
        }
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
                $(this).dialog('close');
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

