/**
 * Created by Huangqijun on 2017/7/4.
 */


$(document).ready(function () {

    var flag = false;
    $("body").unbind("click");//

    $.extend({
        setData: function (index,id,month) {
            var tdArrs = $(".middle-table-div tbody tr").eq(index).children();
            var tdArrs2 = $(".left-table-div tbody tr").eq(index).children();
            $("#id").val(id);
            $("#month").val(month);
            $("#name").val(tdArrs2.eq(1).html());
            $("#sfzCode").val(tdArrs2.eq(2).html())
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

    if($(".myrighttablebody tr").length > 0){
        var title = $(".myrighttablebody .editObjectLinkClass").attr("month");
        var strs = title.split("-");
        if(strs.length ==2){
            $(".title-month").html(strs[0]+"年" + strs[1]+"月" + " 工资明细");
        }
    }

    if($(".mymiddletablebody tr").length > 0){
        for(var i = 0;i< $(".mymiddletablebody tr").length;i++){
            if ($(".mymiddletablebody tr").eq(i).children().eq(0).html() == "0"){
                $(".mymiddletablebody tr").eq(i).children().eq(0).html("未通知");
            }else  if ($(".mymiddletablebody tr").eq(i).children().eq(0).html() == "1"){
                $(".mymiddletablebody tr").eq(i).children().eq(0).html("已通知");
            }else  if ($(".mymiddletablebody tr").eq(i).children().eq(0).html() == "2"){
                $(".mymiddletablebody tr").eq(i).children().eq(0).html("已确认");
            }

        }
    }

    $("body").on('click', ".detailObjectLinkClass" ,function () {

        $.setData($(this).parents("tr").index(),$(this).attr("id"),$(this).attr("month"));
        for(var i = 0;i<$("#myform1 .form-control").length;i++){
            $("#myform1 .form-control").eq(i).attr("disabled","disabled");
        }
        $("#gongZiTiaoDetailModal .modal-footer button").eq(1).hide();
        $('#gongZiTiaoDetailModalLabel').text("工资单详情");
        $('#gongZiTiaoDetailModal').modal('show');
        return false;

    });

    $("body").on('click', ".editObjectLinkClass" ,function () {
        var index = $(this).parents("tr").index();
        if($(".mymiddletablebody tr").eq(index).children().eq(0).html() == "已确认"){
            alert("该员工工资已确认,不可修正");
            return;
        }
        $.setData(index,$(this).attr("id"),$(this).attr("month"));
        for(var i = 0;i<$("#myform1 .form-control").length;i++){
            $("#myform1 .form-control").eq(i).removeAttr("disabled");
        }
        $("#shiFaGongZi").attr("disabled","disabled");
        $("#yingFaGongZi").attr("disabled","disabled");
        $("#gongZiTiaoDetailModal .modal-footer button").eq(1).show();
        $('#gongZiTiaoDetailModalLabel').text("编辑工资条");
        $('#gongZiTiaoDetailModal').modal('show');
        return false;

    });

    $("#saveObjectBtnInModal").click(function () {
        var jiaBanGongZi = parseInt($("#jiaBanGongZi").val());
        if(isNaN(jiaBanGongZi)){
            jiaBanGongZi = 0;
        }
        var gangWeiGongZi = parseInt($("#gangWeiGongZi").val());
        if(isNaN(gangWeiGongZi)){
            gangWeiGongZi = 0;
        }

        var jiXiaoGongZi = parseInt($("#jiXiaoGongZi").val());
        if(isNaN(jiXiaoGongZi)){
            jiXiaoGongZi = 0;
        }

        var keShiFei = parseInt($("#keShiFei").val());
        if(isNaN(keShiFei)){
            keShiFei = 0;
        }

        var jieShaoFei = parseInt($("#jieShaoFei").val());
        if(isNaN(jieShaoFei)){
            jieShaoFei = 0;
        }

        var jiXiaoJiangJin = parseInt($("#jiXiaoJiangJin").val());
        if(isNaN(jiXiaoJiangJin)){
            jiXiaoJiangJin = 0;
        }

        var jiaBanFei = parseInt($("#jiaBanFei").val());
        if(isNaN(jiaBanFei)){
            jiaBanFei = 0;
        }

        var quanQinJiang = parseInt($("#quanQinJiang").val());
        if(isNaN(quanQinJiang)){
            quanQinJiang = 0;
        }

        var buKeFei = parseInt($("#buKeFei").val());
        if(isNaN(buKeFei)){
            buKeFei = 0;
        }

        var tongXunBuTie = parseInt($("#tongXunBuTie").val());
        if(isNaN(tongXunBuTie)){
            tongXunBuTie = 0;
        }

        var jiaoTongBuTie = parseInt($("#jiaoTongBuTie").val());
        if(isNaN(jiaoTongBuTie)){
            jiaoTongBuTie = 0;
        }

        var canFeiBuTie = parseInt($("#canFeiBuTie").val());
        if(isNaN(canFeiBuTie)){
            canFeiBuTie = 0;
        }

        var gongLingGongZi = parseInt($("#gongLingGongZi").val());
        if(isNaN(gongLingGongZi)){
            gongLingGongZi = 0;
        }

        var otherBonus = parseInt($("#otherBonus").val());
        if(isNaN(otherBonus)){
            otherBonus = 0;
        }

        var qingJiaKouKuan = parseInt($("#qingJiaKouKuan").val());
        if(isNaN(qingJiaKouKuan)){
            qingJiaKouKuan = 0;
        }

        var tuiFeiKouKuan = parseInt($("#tuiFeiKouKuan").val());
        if(isNaN(tuiFeiKouKuan)){
            tuiFeiKouKuan = 0;
        }

        var yangLaoBaoXian = parseInt($("#yangLaoBaoXian").val());
        if(isNaN(yangLaoBaoXian)){
            yangLaoBaoXian = 0;
        }

        var yiLiaoBaoXian = parseInt($("#yiLiaoBaoXian").val());
        if(isNaN(yiLiaoBaoXian)){
            yiLiaoBaoXian = 0;
        }

        var shiYeBaoXian = parseInt($("#shiYeBaoXian").val());
        if(isNaN(shiYeBaoXian)){
            shiYeBaoXian = 0;
        }

        var gongShangBaoXian = parseInt($("#gongShangBaoXian").val());
        if(isNaN(gongShangBaoXian)){
            gongShangBaoXian = 0;
        }

        var shengYuBaoXian = parseInt($("#shengYuBaoXian").val());
        if(isNaN(shengYuBaoXian)){
            shengYuBaoXian = 0;
        }

        var gongJiJin = parseInt($("#gongJiJin").val());
        if(isNaN(gongJiJin)){
            gongJiJin = 0;
        }

        var tax = parseInt($("#tax").val());
        if(isNaN(tax)){
            tax = 0;
        }

        var otherKK = parseInt($("#otherKK").val());
        if(isNaN(otherKK)){
            otherKK = 0;
        }

        var id = $("#id").val();
        var month = $("#month").val();
        var name = $("#name").val();
        var sfzCode = $("#sfzCode").val();

        flag = true;
        $('#gongZiTiaoDetailModal').modal('hide');
        $.ajax({
            type: "post",
            url: "/updateGongZiTiao",
            async:false,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                id:id,
                month:month,
                name:name,
                sfz_code:sfzCode,
                month:$('#gongZiTiaoMonth').val(),
                shi_fa_gz:$('#shiFaGongZi').val(),
                ying_fa_zong_gz:$('#yingFaGongZi').val(),
                jia_ban_gz:jiaBanGongZi,
                gang_wei_gz:gangWeiGongZi,
                ji_xiao_gz:jiXiaoGongZi,
                ke_shi_fei:keShiFei,
                jie_shao_fei:jieShaoFei,
                jiXiao_jiangJin:jiXiaoJiangJin,
                jia_ban_fei:jiaBanFei,
                quan_qing_jiang:quanQinJiang,
                bu_ke_fei:buKeFei,
                tong_xun_bu_tie:tongXunBuTie,
                jiao_tong_bu_tie:jiaoTongBuTie,
                can_bu:canFeiBuTie,
                gong_ling_gz:gongLingGongZi,
                other_bonus:otherBonus,
                qing_jia_kou_kuan:qingJiaKouKuan,
                tui_fei_kou_kuan:tuiFeiKouKuan,
                yang_lao_kk:yangLaoBaoXian,
                yi_liao_kk:yiLiaoBaoXian,
                shi_ye_kk:shiYeBaoXian,
                gong_shang_kk:gongShangBaoXian,
                sheng_yu_kk:shengYuBaoXian,
                gong_ji_jing_kk:gongJiJin,
                tax_kk:tax,
                other_kk:otherKK,
                status:0,
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",//(可以)
            success: function (data, textStatus) {
                if (data.success) {

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

    });

    $('#gongZiTiaoDetailModal').on('hidden.bs.modal', function () {
        if(flag){
            flag = false;
            $.ajax({
                type: "GET",
                url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                async:false,
                data: {
                    month: $("#month").val(),
                },
                success: function (data) {
                    $('#mainContents').empty();
                    //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                    var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                    var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                    var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                    $('#mainContents').append(data4);
                }
            });
        }
    })

    $("#gongZiTiaoDetailModal form").on("change",".form-control",function () {

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

    $("body").on('click', ".mylefttablehead tr .selectedEmployee", function () {
        if ($(this).is(':checked')) {
            for (var i = 0; i < $(".mylefttablebody tr").length; i++) {
                var tdArr = $(".mylefttablebody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        } else {
            for (var i = 0; i < $(".mylefttablebody tr").length; i++) {
                var tdArr = $(".mylefttablebody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        }
    });

    $("body").on('click', ".mylefttablebody tr .selectedEmployee", function () {
        if (!$(this).is(':checked')) {
            $(".mylefttablehead tr .selectedEmployee").prop("checked", false);
            $(".mylefttablehead tr .selectedEmployee").removeAttr("checked");
        } else {
            var bAllChecked = true;
            for (var i = 0; i < $(".mylefttablebody tr").length; i++) {
                var tdArr = $(".mylefttablebody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    bAllChecked = false;
                    break;
                }
            }
            if (bAllChecked) {
                $(".mylefttablehead tr .selectedEmployee").prop("checked", true);

            }
        }

    });

    $(".delete-btn").click(function () {
        var ids = "";
        var names = "";
        var sfzCodes = "";
        var month = "";
        if($.checkData()){
            for(var i = 0; i < $(".mylefttablebody tr").length;i++){
                if($(".mylefttablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                    var index = $(".mylefttablebody tr").eq(i).index();
                    if(names == ""){
                        names += $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    else {
                        names += "," + $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    if(sfzCodes == ""){
                        sfzCodes += $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    else {
                        sfzCodes += "," + $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    if(ids == ""){
                        ids += $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                    else {
                        ids += "," + $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                }
            }
            month = $(".myrighttablebody tr").eq(0).find(".editObjectLinkClass").attr("month")
            $.ajax({
                type: "get",
                url: "/deleteGongZiTiao",
                data: {
                    ids: ids,
                    names: names,
                    sfzCodes: sfzCodes
                },
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                success: function (data, textStatus) {
                    if (data.success) {
                        $.ajax({
                            type: "GET",
                            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                            data: {
                                month: month,
                            },
                            success: function (data) {
                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                                $('#mainContents').append(data4);
                            }
                        });
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
    });

    $(".notice-btn").click(function () {
        var ids = "";
        var names = "";
        var sfzCodes = "";
        if($.checkData()){
            for(var i = 0; i < $(".mylefttablebody tr").length;i++){
                if($(".mylefttablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                    var index = $(".mylefttablebody tr").eq(i).index();

                    if($(".mymiddletablebody tr").eq(index).children().eq(0).html() == "已确认" ||
                        $(".mymiddletablebody tr").eq(index).children().eq(0).html() == "已通知"){
                        continue;
                    }

                    if(names == ""){
                        names += $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    else {
                        names += "," + $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    if(sfzCodes == ""){
                        sfzCodes += $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    else {
                        sfzCodes += "," + $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    if(ids == ""){
                        ids += $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                    else {
                        ids += "," + $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                }
            }
            if(ids == ""){
                alert("所选员工的工资单已经确认,不需要再通知.");
                return;
            }
            month = $(".myrighttablebody tr").eq(0).find(".editObjectLinkClass").attr("month")
            $.ajax({
                type: "get",
                url: "/updateGongZiTiaoStatus",
                data: {
                    ids: ids,
                    names: names,
                    sfzCodes: sfzCodes,
                    status:1
                },
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                success: function (data, textStatus) {
                    if (data.success) {
                        $.ajax({
                            type: "GET",
                            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                            data: {
                                month: month,
                            },
                            success: function (data) {
                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                                $('#mainContents').append(data4);
                            }
                        });
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
    });

    $(".undo-btn").click(function () {
        var ids = "";
        var names = "";
        var sfzCodes = "";
        if($.checkData()){
            for(var i = 0; i < $(".mylefttablebody tr").length;i++){
                if($(".mylefttablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                    var index = $(".mylefttablebody tr").eq(i).index();

                    if($(".mymiddletablebody tr").eq(index).children().eq(0).html() == "已确认" ||
                        $(".mymiddletablebody tr").eq(index).children().eq(0).html() == "未通知"){
                        continue;
                    }

                    if(names == ""){
                        names += $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    else {
                        names += "," + $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    if(sfzCodes == ""){
                        sfzCodes += $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    else {
                        sfzCodes += "," + $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    if(ids == ""){
                        ids += $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                    else {
                        ids += "," + $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                }
            }
            if(ids == ""){
                alert("所选员工的工资单已经确认,不可撤回.");
                return;
            }
            month = $(".myrighttablebody tr").eq(0).find(".editObjectLinkClass").attr("month")
            $.ajax({
                type: "get",
                url: "/updateGongZiTiaoStatus",
                data: {
                    ids: ids,
                    names: names,
                    sfzCodes: sfzCodes,
                    status:0
                },
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                success: function (data, textStatus) {
                    if (data.success) {
                        $.ajax({
                            type: "GET",
                            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                            data: {
                                month: month,
                            },
                            success: function (data) {
                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                                $('#mainContents').append(data4);
                            }
                        });
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
    });

    $(".confirm-btn").click(function () {
        var ids = "";
        var names = "";
        var sfzCodes = "";
        if($.checkData()){
            for(var i = 0; i < $(".mylefttablebody tr").length;i++){
                if($(".mylefttablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                    var index = $(".mylefttablebody tr").eq(i).index();

                    if($(".mymiddletablebody tr").eq(index).children().eq(0).html() == "未通知"){
                        continue;
                    }

                    if(names == ""){
                        names += $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    else {
                        names += "," + $(".mylefttablebody tr").eq(i).children().eq(1).html();
                    }
                    if(sfzCodes == ""){
                        sfzCodes += $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    else {
                        sfzCodes += "," + $(".mylefttablebody tr").eq(i).children().eq(2).html();
                    }
                    if(ids == ""){
                        ids += $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                    else {
                        ids += "," + $(".myrighttablebody tr").eq(index).find(".editObjectLinkClass").attr("id");
                    }
                }
            }
            if(ids == ""){
                alert("所选员工的工资单还有可能要更新,暂不可确认.");
                return;
            }
            month = $(".myrighttablebody tr").eq(0).find(".editObjectLinkClass").attr("month")
            $.ajax({
                type: "get",
                url: "/updateGongZiTiaoStatus",
                data: {
                    ids: ids,
                    names: names,
                    sfzCodes: sfzCodes,
                    status:2
                },
                dataType: "json",
                contentType: "application/json; charset=utf-8",//(可以)
                success: function (data, textStatus) {
                    if (data.success) {
                        $.ajax({
                            type: "GET",
                            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                            data: {
                                month: month,
                            },
                            success: function (data) {
                                $('#mainContents').empty();
                                //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                                var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                                var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                                var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                                $('#mainContents').append(data4);
                            }
                        });
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
    });

    $("#gongZiTiaoDetailModal form input").focusout(function () {

        if($(this).val() == ""){
            return;
        }
        var numReg = /^\+?[1-9][0-9]*$/i;
        if ( !numReg.test($(this).val()) ) {
            $(this).val("");
            $(this).next().text("非数字,不合法!");
            $(this).next().css({"display": "block", "color": "red"});
        } else {
            $(this).next().css("display", "none");
        }


    });

    $("#backToListbreadLink").click(function () {
        $("#gongzitiaoguanli").click();
    });

});

$.extend({
    checkData: function () {
        var bChecked = false;
        for (var i = 0; i < $(".mylefttablebody tr").length; i++) {
            var tdArr = $(".mylefttablebody tr").eq(i).children();
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


