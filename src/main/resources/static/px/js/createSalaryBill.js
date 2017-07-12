$(function () {

    $.extend({
        checkData: function () {
            if ($("#salaryBillMonth").val() == "") {
                alert("请选择创建月份.");
                $("#salaryBillMonth").focus();
                return false;
            }

            var bChecked = false;
            for (var i = 0; i < $(".yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    bChecked = true;
                    break;
                }
            }
            if (!bChecked) {
                alert("请至少选择一名员工..");
                return false;
            }
            return true;
        }
    });

    $('input[name="date"]').datepicker({
        monthNamesShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],  // 区域化月名为中文
        prevText: '上月',         // 前选按钮提示
        nextText: '下月',         // 后选按钮提示
        changeYear: true,          // 年下拉菜单
        changeMonth: true,             // 月下拉菜单
        showButtonPanel: true,         // 显示按钮面板
        showMonthAfterYear: true,  // 月份显示在年后面
        currentText: "本月",         // 当前日期按钮提示文字
        closeText: "确定",           // 关闭按钮提示文字
        dateFormat: "yy-mm",       // 日期格式
        onClose: function (dateText, inst) {// 关闭事件
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }

    });

    $("#createSalaryBill").click(function () {
        if ($.checkData()) {
            //alert("createSalaryBill");
            for(var i = 0;i< $("form .text-input-cpt").length;i++){
                $("form .text-input-cpt").eq(i).val("");
            }
            $('.createNewSalaryBill').dialog("option", "title", "创建工资单").dialog('open');
        }
    });


    $("form").on("change",".text-input-cpt",function () {

       var totalMoney = 0;
       var jiaBanGongZi = parseInt($("#jiaBanGongZi").val());
       if(isNaN(jiaBanGongZi)){
           jiaBanGongZi = 0;
       }
        totalMoney += jiaBanGongZi;

        var gangWeiGongZi = parseInt($("#gangWeiGongZi").val());
        if(isNaN(gangWeiGongZi)){
            gangWeiGongZi = 0;
        }
        totalMoney += gangWeiGongZi;

        var jiXiaoGongZi = parseInt($("#jiXiaoGongZi").val());
        if(isNaN(jiXiaoGongZi)){
            jiXiaoGongZi = 0;
        }
        totalMoney += jiXiaoGongZi;

        var keShiFei = parseInt($("#keShiFei").val());
        if(isNaN(keShiFei)){
            keShiFei = 0;
        }
        totalMoney += keShiFei;

        var jieShaoFei = parseInt($("#jieShaoFei").val());
        if(isNaN(jieShaoFei)){
            jieShaoFei = 0;
        }
        totalMoney += jieShaoFei;

        var jiXiaoJiangJin = parseInt($("#jiXiaoJiangJin").val());
        if(isNaN(jiXiaoJiangJin)){
            jiXiaoJiangJin = 0;
        }
        totalMoney += jiXiaoJiangJin;

        var jiaBanFei = parseInt($("#jiaBanFei").val());
        if(isNaN(jiaBanFei)){
            jiaBanFei = 0;
        }
        totalMoney += jiaBanFei;

        var quanQinJiang = parseInt($("#quanQinJiang").val());
        if(isNaN(quanQinJiang)){
            quanQinJiang = 0;
        }
        totalMoney += quanQinJiang;

        var buKeFei = parseInt($("#buKeFei").val());
        if(isNaN(buKeFei)){
            buKeFei = 0;
        }
        totalMoney += buKeFei;

        var tongXunBuTie = parseInt($("#tongXunBuTie").val());
        if(isNaN(tongXunBuTie)){
            tongXunBuTie = 0;
        }
        totalMoney += tongXunBuTie;

        var jiaoTongBuTie = parseInt($("#jiaoTongBuTie").val());
        if(isNaN(jiaoTongBuTie)){
            jiaoTongBuTie = 0;
        }
        totalMoney += jiaoTongBuTie;

        var canFeiBuTie = parseInt($("#canFeiBuTie").val());
        if(isNaN(canFeiBuTie)){
            canFeiBuTie = 0;
        }
        totalMoney += canFeiBuTie;

        var gongLingGongZi = parseInt($("#gongLingGongZi").val());
        if(isNaN(gongLingGongZi)){
            gongLingGongZi = 0;
        }
        totalMoney += gongLingGongZi;

        var otherBonus = parseInt($("#otherBonus").val());
        if(isNaN(otherBonus)){
            otherBonus = 0;
        }
        totalMoney += otherBonus;

        var qingJiaKouKuan = parseInt($("#qingJiaKouKuan").val());
        if(isNaN(qingJiaKouKuan)){
            qingJiaKouKuan = 0;
        }
        totalMoney -= qingJiaKouKuan;

        var tuiFeiKouKuan = parseInt($("#tuiFeiKouKuan").val());
        if(isNaN(tuiFeiKouKuan)){
            tuiFeiKouKuan = 0;
        }
        totalMoney -= tuiFeiKouKuan;

        var yangLaoBaoXian = parseInt($("#yangLaoBaoXian").val());
        if(isNaN(yangLaoBaoXian)){
            yangLaoBaoXian = 0;
        }
        totalMoney -= yangLaoBaoXian;

        var yiLiaoBaoXian = parseInt($("#yiLiaoBaoXian").val());
        if(isNaN(yiLiaoBaoXian)){
            yiLiaoBaoXian = 0;
        }
        totalMoney -= yiLiaoBaoXian;

        var shiYeBaoXian = parseInt($("#shiYeBaoXian").val());
        if(isNaN(shiYeBaoXian)){
            shiYeBaoXian = 0;
        }

        var gongShangBaoXian = parseInt($("#gongShangBaoXian").val());
        if(isNaN(gongShangBaoXian)){
            gongShangBaoXian = 0;
        }
        totalMoney -= gongShangBaoXian;

        var shengYuBaoXian = parseInt($("#shengYuBaoXian").val());
        if(isNaN(shengYuBaoXian)){
            shengYuBaoXian = 0;
        }
        totalMoney -= shengYuBaoXian;

        var gongJiJin = parseInt($("#gongJiJin").val());
        if(isNaN(gongJiJin)){
            gongJiJin = 0;
        }
        totalMoney -= gongJiJin;

        var tax = parseInt($("#tax").val());
        if(isNaN(tax)){
            tax = 0;
        }
        totalMoney -= tax;

        var otherKK = parseInt($("#otherKK").val());
        if(isNaN(otherKK)){
            otherKK = 0;
        }
        totalMoney -= otherKK;

        $("#shiFaGongZi").val(totalMoney);
        $("#yingFaGongZi").val(totalMoney);
    });

    $("#copySalaryBill").click(function () {
        if ($.checkData()) {
            /*$.ajax({
                url: "/px/insertSchool",//servlet文件的名称
                type: "POST",
                data:"",
                contentType: "application/json; charset=utf-8",
                success: function (data, textStatus) {
                    if(data.success){
                        //alert("工资单拷贝成功");

                    }
                    else{
                        window.alert("工资单拷贝失败");
                    }
                }
            });*/
            window.location.href="SalaryBillDetail.html";
        }
    });


    $("body").on('click', ".yunmo thead tr .selectedEmployee", function () {
        //alert($(this).is(':checked'));
        if ($(this).is(':checked')) {
            for (var i = 0; i < $(".yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        } else {
            for (var i = 0; i < $(".yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        }
    });

    $("body").on('click', ".yunmo tbody tr .selectedEmployee", function () {
        //alert($(this).is(':checked'));
        if (!$(this).is(':checked')) {
            $(".yunmo thead tr .selectedEmployee").prop("checked", false);
            $(".yunmo thead tr .selectedEmployee").removeAttr("checked");
        } else {
            var bAllChecked = true;
            for (var i = 0; i < $(".yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    bAllChecked = false;
                    break;
                }
            }
            if (bAllChecked) {
                $(".yunmo thead tr .selectedEmployee").prop("checked", true);

            }
        }

    });

    $("body").on('click', ".detailButton", function () {
        window.location.href = "ClassDetail.html";
    });

    $("#search").click(function () {
        $.ajax({
            type: "POST",
            url: "XXXXXX",
            data: "keyword=" + $("#keyword").val(),
            success: function (data) {

            }
        });
    });

    $('.createNewSalaryBill').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 440,
        height: 460,
        title: '创建工资单',
        buttons: {
            '保存': function () {
                //$(this).submit();
               /* $.ajax({
                    url: "/px/insertSchool",//servlet文件的名称
                    type: "POST",
                    data:"",
                    contentType: "application/json; charset=utf-8",
                    success: function (data, textStatus) {
                        if(data.success){
                            //alert("工资单创建成果");

                        }
                        else{
                            window.alert("工资单创建失败");
                        }
                    }
                });*/
                window.location.href="SalaryBillDetail.html";
                $(this).dialog('close');
                //-----------------------------

                //------------------------------
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
    });
});
