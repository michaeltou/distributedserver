$(function () {
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

    $(".classRecordListDiv").on('click', ".editButton", function () {
        window.location.href = "RememberClassDetail.html";
    });

    $(".coursesDetailListDiv").on('click', ".printClassCardBtn", function () {
        window.location.href = "PrintCourseRegistrationCard.html";
    });
    $(".ordersDetailListDiv").on('click', ".printButton", function () {
        window.location.href = "PrinntFeeVoucher.html";
    });

});

