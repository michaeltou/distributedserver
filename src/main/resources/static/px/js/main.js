$(function () {
    $('input[name="date"]').datepicker({
        showWeek: false,
        changeMonth: true,
        changeYear: true,
        yearRange: '1990:2050',
        yearSuffix: '年',
        //	maxDate:0,
    });

    $('input[name="date1"]').datepicker({
        showWeek: false,
        changeMonth: true,
        changeYear: true,
        yearRange: '1990:2050',
        yearSuffix: '年',
        //	maxDate:0,
    });
});


function exitmanagesys() {
    window.parent.location = "index.html";
}