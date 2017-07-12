$(function () {
    $.extend({
        checkData: function () {
            var bChecked = false;
            for (var i = 0; i < $(".recordList-left .yunmo tbody tr").length; i++) {
                var tdArr = $(".recordList-left .yunmo tbody tr").eq(i).children();
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

    $.extend({
        setData: function (index) {
            var tdArrs = $(".recordList-middle tbody tr").eq(index).children();
            $("#shiFaGongZi").val(tdArrs.eq(1).html());
            $("#yingFaGongZi").val(tdArrs.eq(2).html());
            $("#jiaBanGongZi").val(tdArrs.eq(3).html());
            $("#gangWeiGongZi").val(tdArrs.eq(4).html());
            $("#jiXiaoGongZi").val(tdArrs.eq(5).html());
            $("#keShiFei").val(tdArrs.eq(6).html());
            $("#jieShaoFei").val(tdArrs.eq(7).html());
            $("#jiXiaoJiangJin").val(tdArrs.eq(8).html());
            $("#jiaBanFei").val(tdArrs.eq(9).html());
            $("#quanQinJiang").val(tdArrs.eq(10).html());
            $("#buKeFei").val(tdArrs.eq(11).html());
            $("#tongXunBuTie").val(tdArrs.eq(12).html());
            $("#jiaoTongBuTie").val(tdArrs.eq(13).html());
            $("#canFeiBuTie").val(tdArrs.eq(14).html());
            $("#gongLingGongZi").val(tdArrs.eq(15).html());
            $("#otherBonus").val(tdArrs.eq(16).html());
            $("#qingJiaKouKuan").val(tdArrs.eq(17).html());
            $("#tuiFeiKouKuan").val(tdArrs.eq(18).html());
            $("#yangLaoBaoXian").val(tdArrs.eq(19).html());
            $("#yiLiaoBaoXian").val(tdArrs.eq(20).html());
            $("#shiYeBaoXian").val(tdArrs.eq(21).html());
            $("#gongShangBaoXian").val(tdArrs.eq(22).html());
            $("#shengYuBaoXian").val(tdArrs.eq(23).html());
            $("#gongJiJin").val(tdArrs.eq(24).html());
            $("#tax").val(tdArrs.eq(25).html());
            $("#otherKK").val(tdArrs.eq(26).html());
        }
    });

    $(".deleteBtn").click(function () {
        if($.checkData()){

        }
    });

    $(".sendBtn").click(function () {
        if($.checkData()){

        }
    });

    $(".unDoBtn").click(function () {
        if($.checkData()){

        }
    });

    $("body").on("click",".editButton", function () {
        //alert($(this).parents("tr").index());
        $.setData($(this).parents("tr").index());
        for(var i = 0;i<$("form .text-input-cpt").length;i++){
            $("form .text-input-cpt").eq(i).removeAttr("disabled");
        }
        $("#shiFaGongZi").attr("disabled","disabled");
        $("#yingFaGongZi").attr("disabled","disabled");
        $(".ui-dialog-buttonset").children().eq(0).show();
        $(".ui-dialog-buttonset").children().eq(1).show();
        $(".ui-dialog-buttonset").children().eq(2).hide();
        $('.salaryBillDetails').dialog("option", "title", "编辑工资单").dialog('open');
    });

    $("body").on("click",".detailButton", function () {
        $.setData($(this).parents("tr").index());
        for(var i = 0;i<$("form .text-input-cpt").length;i++){
            $("form .text-input-cpt").eq(i).attr("disabled","disabled");
        }
        $(".ui-dialog-buttonset").children().eq(0).hide();
        $(".ui-dialog-buttonset").children().eq(1).hide();
        $(".ui-dialog-buttonset").children().eq(2).show();
        $('.salaryBillDetails').dialog("option", "title", "工资单详情").dialog('open');
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

    $("body").on('click', ".recordList-left .yunmo thead tr .selectedEmployee", function () {
        //alert($(this).is(':checked'));
        if ($(this).is(':checked')) {
            for (var i = 0; i < $(".recordList-left .yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        } else {
            for (var i = 0; i < $(".recordList-left .yunmo tbody tr").length; i++) {
                var tdArr = $(".yunmo tbody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        }
    });

    $("body").on('click', ".recordList-left .yunmo tbody tr .selectedEmployee", function () {
        //alert($(this).is(':checked'));
        if (!$(this).is(':checked')) {
            $(".recordList-left .yunmo thead tr .selectedEmployee").prop("checked", false);
            $(".recordList-left .yunmo thead tr .selectedEmployee").removeAttr("checked");
        } else {
            var bAllChecked = true;
            for (var i = 0; i < $(".recordList-left .yunmo tbody tr").length; i++) {
                var tdArr = $(".recordList-left .yunmo tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    bAllChecked = false;
                    break;
                }
            }
            if (bAllChecked) {
                $(".recordList-left .yunmo thead tr .selectedEmployee").prop("checked", true);

            }
        }

    });

    $('.salaryBillDetails').dialog({
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
               // window.location.href="SalaryBillDetail.html";
                $(this).dialog('close');
                //-----------------------------

                //------------------------------
            },
            '取消': function () {
                $(this).dialog('close');
            },
            '关闭': function () {
                $(this).dialog('close');
            }
        },
    });

});
