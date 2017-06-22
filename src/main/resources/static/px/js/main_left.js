$(function () {
    $("li").click(function () {
        $(".noSub").removeClass("active");
        $("li").removeClass("active");
        $(this).addClass("active");
    });

    $(".noSub").click(function () {
        $("li").removeClass("active");
        $(this).addClass("active");
    });


});


function exitmanagesys() {
    window.parent.location = "index.html";
}