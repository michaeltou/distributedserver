$(function () {
    $(".revenueAccount").show();
    $(".expenditureAccount").hide();

    $(".tab-nav-btn-cpt").click(function () {
        $(".tab-nav-btn-cpt").removeClass("selected");
        $(this).addClass("selected");
        if($(this).is( $(".tab-nav-btn-cpt").eq(0))){
            $(".revenueAccount").show();
            $(".expenditureAccount").hide();
        }else if($(this).is( $(".tab-nav-btn-cpt").eq(1))){
            $(".revenueAccount").hide();
            $(".expenditureAccount").show();
        }
    });
    
    $("#Save").click(function () {

        if($(".tab-nav-btn-cpt").eq(0).attr("class").indexOf("selected") > 0){
            //收入
            alert("收入");
        }else if($(".tab-nav-btn-cpt").eq(1).attr("class").indexOf("selected") > 0){
            //支出
            alert("支出");
        }
        window.location.href = "RevenueExpenditureDetails .html";
    });

    $("#Cancel").click(function () {
        window.location.href = "RevenueExpenditureDetails .html";
    });

});

