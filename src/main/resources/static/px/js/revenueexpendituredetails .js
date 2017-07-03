$(function () {

    $('#newAccount').click(function () {
        window.location.href = "AddNewAccount.html";
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

    $("body").on('click', ".editButton", function () {
        // 编辑按钮;
    });

    $("body").on('click', ".confirmButton", function () {
        // 确认按钮
    });

    $("tbody").on('click', ".checkItem", function () {
        var bAllChecked = true;
        if ($(this).attr("checked") === undefined) {
            $(this).attr("checked", true);
            for(var i = 0;i< $("tbody").find(".checkItem").length;i++){
                if(typeof ($("tbody").find(".checkItem").eq(i).attr("checked")) == "undefined") {
                    bAllChecked = false;
                    break;
                }
            }
            if(bAllChecked){
                if(typeof ($("thead").find(".checkItem").attr("checked")) == "undefined"){
                    $("thead").find(".checkItem").click();
                }
            }
        }
        else {
            $(this).attr("checked", false);
            if($("thead").find(".checkItem").attr("checked") == "checked"){
                $("thead").find(".checkItem").prop("checked",false);
                $("thead").find(".checkItem").removeAttr("checked");
            }

        }
    });

    $("thead").on('click', ".checkItem", function () {
        if ($(this).attr("checked") === undefined) {
            $(this).attr("checked", true);
            for(var i = 0;i< $("tbody").find(".checkItem").length;i++){
                if(typeof ($("tbody").find(".checkItem").eq(i).attr("checked")) == "undefined") {
                    $("tbody").find(".checkItem").eq(i).click();
                }
            }
        }
        else {
            $(this).attr("checked", false);
            for(var i = 0;i< $("tbody").find(".checkItem").length;i++){
                if($("tbody").find(".checkItem").eq(i).attr("checked") == "checked") {
                    $("tbody").find(".checkItem").eq(i).click();
                }
            }
        }
    });


    $("#search").click(function () {

        var institution_code = "tm";
        var courseName = $("#courseTypeNameForSearchText").val();
        $.ajax({
            url: "",
            type: "POST",
            data: "",
            contentType: "application/json; charset=utf-8",

            success: function (data, textStatus) {


                if (data.success) {
                    // alert(JSON.stringify(data)); 调试使用，请勿删除

                    //清空当前表格
                    document.getElementById("data_body").innerHTML = '';

                    //动态构建表格数据.

                }
                else {

                }
            }
        });
    });
});

function EditData(editRow) {
    var tr = editRow.parentNode.parentNode;
}

function DeleteData(delRow) {
    var tr = delRow.parentNode.parentNode;
    var table = delRow.parentNode.parentNode.parentNode;
    table.removeChild(delRow.parentNode.parentNode);
    $.ajax({
        url: "",
        type: "POST",
        data: "",
        contentType: "application/json; charset=utf-8",
        success: function (data, textStatus) {
            if (data.success) {
                alert("收支明细删除成功");
                window.location.href = "";
            }
            else {
                window.alert("收支明细删除失败");
            }
        }
    });
}