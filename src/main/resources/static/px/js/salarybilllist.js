$(function () {

    $('input[name="date"]').datepicker({
        monthNamesShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],  // 区域化月名为中文
        prevText: '上月',         // 前选按钮提示
        nextText: '下月',         // 后选按钮提示
        changeYear: true,          // 年下拉菜单
        changeMonth: true,             // 月下拉菜单
        showButtonPanel: true,         // 显示按钮面板
        showMonthAfterYear: true,  // 月份显示在年后面
        currentText: "本月",         // 当前日期按钮提示文字
        closeText: "确定",           // 关闭按钮提示文字
        dateFormat: "yy-mm",       // 日期格式
        onClose: function (dateText, inst) {// 关闭事件
            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, month, 1));
        }

    });


    $("body").on('click', ".deleteButton", function () {
        if (window.confirm('你确定要删除吗？')) {
            //alert("确定");
            DeleteData($(this).get(0));
            return true;
        } else {
            //alert("取消");
            return false;
        }
    });

    $("body").on('click', ".detailButton", function () {
        window.location.href = "SalaryBillDetail.html";
    });

    $("#createSalaryBill").click(function () {
        window.location.href = "CreateSalaryBill.html";
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
});

function DeleteData(delRow) {
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
}