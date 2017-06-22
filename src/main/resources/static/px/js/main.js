$(function () {
    $('input[name="date"]').datepicker({
        showWeek: true,
        changeMonth: true,
        changeYear: true,
        yearRange: '1990:2020',
        yearSuffix: '年',
        //	maxDate:0,
    });

    $('input[name="date1"]').datepicker({
        showWeek: true,
        changeMonth: true,
        changeYear: true,
        yearRange: '1990:2020',
        yearSuffix: '年',
        //	maxDate:0,
    });

    $('input[name="statistictype"]').click(function () {
        if ($('#statistictype').get(0).checked) {
            $("#query-condition").hide();
            $("#timecondition").hide();
        } else {
            $("#query-condition").show();
            $("#timecondition").show();
        }
    });
});


function exitmanagesys() {
    window.parent.location = "index.html";
}