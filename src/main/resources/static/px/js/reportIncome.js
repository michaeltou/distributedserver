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
                label: '学费',
                backgroundColor: color(window.chartColors.green).alpha(0.5).rgbString(),
                borderColor: window.chartColors.green,
                borderWidth: 1,
                data: "",// [10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },
            {
                label: '教材费',
                backgroundColor: color(window.chartColors.orange).alpha(0.5).rgbString(),
                borderColor: window.chartColors.orange,
                borderWidth: 1,
                data: "",//[10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },
            {
                label: '杂费',
                backgroundColor: color(window.chartColors.purple).alpha(0.5).rgbString(),
                borderColor: window.chartColors.purple,
                borderWidth: 1,
                data: "",// [10, 23, 13, 18, 44, 32, 24, 55, 23, 64]
            },
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
    $(".tab-nav-btn-cpt").click(function () {
        $(".accordingToSchool").empty();
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if ($(this).is($(".tab-nav-btn-cpt").eq(0))) {
            selectedTabIndex = 0;
            $(".reportYearDiv").hide();
            $(".reportPeriod").show();
        } else if ($(this).is($(".tab-nav-btn-cpt").eq(1))) {
            selectedTabIndex = 1;
            $(".reportYearDiv").show();
            $(".reportPeriod").hide();
        }
    });

    /*
     初始化校区信息
     */
    for (var i = 0; i < 10; i++) {
        $input = $('<input value="" name="handingSchool" type="checkbox" class="handingSchool" checked = "checked"/>');
        var schoolName = "校区" + (i + 1);
        $(".handingSchoolDiv").append($input);
        $(".handingSchoolDiv").append(schoolName);
    }

    /*
     初始化统计年度下拉列表
     */
    var date = new Date();
    var year = date.getFullYear();
    for (var i = 0; i < 10; i++) {
        $option = $('<option value=""></option>');
        $option.html(year - i);
        $option.val(year - i);
        $("#reportYear").append($option);
    }
    $("#reportYear").find("option[text=year]").attr("selected", true);

    /*
     初始化统计期间
     */
    date = moment(date);
    date = date.format("YYYY-MM-DD");
    $("#reportStartDate").val(date);
    $("#reportEndDate").val(date);


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
        initialHtml();
        if (selectedTabIndex == 0) {
            chartAccordingToSchool();
            tableAccordingToSchool();
        } else if (selectedTabIndex == 1) {
            $(".accordingToSchool table thead tr th").eq(0).html("月份");
            chartAccordingToMonth();
            tableAccordingToMonth();
        }

    });

    $("#exportReport").click(function () {
        if ($(".accordingToSchool .yunmo tbody tr").length > 0) {
            PrintTableToExcel($(".accordingToSchool .yunmo").get(0));
        }

    });

    function  initialHtml() {
        var html = '<div class="chartContainer">'+
                ' <canvas class="canvas"></canvas>'+
                '</div>'+
                ' <div style="clear: both;height: 20px;width: 100%;"></div>'+
                '<div class="recordList" style="padding-top: 20px;">'+
                '<table class="yunmo">'+
                '<thead>'+
                '<tr>'+
                '<th style="width:20%;">经办校区</th>'+
                '<th style="width:20%;">学费</th>'+
                '<th style="width:20%;">教材费</th>'+
                '<th style="width:20%;">杂费</th>'+
                '<th style="width:20%;">总计</th>'+
                '</tr>'+
                '</thead>'+
                '<tbody>'+
                '</tbody>'+
                '</table>'+
                '</div>';
        $(".accordingToSchool").empty().append(html);

    }


    function chartAccordingToSchool() {


        barChartData.labels = ["校区1", "校区2", "校区3", "校区4", "校区5", "校区6", "校区7", "校区8", "校区9", "校区10"];
        for (var i = 0; i < barChartData.datasets.length; i++) {
            barChartData.datasets[i].data = [10, 23, 13, 18, 44, 32, 24, 55, 23, 64];
        }
        var ctx = ($(".canvas").get(0)).getContext("2d");
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: options,
        });

    }
    
    function tableAccordingToSchool() {
        for(var  i = 0;i< 10;i++) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html("东校区"));
            $tr.append($td.clone().html("12345"));
            $tr.append($td.clone().html("111"));
            $tr.append($td.clone().html("2222"));
            $tr.append($td.clone().html("34567"));
            $(".accordingToSchool table tbody").append($tr);
        }
    }

    function chartAccordingToMonth() {

        barChartData.labels = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];
        for (var i = 0; i < barChartData.datasets.length; i++) {
            barChartData.datasets[i].data = [10, 23, 13, 18, 44, 32, 24, 55, 23, 64, 100, 59];
        }


        var ctx = ($(".canvas").get(0)).getContext("2d");
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: barChartData,
            options: options,
        });
    }

    function tableAccordingToMonth() {
        for(var  i = 0;i< 10;i++) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html("2017-06"));
            $tr.append($td.clone().html("12345"));
            $tr.append($td.clone().html("111"));
            $tr.append($td.clone().html("2222"));
            $tr.append($td.clone().html("34567"));
            $(".accordingToSchool table tbody").append($tr);
        }
    }
});


function PrintTableToExcel(objTab) {
    try {
        var xls = new ActiveXObject("Excel.Application");
    }
    catch (e) {
        alert(e)
        //alert( "要打印该表，您必须安装Excel电子表格软件，同时浏览器须使用“ActiveX 控件”，您的浏览器须允许执行控件。 请点击【帮助】了解浏览器设置方法！");
        return false;
    }
    xls.visible = true;
    var xlBook = xls.Workbooks.Add;
    var xlsheet = xlBook.Worksheets(1);
    var x = 1;
    var y = 1;
    for (var i = 0; i < objTab.rows.length; i++) {
        y = 1;
        for (var j = 0; j < objTab.rows[i].cells.length; j++) {
            xlsheet.Cells(x, y).Value = objTab.rows[i].cells[j].innerHTML;
            xlsheet.Cells(x, y).Borders.LineStyle = 1;
            y++;
        }
        x++;
    }
    xlsheet.Columns.AutoFit; //自动适应大小
    return;
}
