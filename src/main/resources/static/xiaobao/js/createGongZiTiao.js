/**
 * Created by lenovo on 2017/7/4.
 */


$(document).ready(function () {

    var flag = false;
    $.extend({
        checkData: function () {
            if ($("#gongZiTiaoMonth").val() == "") {
                alert("请选择创建月份.");
                $("#gongZiTiaoMonth").focus();
                return false;
            }

            var bChecked = false;
            for (var i = 0; i < $("#mytablebody tr").length; i++) {
                var tdArr = $("#mytablebody tr").eq(i).children();
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

    $('#gongZiTiaoMonth').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm',
        initialDate: new Date(),//初始化当前日期
        autoclose: true,//选中自动关闭
        todayBtn: true,//显示今日按钮
        startView: 3,
        minView: 3

    });

    var nowDate = new Date();
    var result=nowDate.getFullYear()+'-'+padZero((nowDate.getMonth()+1),2);//
    $('#gongZiTiaoMonth').val(result);

    $("#createObjectBtnInList").click(function () {
        if($.checkData()){
            $('#createGongZiTiaoModal').modal('show');
            return false;
        }
    });

    $("#copyObjectBtnInList").click(function () {
        if($.checkData()){
            var names = "";
            var sfzCodes = "";

            for(var i = 0;i < $("#mytablebody tr").length;i++){
                if(!$("#mytablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                    continue;
                }
                var tds = $("#mytablebody tr").eq(i).children();
                if(names == ""){
                    names+=tds.eq(1).html();
                }
                else {
                    names+= "," + tds.eq(1).html();
                }

                if(sfzCodes == ""){
                    sfzCodes+=tds.eq(3).html();
                }
                else {
                    sfzCodes+= "," + tds.eq(3).html();
                }
            }
            $.ajax({
                type: "get",
                url: "/copyPreMonthGongZiTiao",
                async:false,
                data: {
                    names:names,
                    sfzCodes:sfzCodes,
                    month:$('#gongZiTiaoMonth').val(),
                },
                success: function (data, textStatus) {
                    if (data.success) {
                        alert("上月工资单拷贝成功");
                        $.ajax({
                            type: "GET",
                            url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                            async:false,
                            data:{month:$("#gongZiTiaoMonth").val()},
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
                        /*$("#failLabel").css("display:block");*/
                        alert(data.errorMsg);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("系统异常！");
                }
            });
        }
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

        var names = "";
        var sfzCodes = "";

        for(var i = 0;i < $("#mytablebody tr").length;i++){
            if(!$("#mytablebody tr").eq(i).find(".selectedEmployee").is(":checked")){
                continue;
            }
            var tds = $("#mytablebody tr").eq(i).children();
            if(names == ""){
                names+=tds.eq(1).html();
            }
            else {
                names+= "," + tds.eq(1).html();
            }

            if(sfzCodes == ""){
                sfzCodes+=tds.eq(3).html();
            }
            else {
                sfzCodes+= "," + tds.eq(3).html();
            }
        }
        flag = "true";
        $('#createGongZiTiaoModal').modal('hide');
        $.ajax({
            type: "post",
            url: "/insertGongZiTiao",
            async:false,
            /**     * 关键点：获取post请求的参数，有2个关键点：
             * 1、java接口需要加上@RequestBody这个注解.
             * 2、js里面的ajax请求的data要使用 data:  JSON.stringify({name: $("#name").val(), age: $("#age").val()}), 传递json字符串，而不json对象.
             * */
            data: JSON.stringify({
                name:names,
                sfz_code:sfzCodes,
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

    $('#createGongZiTiaoModal').on('hidden.bs.modal', function () {
       if(flag == "true"){
            $.ajax({
                type: "GET",
                url: "/xiaobao/queryGongZiTiaoListByInstitutionAndMonth",
                async:false,
                data:{month:$("#gongZiTiaoMonth").val()},
                success: function (data) {
                    $('#mainContents').empty();
                    //通过替换为空，这个主要是解决jquery多次引入导致的冲突问题（不可预知的问题.）
                    var data2 = data.replace(/\<script src=\"\/xiaobao\/js\/jquery-3.2.1.js\"\>\<\/script\>/, "");

                    var data3= data2.replace(/\<script src=\"\/xiaobao\/js\/bootstrap.js\"\>\<\/script\>/, "");

                    var data4= data3.replace(/\<link rel=\"stylesheet\" href=\"\/xiaobao\/css\/bootstrap.css\"\/\>/, "");
                    $('#mainContents').append(data4);
                }
            });
           flag = false;
       }
    })

    $("#createGongZiTiaoModal form").on("change",".form-control",function () {

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

    $("body").on('click', "#mytablehead tr .selectedEmployee", function () {
        if ($(this).is(':checked')) {
            for (var i = 0; i < $("#mytablebody tr").length; i++) {
                var tdArr = $("#mytablebody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        } else {
            for (var i = 0; i < $("#mytablebody tr").length; i++) {
                var tdArr = $("#mytablebody tr").eq(i).children();
                if (tdArr.eq(0).children().is(':checked')) {
                    tdArr.eq(0).children().click();
                }
            }
        }
    });

    $("body").on('click', "#mytablebody tr .selectedEmployee", function () {
        if (!$(this).is(':checked')) {
            $("#mytablehead tr .selectedEmployee").prop("checked", false);
            $("#mytablehead tr .selectedEmployee").removeAttr("checked");
        } else {
            var bAllChecked = true;
            for (var i = 0; i < $("#mytablebody tr").length; i++) {
                var tdArr = $(".table tbody tr").eq(i).children();
                if (!tdArr.eq(0).children().is(':checked')) {
                    bAllChecked = false;
                    break;
                }
            }
            if (bAllChecked) {
                $("#mytablehead tr .selectedEmployee").prop("checked", true);

            }
        }

    });

    $("#backToListbreadLink").click(function () {
        $("#gongzitiaoguanli").click();

    });

    $("#createGongZiTiaoModal form input").focusout(function () {

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

});

function padZero(num, n) {
    if ((num + "").length >= n) {
        return num;
    }
    return padZero("0" + num, n);
}
