$(function () {

    $('input[type=radio]').button();
    $('input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });

    $("#Save").click(function () {

        window.location.href = "PerformanceRuleList.html";
    });

    $("#Cancel").click(function () {
        window.location.href = "PerformanceRuleList.html";
    });

    $("body").on('click', "#employeeList thead tr .selectedEmployee", function () {
        if ($(this).is(':checked')) {
            for (var i = 0; i < $("#employeeList tbody tr").length; i++) {
                var tdArr = $("#employeeList tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        } else {
            for (var i = 0; i < $("#employeeList tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        }
    });

    $("body").on('click', "#employeeList tbody tr .selectedEmployee", function () {
        if (!$(this).is(':checked')) {
            $("#employeeList thead tr .selectedEmployee").prop("checked", false);
            $("#employeeList thead tr .selectedEmployee").removeAttr("checked");
        } else {
            var bAllChecked = true;
            for (var i = 0; i < $("#employeeList tbody tr").length; i++) {
                var tdArr = $("#employeeList tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    bAllChecked = false;
                    break;
                }
            }
            if (bAllChecked) {
                $("#employeeList thead tr .selectedEmployee").prop("checked", true);

            }
        }

    });

    $("#SelectEmployee").click(function () {
        /*
         加载社员信息
         */

        // 如果头部的checkbox处于选中状态,则去掉选中状态
        if($("#employeeList thead .selectedEmployee").is(":checked")){
            $("#employeeList thead .selectedEmployee").prop("checked",false);
            $("#employeeList thead .selectedEmployee").removeAttr("checked");
        }

        //加载table的数据部
        $("#employeeList tbody").empty();
        for (var i = 0; i < 50; i++) {
            $tr = $('<tr></tr>');
            $td = $('<td></td>');
            $tr.append($td.clone().html('<input value="" name="selectedEmployee" type="checkbox" class="selectedEmployee">'));
            $tr.append($td.clone().html("小王" + i));
            $tr.append($td.clone().html("18717947096"));
            $tr.append($td.clone().html("187179470961871794"));
            $tr.append($td.clone().html("男"));
            $tr.append($td.clone().html("男"));
            $("#employeeList tbody").append($tr);
        }

        // 把画面上已经选择的员工的checkbox勾选
        var selectedItems = $(".seletedEmployeeDiv");
        var tableItems = $("#employeeList tbody tr");
        if(selectedItems.length == tableItems.length){
            $("#employeeList thead .selectedEmployee").prop("checked",true);
        }
        for(var i = 0;i< selectedItems.length;i++){
            var employeeName = selectedItems.eq(i).children("label").html();
            for(var j = 0;j< tableItems.length;j++){
                var tdArr = tableItems.eq(j).children();
                if(employeeName == tdArr.eq(1).html()){
                    tdArr.eq(0).children().prop("checked",true);
                    //alert(tdArr.eq(0).html());
                    break;
                }
            }
        }


        $('.employeeDialog').dialog("option", "title", "选择员工").dialog('open');
    });
    
    $("#ruleType1").click(function () {
        if($(this).is(":checked")){
            $(".percentageType").text("每课时");
            $(".percentageUnit").text("元");
        }
    });
    $("#ruleType2").click(function () {
        if($(this).is(":checked")){
            $(".percentageType").text("每课时");
            $(".percentageUnit").text("元");
        }
    });
    $("#ruleType3").click(function () {
        if($(this).is(":checked")){
            $(".percentageType").text("课时费");
            $(".percentageUnit").text("%");
        }
    });

    $(".seletedEmployeesDiv").on("click", ".deleteButton", function () {
        $(this).parent().remove();
    });

    // 员工选择dialog
    $('.employeeDialog').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 670,
        height: 500,
        title: '选择员工',
        buttons: {
            '确定': function () {
                $(this).dialog('close');
                $(".seletedEmployeesDiv").empty();
                for (var i = 0; i < $("#employeeList tbody tr").length; i++){
                    var tdArr = $("#employeeList tbody tr").eq(i).children();
                    if (tdArr.eq(0).children().is(':checked')) {
                        var $div = $('<div class="seletedEmployeeDiv"></div>');
                        var $lbl = $("<label></label>");
                        $lbl.html(tdArr.eq(1).html());
                        var $span = $('<span class="deleteButton icon iconfont icon-close"></span>')
                        $div.append($lbl);
                        $div.append($span);
                        $(".seletedEmployeesDiv").append($div);
                    }
                }
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },

    });

});

