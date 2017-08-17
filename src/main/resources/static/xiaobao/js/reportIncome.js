$(function () {


    /*
     Chart初期参数定义开始
     */
    var color = Chart.helpers.color;
    var barChartData = {
        labels: "",//["校区1", "校区2", "校区3", "校区4", "校区5", "校区6", "校区7", "校区8", "校区9", "校区10"],
        datasets: [{
            label: '总收入',
            backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
            borderColor: window.chartColors.blue,
            borderWidth: 1,
            data: "", //[10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
        },
            {
                label: '总支出',
                backgroundColor: color(window.chartColors.green).alpha(0.5).rgbString(),
                borderColor: window.chartColors.green,
                borderWidth: 1,
                data: "",// [10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },
            {
                label: '总利润',
                backgroundColor: color(window.chartColors.orange).alpha(0.5).rgbString(),
                borderColor: window.chartColors.orange,
                borderWidth: 1,
                data: "",//[10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },
            /*{
                label: '杂费',
                backgroundColor: color(window.chartColors.purple).alpha(0.5).rgbString(),
                borderColor: window.chartColors.purple,
                borderWidth: 1,
                data: "",// [10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },*/
        ]

        /* 四个条形柱分四种颜色显示
         datasets: [{
         data: [45, 25, 20, 10],
         backgroundColor: ['#ff6384','#36a2eb','#cc65fe','#ffce56']
         }],
         labels: ['Red', 'Blue', 'Purple', 'Yellow']*/

    };

    var options = {
        responsive: true,
        legend: {
            position: 'top',
            /* 设置lable的字体颜色
             labels: {
             // This more specific font property overrides the global property
             fontColor: 'red'
             }*/
        },
        title: {
            display: true,
            fontSize: 14,
            text: '各校区总收入'
        },
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                },
                gridLines: {
                    display: true,
                    color: "rgba(255,99,132,0.2)"
                },
                stacked: false,//true:叠加显示柱形图
            }],
            xAxes: [{
                gridLines: {
                    display: false
                },
                stacked: false,//true:叠加显示柱形图
            }]
        },
        layout: {
            padding: {
                left: 50,
                right: 0,
                top: 20,
                bottom: 0
            }
        },
        tooltips: {
            backgroundColor: "rgba(68,55,228,0.8)",
            /*callbacks: {
             labelColor: function(tooltipItem, chart) {
             return {
             /!*borderColor: 'rgb(255, 0, 0)',
             backgroundColor: 'rgb(255, 0, 0)'*!/
             }
             }
             }*/
        }
        /*hover: {
         // Overrides the global setting
         mode: 'index'
         }*/
        /* scales: {
         xAxes: [{
         gridLines: {
         offsetGridLines: false
         }
         }]
         }*/

    };
    /*
     Chart初期参数定义结束
     */

    $(".reportYearDiv").hide();
    $(".reportPeriod").show();
    $(".accordingToSchool").empty();

    var selectedTabIndex = 0;
    $("li").click(function () {
        $(".accordingToSchool").empty();
        $("li").removeClass("active");
        $(this).addClass("active");
        if ($(this).find("a").html() == "按经办校区") {
            selectedTabIndex = 0;
            $(".reportYearDiv").hide();
            $(".reportPeriod").show();
        } else if ($(this).find("a").html() == "按月份") {
            selectedTabIndex = 1;
            $(".reportYearDiv").show();
            $(".reportPeriod").hide();
        }
    });

    /*
     初始化校区信息
     */

    function initialSchoolList() {
        $.ajax({
            url: "/querySchoolListModelByInstitution",
            type: "GET",
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空下拉列表框
                    $(".handingSchoolDiv").empty();


                    $checkboxgroup = $('<div class="checkbox-group" style="float: left"></div>');
                    $inputAllSchool = $('<input value="全部校区" name="handingSchool" type="checkbox" class="handingSchool" checked="checked">');
                    $inputAllSchool.attr("value","全部校区");
                    $checkboxgroup.append($inputAllSchool);
                    $checkboxgroup.append(" 全部校区");
                    $(".handingSchoolDiv").append($checkboxgroup);
                    //动态构建表格数据.
                    $.each(data.data, function (id, school) {
                        $checkboxgroup = $('<div class="checkbox-group" style="float: left"></div>');
                        $input = $('<input value="" name="handingSchool" type="checkbox" class="handingSchool" checked = "checked" style="margin-left: 15px;"/>');
                        var schoolName = school.school_name;
                        $input.attr("value",schoolName);
                        $checkboxgroup.append($input);
                        $checkboxgroup.append(" "+schoolName);
                        $(".handingSchoolDiv").append($checkboxgroup);

                    });//each

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
    initialSchoolList();


    /*
     初始化统计期间
     */
    $('#reportStartDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    $('#reportEndDate').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 2,
        minView: 2

    });

    $('#reportYear').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 4,
        minView: 4

    });

    var nowDate = new Date();
    $('#reportYear').val(nowDate.getFullYear());



    $(".handingSchoolDiv").on("click", ".handingSchool", function () {

        if ($(this).is($(".handingSchool").eq(0))) {
            // 全部校区
            if ($(this).is(":checked")) {
                for (var i = 1; i < $(".handingSchool").length; i++) {
                    if (!$(".handingSchool").eq(i).is(":checked")) {
                        $(".handingSchool").eq(i).click();
                    }
                }
            } else {
                for (var i = 1; i < $(".handingSchool").length; i++) {
                    if ($(".handingSchool").eq(i).is(":checked")) {
                        $(".handingSchool").eq(i).click();
                    }
                }
            }

        } else {
            if ($(this).is(":checked")) {
                var bAllChecked = true;
                for (var i = 1; i < $(".handingSchool").length; i++) {
                    if (!$(".handingSchool").eq(i).is(":checked")) {
                        bAllChecked = false;
                        break;
                    }
                }
                if (bAllChecked) {
                    if (!$(".handingSchool").eq(0).is(":checked")) {
                        $(".handingSchool").eq(0).click();
                    }
                }
            } else {
                if ($(".handingSchool").eq(0).is(":checked")) {
                    $(".handingSchool").eq(0).prop("checked", false);
                    $(".handingSchool").eq(0).removeAttr("checked");
                }
            }
        }
    });

    $("#createReport").click(function () {
        if(selectedTabIndex == 0){
            getReportData();
        }
        else {
            getReportDataByYear();
        }

    });



    $("#exportReport").click(function () {
        if ($(".accordingToSchool table tbody tr").length == 0) {
            alert("没有要导出的数据");
            return;

        }
        table2excel("recordList", selectedTabIndex);

    });

    function getReportData() {

        var schoolList = "";
        for(var i = 1;i<$(".handingSchool").length;i++){
            if($(".handingSchool").eq(i).is(":checked")){
                if(schoolList == ""){
                    schoolList += $(".handingSchool").eq(i).attr("value");
                }
                else {
                    schoolList +="," + $(".handingSchool").eq(i).attr("value");
                }
            }
        }

        if(schoolList == ""){
            alert("请至少选择一个校区");
            return;
        }

        $.ajax({
            url: "/queryBaoBiao1ListByInstitution",
            type: "GET",
            data: {
                schoolList:schoolList,
                startDate:$("#reportStartDate").val(),
                endDate:$("#reportEndDate").val(),
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    //alert(JSON.stringify(data)); //调试使用，请勿删除

                    initialHtml();
                    chartAccordingToSchool(data.data);
                    tableAccordingToSchool(data.data);

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

    function getReportDataByYear() {

        var schoolList = "";
        for(var i = 1;i<$(".handingSchool").length;i++){
            if($(".handingSchool").eq(i).is(":checked")){
                if(schoolList == ""){
                    schoolList += $(".handingSchool").eq(i).attr("value");
                }
                else {
                    schoolList +="," + $(".handingSchool").eq(i).attr("value");
                }
            }
        }

        if(schoolList == ""){
            alert("请至少选择一个校区");
            return;
        }

        $.ajax({
            url: "/queryShouZhiDetailListByInstitutionForYear",
            type: "GET",
            data: {
                schoolList:schoolList,
                reportYear:$("#reportYear").val()
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus) {
                if (data.success) {
                    //alert(JSON.stringify(data)); //调试使用，请勿删除

                    initialHtml();
                    $(".accordingToSchool table thead tr th").eq(0).html("月份");
                    chartAccordingToMonth(data.data);
                    tableAccordingToMonth(data.data);

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

    function initialHtml() {
        /*var html = '<div class="chartContainer">' +
            ' <canvas class="canvas"></canvas>' +
            '</div>' +
            ' <div style="clear: both;height: 20px;width: 100%;"></div>' +
            '<div class="recordList" style="padding-top: 20px;">' +
            '<table class="yunmo" id = "yunmo">' +
            '<thead>' +
            '<tr>' +
            '<th style="width:20%;">经办校区</th>' +
            '<th style="width:20%;">学费</th>' +
            '<th style="width:20%;">教材费</th>' +
            '<th style="width:20%;">杂费</th>' +
            '<th style="width:20%;">总计</th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>' +
            '</tbody>' +
            '</table>' +
            '</div>';*/

        var html = '<div class="chartContainer">' +
            '<canvas class="canvas"></canvas>'+
            '</div>'+
            '<div class="table-responsive">'+
            '<table class="table table-striped table-hover" id = "recordList">'+
            '<thead >'+
            '<tr>'+
            '<th style="width:25%;"> 经办校区</th>'+
            '<th style="width:25%;"> 总收入</th>'+
            '<th style="width:25%;"> 总支出</th>'+
            '<th style="width:25%;"> 总利润</th>'+
            '</tr>'+
            '</thead>'+
            '<tbody id="mytablebody">'+
            '</tbody>'+
            '</table>'+
            '</div>';
        $(".accordingToSchool").empty().append(html);

    }


    function chartAccordingToSchool(dataList) {

        var schoolList = new Array();
        var shouruList = new Array();
        var zhichuList = new Array();
        var lirunList = new Array();
        var index = 0;
        $.each(dataList, function (id, data) {
            schoolList[index] = data.handingSchool;
            shouruList[index] = data.shouru;
            zhichuList[index] = data.zhichu;
            lirunList[index] = data.lirun;
            index++;



        });//each
        barChartData.labels = schoolList;
        barChartData.datasets[0].data = shouruList;
        barChartData.datasets[1].data = zhichuList;
        barChartData.datasets[2].data = lirunList;
        /*for (var i = 0; i < barChartData.datasets.length; i++) {
            barChartData.datasets[i].data = [10, 23, 13, 18, 44, 32, 24, 55, 23, 64];
        }*/
        var ctx = ($(".canvas").get(0)).getContext("2d");
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: options,
        });

    }

    function tableAccordingToSchool(dataList) {

        $.each(dataList, function (id, data) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html(data.handingSchool));
            $tr.append($td.clone().html(data.shouru));
            $tr.append($td.clone().html(data.zhichu));
            $tr.append($td.clone().html(data.lirun));
            $(".accordingToSchool table tbody").append($tr);


        });//each
    }

    function chartAccordingToMonth(dataList) {

        barChartData.labels = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];
        var shouruList = new Array();
        var zhichuList = new Array();
        var lirunList = new Array();
        var index = 0;
        $.each(dataList, function (id, data) {
            shouruList[index] = data.shouru;
            zhichuList[index] = data.zhichu;
            lirunList[index] = data.lirun;
            index++;



        });//each
        barChartData.datasets[0].data = shouruList;
        barChartData.datasets[1].data = zhichuList;
        barChartData.datasets[2].data = lirunList;

        /*for (var i = 0; i < barChartData.datasets.length; i++) {
            barChartData.datasets[i].data = [10, 23, 13, 18, 44, 32, 24, 55, 23, 64, 100, 59];
        }*/


        var ctx = ($(".canvas").get(0)).getContext("2d");
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: options,
        });
    }

    function tableAccordingToMonth(dataList) {
        /*for (var i = 0; i < 10; i++) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html("2017年06月"));
            $tr.append($td.clone().html("12345"));
            $tr.append($td.clone().html("111"));
            $tr.append($td.clone().html("2222"));
            $(".accordingToSchool table tbody").append($tr);
        }*/

        $.each(dataList, function (id, data) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html(data.month));
            $tr.append($td.clone().html(data.shouru));
            $tr.append($td.clone().html(data.zhichu));
            $tr.append($td.clone().html(data.lirun));
            $(".accordingToSchool table tbody").append($tr);


        });//each
    }
});


function table2excel(tableid, reportType) {
    tableToExcel(tableid, reportType);
}
var tableToExcel = (function () {
    var uri = 'data:text/xls;charset=utf-8,\ufeff,',
        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64 = function (s) {
            return window.btoa(encodeURIComponent(s))
        },
        format = function (s, c) {
            return s.replace(/{(\w+)}/g,
                function (m, p) {
                    return c[p];
                }
            )
        }
    return function (table, reportType) {
        var sheetName = "Worksheet";
        var xlsName = "财务收入.xls";
        if (reportType == 1) {
            //var obj = document.getElementById("reportYear");
            //var index = obj.selectedIndex; // 选中索引
            //sheetName = obj.options[index].text; // 选中文本
            //var value = obj.options[index].value; // 选中值
            sheetName = $("#reportYear").val();
            xlsName = "财务收入" + "_" + sheetName + ".xls";
        }
        else if (reportType == 0) {
            var start = document.getElementById("reportStartDate").value;
            var end = document.getElementById("reportEndDate").value;
            if (start == "" && end == "") {
                sheetName = "全部";
            } else {
                sheetName = start + "-" + end;
            }
            xlsName = "财务收入_按校区" + "(" + sheetName + ")" + ".xls";

        }
        if (!table.nodeType)
            table = document.getElementById(table)
        var ctx =
            {
                worksheet: sheetName,
                table: table.innerHTML
                //table:'<thead><tr><th style="width:20%;">经办校区</th><th style="width:20%;">学费</th><th style="width:20%;">教材费</th><th style="width:20%;">杂费</th><th style="width:20%;">总计</th></tr></thead><tbody><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr><tr><td>东校区</td><td>12345</td><td>111</td><td>2222</td><td>34567</td></tr></tbody>'
            }

        //window.location.href = uri + base64(format(template, ctx))
        var downloadLink = document.createElement("a");
        downloadLink.href = uri + format(template, ctx);

        downloadLink.download = xlsName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    }
})()