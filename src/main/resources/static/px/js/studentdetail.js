$(function () {

    $("input[name='sex']").eq(0).attr("checked", "checked");
    $("input[name='sex']").eq(0).click();

    $('input[type=radio]').button();
    $('input[title]').tooltip({
        show: false,
        hide: false,
        position: {
            my: 'top left',
            at: 'right center'
        }
    });
    $(".ordersDetailListDiv").hide();
    $(".coursesDetailListDiv").show();
    $(".classScheduleListDiv").hide();
    $(".classRecordListDiv").hide();

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(3))){
            $(".ordersDetailListDiv").show();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(this).addClass("selected");
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").show();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").show();
            $(".classRecordListDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(2))){
            $(".ordersDetailListDiv").hide();
            $(".coursesDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").show();
        };
    });

    // [上课记录] =>[编辑]
    $(".classRecordListDiv").on('click', ".editButton", function () {
        window.location.href = "RememberClassDetail.html";
    });

    // [课程] =>[打印听课证]
    $(".coursesDetailListDiv").on('click', ".printClassCardBtn", function () {
        window.location.href = "PrintCourseRegistrationCard.html";
    });

    // [课程] =>[续费]
    $(".coursesDetailListDiv").on('click', ".renewBtn", function () {
        window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[买教材]
    $(".coursesDetailListDiv").on('click', ".buyTextbooksBtn", function () {
        window.location.href = "BuyTeachingMaterial.html";
    });

    // [课程] =>[转班]
    $(".coursesDetailListDiv").on('click', ".classTransferBtn", function () {
        //window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[停课]
    $(".coursesDetailListDiv").on('click', ".suspendClassesBtn", function () {
        //window.location.href = "StudentSignUpRenew.html";
    });

    // [课程] =>[退费]
    $(".coursesDetailListDiv").on('click', ".refundBtn", function () {
        window.location.href = "StudentRefund.html";
    });

    // [课程] =>[结课]
    $(".coursesDetailListDiv").on('click', ".endClassesBtn", function () {
        $('.endClass').dialog("option", "title", "结课确认").dialog('open');
    });

    // [课程] =>[分班]
    $(".coursesDetailListDiv").on('click', ".placementClassesBtn", function () {
        $('.selectClasses').dialog("option", "title", "班级选择").dialog('open');
    });

    var $lastSelectedClass;
    $(".selectClasses .yunmo tr").click(function () {
        if ($lastSelectedClass) {
            var trSeq = $lastSelectedClass.parent().find("tr").index($lastSelectedClass);
            if (trSeq % 2 == 0) {
                $lastSelectedClass.css("background-color", "white");
            } else {
                $lastSelectedClass.css("background-color", "#ecf0f1");
            }
        }
        $(this).css("background-color", "#00CCFF");
        $lastSelectedClass = $(this);
    });


    $(".ordersDetailListDiv").on('click', ".printButton", function () {
        window.location.href = "PrinntFeeVoucher.html";
    });

    // 班级选择dialog
    $('.selectClasses').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 770,
        height: 500,
        title: '选择班级',
        buttons: {
            '选择': function () {
                if ($lastSelectedClass) {
                    $(this).dialog('close');

                } else {
                    alert("请选择班级");
                    return false;
                }
            },
            '取消': function () {
                $(this).dialog('close');
            }
        },
        open: function (event, ui) {
            $(".ui-dialog-titlebar-close", $(this).parent()).hide();
        },

    });

    // 结课dialog
    $('.endClass').dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        width: 500,
        height: 300,
        title: '结课确认',
        buttons: {
            '确认': function () {
                $(this).dialog('close');
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

