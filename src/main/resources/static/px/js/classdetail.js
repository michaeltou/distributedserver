$(function () {
    $(".studentsDetailListDiv").show();
    $(".classScheduleListDiv").hide();
    $(".classRecordListDiv").hide();
    $(".homeworkListDiv").hide();
    $(".pointTableDiv").hide();
    $(".studentsInfoDiv").hide();

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            $(".studentsDetailListDiv").show();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").show();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(2))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").show();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(3))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").show();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(4))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").show();
            $(".studentsInfoDiv").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(5))){
            $(".studentsDetailListDiv").hide();
            $(".classScheduleListDiv").hide();
            $(".classRecordListDiv").hide();
            $(".homeworkListDiv").hide();
            $(".pointTableDiv").hide();
            $(".studentsInfoDiv").show();
        }
    });

    $(".classRecordListDiv").on('click', ".editButton", function () {
        window.location.href = "RememberClassDetail.html";
    });

    $(".classRecordListDiv").on('click', ".deleteButton", function () {
        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });

    $(".studentsDetailListDiv").on('click', ".printClassCardBtn", function () {
        //window.location.href = "PrintCourseRegistrationCard.html";
    });
    $(".ordersDetailListDiv").on('click', ".printButton", function () {
        //window.location.href = "PrinntFeeVoucher.html";
    });

    $(".btnPrint").click(function () {
        if ($(this).parents(".pointTableDiv").length > 0) {
            $(this).parents(".pointTableDiv").children(".printDataDiv").printArea();
        } else if ($(this).parents(".studentsInfoDiv").length > 0) {
            $(this).parents(".studentsInfoDiv").children(".printDataDiv").printArea();
        }
    });

    $("#rememberClassBtn").click(function (){

        window.location.href = "RememberClassDetail.html";
    });



});


function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}

