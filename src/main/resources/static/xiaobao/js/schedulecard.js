$(function () {

    function initialEvent() {
        $.ajax({
            url: "/queryBanjiPaikeItemListForEventByInstitution",
            type: "GET",
            data: "",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    //alert(JSON.stringify(data.data)); //调试使用，请勿删除
                    for(var i = 0;i<data.data.length;i++){
                        $('#calendar').fullCalendar('renderEvent', data.data[i], true); // stick? = true
                    }


                }
                else {
                    alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });//ajax
    }


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
        selectable: false,
        selectHelper: true,
        select: function (start, end) {

        },
        //timeFormat: 'h:mm',
        //axisFormat:'H:mm',
        timezone: 'local',
        locale: "zh-cn",
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
                    .append("班级：" + event.banji_name + "<br/>")
                    .append("教师：" + event.teacher_name + "<br/>")
                    .append("助教：" + event.assist_teacher_name + "<br/>")
                    .append("教室：" + event.classroom_name + "<br/>")
                    .append("主题：" + event.classSubject);
                element.qtip({
                    content: qtipHtml,
                    show: 'mouseover',
                    hide: 'mouseout',
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

    $("#calendar").mouseout(function(){
        $(".qtip-content").hide();
    });
    $("#calendar").mouseover(function(){
        $(".qtip-content").show();
    });

    initialEvent();

    $("#searchBtn").click(function () {

        $.ajax({
            url: "/queryBanjiPaikeItemListByFilter",
            type: "GET",
            data: {
                schoolName: $("#shcoolName option:selected").val(),
                className: $("#className option:selected").val(),
                teacherName: $("#teacherName option:selected").val(),
                classRoomName: $("#classRoomName option:selected").val()
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    $('#calendar').fullCalendar( 'removeEvents');
                    for(var i = 0;i<data.data.length;i++){
                        $('#calendar').fullCalendar('renderEvent', data.data[i], true); // stick? = true
                    }
                }
                else {
                    alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });//ajax
    });

});

function padZero(num, n) {
    if ((num + "").length >= n) {
        return num;
    }
    return padZero("0" + num, n);
}


