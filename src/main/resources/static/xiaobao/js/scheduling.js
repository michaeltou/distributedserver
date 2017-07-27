$(function () {
    $.extend({
        addNewSchedule: function () {
            var classDate = $("#classesDate").val();
            var classStartTime = $("#startTime").val();
            var classEndTime = $("#endTime").val();
            var teacherName = $("#teacherName option:selected").text();
            var teachersfzCode = $("#teacherName option:selected").val();
            var helpTeacherName = $("#helpTeacherName option:selected").text();
            var helpTeachersfzCode = $("#helpTeacherName option:selected").val();
            var classRoomName = $("#classRoomName option:selected").val();
            var className = $("#className option:selected").val();
            var schoolName = "";
            var mainSubject = $("#classSubject").val();
            var eventData;
            eventData = {
                id:"",
                title:className,
                xiaoqu_name: schoolName,
                classroom_name:classRoomName ,
                start: classDate + " " + classStartTime+":00",
                end: classDate + " " + classEndTime+":00",
                banji_name: className,
                teacher_name:teacherName,
                jiaoshi_sfzCode: teachersfzCode,
                assist_teacher_name:helpTeacherName,
                assist_teacher_sfzCode:helpTeachersfzCode,
                classSubject:mainSubject,
                status:1,
                rule_id:1
            };

            //===================================
            var url = "/insertBanjiPaikeItem";
            $.ajax({
                type: "post",
                url: url,
                async:false,
                /**     * 关键点：获取post请求的参数，有2个关键点：
                 * 1、java接口需要加上@RequestBody这个注解.
                 * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
                 * */
                data: JSON.stringify(eventData),
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                success: function (data, textStatus) {
                    if (data.success) {
                        //清空表格数据
                        $("#myform1")[0].reset();
                        $("#myform2")[0].reset();
                        eventData.id = data.data;
                    }
                    else {
                        /*$("#failLabel").css("display:block");*/
                        alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("系统异常！");
                }
            });

            //======================================
            //initialEvent();
            $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
            //$("#paikeguanli").click();

        }
    });
    
    function checkConflict () {
        var classDate = $("#classesDate").val();
        var classStartTime = $("#startTime").val();
        var classEndTime = $("#endTime").val();
        var teacherName = $("#teacherName option:selected").text();
        var teachersfzCode = $("#teacherName option:selected").val();
        var helpTeacherName = $("#helpTeacherName option:selected").text();
        var helpTeachersfzCode = $("#helpTeacherName option:selected").val();
        var classRoomName = $("#classRoomName option:selected").val();
        var className = $("#className option:selected").val();
        var schoolName = "";
        var mainSubject = $("#classSubject").val();
        var eventData;
        eventData = {
            id:"",
            title:className,
            xiaoqu_name: schoolName,
            classroom_name:classRoomName ,
            start: classDate + " " + classStartTime+":00",
            end: classDate + " " + classEndTime+":00",
            banji_name: className,
            teacher_name:teacherName,
            jiaoshi_sfzCode: teachersfzCode,
            assist_teacher_name:helpTeacherName,
            assist_teacher_sfzCode:helpTeachersfzCode,
            classSubject:mainSubject,
            status:1,
            rule_id:1
        };

        //===================================
        var bCheckedResult;
        var url = "/checkBanjiPaikeItem";
        $.ajax({
            type: "post",
            url: url,
            async:false,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify(eventData),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    bCheckedResult = true;
                }
                else {
                    alert("错误详情：" + data.errorMsg);
                    bCheckedResult = false;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
                bCheckedResult = false;
            }
        });

        return bCheckedResult;
    }

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

    function deleteEvent(id) {
        $.ajax({
            type: "post",
            url: "/deleteBanjiPaikeItem",
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id: id
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {
                    $('#myDeleteModal').modal('hide');
                    //$("#xiaoquguanli").click();
                }
                else {
                    alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统异常！");
            }
        });
    }


    var $calEvent;
    $('#classesDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    $('#startTime').datetimepicker({
        language:  'zh-CN',
        format: 'hh:ii',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0

    });

    $('#endTime').datetimepicker({
        language:  'zh-CN',
        format: 'hh:ii',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0

    });


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

        /*events: function(callback) {
            $.ajax({
                url: "/queryBanjiPaikeItemListForEventByInstitution",
                type: "GET",
                data: "",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data, textStatus) {
                    if (data.success) {
                        //alert(JSON.stringify(data.data)); //调试使用，请勿删除
                        var events = [];
                        $.each(data.data,function(i,c) {

                            events.push({
                                id:c.id,
                                title:c.title,
                                xiaoqu_name: c.xiaoqu_name,
                                classroom_name:c.classroom_name ,
                                start: c.start,
                                end: c.end,
                                banji_name: c.banji_name,
                                teacher_name:c.teacher_name,
                                jiaoshi_sfzCode: c.jiaoshi_sfzCode,
                                assist_teacher_name:c.assist_teacher_name,
                                assist_teacher_sfzCode:c.assist_teacher_sfzCode,
                                classSubject:c.classSubject,
                                status:c.status,
                                rule_id:c.rule_id
                            });

                        });
                        alert(events);

                    }
                    else {
                        alert("发生了错误！错误码：" + data.errorCode + ",错误详情：" + data.errorMsg);
                    }
                    callback(events);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("系统异常！");
                }
            });//ajax
        },*/

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

            $('#classesDate').val(startDate);

            var strDate =startDate + " " + classStartHour+":"+classStartMin + ":00"
            $('#startTime').val(classStartHour+":"+classStartMin);
            $('#startTime').datetimepicker('setDate',ConvertString2Date(strDate));

            strDate =startDate + " " + classEndHour+":"+classEndMin + ":00"
            $('#endTime').val(classEndHour+":"+classEndMin);
            $('#endTime').datetimepicker('setDate',ConvertString2Date(strDate));

            //显示属性框.
            $('#myConfirmModal').modal('show');
            return false;
        },
        eventClick: function (calEvent, jsEvent, view) {
            if ((calEvent.title + "").length > 0) {

                var className = calEvent.banji_name;
                var teacherName = calEvent.teacher_name;
                var helpTeacherName = calEvent.assist_teacher_name;
                var classRoomName = calEvent.classroom_name;
                var mainSubject = calEvent.classSubject;

                var startDateTime = moment(calEvent.start);
                var endDateTime = moment(calEvent.end);
                var classDate = startDateTime.format("YYYY-MM-DD");
                var classStartHour = startDateTime.format("HH");
                var classStartMin = startDateTime.format("mm");
                var classEndHour = endDateTime.format("HH");
                var classEndMin = endDateTime.format("mm");

                $('#classesDate').val(classDate);

                var strDate =classDate + " " + classStartHour+":"+classStartMin + ":00"
                $('#startTime').val(classStartHour+":"+classStartMin);
                $('#startTime').datetimepicker('setDate',ConvertString2Date(strDate));

                strDate =classDate + " " + classEndHour+":"+classEndMin + ":00"
                $('#endTime').val(classEndHour+":"+classEndMin);
                $('#endTime').datetimepicker('setDate',ConvertString2Date(strDate));

                $("#teacherName").val(calEvent.jiaoshi_sfzCode);
                $("#helpTeacherName").val(calEvent.assist_teacher_sfzCode);
                $("#classRoomName").val(classRoomName);
                $("#className").val(className);
                $("#classSubject").val(mainSubject);


                $("#operationType").val("1");
                $calEvent = calEvent;
                $("#addClassesTimesModal .modal-footer button").eq(2).show();
                $('#addClassesTimesModalLabel').text("编辑上课时间");
                $('#addClassesTimesModal').modal('show');
                return false;
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

    $("#confirmObjectBtnInModal").click(function () {
        $('#myConfirmModal').modal('hide');

        $('#addClassesTimesModalLabel').text("新增上课时间");
        $("#addClassesTimesModal .modal-footer button").eq(2).hide();
        $('#addClassesTimesModal').modal('show');
        return false;

    });

    $("#saveObjectBtnInModal").click(function () {
        if(!checkConflict ()){
            return;
        }
        if ($("#operationType").val() == "1") {
            //更新当前日程
            var id = "";
            $('#calendar').fullCalendar('removeEvents', function (event) {
                if (event == $calEvent){
                    id = event.id;
                }
                return event == $calEvent;
            });
            if(id !=  ""){
                deleteEvent(id);
                $.addNewSchedule();
            }
        } else if ($("#operationType").val() == "0") {
            $.addNewSchedule();
        }
        $('#addClassesTimesModal').modal('hide');


    });

    $("#deleteObjectBtnInModal").click(function () {
        var id = "";
        $('#calendar').fullCalendar('removeEvents', function (event) {
            if (event == $calEvent){
                id = event.id;
            }
            return event == $calEvent;
        });
        if(id !=  ""){
            deleteEvent(id);
        }
        $('#addClassesTimesModal').modal('hide');

    });

    $('#myConfirmModal').on('hidden.bs.modal', function () {

    });

    $('#addClassesTimesModal').on('hidden.bs.modal', function () {
        // 执行一些动作...
        //$("#paikeguanli").click();
    });

    $('#addClassesTimesModal').on('hidden.bs.modal', function () {
        $("#operationType").val("0");
        $calEvent = "";
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

function  ConvertString2Date(strDate) {
    strDate = strDate.replace(/-/g,"/");
    var date = new Date(strDate);
    return date;
}


